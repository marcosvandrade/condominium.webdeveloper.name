<template>
    <div class="avisos-admin">
        <b-form>
            <input id="avisos-id" type="hidden" v-model="aviso.id" />
            <b-form-group label="Title:" label-for="aviso-title">
                <b-form-input id="aviso-title" type="text"
                    v-model="aviso.title" required
                    :readonly="mode === 'remove'"
                    placeholder="Inform the Notice..." />
            </b-form-group>
            <b-form-group v-if="mode === 'save'"
                label="Image (URL):" label-for="aviso-imageUrl">
                <b-form-input id="aviso-imageUrl" type="text"
                    v-model="aviso.imageUrl"
                    :readonly="mode === 'remove'"
                    placeholder="Enter the Image URL..." />
            </b-form-group>
            <b-form-group v-if="mode === 'save'" 
                label="Menu:" label-for="aviso-categoryId">
                <b-form-select id="aviso-categoryId"
                    :options="categories" v-model="aviso.categoryId" />
            </b-form-group>
            <b-form-group v-if="mode === 'save'" 
                label="Author:" label-for="aviso-userId">
                <b-form-select id="aviso-userId"
                    :options="users" v-model="aviso.userId" />
            </b-form-group>
            <b-form-group v-if="mode === 'save'"
                label="Contents" label-for="aviso-content">
                <VueEditor v-model="aviso.content"
                    placeholder="Inform the Content of the Notice..." />
            </b-form-group>
            <b-button variant="primary" v-if="mode === 'save'"
                @click="save">Save</b-button>
            <b-button variant="danger" v-if="mode === 'remove'"
                @click="remove">Delete</b-button>
            <b-button class="ml-2" @click="reset">Cancel</b-button>
        </b-form>
        <hr>
        <b-table hover striped :items="notices" :fields="fields">
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
                { key: 'id', label: 'Code', sortable: true },
                { key: 'title', label: 'Title', sortable: true },
                { key: 'actions', label: 'Actions' }
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
    .avisos-admin {
        width: 100%;
    }

</style>