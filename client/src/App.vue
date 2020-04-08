<template>
  <div class="flex-container">
    <h5>Acesso ao Portal do Condomínio</h5>
    <br>    
    <form>
      <div class="form-group">
        <label for="exampleInputEmail1">Usuário</label>
        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Digite seu email">
        <!-- <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small> -->
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">Senha</label>
        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Digite sua senha">
      </div>
      
      <!-- GOTO - IMPLEMENTAR GOOGLE RECAPTCHA -->
            
      <div class="form-group form-check">
        <div class="container">
          <div class="row">
            <div class="col-sm">
              <input type="checkbox" class="form-check-input" id="exampleCheck1">
              <label class="form-check-label" for="exampleCheck1">Manter-me conectado</label>
            </div>
            <div class="col-sm">
              <small id="passwordHelp" class="form-text text-muted">Esqueceu sua senha?</small>
            </div>
          </div>
        </div>
      </div>
      <button type="submit" class="btn btn-primary btn-block btn-sm">Acessar</button>
      <br>
      <div class="form-group">
        <div class="container">
          <div class="row">
            <div class="col-sm">
              <small id="cadastrar" class="form-text text-muted">Ainda não tem conta?</small>
            </div>
            <div class="col-sm">
              <button type="submit" id="cadastrar" class="btn btn-primary btn-sm">Cadastre-se</button>
            </div>
          </div>
        </div>
      </div>
    </form>
  </div>

</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'
export default {

name: 'App',
  // components: {
  //   HelloWorld
}

</script>

<style>

/* body {
  background-color: #4b755505;
  font-family: Arial, Helvetica, sans-serif;
  width: 400px;
  margin: auto;
  padding: 150px 0;  
} */

h5 {
  display: flexbox;
  margin: auto;
  font-family: Arial, Helvetica, sans-serif;
  text-align: center;
}

.flex-container {
  display: flexbox;
  margin: auto;
  font-family: Arial, Helvetica, sans-serif;
  width: 400px;
  padding: 100px 0;
}

.captchaContainer {
  display: flex;
 
}

/* .captcha {
  display: flexbox;
  
} */

/* 
.form-group {
  
} */


/* @import url(https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css); */

</style>
