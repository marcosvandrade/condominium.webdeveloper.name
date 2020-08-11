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
				</b-list-group-item>
			</b-list-group>
  </div>
</template>

<script>
import  Usuarios from '../services/usuarios'

export default {
		data() {
			return {
				usuarios: []
			}
		},
        props: {
			usuario: {
				
			}
		},
        methods: {
			listar() {
                Usuarios.listar (this.usuario)
                .then(resp => {
                       this.usuarios = resp.data
                })
			}
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