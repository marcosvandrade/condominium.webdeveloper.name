<template>
    <div class="condomino-item">
        <router-link :to="{ name: 'condominoById', params: { id: condomino.id } }">
            <div class="condomino-item-info">
                <b-table hover striped :items="condominos" :fields="fields"></b-table>
                <!-- <h2>{{ condomino.apartamento }}</h2>
                <p>{{ condomino.responsavel }}</p> -->
                <!-- <span class="condomino-item-author">
                    <strong>Autor: </strong>{{ condomino.author }}
                </span> -->
            </div>
        </router-link>
    </div>
</template>

<script>

import { baseApiUrl} from '@/global'
import axios from 'axios'

export default {
    name: 'CondominoItem',
    props: ['condomino'],
    data: function() {
        return {
            condomino: {},
            condominos: [],
            fields: [
                { key: 'id', label: 'Código', sortable: true },
                { key: 'apartamento', label: 'apartamento', sortable: true },
                { key: 'responsavel', label: 'Responsável', sortable: true },
                { key: 'nome', label: 'Nome Completo:', sortable: true },
                { key: 'parentesco', label: 'Parentesco', sortable: true },
                { key: 'actions', label: 'Ações' }
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
