const { db } = require('./.env')

module.exports = {
	client: 'postgresql',
	connection:{
		host : 'postgres-instance.clab2bcpgufq.us-east-1.rds.amazonaws.com',
        port: 5432,
		database: 'node_siscondominio',
		user: 'postgres',
		password: 'Fm6xwUJStQjn'
	},
	pool: {
		min: 2,
		max: 10,
		acquireTimeout: 60 * 1000
	},
	migrations: {
		tableName: 'knex_migrations'
	}
};