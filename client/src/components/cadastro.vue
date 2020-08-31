<template>
  <div id="cadastro">
    <h3>Solicitação de Acesso ao Sistema</h3>
    <b-alert
      show
      dismissible
      v-for="mensagem in mensagens"
      :key="mensagem.texto"
      :variant="mensagem.tipo"
    >{{ mensagem.texto }}</b-alert>
    <div class="form">
      <div>
        <label for="nome">Nome Completo *</label>
        <input
          type="text"
          id="nome"
          v-model.trim="usuario.nome"
          placeholder="Digite seu nome completo"
        />
      </div>
      <div>
        <label for="cpf">CPF *</label>
        <input type="text" id="cpf" v-model.trim="usuario.cpf" placeholder="Digite seu CPF" />
      </div>
      <div>
        <label for="apartamento">Apartamento *</label>
        <input
          type="text"
          id="apartamento"
          v-model.trim="usuario.apartamento"
          placeholder="Digite o número do seu apartamento"
        />
      </div>
      <div>
        <label for="contato1">Contato 1 *</label>
        <input
          type="text"
          id="contato1"
          v-model.trim="usuario.contato1"
          placeholder="Digite um telefone para contato"
        />
      </div>
      <div>
        <label for="contato2">Contato 2</label>
        <input
          type="text"
          id="contato2"
          v-model.trim="usuario.contato2"
          placeholder="Digite um telefone para contato"
        />
      </div>
      <div>
        <label for="email">Usuário *</label>
        <input
          type="email"
          id="email"
          v-model.trim="usuario.email"
          placeholder="Digite um e-mail válido"
        />
      </div>
      <div>
        <div>
          <!-- TODO configurar validacao para senha -->
          <label for="senha1">Senha *</label>
          <input
            type="password"
            id="senha1"
            v-model.trim="usuario.senha"
            placeholder="Digite sua senha"
          />
        </div>
        <div>
          <label for="senha2">&nbsp;</label>
          <input type="password" id="senha2" placeholder="Repita sua senha" />
        </div>
      </div>
      <div id="required">* Preenchimento obrigatório</div>
      <button @click="salvar">Enviar</button>
    </div>

    <div class="container">
      <b-list-group>
        <b-button @click="listar" size="lg" variant="success" class="ml-0">Listar Usuários</b-button>
        <b-list-group-item v-model.trim="usuario.id" v-for="(usuario, id) in usuarios" :key="id">
          <strong>ID:</strong>
          {{ usuario.id }}
          <br />
          <strong>Nome Completo:</strong>
          {{ usuario.nome }}
          <br />
          <strong>CPF:</strong>
          {{ usuario.cpf }}
          <br />
          <strong>E-mail:</strong>
          {{ usuario.email }}
          <br />
          <strong>Apartamento:</strong>
          {{ usuario.apartamento }}
          <br />
          <strong>Contato:</strong>
          {{ usuario.contato1 }}
          <br />

          <!-- <b-button variant="warning" size="lg"
          @click="carregar(id)">Carregar</b-button>-->

          <b-button variant="danger" size="lg" class="ml-2" @click="excluir(usuario.id)">Excluir</b-button>
        </b-list-group-item>
      </b-list-group>
    </div>

    <!-- <router-view /> -->
  </div>
</template>

<script>
import Usuarios from "../services/usuarios";
// import "../routes/routes"
// require('../assets/css/cadastro.css')

export default {
  name: "cadastro",
  data() {
    return {
      usuario: {
        id: null,
        nome: "",
        cpf: "",
        apartamento: "",
        contato1: "",
        contato2: "",
        email: "",
        senha: "",
      },
      usuarios: [],
      errors: [],
      mensagens: [],
    };
  },
  methods: {
    limpar() {
      this.usuario.nome = "";
      this.usuario.cpf = "";
      this.usuario.apartamento = "";
      this.usuario.contato1 = "";
      this.usuario.contato2 = "";
      this.usuario.email = "";
      this.usuario.senha = "";
      this.mensagens = [];
    },
    // carregar(id) {
    // 	// this.id = id
    // 	this.usuario = { ...this.usuarios[id] }
    // },
    listar() {
      Usuarios.listar(this.usuario).then((resp) => {
        this.usuarios = resp.data;
      });
    },
    salvar() {
      // const metodo = this.id ? 'atualizar' : 'salvar'
      Usuarios.salvar(this.usuario).then(() => {
        this.limpar();
        this.mensagens.push({
          texto: "Operação realizada com sucesso!",
          tipo: "success",
        });
      });
    },
    excluir(id) {
      Usuarios.deletar(id);
    },
  },
};
</script>

<style>
#cadastro {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

#cadastro h3 {
  display: flex;
  flex-direction: column;
  border: 1px solid #000;
  background-color: #0004;
  padding: 5px;
  margin-top: 15px;
  border-radius: 5px;
  width: 375px;
  font-size: 1.3em;
}

#cadastro .form {
  display: flex;
  flex-direction: column;
  padding: 5px;
  margin: 5px;
}

#cadastro .form input {
  display: flex;
  background-color: whitesmoke;
  margin: 5px;
  padding: 5px;
  width: 350px;
  border: 1px solid #fff4;
  border-radius: 5px;
}

#cadastro .form label {
  display: flex;
  padding: 0;
  margin-left: 5px;
}

#cadastro .form button {
  display: flex;
  flex-direction: column;
  padding: 7px;
  margin: 10px 110px;
  width: 150px;
  align-items: center;
  border: 1px solid #000;
  background-color: #0004;
  border-radius: 5px;
}

.container {
  color: rgb(16, 16, 48);
  padding: 0px;
  margin-bottom: 20px;
  display: flex;
  flex-direction: column;
  width: 600px;
}
</style>