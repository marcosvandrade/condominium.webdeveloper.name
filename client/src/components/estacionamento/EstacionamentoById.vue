<template>
    <div class="estacionamento-by-id">
        <PageTitle icon="fa fa-file-o" :main="estacionamento.vaga"/>
        <div class="estacionamento-nome" v-html="estacionamento.nome"></div>
    </div>
</template>

<script>
import 'highlightjs/styles/dracula.css'
import hljs from 'highlightjs/highlight.pack.js'
import { baseApiUrl } from '@/global'
import axios from 'axios'
import PageTitle from '../template/PageTitle'

export default {
    name: 'EstacionamentoById',
    components: { PageTitle },
    data: function() {
        return {
            estacionamento: {}
        }
    },
    mounted() {
        const url = `${baseApiUrl}/estacionamentos/${this.$route.params.id}`
        axios.get(url).then(res => this.estacionamento = res.data)
    },
    updated() {
        document.querySelectorAll('.estacionamento-responsavel pre.ql-syntax').forEach(e => {
            hljs.highlightBlock(e)
        })
    }
}
</script>

<style>
    .estacionamento-responsavel {
        background-color: #FFF;
        border-radius: 8px;
        padding: 25px;
    }

    .estacionamento-responsavel pre {
        padding: 20px;
        border-radius: 8px;
        font-size: 1.2rem;
        background-color: #1e1e1e;
        color: #FFF;
    }

    .estacionamento-responsavel img {
        max-width: 100%;
    }

    .estacionamento-responsavel :last-child {
        margin-bottom: 0px;
    }
</style>
