<template>
    <div class="estacionamentos-by-category">
        <PageTitle icon="fa fa-folder-o"
            :main="category.name" />
        <ul>
            <li>
                <EstacionamentoItem />
            </li>
        </ul>
    </div>
</template>

<script>
import { baseApiUrl } from '@/global'
import axios from 'axios'
import PageTitle from '../template/PageTitle'
import EstacionamentoItem from './EstacionamentoItem'

export default {
    name: 'EstacionamentosByCategory',
    components: { PageTitle, EstacionamentoItem },
    data: function() {
        return {
            category: {},
            estacionamentos: [],
            page: 1,
            loadMore: true
        }
    },
    methods: {
        getCategory() {
            const url = `${baseApiUrl}/categories/${this.category.id}`
            axios(url).then(res => this.category = res.data)
        },
        getEstacionamentos() {
            const url = `${baseApiUrl}/categories/${this.category.id}/estacionamentos?page=${this.page}`
            axios(url).then(res => {
                this.estacionamentos = this.estacionamentos.concat(res.data)
                this.page++

                if(res.data.length === 0) this.loadMore = false
            })
        }
    },
    watch: {
        $route(to) {
            this.category.id = to.params.id
            this.estacionamentos = []
            this.page = 1
            this.loadMore = true

            this.getCategory()
            this.getEstacionamentos()
        }
    },
    mounted() {
        this.category.id = this.$route.params.id
        this.getCategory()
        this.getEstacionamentos()
    }
}
</script>

<style>
    .estacionamentos-by-category ul {
        list-style-type: none;
        padding: 0px;
    }

    .estacionamentos-by-category .load-more {
        display: flex;
        flex-direction: column;
        align-items: center;
        margin-top: 25px;
    }
</style>
