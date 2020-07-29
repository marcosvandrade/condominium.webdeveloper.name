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

export default {
    name: "App",
    components: { Login}
   }

</script>

<style>

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

#login h3 {
    border: 1px solid #000;
    background-color: #0004;
    padding: 15px;
    border-radius: 5px;
}

#login .form {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

#login .form input {
  display: flex;
    padding: 15px;
    width: 350px;
}

#login .form label {
  display: flex;
  padding: 10px;
}

#login .form button {
  display: flex;
  padding: 10px;
  margin: 15px;
  width: 150px;
  justify-content: center;
}


#register h3 {
    border: 1px solid #000;
    background-color: #0004;
    padding: 12px;
    margin-top: 0;
    margin-bottom: 30px;
}

#required {
    display: flex;
    padding: 5px;
    width: 300px;
}

#register .form {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

#register .form input {
  display: flex;
   padding: 5px;
   margin: 5px; 
   width: 300px;  
}

#register .form label {
  display: flex;
  padding: 1px;
}

#register .form button {
  display: flex;
  padding: 8px;
  margin: 10px;
}


</style>

