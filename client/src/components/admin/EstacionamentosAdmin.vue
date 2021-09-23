<template>
    <div class="estacionamentos-admin">
        <b-form>
            <input id="estacionamentos-id" type="hidden" v-model="estacionamento.id" />
            <b-form-group label="Vacancy:" label-for="estacionamento-vaga">
                <b-form-input id="estacionamento-vaga" type="text"
                    v-model="estacionamento.vaga" required
                    :readonly="mode === 'remove'"
                    placeholder="Enter the vacancy number..." />
            </b-form-group>
            <b-form-group 
                label="Apartment:" label-for="estacionamento-apartamento">
                <b-form-input id="estacionamento-apartamento" type="text"
                    v-model="estacionamento.apartamento"
                    :readonly="mode === 'remove'"
                    placeholder="Inform the person responsible for the vacancy's apartment..." />
            </b-form-group>
            <b-form-group 
                label="Name of Responsible:" label-for="estacionamento-nome">
                <b-form-input id="estacionamento-nome" type="text"
                    v-model="estacionamento.nome"
                    :readonly="mode === 'remove'"
                    placeholder="Enter the name of the person responsible for the vacancy..." />
            </b-form-group>
            <b-form-group v-if="mode === 'save'" 
                label="Menu:" label-for="estacionamento-categoryId">
                <b-form-select id="estacionamento-categoryId"
                    :options="categories" v-model="estacionamento.categoryId" />
            </b-form-group>
            <b-form-group v-if="mode === 'save'" 
                label="Author:" label-for="estacionamento-userId">
                <b-form-select id="estacionamento-userId"
                    :options="users" v-model="estacionamento.userId" />
            </b-form-group>
            <b-form-group v-if="mode === 'save'"
                label="Observation" label-for="estacionamento-obs">
                <VueEditor v-model="estacionamento.obs"
                    placeholder="Enter if there are remarks..." />
            </b-form-group>
            <b-button variant="primary" v-if="mode === 'save'"
                @click="save">Save</b-button>
            <b-button variant="danger" v-if="mode === 'remove'"
                @click="remove">Delete</b-button>
            <b-button class="ml-2" @click="reset">Cancel</b-button>
        </b-form>
        <hr>
        <b-table hover striped :items="estacionamentos" :fields="fields">
            <template slot="actions" slot-scope="data">
                <b-button variant="warning" @click="loadEstacionamento(data.item)" class="mr-2">
                    <i class="fa fa-pencil"></i>
                </b-button>
                <b-button variant="danger" @click="loadEstacionamento(data.item, 'remove')">
                    <i class="fa fa-trash"></i>
                </b-button>
            </template>
        </b-table>
        <b-pagination size="md" v-model="page" :total-rows="count" :per-page="limit" />
    </div>
</template>

<script>
import { VueEditor } from "vue2-editor"
import { baseApiUrl, showError } from '@/global'
import axios from 'axios'

export default {
    name: 'EstacionamentoAdmin',
    components: { VueEditor },
data: function() {
        return {
            mode: 'save',
            estacionamento: {},
            estacionamentos: [],
            categories: [],
            users: [],
            page: 1,
            limit: 0,
            count: 0,
            fields: [
                { key: 'vaga', label: 'Vacancy', sortable: true },
                { key: 'apartamento', label: 'Apartment', sortable: true },
                { key: 'nome', label: 'Name of Responsible', sortable: true },
                { key: 'obs', label: 'Observation', sortable: true },
                { key: 'actions', label: 'Actions' }
            ]
        }
    },
    methods: {
        loadEstacionamentos() {
            const url = `${baseApiUrl}/estacionamentos?page=${this.page}`
            axios.get(url).then(res => {
                this.estacionamentos = res.data.data
                this.count = res.data.count
                this.limit = res.data.limit
            })
        },
        reset() {
            this.mode = 'save'
            this.estacionamento = {}
            this.loadEstacionamentos()
        },
        save() {
            const method = this.estacionamento.id ? 'put' : 'post'
            const id = this.estacionamento.id ? `/${this.estacionamento.id}` : ''
            axios[method](`${baseApiUrl}/estacionamentos${id}`, this.estacionamento)
                .then(() => {
                    this.$toasted.global.defaultSuccess()
                    this.reset()
                })
                .catch(showError)
        },
        remove() {
            const id = this.estacionamento.id
            axios.delete(`${baseApiUrl}/estacionamentos/${id}`)
                .then(() => {
                    this.$toasted.global.defaultSuccess()
                    this.reset()
                })
                .catch(showError)
        },
        loadEstacionamento(estacionamento, mode = 'save') {
            this.mode = mode
            axios.get(`${baseApiUrl}/estacionamentos/${estacionamento.id}`)
                .then(res => this.estacionamento = res.data)
        },
        loadCategories() {
            const url = `${baseApiUrl}/categories`
            axios.get(url).then(res => {
                this.categories = res.data.map(category => {
                    return { value: category.id, text: category.path }
                })
            })
        },
       loadUsers() {
            const url = `${baseApiUrl}/users`
            axios.get(url).then(res => {
                this.users = res.data.map(user => {
                    return { value: user.id, text: `${user.name} - ${user.email}` }
                })
            })
        }
    },
    watch: {
        page() {
            this.loadEstacionamentos()
        }
    },
    mounted() {
        this.loadUsers()
        this.loadCategories()
        this.loadEstacionamentos()
    }
}
</script>

<style scoped>
    .estacionamentos-admin {
        width: 100%;
    }
</style>