
exports.up = function(knex, Promise) {
    return knex.schema.createTable('estacionamentos', table => {
        table.increments('id').primary()
        table.string('vaga').notNull()
        table.string('apartamento').notNull()
        table.string('nome').notNull()
        table.string('obs')
        table.integer('userId').references('id')
            .inTable('users').notNull()
        table.integer('categoryId').references('id')
            .inTable('categories').notNull()
    })
};

exports.down = function(knex, Promise) {
    return knex.schema.dropTable('estacionamentos')
};
