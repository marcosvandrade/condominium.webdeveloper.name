<template>
  <div id="user" class="container">
	  		<h2>Usuários do Condomínio</h2>

	<b-list-group>
		<!-- <b-card>
			<b-button @click="listar"
					size="lg" variant="success"
					class="ml-2">Lista de Usuários
			</b-button>
		</b-card>
		<hr> -->
				<span>{{ listar() }}</span>
				<b-list-group-item v-for="(usuario, id) in usuarios" :key="id">
					<strong>Nome Completo: </strong> {{ usuario.nome }}<br>
					<strong>CPF: </strong> {{ usuario.cpf }}<br>
					<strong>E-mail: </strong> {{ usuario.email }}<br>
					<strong>Apartamento: </strong> {{ usuario.apartamento }}<br>
					<strong>Contato: </strong> {{ usuario.contato1 }}<br>
					
					<b-button variant="warning" size="lg"
					@click="carregar(id)">Carregar</b-button>
				    
					<b-button variant="danger" size="lg" class="ml-2"
					@click="excluir(id)">Excluir</b-button>
				</b-list-group-item>
			</b-list-group>
  </div>
</template>

<script>
import  Usuarios from '../services/usuarios'
import usuarios from '../services/usuarios'

export default {
		data() {
			return {
				usuarios: [],
				mensagem: []
								
			}
		},
        props: {
			usuario: [],
			mensagens: []
						
		},
        methods: {
		// 	 limpar() {
		// 	usuarios: [],
		// 	this.id = null,
		// 	mensagem: []
        // },
			listar() {
                Usuarios.listar (this.usuario)
                .then(resp => {
                       this.usuarios = resp.data
                })
			},
			carregar(id) {
			this.id = id
			this.usuario = { ...this.usuarios[id] }
		},
			excluir(id) {
			Usuarios.deletar(this.usuario)
				// .then(() => this.limpar())
				.then(resp => {
					this.mensagens = resp.this.mensagem.push({
						texto: 'Problema para excluir!',
						tipo: 'danger'
					})

				})
				// .catch(err => {
				// 	this.limpar()
				// })
		},
		}
}
</script>

<style>
#user {
	font-family: 'Avenir', Helvetica, Arial, sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	color: #2c3e50;
	font-size: 1.1rem;
	display: flex;
	flex-direction: column;
	
}

#user h2 {
	text-align: center;
	margin: 20px;
	color: whitesmoke;
	display: flex;	
}
</style>