<template>
    <!-- <aside class="menu" v-show="isMenuVisible">
        <div class="menu-filter">
            <i class="fa fa-search fa-lg"></i>
            <input type="text" placeholder="Digite para pesquisar..."
                v-model="treeFilter" class="filter-field">
        </div>
        <div class="menu-escolha">
        <Tree :data="treeData" :options="treeOptions" 
            :filter="treeFilter" ref="tree"/>
        </div>
    </aside> -->
    <div class="menu" v-show="isMenuVisible">
     <div class="menu-filter">
            <i class="fa fa-search fa-lg"></i>
            <input type="text" placeholder="Digite para pesquisar..."
                class="filter-field">
     </div>
     <ul class="nav flex-column">
        <li class="nav-item">
            <a class="nav-link" href="2" ></a>
            <!-- <b-icon icon="house-door" font-scale="1"></b-icon> -->
        </li>
        <li class="nav-item">
            <a class="nav-link active" href="/categories/3/avisos">Avisos</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/categories/13/noticias">Notícias</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="11">Assinar a Newsletter</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="4">Chamados</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="5">Condôminos</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="12">Consumo Água/Energia</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="6">Documentos</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="7">Estacionamento</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="8">Funcionários</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="10">Legislação</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="9">Relatórios</a>
        </li>
        
     </ul>
    </div>
</template>

<script>
import { mapState } from 'vuex'
// import avisosByCategory from '../aviso/AvisosByCategory'
// import Tree from 'liquor-tree'
// import { baseApiUrl } from '@/global'
// import axios from 'axios'

export default {
    name: 'Menu',
    computed: mapState(['isMenuVisible']),
    
    // components: { avisosByCategory },
    // data: function() {
    //     return {
    //     //    avisos:[]
    //         }
    //     },
    // methods: {
    //     loadAvisos() {
    //         // const url = `${baseApiUrl}/categories/${this.category.id}`
    //         // axios(url).then(res => this.category = res.data)
    //         this.$router.push({
    //             name: 'avisosByCategory',
    //             // params: { id: this.id }
    //         })
    // },
    // }
    
}
</script>

<style>
    .menu {
        grid-area: menu;
        background: linear-gradient(to right, #232526, #414345);

        display: flex;
        flex-direction: column;
        flex-wrap: wrap;
        text-decoration: none;
    }

    .nav-item {
        /* height: 80%; */
        color: whitesmoke;
        text-decoration: none;
        justify-self: flex-start;
        text-decoration: none;

        display: flex;
        flex-direction: column;
        justify-content: flex-start;
        align-items: flex-start;

        font-size: 1.1rem;
        margin-left: 30px;
    }
    
    .menu a, 
    .menu a:hover {
        color: #fff;
        text-decoration: none;
    }


    /* .menu .tree-node.selected > .tree-content,
    .menu .tree-node .tree-content:hover {
        background-color: rgba(255, 255, 255, 0.2);
        
    }


    .tree-arrow.has-child {
        filter: brightness(2);
    } */

    .menu .menu-filter {
        display: flex;
        justify-content: center;
        align-items: center;

        margin: 20px;
        padding-bottom: 8px;
        border-bottom: 1px solid #AAA;
    }

    .menu .menu-filter i {
        color: #AAA;
        margin-right: 10px;
    }

    .menu input {
        color: #CCC;
        font-size: 1.1rem;
        border: 0;
        outline: 0;
        width: 100%;
        background: transparent;
    }
/* 
    .tree-filter-empty {
        color: #CCC;
        font-size: 1.3rem;
        margin-left: 20px;
    } */
</style>
