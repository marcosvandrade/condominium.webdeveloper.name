<template>
  <div id="app">
    <!-- <router-view/> -->
    <Login />
    <!-- <Cadastro /> -->
  </div>
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

