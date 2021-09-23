<template>
    <div class="home">
    <PageTitle icon="fa fa-home" main="Dashboard"
        sub="Statistics" v-if="user.admin"/>
    <div class="stats" v-if="user.admin">
       <Stat title="Notices" :value="stat.avisos"
            icon="fa fa-file" color="#3bc480" />
        <Stat title="Owners" :value="stat.condominos"
        icon="fa fa-user" color="#fcba03" />
        <Stat title="Parking" :value="stat.estacionamentos"
            icon="fa fa-user" color="#3282cd" />
        <Stat title="News" :value="stat.noticias"
        icon="fa fa-file" color="#d54d50" />
        <Stat title="Users" :value="stat.users"
            icon="fa fa-user" color="#fcba03" />
    </div>
        <div v-if="!user.admin">
           <div class="home-user">
                <h1>Welcome,</h1>
                <h3>{{ user.name }}</h3>
                <hr>
                <img src="@/assets/importante.png" alt="">
                <!-- <h2>IMPORTANTE</h2>                -->
                <p>&nbsp; &nbsp; &nbsp; &nbsp;In view of the various cases of invasion of neighboring condominiums, I request that residents remove their bicycles from the garage or secure them in a fixed location.
                        In addition, I emphasize the adoption of security measures aimed at hindering the action of invaders, such as: </p>
                <ul>
                    <li>Keep garage access doors locked at all times</li>
                    <li>Keep vehicles locked at all times</li>
                    <li>Do not leave objects inside vehicles</li>
                    <li>Communicate the presence of suspicious persons to the concierge</li>
                </ul>   
               <hr>     
           </div>
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

    .home {
        display: flex;
        flex-direction: column;
        height: 100%;
    }
   
    .stats {
        display: flex;
        margin-left: 60px;
        margin-right: 60px;
        justify-content: space-around;
        flex-wrap: wrap;
    }

    .home .home-user {
        display: flex;
        flex-direction: column;
        height: 100%;
        margin-left: 50px;
        margin-top: 30px;
        font-family: Verdana, Geneva, Tahoma, sans-serif;
        
    }

    .home .home-user h1 {
        color: gray;
        margin: 0;
    }
    
    .home .home-user h3 {
        margin-top: 10px;
    }
   
    .home .home-user h2 {
        color: orangered;
        text-align: center;
        margin-top: 30px;
        font-weight: 100;
    }
    
    .home .home-user p {
        display: flex;
        margin: auto;
        font-size: 1.5rem;
        text-align: justify;
        font-family: cursive;
        padding: 10px;
    }
   
    .home .home-user ul li{
        display: flex;
        margin: auto;
        font-size: 1.4rem;
        font-family: cursive;
        padding: 5px;
    }

    .home .home-user hr {
        border: 0;
        width: 100%;
        height: 1px;
        background-image: linear-gradient(to right,
        rgba(120, 120, 120, 0),
        rgba(120, 120, 120, 0.75),
        rgba(120, 120, 120, 0));
    }

    .home .home-user img {
      display: block;
      margin-left: auto;
      margin-right: auto;
      margin-top: 30px;
      width: 20%;
    }

</style>
