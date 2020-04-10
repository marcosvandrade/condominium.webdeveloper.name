<template>
    <div class="login">
    <h5>Acesso ao Portal do Condomínio</h5>
    <br>    
    <form>
      <div class="form-group">
        <label for="email">Usuário</label>
        <input type="email" class="form-control" id="email" placeholder="Digite seu email">
        <!-- <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small> -->
      </div>
      <div class="form-group">
        <label for="senha">Senha</label>
        <input type="password" class="form-control" id="senha" placeholder="Digite sua senha">
      </div>
      
      <!-- TODO - IMPLEMENTAR GOOGLE RECAPTCHA -->
            
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
              <router-link class="btn btn-primary btn-sm" :to="{ name: 'cadastro' }">Cadastre-se</router-link>
            </div>
          </div>
        </div>
      </div>
    </form>
    <router-view/>
  </div>
</template>

<script>
export default {
    name: "login",
    data() {
        return {}
    },
    methods:{}
}
</script>

<style>

h5 {
  display: flexbox;
  margin: auto;
  font-family: Arial, Helvetica, sans-serif;
  text-align: center;
}

.login {
  display: flexbox;
  margin: auto;
  font-family: Arial, Helvetica, sans-serif;
  width: 400px;
  padding: 50px 0;
}

.form-check-label {
  font-size: 10pt;
}

</style>