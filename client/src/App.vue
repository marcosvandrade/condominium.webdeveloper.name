<template>
  <v-app>
    <slot name = "login">
    <page-cadastro />
    <page-usuarios />
    </slot>
    
    <!-- <v-main>
      <router-view/>
    </v-main> -->
  </v-app>
</template>

<script>

// require('./assets/css/app.css')

export default {
    name: "App",
    
   }
</script>
