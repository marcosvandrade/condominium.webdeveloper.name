<template>
    <div class="condomino-item">
            <div class="condomino-item-info">
                <b-table hover
                              striped
                              responsive
                              :items="condominos" :fields="fields"></b-table>
                <b-pagination size="md" v-model="page" :total-rows="count" :per-page="limit" />
            </div>
    </div>
</template>

<script>

import { baseApiUrl} from '@/global'
import axios from 'axios'

export default {
     name: 'CondominoItem',
    data: function() {
        return {
            condomino: {},
            condominos: [],
            page: 1,
            limit: 0,
            count: 0,
            fields: [
                // { key: 'id', label: 'Código', sortable: true },
                { key: 'apartamento', label: 'apartment', sortable: true },
                { key: 'responsavel', label: 'Responsible', sortable: true },
                { key: 'nome', label: 'Full name:', sortable: true },
                { key: 'parentesco', label: 'Kinship', sortable: true },
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
        loadCondomino(condomino) {
            axios.get(`${baseApiUrl}/condominos/${condomino.id}`)
                .then(res => this.condomino = res.data)
        },
    },
        watch: {
        page() {
            this.loadCondominos()
        }
    },
    mounted() {
        this.loadCondominos()
    }
}
</script>

<style>
    .codomino-item {
        border-radius: 8px;
        margin-bottom: 20px;
        background-color: #FFF;
        padding: 20px;
        border: 1px solid rgba(0, 0, 0, 0.2);
        box-shadow: 0 1px 5px rgba(0, 0, 0, 0.15);
    }

    .codomino-item a {
        display: flex;
        align-items: flex-start;
        text-decoration: none;
        color: #000;
    }

    .codomino-item-info h2 {
        font-size: 1.7rem;
    }

    .codomino-item-info {
        display: flex;
        align-self: stretch;
        flex-direction: column;
    }

    .codomino-item-info p {
        flex: 1;
        color: #555;
        font-size: 1.1rem;
    }
</style>
