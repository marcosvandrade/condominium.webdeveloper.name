
exports.up = function(knex, Promise) {
    return knex.schema.createTable('condominos', table => {
        table.increments('id').primary()
        table.string('apartamento').notNull()
        table.string('responsavel').notNull()
        table.string('nome').notNull()
        table.string('parentesco')
        table.string('obs')
        table.integer('userId').references('id')
            .inTable('users').notNull()
        table.integer('categoryId').references('id')
            .inTable('categories').notNull()
    })
};

exports.down = function(knex, Promise) {
    return knex.schema.dropTable('condominos')
};
