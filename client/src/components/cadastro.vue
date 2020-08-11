<template>
<div id="cadastro">

    <h3>Solicitação de Acesso ao Sistema</h3>

    <div class="form">
        <div>
            <label for="nome">Nome Completo *</label>
            <input type="text" id="nome" v-model.trim="usuario.nome" placeholder="Digite seu nome completo">
        </div>
        <div>
            <label for="cpf">CPF *</label>
            <input type="text" id="cpf" v-model.trim="usuario.cpf" placeholder="Digite seu CPF">
        </div>     
        <div>
            <label for="apartamento">Apartamento *</label>
            <input type="text" id="apartamento" v-model.trim="usuario.apartamento" placeholder="Digite o número do seu apartamento">
        </div> 
        <div>
            <label for="contato1">Contato 1 *</label>
            <input type="text" id="contato1" v-model.trim="usuario.contato1" placeholder="Digite um telefone para contato">
        </div>
        <div>
            <label for="contato2">Contato 2</label>
            <input type="text" id="contato2"  v-model.trim="usuario.contato2" placeholder="Digite um telefone para contato">
        </div>  
        <div>
            <label for="email">Usuário</label>
            <input type="email" id="email" v-model.trim="usuario.email" placeholder="Digite um e-mail válido">
        </div>   
        <div>
            <div>
            <!-- TODO configurar validacao para senha -->
            <label for="senha1">Senha</label>
            <input type="password" id="senha1" v-model.trim="usuario.senha" placeholder="Digite sua senha">
            </div>
            <div>
            <label for="senha2">&nbsp;</label>
            <input type="password" id="senha2" placeholder="Repita sua senha">
            </div>
        </div>
        <div id = "required"> * Preenchimento obrigatório </div>
             <button @click="salvar">Enviar</button>
    </div>

     <!-- <router-view /> -->
</div>
</template>

<script>

import  Usuarios from '../services/usuarios'
// import "../routes/routes"
// require('../assets/css/cadastro.css')

    export default {
    name: "cadastro",
    data() {
        return {
           usuario: {
           id:'',
           nome: '', 
           cpf: '',
           apartamento: '',
           contato1: '',
           contato2: '',
           email: '',
           senha: '',
            },
            // usuarios: [], --listar
            errors:[]
        }
    },
    methods:{
        
        salvar() {
                Usuarios.salvar (this.usuario)
                .then(resp => {
                        this.usuario = {}
                })
       
        //     salvar(){
        //         Usuarios.salvar(this.usuario).then(resposta => {
        //             this.resposta = resposta
        //             this.usuario = {}
        //             this.errors = {}
        //             alert('Solicitação de cadastro enviada com sucesso!')
        //     }).catch(e => {
        //             this.errors = e.response.data.errors
        //     })
        // }
        }

    }
    }

</script>
