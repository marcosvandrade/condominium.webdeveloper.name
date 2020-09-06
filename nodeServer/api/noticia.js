
module.exports = app => {
    const { existsOrError } = app.api.validation

    const save = (req, res) => {
        const noticia = { ...req.body }
        if(req.params.id) noticia.id = req.params.id

        try {
            existsOrError(noticia.title, 'Nome não informado')
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
            .select('id', 'title')
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

    return { save, remove, get, getById }
}