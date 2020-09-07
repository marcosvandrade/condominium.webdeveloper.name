<template>
    <div class="noticias-by-category">
        <PageTitle icon="fa fa-folder-o"
            :main="category.name" sub="Categoria" />
        <ul>
            <li v-for="noticia in noticias" :key="noticia.id">
                <NoticiaItem :noticia="noticia" />
            </li>
        </ul>
        <div class="load-more">
            <button v-if="loadMore"
                class="btn btn-lg btn-outline-primary"
                @click="getNoticias">Carregar Mais Notícias</button>
        </div>
    </div>
</template>

<script>
import { baseApiUrl } from '@/global'
import axios from 'axios'
import PageTitle from '../template/PageTitle'
import NoticiaItem from './NoticiaItem'

export default {
    name: 'NoticiasByCategory',
    components: { PageTitle, NoticiaItem },
    data: function() {
        return {
            category: {},
            noticias: [],
            page: 1,
            loadMore: true
        }
    },
    methods: {
        getCategory() {
            const url = `${baseApiUrl}/categories/${this.category.id}`
            axios(url).then(res => this.category = res.data)
        },
        getNoticias() {
            const url = `${baseApiUrl}/categories/${this.category.id}/noticias?page=${this.page}`
            axios(url).then(res => {
                this.noticias = this.noticias.concat(res.data)
                this.page++

                if(res.data.length === 0) this.loadMore = false
            })
        }
    },
    watch: {
        $route(to) {
            this.category.id = to.params.id
            this.noticias = []
            this.page = 1
            this.loadMore = true

            this.getCategory()
            this.getNoticias()
        }
    },
    mounted() {
        this.category.id = this.$route.params.id
        this.getCategory()
        this.getNoticias()
    }
}
</script>

<style>
    .noticias-by-category ul {
        list-style-type: none;
        padding: 0px;
    }

    .noticias-by-category .load-more {
        display: flex;
        flex-direction: column;
        align-items: center;
        margin-top: 25px;
    }
</style>
