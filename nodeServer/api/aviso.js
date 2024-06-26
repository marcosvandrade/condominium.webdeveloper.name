const queries = require('./queries')

module.exports = app => {
    const { existsOrError } = app.api.validation

    const save = (req, res) => {
        const aviso = { ...req.body }
        if(req.params.id) aviso.id = req.params.id

        try {
            existsOrError(aviso.title, 'Nome não informado')
            existsOrError(aviso.userId, 'Autor não informado')
            existsOrError(aviso.content, 'Conteúdo não informado')
            existsOrError(aviso.categoryId, 'Categoria não informada')

        } catch(msg) {
            res.status(400).send(msg)
        }

        if(aviso.id) {
            app.db('avisos')
                .update(aviso)
                .where({ id: aviso.id })
                .then(_ => res.status(204).send())
                .catch(err => res.status(500).send(err))
        } else {
            app.db('avisos')
                .insert(aviso)
                .then(_ => res.status(204).send())
                .catch(err => res.status(500).send(err))
        }
    }

    const remove = async (req, res) => {
        try {
            const rowsDeleted = await app.db('avisos')
                .where({ id: req.params.id }).del()
            
            try {
                existsOrError(rowsDeleted, 'Aviso não foi encontrado.')
            } catch(msg) {
                return res.status(400).send(msg)    
            }

            res.status(204).send()
        } catch(msg) {
            res.status(500).send(msg)
        }
    }

    const limit = 3 // usado para paginação
    const get = async (req, res) => {
        const page = req.query.page || 1

        const result = await app.db('avisos').count('id').first()
        const count = parseInt(result.count)

        app.db('avisos')
            .select('id', 'title')
            .limit(limit).offset(page * limit - limit)
            .then(avisos => res.json({ data: avisos, count, limit }))
            .catch(err => res.status(500).send(err))
    }

    const getById = (req, res) => {
        app.db('avisos')
            .where({ id: req.params.id })
            .first()
            .then(aviso => {
                aviso.content = aviso.content.toString()
                return res.json(aviso)
            })
            .catch(err => res.status(500).send(err))
    }

    const getByCategory = async (req, res) => {
        const categoryId = req.params.id
        const page = req.query.page || 1
        const categories = await app.db.raw(queries.categoryWithChildren, categoryId)
        const ids = categories.rows.map(c => c.id)

        app.db({a: 'avisos', u: 'users'})
            .select('a.id', 'a.title', 'a.imageUrl', { author: 'u.name' })
            .limit(limit).offset(page * limit - limit)
            .whereRaw('?? = ??', ['u.id', 'a.userId'])
            .whereIn('categoryId', ids)
            .orderBy('a.id', 'desc')
            .then(avisos => res.json(avisos))
            .catch(err => res.status(500).send(err))
    }

    return { save, remove, get, getById, getByCategory }
}