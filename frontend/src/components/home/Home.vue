<template>
    <div class="home">
        <PageTitle icon="fa fa-home" main="Página Inicial"
            sub="Bem vindo!" />
        <!-- <div class="article">
            <Article title="Artigos"
                icon="fa fa-file" color="#d54d50" />
            <Article title="Artigos" 
                icon="fa fa-file" color="#3bc480" />
            <Article title="Artigos" 
                icon="fa fa-file" color="#3282cd" />
            
        </div> -->
    </div>
</template>

<script>
import PageTitle from '../template/PageTitle'
// import Article from './Article'
// import axios from 'axios'
// import { baseApiUrl } from '@/global'

export default {
    name: 'Home',
    components: { PageTitle}
    // data: function() {
    //     return {
    //         stat: {}
    //     }
    // },
    // methods: {
    //     getStats() {
    //         axios.get(`${baseApiUrl}/stats`).then(res => this.stat = res.data)
    //     }
    // },
    // mounted() {
    //     this.getStats()
    // }
}
</script>

<style>
    .article {
        display: flex;
        justify-content: space-between;
        flex-wrap: wrap;
    }
</style>
