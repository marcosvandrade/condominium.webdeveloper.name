<template>
  <b-list-group>
      <b-card>
          <b-button @click="listaUsuarios"
				size="lg" variant="success"
				class="ml-2">Listar
          </b-button>
      </b-card>
      
      <hr>
			<b-list-group-item v-for="(usuario, id) in usuarios" :key="id">
				<strong>Nome: </strong> {{ usuario.nome }}<br>
				<strong>E-mail: </strong> {{ usuario.email }}<br>
				<strong>ID: </strong> {{ id }}<br>
			</b-list-group-item>
		</b-list-group>
</template>

<script>
export default {
        data() {
            return {
                usuarios: []
            }
        },
        listaUsuarios() {
			this.$http.get('usuarios.json').then(res => {
				this.usuarios = res.data
				console.log(res.data)
			})
		}
}
</script>

<style>

</style>