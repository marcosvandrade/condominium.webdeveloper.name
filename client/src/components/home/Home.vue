<template>
    <div class="home">
    <PageTitle icon="fa fa-home" main="Dashboard"
        sub="Estatísticas" v-if="user.admin"/>
    <div class="stats" v-if="user.admin">
        <!-- <Stat title="Menu" :value="stat.categories"
            icon="fa fa-folder" color="#fcba03" /> -->
        <Stat title="Avisos" :value="stat.avisos"
            icon="fa fa-file" color="#3bc480" />
        <Stat title="Notícias" :value="stat.noticias"
        icon="fa fa-folder" color="#d54d50" />
        <Stat title="Usuários" :value="stat.users"
            icon="fa fa-user" color="#3282cd" />
    </div>
        <div v-if="!user.admin">
           <img src="https://pixy.org/src/476/4765590.jpg" alt="inconstruction">
        </div>
    </div>
</template>

<script>
import PageTitle from '../template/PageTitle'
import Stat from './Stat'
import axios from 'axios'
import { mapState } from 'vuex'
import { baseApiUrl } from '@/global'

export default {
    name: 'Home',
    components: { PageTitle, Stat },
    computed: mapState(['user']),
    data: function() {
        return {
            stat: {}
        }
    },
    methods: {
        getStats() {
            axios.get(`${baseApiUrl}/stats`).then(res => this.stat = res.data)
        }
    },
    mounted() {
        this.getStats()
    }
}
</script>

<style>
    .stats {
        display: flex;
        justify-content: space-between;
        flex-wrap: wrap;
    }

    img {
        max-width: 100%;
    }   

</style>
