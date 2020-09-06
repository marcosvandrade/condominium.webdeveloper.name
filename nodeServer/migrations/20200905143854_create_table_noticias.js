
exports.up = function(knex, Promise) {
    return knex.schema.createTable('noticias', table => {
        table.increments('id').primary()
        table.string('title').notNull()
        table.string('imageUrl', 1000)
        table.binary('content').notNull()
        table.integer('userId').references('id')
            .inTable('users').notNull()
       
    })
};

exports.down = function(knex, Promise) {
    return knex.schema.dropTable('noticias')
};
