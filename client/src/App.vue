<template>
  <v-app>
    <Login />
    <!-- <v-main>
      <router-view/>
    </v-main> -->
  </v-app>
</template>

<script>

import Login from "./components/login"
import Cadastro from "./components/cadastro"
require('./assets/css/app.css')
export default {
    name: "App",
    components: { Login}
   }
</script>
