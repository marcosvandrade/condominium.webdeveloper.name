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
              <small>Ainda não tem conta?</small>
            </div>
            <div>
              <button>Cadastre-se</button>
                 <!-- <cadastro /> -->
               <!-- <router-link v-on:click = "cadastro"  to= "./cadastro"></router-link>  -->
             </div>
          </div>
      </div>
  </div>
 </div>
</template>

<script>

// import Cadastro from './cadastro'

export default {
    name: "Login",
    // components: { Cadastro },
    // data() {
    //      return { Cadastro}
    //  },
}
</script>

<style>

#login h3 {
    border: 1px solid #000;
    background-color: #0004;
    padding: 15px;
    border-radius: 5px;
}

.form {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.form input {
  display: flex;
   padding: 15px;
   width: 350px;
}

.form label {
  display: flex;
  padding: 10px;
}

.form button {
  display: flex;
  padding: 10px;
  margin: 15px;
  width: 150px;
  justify-content: center;
}

</style>