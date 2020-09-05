<template>
    <div class="noticia-by-id">
        <PageTitle icon="fa fa-file-o" :main="noticia.title"/>
        <div class="noticia-content" v-html="noticia.content"></div>
    </div>
</template>

<script>
import 'highlightjs/styles/dracula.css'
import hljs from 'highlightjs/highlight.pack.js'
import { baseApiUrl } from '../../global'
import axios from 'axios'
import PageTitle from '../template/PageTitle'

export default {
    name: 'NoticiaById',
    components: { PageTitle },
    data: function() {
        return {
            noticia: {}
        }
    },
    mounted() {
        const url = `${baseApiUrl}/api/noticias/${this.$route.params.id}`
        axios.get(url).then(res => this.noticia = res.data)
    },
    updated() {
        document.querySelectorAll('.noticia-content pre.ql-syntax').forEach(e => {
            hljs.highlightBlock(e)
        })
    }
}
</script>

<style>
    .noticia-content {
        background-color: #FFF;
        border-radius: 8px;
        padding: 25px;
    }

    .noticia-content pre {
        padding: 20px;
        border-radius: 8px;
        font-size: 1.2rem;
        background-color: #1e1e1e;
        color: #FFF;
    }

    .noticia-content img {
        max-width: 100%;
    }

    .noticia-content :last-child {
        margin-bottom: 0px;
    }
</style>
