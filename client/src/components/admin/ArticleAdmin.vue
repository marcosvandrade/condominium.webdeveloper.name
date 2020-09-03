<template>
    <div class="article-admin">
        <b-form>
            <input id="article-id" type="hidden" v-model="article.id" />
            <b-form-group label="Título:" label-for="article-title">
                <b-form-input id="article-title" type="text"
                    v-model="article.title" required
                    :readonly="mode === 'remove'"
                    placeholder="Informe o Título do Artigo..." />
            </b-form-group>
            <!-- <b-form-group label="Descrição" label-for="article-description">
                <b-form-input id="article-description" type="text"
                    v-model="article.description" required
                    :readonly="mode === 'remove'"
                    placeholder="Informe o Nome do Artigo..." />
            </b-form-group> -->
            <b-form-group v-if="mode === 'save'"
                label="Imagem (URL):" label-for="article-imageUrl">
                <b-form-input id="article-imageUrl" type="text"
                    v-model="article.imageUrl"
                    :readonly="mode === 'remove'"
                    placeholder="Informe a URL da Imagem..." />
            </b-form-group>
            <!-- <b-form-group v-if="mode === 'save'" 
                label="Categoria:" label-for="article-categoryId">
                <b-form-select id="article-categoryId"
                    :options="categories" v-model="article.categoryId" />
            </b-form-group> -->
            <!-- <b-form-group v-if="mode === 'save'" 
                label="Autor:" label-for="article-id">
                <b-form-select id="article-id"
                    :options="users" v-model="article.id" />
            </b-form-group> -->
            <b-form-group v-if="mode === 'save'"
                label="Conteúdo" label-for="article-content">
                <VueEditor v-model="article.content"
                    placeholder="Informe o Conteúdo do Artigo..." />
            </b-form-group>
            <b-button variant="primary" v-if="mode === 'save'"
                @click="save">Salvar</b-button>
            <b-button variant="danger" v-if="mode === 'remove'"
                @click="remove">Excluir</b-button>
            <b-button class="ml-2" @click="reset">Cancelar</b-button>
        </b-form>
        <hr>
        <b-table hover striped :items="articles" :fields="fields">
            <template slot="actions" slot-scope="data">
                <!-- <b-button variant="warning" @click="loadArticle(data.item)" class="mr-2">
                    <i class="fa fa-pencil"></i>
                </b-button> -->
                <b-button variant="danger" @click="loadArticle(data.item, 'remove')">
                    <i class="fa fa-trash"></i>
                </b-button>
            </template>
        </b-table>
        <!-- <b-pagination size="md" v-model="page" :total-rows="count" :per-page="limit" /> -->
    </div>
</template>

<script>
import { VueEditor } from "vue2-editor"
import { baseApiUrl, showError } from '../../global'
import axios from 'axios'

export default {
    name: 'ArticleAdmin',
    components: { VueEditor },
    data: function() {
        return {
            mode: 'save',
            article: {},
            articles: [],
            fields: [
                { key: 'id', label: 'Código', sortable: true },
                { key: 'title', label: 'Título', sortable: true },
                { key: 'actions', label: 'Ações' }
            ]
        }
    },
    methods: {
        loadArticles() {
            const url = `${baseApiUrl}/api/articles/`
            axios.get(url).then(res => {
                this.articles = res.data
            })
        },
        reset() {
            this.mode = 'save'
            this.article = {}
            this.loadArticles()
        },
        save() {
            const method = this.article.id ? 'put' : 'post'
            const id = this.article.id ? `/${this.article.id}` : ''
            axios[method](`${baseApiUrl}/api/articles${id}`, this.article)
                .then(() => {
                    this.$toasted.global.defaultSuccess()
                    this.reset()
                })
                .catch(showError)
        },
        remove() {
            const id = this.article.id
            axios.delete(`${baseApiUrl}/api/articles/${id}`)
                .then(() => {
                    this.$toasted.global.defaultSuccess()
                    this.reset()
                })
                .catch(showError)
        },
        loadArticle(article, mode = 'save') {
            this.mode = mode
            axios.get(`${baseApiUrl}/api/articles/${article.id}`)
                .then(res => this.article = res.data)
        }
        // loadUsers() {
        //     const url = `${baseApiUrl}/api/admin/usuarios`
        //     axios.get(url).then(res => {
        //         this.users = res.data.map(user => {
        //             return { value: user.id, text: `${user.nome} - ${user.email}` }
        //         })
        //     })
        // }
    },
    // watch: {
    //     page() {
    //         this.loadArticles()
    //     }
    // },
    mounted() {
        // this.loadUsers()
        this.loadArticles()
    }
}
</script>

<style>
    
</style>