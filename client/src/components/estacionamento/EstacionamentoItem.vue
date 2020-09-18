<template>
    <div class="estacionamento-item">
            <div class="estacionamento-item-info">
                <b-table hover
                              striped
                              responsive
                              :items="estacionamentos" :fields="fields"></b-table>
                <b-pagination size="md" v-model="page" :total-rows="count" :per-page="limit" />
            </div>
    </div>
</template>

<script>

import { baseApiUrl} from '@/global'
import axios from 'axios'

export default {
     name: 'EstacionamentoItem',
    data: function() {
        return {
            estacionamento: {},
            estacionamentos: [],
            page: 1,
            limit: 0,
            count: 0,
            fields: [
                { key: 'vaga', label: 'Vaga', sortable: true },
                { key: 'apartamento', label: 'Apartamento', sortable: true },
                { key: 'nome', label: 'Nome do Responsável', sortable: true },
                { key: 'obs', label: 'Nome Completo:', sortable: true },
            ]
        }
    },
    methods: {
        loadEstacionamentos() {
            const url = `${baseApiUrl}/estacionamentos?page=${this.page}`
            axios.get(url).then(res => {
                this.estacionamentos = res.data.data
                this.count = res.data.count
                this.limit = res.data.limit
            })
        },
        loadEstacionamento(estacionamento) {
            axios.get(`${baseApiUrl}/estacionamentos/${estacionamento.id}`)
                .then(res => this.estacionamento = res.data)
        },
    },
        watch: {
        page() {
            this.loadEstacionamentos()
        }
    },
    mounted() {
        this.loadEstacionamentos()
    }
}
</script>

<style>
    .estacionamento-item {
        border-radius: 8px;
        margin-bottom: 20px;
        background-color: #FFF;
        padding: 20px;
        border: 1px solid rgba(0, 0, 0, 0.2);
        box-shadow: 0 1px 5px rgba(0, 0, 0, 0.15);
    }

    .estacionamento-item a {
        display: flex;
        align-items: flex-start;
        text-decoration: none;
        color: #000;
    }

    .estacionamento-item-info h2 {
        font-size: 1.7rem;
    }

    .estacionamento-item-info {
        display: flex;
        align-self: stretch;
        flex-direction: column;
    }

    .estacionamento-item-info p {
        flex: 1;
        color: #555;
        font-size: 1.1rem;
    }
</style>
