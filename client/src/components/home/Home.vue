<template>
    <div class="home">
        <PageTitle icon="fa fa-home" main="Página Inicial"
            sub="Bem vindo!" />

             <div class="news">
                <div class="row">
                    <div class="column">
                        <News1 title="news1"
                        icon="fa fa-file" color="#d54d50" />
                    </div>    
                    <div class="column">
                        <News2 title="news2" 
                        icon="fa fa-file" color="#3bc480" />
                    </div>
                    <div class="column">
                        <News3 title="news3" 
                        icon="fa fa-file" color="#3282cd" />
                    </div>    
                </div>
                <div class="row">
                    <div class="column">
                        <News4 title="news4"
                        icon="fa fa-file" color="#d54d50" />
                    </div>    
                    <div class="column">
                        <News5 title="news5" 
                        icon="fa fa-file" color="#3bc480" />
                    </div>
                    <div class="column">
                        <News6 title="news6" 
                        icon="fa fa-file" color="#3282cd" />
                    </div>    
                </div>
            </div>
    </div>
</template>

<script>
import PageTitle from '../template/PageTitle'
import News1 from './News1'
import News2 from './News2'
import News3 from './News3'
import News4 from './News4'
import News5 from './News5'
import News6 from './News6'
// import axios from 'axios'
// import { baseApiUrl } from '@/global'

export default {
    name: 'Home',
    components: { PageTitle, News1, News2,  News3, News4, News5, News6 }
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

.home {
    display: flex;
    flex-wrap: wrap;
    justify-content: flex-start;
}

 .row {
  display: flex;
  flex: 1;
  padding: 10px;
  /* margin-right: 5px;
  margin-left: 5px; */
  }

.column {
  display: flex;
  flex: 1;
  padding: 10px;
  margin: 10px;
 }

</style>
