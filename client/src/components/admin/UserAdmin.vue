<template>
    <div class="user-admin">
        <b-form>
            <input id="user-id" type="hidden" v-model="user.id" />
            <b-row>
                <b-col md="6" sm="12">
                    <b-form-group label="Nome Completo:" label-for="user-name">
                        <b-form-input id="user-name" type="text"
                            v-model="user.nome" required
                            :readonly="mode === 'remove'"
                            placeholder="Informe o Nome do Usuário" />
                    </b-form-group>
                </b-col>
                <b-col md="6" sm="12">
                    <b-form-group label="E-mail:" label-for="user-email">
                        <b-form-input id="user-email" type="text"
                            v-model="user.email" required
                            :readonly="mode === 'remove'"
                            placeholder="Informe o E-mail do Usuário" />
                    </b-form-group>
                </b-col>
            </b-row>
            <b-row v-show="mode === 'save'">
                <b-col md="6" sm="12">
                    <b-form-group label="Senha:" label-for="user-password">
                        <b-form-input id="user-password" type="password"
                            v-model="user.senha" required
                            placeholder="Informe a Senha do Usuário" />
                    </b-form-group>
                </b-col>
                <b-col md="6" sm="12">
                    <b-form-group label="Confirmação de Senha:" 
                        label-for="user-confirm-password">
                        <b-form-input id="user-confirm-password" type="password" required
                            placeholder="Confirme a Senha do Usuário" />
                    </b-form-group>
                </b-col>
                <b-form-checkbox id="user-admin" v-show="mode === 'save'"
                    v-model="user.administrador" class="mt-3 mb-3">
                    Administrador?
                </b-form-checkbox>
            </b-row>
            <b-row>
                <b-col md="6" sm="12">
                    <b-form-group label="CPF:" label-for="user-cpf">
                        <b-form-input id="user-cpf" type="text"
                            v-model="user.cpf" required
                            :readonly="mode === 'remove'"
                            placeholder="Informe o CPF do Usuário (somente números)" />
                    </b-form-group>
                </b-col>
                <b-col md="6" sm="12">
                    <b-form-group label="Apartamento:" label-for="user-apartamento">
                        <b-form-input id="user-apartamento" type="text"
                            v-model="user.apartamento" required
                            :readonly="mode === 'remove'"
                            placeholder="Informe o qual o seu apartamento" />
                    </b-form-group>
                </b-col>
            </b-row>
            <b-row>
                <b-col md="6" sm="12">
                    <b-form-group label="Contato:" label-for="user-contato">
                        <b-form-input id="user-contato" type="text"
                            v-model="user.contato1" required
                            :readonly="mode === 'remove'"
                            placeholder="Informe um telefone de contato" />
                    </b-form-group>
                </b-col>
            </b-row>
            <b-row>
                <b-col xs="12">
                    <b-button variant="primary" v-if="mode === 'save'"
                        @click="save">Salvar</b-button>
                    <b-button variant="danger" v-if="mode === 'remove'"
                        @click="remove">Excluir</b-button>
                    <b-button class="ml-2" @click="reset">Cancelar</b-button>
                </b-col>
            </b-row>
        </b-form>
        <hr>
        <b-table hover striped :items="users">
             <template slot="actions" slot-scope="data">
                <b-button variant="warning" @click="loadUser(data.item)" class="mr-2">
                    <i class="fa fa-pencil"></i>
                </b-button>
                <b-button variant="danger" @click="loadUser(data.item, 'remove')">
                    <i class="fa fa-trash"></i>
                </b-button>
            </template>
        </b-table>
    </div>
</template>

<script>
import { baseApiUrl, showError} from '@/global'
import axios from 'axios'

export default {
    name: 'UserAdmin',
    data: function() {
        return {
            mode: 'save',
            user: {},
            users: [],
            fields: [
                { key: 'id', label: 'Código', sortable: true },
                { key: 'nome', label: 'Nome Completo', sortable: true },
                { key: 'email', label: 'E-mail', sortable: true },
                { key: 'cpf', label: 'CPF', sortable: true },
                { key: 'apartamento', label: 'Apartamento', sortable: true },
                { key: 'contato1', label: 'Contato', sortable: true },
                { key: 'administrador', label: 'Administrador', sortable: true,
                    formatter: value => value ? 'Sim' : 'Não' },
                { key: 'actions', label: 'Ações' }
            ]
        }
    },
    methods: {
        loadUsers() {
            const url = `${baseApiUrl}/api/admin/usuarios`
            axios.get(url).then(res => {
                this.users = res.data
                // console.log(this.users)
            })
        },
         reset() {
            this.mode = 'save'
            this.user = {}
            this.loadUsers()
        },
        save() {
            const method = this.user.id ? 'put' : 'post'
            const id = this.user.id ? `/${this.user.id}` : ''
            axios[method](`${baseApiUrl}/api/admin/usuarios${id}`, this.user)
                .then(() => {
                    this.$toasted.global.defaultSuccess()
                    this.reset()
                })
                .catch(showError)
        },
        remove() {
            const id = this.user.id
            axios.delete(`${baseApiUrl}/api/admin/usuarios/${id}`)
                .then(() => {
                    this.$toasted.global.defaultSuccess()
                    this.reset()
                })
                .catch(showError)
        },
        loadUser(user, mode = 'save') {
            this.mode = mode
            this.user = { ...user }
        },
    },
        mounted() {
        this.loadUsers()
        }
    
}
</script>

<style>

</style>
