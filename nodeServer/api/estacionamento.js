const queries = require('./queries')

module.exports = app => {
    const { existsOrError } = app.api.validation

    const save = (req, res) => {
        const estacionamento = { ...req.body }
        if(req.params.id) estacionamento.id = req.params.id

        try {
            existsOrError(estacionamento.vaga, 'Número da vaga não informada')
            existsOrError(estacionamento.apartamento, 'Apartamento não informado')
            existsOrError(estacionamento.nome, 'Nome não informado')
            existsOrError(estacionamento.userId, 'Autor não informado')
            existsOrError(estacionamento.categoryId, 'Categoria não informada')

        } catch(msg) {
            res.status(400).send(msg)
        }

        if(estacionamento.id) {
            app.db('estacionamentos')
                .update(estacionamento)
                .where({ id: estacionamento.id })
                .then(_ => res.status(204).send())
                .catch(err => res.status(500).send(err))
        } else {
            app.db('estacionamentos')
                .insert(estacionamento)
                .then(_ => res.status(204).send())
                .catch(err => res.status(500).send(err))
        }
    }

    const remove = async (req, res) => {
        try {
            const rowsDeleted = await app.db('estacionamentos')
                .where({ id: req.params.id }).del()
            
            try {
                existsOrError(rowsDeleted, 'Vaga não foi encontrada.')
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

        const result = await app.db('estacionamentos').count('id').first()
        const count = parseInt(result.count)

        app.db('estacionamentos')
            .select('id', 'vaga','apartamento', 'nome', 'obs')
            .limit(limit).offset(page * limit - limit)
            .then(estacionamentos => res.json({ data: estacionamentos, count, limit }))
            .catch(err => res.status(500).send(err))
    }

    const getById = (req, res) => {
        app.db('estacionamentos')
            .where({ id: req.params.id })
            .first()
            .then(estacionamento => {
                // estacionamento.content = estacionamento.content.toString()
                return res.json(estacionamento)
            })
            .catch(err => res.status(500).send(err))
    }

    const getByCategory = async (req, res) => {
        const categoryId = req.params.id
        const page = req.query.page || 1
        const categories = await app.db.raw(queries.categoryWithChildren, categoryId)
        const ids = categories.rows.map(c => c.id)

        app.db({a: 'estacionamentos', u: 'users'})
            .select('a.id', 'a.vaga','a.apartamento', 'a.nome', 'a.obs',{ author: 'u.name' })
            .limit(limit).offset(page * limit - limit)
            .whereRaw('?? = ??', ['u.id', 'a.userId'])
            .whereIn('categoryId', ids)
            .orderBy('a.id', 'desc')
            .then(estacionamentos => res.json(estacionamentos))
            .catch(err => res.status(500).send(err))
    }

    return { save, remove, get, getById, getByCategory }
}