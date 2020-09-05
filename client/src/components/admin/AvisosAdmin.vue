<template>
    <div class="avisos-admin">
        <b-form>
            <input id="avisos-id" type="hidden" v-model="avisos.id" />
            <b-form-group label="Título:" label-for="avisos-title">
                <b-form-input id="avisos-title" type="text"
                    v-model="avisos.title" required
                    :readonly="mode === 'remove'"
                    placeholder="Informe o Aviso..." />
            </b-form-group>
            <b-form-group v-if="mode === 'save'"
                label="Imagem (URL):" label-for="avisos-imageUrl">
                <b-form-input id="avisos-imageUrl" type="text"
                    v-model="avisos.imageUrl"
                    :readonly="mode === 'remove'"
                    placeholder="Informe a URL da Imagem..." />
            </b-form-group>
            <b-form-group v-if="mode === 'save'" 
                label="Categoria:" label-for="avisos-categoryId">
                <b-form-select id="avisos-categoryId"
                    :options="categories" v-model="avisos.categoryId" />
            </b-form-group>
            <b-form-group v-if="mode === 'save'" 
                label="Autor:" label-for="avisos-id">
                <b-form-select id="avisos-id"
                    :options="users" v-model="avisos.id" />
            </b-form-group>
            <b-form-group v-if="mode === 'save'"
                label="Conteúdo" label-for="avisos-content">
                <VueEditor v-model="avisos.content"
                    placeholder="Informe o Conteúdo do Aviso..." />
            </b-form-group>
            <b-button variant="primary" v-if="mode === 'save'"
                @click="save">Salvar</b-button>
            <b-button variant="danger" v-if="mode === 'remove'"
                @click="remove">Excluir</b-button>
            <b-button class="ml-2" @click="reset">Cancelar</b-button>
        </b-form>
        <hr>
        <b-table hover striped :items="avisos" :fields="fields">
            <template slot="actions" slot-scope="data">
                <b-button variant="warning" @click="loadAviso(data.item)" class="mr-2">
                    <i class="fa fa-pencil"></i>
                </b-button>
                <b-button variant="danger" @click="loadAviso(data.item, 'remove')">
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
    name: 'AvisoAdmin',
    components: { VueEditor },
data: function() {
        return {
            mode: 'save',
            aviso: {},
            avisos: [],
            categories: [],
            users: [],
            page: 1,
            limit: 0,
            count: 0,
            fields: [
                { key: 'id', label: 'Código', sortable: true },
                { key: 'title', label: 'Título', sortable: true },
                { key: 'actions', label: 'Ações' }
            ]
        }
    },
    methods: {
        loadAvisos() {
            const url = `${baseApiUrl}/avisos?page=${this.page}`
            axios.get(url).then(res => {
                this.avisos = res.data.data
                this.count = res.data.count
                this.limit = res.data.limit
            })
        },
        reset() {
            this.mode = 'save'
            this.aviso = {}
            this.loadAvisos()
        },
        save() {
            const method = this.aviso.id ? 'put' : 'post'
            const id = this.aviso.id ? `/${this.aviso.id}` : ''
            axios[method](`${baseApiUrl}/avisos${id}`, this.aviso)
                .then(() => {
                    this.$toasted.global.defaultSuccess()
                    this.reset()
                })
                .catch(showError)
        },
        remove() {
            const id = this.aviso.id
            axios.delete(`${baseApiUrl}/avisos/${id}`)
                .then(() => {
                    this.$toasted.global.defaultSuccess()
                    this.reset()
                })
                .catch(showError)
        },
        loadAviso(aviso, mode = 'save') {
            this.mode = mode
            axios.get(`${baseApiUrl}/avisos/${aviso.id}`)
                .then(res => this.aviso = res.data)
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
            this.loadAvisos()
        }
    },
    mounted() {
        this.loadUsers()
        this.loadCategories()
        this.loadAvisos()
    }
}
</script>

<style>
    
</style>