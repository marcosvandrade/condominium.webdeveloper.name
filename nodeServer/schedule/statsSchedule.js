const schedule = require('node-schedule')

module.exports = app => {
    schedule.scheduleJob('*/1 * * * *', async function () {
        const usersCount = await app.db('users').count('id').first()
        const categoriesCount = await app.db('categories').count('id').first()
        const avisosCount = await app.db('avisos').count('id').first()
        const noticiasCount = await app.db('noticias').count('id').first()

        const { Stat } = app.api.stat

        const lastStat = await Stat.findOne({}, {},
            { sort: { 'createdAt' : -1 } })

        const stat = new Stat({
            users: usersCount.count,
            categories: categoriesCount.count,
            avisos: avisosCount.count,
            noticias: noticiasCount.count,
            createdAt: new Date()
        })

        const changeUsers = !lastStat || stat.users !== lastStat.users
        const changeCategories = !lastStat || stat.categories !== lastStat.categories
        const changeAvisos = !lastStat || stat.avisos !== lastStat.avisos
        const changeNoticias = !lastStat || stat.noticias !== lastStat.noticias

        if(changeUsers || changeCategories  ||  changeAvisos || changeNoticias) {
            stat.save().then(() => console.log('[Stats] Estatíticas atualizadas!'))
        }
    })
}