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
    <aside class="menu" v-show="isMenuVisible">
     <div class="menu-filter">
            <i class="fa fa-search fa-lg"></i>
            <input type="text" placeholder="Digite para pesquisar..."
                class="filter-field">
     </div>
     <ul>
       <li ><a  href="/categories/1/avisos">Avisos</a></li>
       <li ><a href="#contact">Contact</a></li>
     </ul>
   </aside>
</template>

<script>
import { mapState } from 'vuex'
import avisosByCategory from '../aviso/AvisosByCategory'
// import Tree from 'liquor-tree'
// import { baseApiUrl } from '@/global'
// import axios from 'axios'

export default {
    name: 'Menu',
    computed: mapState(['isMenuVisible']),
    components: { avisosByCategory },
    data: function() {
        return {
        //    avisos:[]
            }
        },
    methods: {
        loadAvisos() {
            this.$router.push({
                name: 'avisosByCategory',
                params: { id: this.$route.params.id }
            })
    },
    }
    
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

    .menu li {
        height: 60%;
        color: whitesmoke;
        text-decoration: none;
        justify-self: flex-start;
        text-decoration: none;

        display: flex;
        justify-content: flex-start;
        align-items: center;

        font-size: 1.3rem;
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
