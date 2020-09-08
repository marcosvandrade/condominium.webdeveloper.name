<template>
    <div class="avisos-by-category">
        <PageTitle icon="fa fa-folder-o"
            :main="category.name" />
        <ul>
            <li v-for="aviso in avisos" :key="aviso.id">
                <AvisoItem :aviso="aviso" />
            </li>
        </ul>
        <div class="load-more">
            <button v-if="loadMore"
                class="btn btn-lg btn-outline-primary"
                @click="getAvisos">Carregar Mais Avisos</button>
        </div>
    </div>
</template>

<script>
import { baseApiUrl } from '@/global'
import axios from 'axios'
import PageTitle from '../template/PageTitle'
import AvisoItem from './AvisoItem'

export default {
    name: 'AvisosByCategory',
    components: { PageTitle, AvisoItem },
    data: function() {
        return {
            category: {},
            avisos: [],
            page: 1,
            loadMore: true
        }
    },
    methods: {
        getCategory() {
            const url = `${baseApiUrl}/categories/${this.category.id}`
            axios(url).then(res => this.category = res.data)
        },
        getAvisos() {
            const url = `${baseApiUrl}/categories/${this.category.id}/avisos?page=${this.page}`
            axios(url).then(res => {
                this.avisos = this.avisos.concat(res.data)
                this.page++

                if(res.data.length === 0) this.loadMore = false
            })
        }
    },
    watch: {
        $route(to) {
            this.category.id = to.params.id
            this.avisos = []
            this.page = 1
            this.loadMore = true

            this.getCategory()
            this.getAvisos()
        }
    },
    mounted() {
        this.category.id = this.$route.params.id
        this.getCategory()
        this.getAvisos()
    }
}
</script>

<style>
    .avisos-by-category ul {
        list-style-type: none;
        padding: 0px;
    }

    .avisos-by-category .load-more {
        display: flex;
        flex-direction: column;
        align-items: center;
        margin-top: 25px;
    }
</style>
