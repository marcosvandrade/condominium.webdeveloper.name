const admin = require('./admin')

module.exports = app => {
    app.post('/signup', app.api.user.save)
    app.post('/signin', app.api.auth.signin)
    app.post('/validateToken', app.api.auth.validateToken)

    app.route('/users')
        .all(app.config.passport.authenticate())
        .post(admin(app.api.user.save))
        .get(admin(app.api.user.get))

    app.route('/users/:id')
        .all(app.config.passport.authenticate())
        .put(admin(app.api.user.save))
        .get(admin(app.api.user.getById))
        .delete(admin(app.api.user.remove))

    app.route('/categories')
        .all(app.config.passport.authenticate())
        .get(admin(app.api.category.get))
        .post(admin(app.api.category.save))

    // Cuidado com ordem! Tem que vir antes de /categories/:id
    app.route('/categories/tree')
        .all(app.config.passport.authenticate())
        .get(app.api.category.getTree)

    app.route('/categories/:id')
        .all(app.config.passport.authenticate())
        .get(app.api.category.getById)
        .put(admin(app.api.category.save))
        .delete(admin(app.api.category.remove))

    app.route('/avisos')
        .all(app.config.passport.authenticate())
        .get(admin(app.api.aviso.get))
        .post(admin(app.api.aviso.save))

    app.route('/avisos/:id')
        .all(app.config.passport.authenticate())
        .get(app.api.aviso.getById)
        .put(admin(app.api.aviso.save))
        .delete(admin(app.api.aviso.remove))

    app.route('/categories/:id/avisos')
        .all(app.config.passport.authenticate())
        .get(app.api.aviso.getByCategory)

    app.route('/noticias')
        .all(app.config.passport.authenticate())
        .get(admin(app.api.noticia.get))
        .post(admin(app.api.noticia.save))

    app.route('/noticias/:id')
        .all(app.config.passport.authenticate())
        .get(app.api.noticia.getById)
        .put(admin(app.api.noticia.save))
        .delete(admin(app.api.noticia.remove))

    app.route('/categories/:id/noticias')
        .all(app.config.passport.authenticate())
        .get(app.api.noticia.getByCategory)

    app.route('/stats')
        .all(app.config.passport.authenticate())
        .get(app.api.stat.get)
}