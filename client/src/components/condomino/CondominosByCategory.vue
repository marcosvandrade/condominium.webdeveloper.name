<template>
    <div class="condominos-by-category">
        <PageTitle icon="fa fa-folder-o"
            :main="category.name" />
        <ul>
            <li v-for="condomino in condominos" :key="condomino.id">
                <CondominoItem :condomino="condomino" />
            </li>
        </ul>
        <div class="load-more">
            <button v-if="loadMore"
                class="btn btn-lg btn-outline-primary"
                @click="getCondominos">Carregar Mais Condominos</button>
        </div>
    </div>
</template>

<script>
import { baseApiUrl } from '@/global'
import axios from 'axios'
import PageTitle from '../template/PageTitle'
import CondominoItem from './CondominoItem'

export default {
    name: 'CondominosByCategory',
    components: { PageTitle, CondominoItem },
    data: function() {
        return {
            category: {},
            condominos: [],
            page: 1,
            loadMore: true
        }
    },
    methods: {
        getCategory() {
            const url = `${baseApiUrl}/categories/${this.category.id}`
            axios(url).then(res => this.category = res.data)
        },
        getCondominos() {
            const url = `${baseApiUrl}/categories/${this.category.id}/condominos?page=${this.page}`
            axios(url).then(res => {
                this.condominos = this.condominos.concat(res.data)
                this.page++

                if(res.data.length === 0) this.loadMore = false
            })
        }
    },
    watch: {
        $route(to) {
            this.category.id = to.params.id
            this.condominos = []
            this.page = 1
            this.loadMore = true

            this.getCategory()
            this.getCondominos()
        }
    },
    mounted() {
        this.category.id = this.$route.params.id
        this.getCategory()
        this.getCondominos()
    }
}
</script>

<style>
    .condominos-by-category ul {
        list-style-type: none;
        padding: 0px;
    }

    .condominos-by-category .load-more {
        display: flex;
        flex-direction: column;
        align-items: center;
        margin-top: 25px;
    }
</style>
