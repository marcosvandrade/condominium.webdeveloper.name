module.exports = app => {
    const Stat = app.mongoose.model('Stat', {
        users: Number,
        avisos: Number,
        noticias: Number,
        createdAt: Date
    })

    const get = (req, res) => {
        Stat.findOne({}, {}, { sort: { 'createdAt' : -1 } })
            .then(stat => {
                const defaultStat = {
                    users: 0,
                    avisos: 0,
                    noticias: 0
                }
                res.json(stat || defaultStat)
            })
    }

    return { Stat, get }
}