<template>
    <header class="header">
         <a class="toggle" @click="toggleMenu" v-if="!hideToggle">
            <i class="fa fa-lg" :class="icon"></i>
        </a>
         <h1 class="title">
            <router-link to="/">{{ title }}</router-link>
        </h1>
        <UserDropdown  v-if="!hideUserDropdown" />
    </header>
</template>

<script>
import UserDropdown from './UserDropdown'

export default {
    name: 'Header',
    components: { UserDropdown },
    props: {
        title: String,
         hideToggle: Boolean,
         hideUserDropdown: Boolean
    },
    computed: {
        icon() {
            return this.$store.state.isMenuVisible ? "fa-angle-left" : "fa-angle-down"
        }
    },
    methods: {
        toggleMenu() {
            this.$store.commit('toggleMenu')
        }
    }
}
</script>

<style>
    .header {
        grid-area: header;
        background: #00B4DB;  /* fallback for old browsers */
        background: -webkit-linear-gradient(to right, #0083B0, #82999e);  /* Chrome 10-25, Safari 5.1-6 */
        background: linear-gradient(to right, #0083B0, #00B4DB); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

        display: flex;
        justify-content: center;
        align-items: center;
    }

    .title {
        font-size: 1.6rem;
        color: #fff;
        font-weight: 100;
        flex-grow: 1;
        text-align: center;
        margin-left: 150px;
    }

    .title a {
        color: #FFF;
        text-decoration: none;
    }

    .title a:hover {
        color: #FFF;
        text-decoration: none;
    }

    header.header > a.toggle {
        width: 60px;
        height: 100%;
        color: #fff;
        justify-self: flex-start;
        text-decoration: none;

        display: flex;
        justify-content: center;
        align-items: center;
    }

    header.header > a.toggle:hover {
        color: #fff;
        background-color: rgba(0, 0, 0, 0.2);
    }
    
</style>
