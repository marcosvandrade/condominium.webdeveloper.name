<template>
    <div class="condominos-admin">
        <b-form>
            <input id="condominos-id" type="hidden" v-model="condomino.id" />
            <b-form-group label="Apartment:" label-for="condomino-apartamento">
                <b-form-input id="condomino-apartamento" type="text"
                    v-model="condomino.apartamento" required
                    :readonly="mode === 'remove'"
                    placeholder="Inform the Owner..." />
            </b-form-group>
            <b-form-group 
                label="Responsible:" label-for="condomino-responsavel">
                <b-form-input id="condomino-responsavel" type="text"
                    v-model="condomino.responsavel"
                    :readonly="mode === 'remove'"
                    placeholder="Inform the person responsible for the apartment..." />
            </b-form-group>
            <b-form-group 
                label="Full name:" label-for="condomino-nome">
                <b-form-input id="condomino-nome" type="text"
                    v-model="condomino.nome"
                    :readonly="mode === 'remove'"
                    placeholder="Enter the name of the owner..." />
            </b-form-group>
            <b-form-group 
                label="Kinship:" label-for="condomino-parentesco">
                <b-form-input id="condomino-parentesco" type="text"
                    v-model="condomino.parentesco"
                    :readonly="mode === 'remove'"
                    placeholder="Inform the family member's degree of kinship..." />
            </b-form-group>
            <b-form-group v-if="mode === 'save'" 
                label="Menu:" label-for="condomino-categoryId">
                <b-form-select id="condomino-categoryId"
                    :options="categories" v-model="condomino.categoryId" />
            </b-form-group>
            <b-form-group v-if="mode === 'save'" 
                label="Author:" label-for="condomino-userId">
                <b-form-select id="condomino-userId"
                    :options="users" v-model="condomino.userId" />
            </b-form-group>
            <b-form-group v-if="mode === 'save'"
                label="Observation" label-for="condomino-obs">
                <VueEditor v-model="condomino.obs"
                    placeholder="Enter if there are remarks..." />
            </b-form-group>
            <b-button variant="primary" v-if="mode === 'save'"
                @click="save">Save</b-button>
            <b-button variant="danger" v-if="mode === 'remove'"
                @click="remove">Delete</b-button>
            <b-button class="ml-2" @click="reset">Cancel</b-button>
        </b-form>
        <hr>
        <b-table hover striped :items="condominos" :fields="fields">
            <template slot="actions" slot-scope="data">
                <b-button variant="warning" @click="loadCondomino(data.item)" class="mr-2">
                    <i class="fa fa-pencil"></i>
                </b-button>
                <b-button variant="danger" @click="loadCondomino(data.item, 'remove')">
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
    name: 'CondominoAdmin',
    components: { VueEditor },
data: function() {
        return {
            mode: 'save',
            condomino: {},
            condominos: [],
            categories: [],
            users: [],
            page: 1,
            limit: 0,
            count: 0,
            fields: [
                { key: 'id', label: 'Code', sortable: true },
                { key: 'apartamento', label: 'apartment', sortable: true },
                { key: 'responsavel', label: 'Responsible', sortable: true },
                { key: 'nome', label: 'Full name:', sortable: true },
                { key: 'parentesco', label: 'Kinship', sortable: true },
                { key: 'actions', label: 'Actions' }
            ]
        }
    },
    methods: {
        loadCondominos() {
            const url = `${baseApiUrl}/condominos?page=${this.page}`
            axios.get(url).then(res => {
                this.condominos = res.data.data
                this.count = res.data.count
                this.limit = res.data.limit
            })
        },
        reset() {
            this.mode = 'save'
            this.condomino = {}
            this.loadCondominos()
        },
        save() {
            const method = this.condomino.id ? 'put' : 'post'
            const id = this.condomino.id ? `/${this.condomino.id}` : ''
            axios[method](`${baseApiUrl}/condominos${id}`, this.condomino)
                .then(() => {
                    this.$toasted.global.defaultSuccess()
                    this.reset()
                })
                .catch(showError)
        },
        remove() {
            const id = this.condomino.id
            axios.delete(`${baseApiUrl}/condominos/${id}`)
                .then(() => {
                    this.$toasted.global.defaultSuccess()
                    this.reset()
                })
                .catch(showError)
        },
        loadCondomino(condomino, mode = 'save') {
            this.mode = mode
            axios.get(`${baseApiUrl}/condominos/${condomino.id}`)
                .then(res => this.condomino = res.data)
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
            this.loadCondominos()
        }
    },
    mounted() {
        this.loadUsers()
        this.loadCategories()
        this.loadCondominos()
    }
}
</script>

<style scoped>
    condominos-admin {
        width: 100%;
    }
</style>