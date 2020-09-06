<template>
    <div class="noticias-admin">
        <b-form>
            <input id="noticias-id" type="hidden" v-model="noticia.id" />
            <b-form-group label="Título:" label-for="noticia-title">
                <b-form-input id="noticia-title" type="text"
                    v-model="noticia.title" required
                    :readonly="mode === 'remove'"
                    placeholder="Informe a notícia..." />
            </b-form-group>
            <b-form-group v-if="mode === 'save'"
                label="Imagem (URL):" label-for="noticia-imageUrl">
                <b-form-input id="noticia-imageUrl" type="text"
                    v-model="noticia.imageUrl"
                    :readonly="mode === 'remove'"
                    placeholder="Informe a URL da Imagem..." />
            </b-form-group>
            <b-form-group v-if="mode === 'save'" 
                label="Autor:" label-for="noticia.userId">
                <b-form-select id="noticia.userId"
                    :options="users" v-model="noticia.userId" />
            </b-form-group>
            <b-form-group v-if="mode === 'save'"
                label="Conteúdo" label-for="noticia-content">
                <VueEditor v-model="noticia.content"
                    placeholder="Informe o Conteúdo da Notícia..." />
            </b-form-group>
            <b-button variant="primary" v-if="mode === 'save'"
                @click="save">Salvar</b-button>
            <b-button variant="danger" v-if="mode === 'remove'"
                @click="remove">Excluir</b-button>
            <b-button class="ml-2" @click="reset">Cancelar</b-button>
        </b-form>
        <hr>
        <b-table hover striped :items="noticias" :fields="fields">
            <template slot="actions" slot-scope="data">
                <b-button variant="warning" @click="loadNoticia(data.item)" class="mr-2">
                    <i class="fa fa-pencil"></i>
                </b-button>
                <b-button variant="danger" @click="loadNoticia(data.item, 'remove')">
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
    name: 'NoticiaAdmin',
    components: { VueEditor },
data: function() {
        return {
            mode: 'save',
            noticia: {},
            noticias: [],
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
        loadNoticias() {
            const url = `${baseApiUrl}/noticias?page=${this.page}`
            axios.get(url).then(res => {
                this.noticias = res.data.data
                this.count = res.data.count
                this.limit = res.data.limit
            })
        },
        reset() {
            this.mode = 'save'
            this.noticia = {}
            this.loadNoticias()
        },
        save() {
            const method = this.noticia.id ? 'put' : 'post'
            const id = this.noticia.id ? `/${this.noticia.id}` : ''
            axios[method](`${baseApiUrl}/noticias${id}`, this.noticia)
                .then(() => {
                    this.$toasted.global.defaultSuccess()
                    this.reset()
                })
                .catch(showError)
        },
        remove() {
            const id = this.noticia.id
            axios.delete(`${baseApiUrl}/noticias/${id}`)
                .then(() => {
                    this.$toasted.global.defaultSuccess()
                    this.reset()
                })
                .catch(showError)
        },
        loadNoticia(noticia, mode = 'save') {
            this.mode = mode
            axios.get(`${baseApiUrl}/noticias/${noticia.id}`)
                .then(res => this.noticia = res.data)
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
            this.loadNoticias()
        }
    },
    mounted() {
        this.loadUsers()
        this.loadNoticias()
    }
}
</script>

<style>
    
</style>