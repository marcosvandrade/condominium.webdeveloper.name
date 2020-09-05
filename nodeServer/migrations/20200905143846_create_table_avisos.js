
exports.up = function(knex, Promise) {
    return knex.schema.createTable('avisos', table => {
        table.increments('id').primary()
        table.string('title').notNull()
        table.string('imageUrl', 1000)
        table.binary('content').notNull()
        table.integer('userId').references('id')
            .inTable('users').notNull()
        table.integer('categoryId').references('id')
            .inTable('categories').notNull()
    })
};

exports.down = function(knex, Promise) {
    return knex.schema.dropTable('avisos')
};
