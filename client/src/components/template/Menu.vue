<template>
    <div class="menu" v-show="isMenuVisible">
        <div v-if="user.admin" v-on="Mobile()" v-bind:class="[isMobile ? 'mobile' : '']">
            <div class="menu-filter">
                    <i class="fa fa-search fa-lg"></i>
                    <input type="text" placeholder="Type to search..."
                        class="filter-field">
            </div>
            <div class="user-admin">
                <ul class="nav flex-column">
                    <li class="nav-item-home">
                        <a class="nav-link-home" href="/" >
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-house-door" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd" d="M7.646 1.146a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 .146.354v7a.5.5 0 0 1-.5.5H9.5a.5.5 0 0 1-.5-.5v-4H7v4a.5.5 0 0 1-.5.5H2a.5.5 0 0 1-.5-.5v-7a.5.5 0 0 1 .146-.354l6-6zM2.5 7.707V14H6v-4a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 .5.5v4h3.5V7.707L8 2.207l-5.5 5.5z"/>
                                <path fill-rule="evenodd" d="M13 2.5V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
                            </svg>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/maintenance">Subscribe to Newsletter</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/categories/3/avisos">Notices</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/categories/13/noticias">News</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/maintenance">Answer Tickets</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/categories/5/condominos">Owners</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/maintenance">Water/Energy Consumption</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/maintenance">Documents</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/categories/7/estacionamentos">Parking</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/maintenance">Employees</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/maintenance">Legislation</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/maintenance">Reports</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/about">About Us</a>
                    </li>
                </ul>
                </div>
        </div>

        <div v-if="!user.admin" v-on="Mobile()" v-bind:class="[isMobile ? 'mobile' : '']">
            <div class="menu-filter">
                    <i class="fa fa-search fa-lg"></i>
                    <input type="text" placeholder="Type to search..."
                        class="filter-field">
            </div>
            <div class="user-client">
                <ul class="nav flex-column">
                    <li class="nav-item-home">
                        <a class="nav-link" href="/" >
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-house-door" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd" d="M7.646 1.146a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 .146.354v7a.5.5 0 0 1-.5.5H9.5a.5.5 0 0 1-.5-.5v-4H7v4a.5.5 0 0 1-.5.5H2a.5.5 0 0 1-.5-.5v-7a.5.5 0 0 1 .146-.354l6-6zM2.5 7.707V14H6v-4a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 .5.5v4h3.5V7.707L8 2.207l-5.5 5.5z"/>
                                <path fill-rule="evenodd" d="M13 2.5V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
                            </svg>
                            <!-- <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-left-square" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd" d="M14 1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                                <path fill-rule="evenodd" d="M12 8a.5.5 0 0 1-.5.5H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H11.5a.5.5 0 0 1 .5.5z"/>
                            </svg> -->
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/maintenance">Subscribe to Newsletter</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/categories/3/avisos">Notices</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/categories/13/noticias">News</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/maintenance">Open Tickets</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/maintenance">Water/Energy Consumption</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/maintenance">Legislation</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/about">About</a>
                    </li>
                </ul>
                </div>
        </div>
        
    </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
    name: 'Menu',
    computed: mapState(['isMenuVisible', 'user']),
    data: function() {
        return {
            isMobile: false
        }
    },
    methods: {
            Mobile(){
                if(window.innerWidth <= 990){
                    this.isMobile = true
                    // console.log(this.isMobile)
            }
        }
    }
}
</script>

<style>
    .menu {
        grid-area: menu;
        width: 100%;
        background: linear-gradient(to right, #232526, #414345);

        display: flex;
        flex: 1;
        flex-direction: column;
        flex-wrap: wrap;
    }

    .menu .user-admin a {
        color: white;
    }
   
    .menu .user-client a {
        color: white;
    }
    
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

   .menu .user-admin .nav-item a {
        text-decoration: none;
        justify-self: flex-start;

        display: flex;
        flex: 1;
        flex-direction: column;
        justify-content: flex-start;
        align-items: flex-start;
        margin-top: 2px;

        font-size: 1.1rem;
        margin-left: 20px;
    }
  
   .menu .user-client .nav-item a {
        text-decoration: none;
        justify-self: flex-start;

        display: flex;
        flex: 1;
        flex-direction: column;
        justify-content: flex-start;
        align-items: flex-start;

        font-size: 1.1rem;
        margin-left: 20px;
        margin-top: 20px;
    }
        
    .menu .user-admin .nav-item-home {
        display: flex;
        flex: 1;
        margin-left: 40px;
        font-size: 1.5rem;
    }
    
    .menu .user-client .nav-item-home {
        display: flex;
        flex: 1;
        margin-left: 40px;
        font-size: 2rem;
    }

    .menu .user-admin .nav-item-home svg {
       /* margin-inline: 20px; */
        display: block;
        margin-left: 50px;
        margin-top: 10px;
        margin-bottom: 10px;
    }
   
    .menu .user-client .nav-item-home svg {
        /* margin-inline: 20px; */
        display: block;
        margin-left: 50px;
        margin-top: 10px;
        margin-bottom: 10px;
    }

    .menu .user-admin .nav-link:hover {
        color: gray;
    }

    .menu .user-client .nav-link:hover {
        color: gray;
    }

    .menu .mobile .nav-item a {
        font-size: 0.8rem;
    }

    .menu .mobile .nav-item-home a {
        font-size: 1rem;
    }

</style>
