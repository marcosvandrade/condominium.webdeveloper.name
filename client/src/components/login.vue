<template>
          
    <div id="login">

    <div  v-if="cadastro"> <Cadastro /> </div>  

    <h3 v-if="logado">Acesso ao Portal do Condomínio</h3>
        
      <div class="form" v-if="logado">
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
            
     <div><button type="submit" >Acessar</button></div> 
           
           <div>
              <small>Esqueci minha senha</small>
            </div>
           
  </div>
       <!-- <router-view /> -->

 </div>
</template>

<script>

import Cadastro from './cadastro'
require('../assets/css/login.css')

export default {
    name: "Login",
    components:{Cadastro},
    data() {
         return {
           logado: true,
           cadastro: ''
         }
              
     }
}

</script>
