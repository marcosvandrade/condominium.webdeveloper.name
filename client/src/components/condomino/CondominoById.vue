<template>
    <div class="condomino-by-id">
        <PageTitle icon="fa fa-file-o" :main="condomino.title"/>
        <div class="condomino-content" v-html="condomino.content"></div>
    </div>
</template>

<script>
import 'highlightjs/styles/dracula.css'
import hljs from 'highlightjs/highlight.pack.js'
import { baseApiUrl } from '@/global'
import axios from 'axios'
import PageTitle from '../template/PageTitle'

export default {
    name: 'CondominoById',
    components: { PageTitle },
    data: function() {
        return {
            condomino: {}
        }
    },
    mounted() {
        const url = `${baseApiUrl}/condominos/${this.$route.params.id}`
        axios.get(url).then(res => this.condomino = res.data)
    },
    updated() {
        document.querySelectorAll('.condomino-content pre.ql-syntax').forEach(e => {
            hljs.highlightBlock(e)
        })
    }
}
</script>

<style>
    .condomino-content {
        background-color: #FFF;
        border-radius: 8px;
        padding: 25px;
    }

    .condomino-content pre {
        padding: 20px;
        border-radius: 8px;
        font-size: 1.2rem;
        background-color: #1e1e1e;
        color: #FFF;
    }

    .condomino-content img {
        max-width: 100%;
    }

    .condomino-content :last-child {
        margin-bottom: 0px;
    }
</style>
