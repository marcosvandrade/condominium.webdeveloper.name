<template>
    <div id="login">
    
    <h3>Acesso ao Portal do Condomínio</h3>
        
      <div class="form">
        <div>
          <label for="email">Usuário</label>
          <input type="email" id="email" placeholder="Digite seu email">
          <!-- <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small> -->
        </div>
        <div>
          <label for="senha">Senha</label>
          <input type="password" id="senha" placeholder="Digite sua senha">
        </div>
      
      <!-- TODO  IMPLEMENTAR GOOGLE RECAPTCHA -->
            
      <div><button type="submit">Acessar</button></div>
            
      <div>
        <div>
          <div>
            <div>
              <small id="cadastrar">Ainda não tem conta?</small>
            </div>
            <div>
              <button id="cadastro">Cadastre-se</button>
               <router-link v-on:click = "cadastro"  to= "./cadastro"></router-link> 
             </div>
          </div>
        </div>
      </div>
     <!-- <router-view/> -->
  </div>
 </div>
</template>

<script>

import Cadastro from "./cadastro"

export default {
    name: "login",
    components: { Cadastro },
    data() {
        return {}
    },
}
</script>

<style>

#login h3 {
    border: 1px solid #000;
    background-color: #0004;
    padding: 20px;
    margin-top: 0;
    margin-bottom: 30px;
}

.form {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    /* margin-bottom: 120px; */
}

.form input {
  display: flex;
   padding: 10px;
   margin: 10px;   
}

.form label {
  display: flex;
  padding: 10px;
}

.form button {
  display: inline;
  padding: 5px;
  margin: 10px;
}

/* .form-check-label {
  font-size: 10pt;
} */

</style>