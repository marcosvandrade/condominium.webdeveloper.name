<template>
    <div class="aviso-by-id">
        <PageTitle icon="fa fa-file-o" :main="aviso.title"/>
        <div class="aviso-content" v-html="aviso.content"></div>
    </div>
</template>

<script>
import 'highlightjs/styles/dracula.css'
import hljs from 'highlightjs/highlight.pack.js'
import { baseApiUrl } from '@/global'
import axios from 'axios'
import PageTitle from '../template/PageTitle'

export default {
    name: 'AvisoById',
    components: { PageTitle },
    data: function() {
        return {
            aviso: {}
        }
    },
    mounted() {
        const url = `${baseApiUrl}/avisos/${this.$route.params.id}`
        axios.get(url).then(res => this.aviso = res.data)
    },
    updated() {
        document.querySelectorAll('.aviso-content pre.ql-syntax').forEach(e => {
            hljs.highlightBlock(e)
        })
    }
}
</script>

<style>
    .aviso-content {
        background-color: #FFF;
        border-radius: 8px;
        padding: 25px;
    }

    .aviso-content pre {
        padding: 20px;
        border-radius: 8px;
        font-size: 1.2rem;
        background-color: #1e1e1e;
        color: #FFF;
    }

    .aviso-content img {
        max-width: 100%;
    }

    .aviso-content :last-child {
        margin-bottom: 0px;
    }
</style>
