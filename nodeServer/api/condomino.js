const queries = require('./queries')

module.exports = app => {
    const { existsOrError } = app.api.validation

    const save = (req, res) => {
        const condomino = { ...req.body }
        if(req.params.id) condomino.id = req.params.id

        try {
            existsOrError(condomino.apartamento, 'Apartamento não informado')
            existsOrError(condomino.nome, 'Nome não informado')
            existsOrError(condomino.userId, 'Autor não informado')
            existsOrError(condomino.categoryId, 'Categoria não informada')

        } catch(msg) {
            res.status(400).send(msg)
        }

        if(condomino.id) {
            app.db('condominos')
                .update(condomino)
                .where({ id: condomino.id })
                .then(_ => res.status(204).send())
                .catch(err => res.status(500).send(err))
        } else {
            app.db('condominos')
                .insert(condomino)
                .then(_ => res.status(204).send())
                .catch(err => res.status(500).send(err))
        }
    }

    const remove = async (req, res) => {
        try {
            const rowsDeleted = await app.db('condominos')
                .where({ id: req.params.id }).del()
            
            try {
                existsOrError(rowsDeleted, 'Condômino não foi encontrado.')
            } catch(msg) {
                return res.status(400).send(msg)    
            }

            res.status(204).send()
        } catch(msg) {
            res.status(500).send(msg)
        }
    }

    const limit = 10 // usado para paginação
    const get = async (req, res) => {
        const page = req.query.page || 1

        const result = await app.db('condominos').count('id').first()
        const count = parseInt(result.count)

        app.db('condominos')
            .select('id', 'apartamento', 'responsavel', 'nome', 'parentesco', 'obs')
            .limit(limit).offset(page * limit - limit)
            .then(condominos => res.json({ data: condominos, count, limit }))
            .catch(err => res.status(500).send(err))
    }

    const getById = (req, res) => {
        app.db('condominos')
            .where({ id: req.params.id })
            .first()
            .then(condomino => {
                // condomino.content = condomino.content.toString()
                return res.json(condomino)
            })
            .catch(err => res.status(500).send(err))
    }

    const getByCategory = async (req, res) => {
        const categoryId = req.params.id
        const page = req.query.page || 1
        const categories = await app.db.raw(queries.categoryWithChildren, categoryId)
        const ids = categories.rows.map(c => c.id)

        app.db({a: 'condominos', u: 'users'})
            .select('a.id', 'a.apartamento', 'a.responsavel', 'nome', 'parentesco', 'obs',{ author: 'u.name' })
            .limit(limit).offset(page * limit - limit)
            .whereRaw('?? = ??', ['u.id', 'a.userId'])
            .whereIn('categoryId', ids)
            .orderBy('a.id', 'desc')
            .then(condominos => res.json(condominos))
            .catch(err => res.status(500).send(err))
    }

    return { save, remove, get, getById, getByCategory }
}