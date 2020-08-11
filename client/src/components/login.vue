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

// require('../assets/css/login.css')

export default {
    name: "login",
    
    data() {
         return {
           logado: true,
           cadastro: ''
         }
              
     }
}

</script>

<style>

#login {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

#login h3 {
   display: flex;
   flex-direction: column;
    border: 1px solid #000;
    background-color: #0004;
    padding: 15px;
    margin: 30px;
    border-radius: 5px;
    width: 350px;
    font-size: 1.2em;
}

#login .form {
    display: flex;  
    flex-direction: column;
}

#login .form input {
  display: flex;
  background-color: whitesmoke;
  margin: 10px;
  padding: 10px;
  width: 350px;
  border: 1px solid #fff4;
  border-radius: 5px;
}

#login .form label {
  display: flex;
  padding: 1px;
  margin-left: 10px;
}

#login .form button {
  display: flex;
  flex-direction: column;
  padding: 7px;
  margin: 30px 110px;
  width: 150px;
  align-items: center;
  border: 1px solid #000;
  background-color: #0004;
  border-radius: 5px;
}

</style>