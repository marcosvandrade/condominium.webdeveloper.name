<template>
<div class="cadastro">
    <h5>Solicitação de Acesso ao Sistema</h5>
    <form>
    <div class="form-group">
        <label for="nome">Nome Completo *</label>
        <input type="text" class="form-control" id="nome" placeholder="Digite seu nome completo">
    </div>    
    <div class="form-group">
        <label for="apartamento">Apartamento *</label>
        <input type="text" class="form-control" id="apartamento" placeholder="Digite o número do seu apartamento">
    </div> 
    <div class="form-group">
        <label for="contato1">Contato 1 *</label>
        <input type="text" class="form-control" id="contato1" placeholder="Digite um telefone para contato">
    </div>
    <div class="form-group">
        <label for="contato2">Contato 2</label>
        <input type="text" class="form-control" id="contato2" placeholder="Digite um telefone para contato">
    </div>  
    <div class="form-group">
        <label for="email">Usuário</label>
        <input type="email" class="form-control" id="email" placeholder="Digite um e-mail válido">
    </div>   
    <div class="form-row">
        <div class="form-group col-md-6">
        <label for="senha1">Senha</label>
        <input type="password" class="form-control" id="senha1" placeholder="Digite sua senha">
        </div>
        <div class="form-group col-md-6">
        <label for="senha2">&nbsp;</label>
        <input type="password" class="form-control" id="senha2" placeholder="Repita sua senha">
        </div>
    </div>
    <div>
      <small class="form-text text-muted">* Preenchimento obrigatório</small>
    </div>
    <div class="form-group">
        <div class="form-check">
        <input class="form-check-input" type="checkbox" id="gridCheck">
        <label class="form-check-label" for="gridCheck">
            Eu concordo com os termos
            <!-- TODO - TERMOS DE ACESSO -->
        </label>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Enviar</button>
    </form>
</div>
</template>

<script>
    export default {
    name: "cadastro",
    data() {
        return {}
    },
    methods:{}
}
</script>

<style>

h5 {
  display: flexbox;
  padding: 30px;
  margin: auto;
  font-family: Arial, Helvetica, sans-serif;
  text-align: center;
}

small {
  margin: auto;
}

.cadastro {
  display: flexbox;
  margin: auto;
  font-family: Arial, Helvetica, sans-serif;
  width: 450px;
  padding: 50px 0;
}

.form-check {
    display: flexbox;
    margin: auto;
    padding: 4%;
}


</style>