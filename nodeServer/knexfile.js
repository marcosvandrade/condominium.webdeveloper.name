const { db } = require('./.env')

module.exports = {
	client: 'postgresql',
	connection:{
		host : 'localhost',
        port: 5432,
		database: 'node_siscondominio',
		user: 'postgres',
		password: 'Fm6xwUJStQjn'
	},
	pool: {
		min: 2,
		max: 10
	},
	migrations: {
		tableName: 'knex_migrations'
	}
};