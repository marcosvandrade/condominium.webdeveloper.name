<template>
    <div class="home">
    <PageTitle icon="fa fa-home" main="Dashboard"
        sub="Estatísticas" v-if="user.admin"/>
    <div class="stats" v-if="user.admin">
       <Stat title="Avisos" :value="stat.avisos"
            icon="fa fa-file" color="#3bc480" />
        <Stat title="Condôminos" :value="stat.condominos"
        icon="fa fa-user" color="#fcba03" />
        <Stat title="Estacionamento" :value="stat.estacionamentos"
            icon="fa fa-user" color="#3282cd" />
        <Stat title="Notícias" :value="stat.noticias"
        icon="fa fa-file" color="#d54d50" />
        <Stat title="Usuários" :value="stat.users"
            icon="fa fa-user" color="#fcba03" />
    </div>
        <div v-if="!user.admin">
           <div class="home-user">
                <h1>Bem-vindo,</h1>
                <h3>{{ user.name }}</h3>
                <hr>
                <img src="@/assets/importante.png" alt="">
                <!-- <h2>IMPORTANTE</h2>                -->
                <p>&nbsp; &nbsp; &nbsp; &nbsp;Diante dos vários casos de invasão nos condomínios vizinhos, solicito que os moradores retirem suas bicicletas da garagem ou que prendam-nas em local fixo. 
                       Além disso, ressalto a adoção de medidas de segurança que visem a dificultar a ação de invasores, tais como: </p>
                <ul>
                    <li>Manter as portas de acesso à garagem sempre trancadas à chave</li>
                    <li>Manter os veículos sempre trancados</li>
                    <li>Não deixar objetos no interior dos veículos</li>
                    <li>Comunicar ao porteiro a presença de pessoas em atitude suspeita</li>
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
