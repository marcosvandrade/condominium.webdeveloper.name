const queries = require('./queries')

module.exports = app => {
    const { existsOrError } = app.api.validation

    const save = (req, res) => {
        const noticia = { ...req.body }
        if(req.params.id) noticia.id = req.params.id

        try {
            existsOrError(noticia.title, 'Nome não informado')
            existsOrError(noticia.description, 'Descrição não informada')
            existsOrError(noticia.categoryId, 'Categoria não informada')
            existsOrError(noticia.userId, 'Autor não informado')
            existsOrError(noticia.content, 'Conteúdo não informado')
        } catch(msg) {
            res.status(400).send(msg)
        }

        if(noticia.id) {
            app.db('noticias')
                .update(noticia)
                .where({ id: noticia.id })
                .then(_ => res.status(204).send())
                .catch(err => res.status(500).send(err))
        } else {
            app.db('noticias')
                .insert(noticia)
                .then(_ => res.status(204).send())
                .catch(err => res.status(500).send(err))
        }
    }

    const remove = async (req, res) => {
        try {
            const rowsDeleted = await app.db('noticias')
                .where({ id: req.params.id }).del()
            
            try {
                existsOrError(rowsDeleted, 'Notícia não foi encontrado.')
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

        const result = await app.db('noticias').count('id').first()
        const count = parseInt(result.count)

        app.db('noticias')
            .select('id', 'name', 'description')
            .limit(limit).offset(page * limit - limit)
            .then(noticias => res.json({ data: noticias, count, limit }))
            .catch(err => res.status(500).send(err))
    }

    const getById = (req, res) => {
        app.db('noticias')
            .where({ id: req.params.id })
            .first()
            .then(noticia => {
                noticia.content = noticia.content.toString()
                return res.json(noticia)
            })
            .catch(err => res.status(500).send(err))
    }

    const getByCategory = async (req, res) => {
        const categoryId = req.params.id
        const page = req.query.page || 1
        const categories = await app.db.raw(queries.categoryWithChildren, categoryId)
        const ids = categories.rows.map(c => c.id)

        app.db({a: 'noticias', u: 'users'})
            .select('a.id', 'a.name', 'a.description', 'a.imageUrl', { author: 'u.name' })
            .limit(limit).offset(page * limit - limit)
            .whereRaw('?? = ??', ['u.id', 'a.userId'])
            .whereIn('categoryId', ids)
            .orderBy('a.id', 'desc')
            .then(noticias => res.json(noticias))
            .catch(err => res.status(500).send(err))
    }

    return { save, remove, get, getById, getByCategory }
}