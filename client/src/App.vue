<template>
  <div id="app">
    <!-- <router-view/> -->
    <Login />
    <!-- <Cadastro /> -->
  </div>
</template>

<script>

import Login from "./components/login"

export default {
    name: "App",
    components: { Login }
   }

</script>

<style>

/* @font-face {
    font-family: "RobotoMono";
    src: url("./fonts/RobotoMono-Thin.ttf");
}

* {
    font-family: "RobotoMono", monospace;
} */

* {
    box-sizing: border-box;
    font-family: 'Montserrat', sans-serif;
}

body {
    margin: 0;
}

#app {
    display: flex;
    flex-direction: column;
    height: 100vh;
    justify-content: center;
    align-items: center;
    text-align: center;

    color: whitesmoke;
    background: linear-gradient(to right, #1f4037, #99f2c8);
}

</style>

