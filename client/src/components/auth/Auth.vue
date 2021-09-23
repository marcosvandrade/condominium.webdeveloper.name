<template>
    <div class="auth-content">
        <div class="auth-modal">
           <img  src="@/assets/logo.png" width="250" alt="Logo" /><span class="logo">Condominium Manager</span> 
           <hr>
            <div class="auth-title">{{ showSignup ? 'Register' : 'Login' }}</div>

            <input v-if="showSignup" v-model="user.name" type="text" placeholder="Name">
            <input v-model="user.email" name="email" type="text" placeholder="Email">
            <!-- <input v-if="showSignup" v-model="user.cpf" type="text" placeholder="CPF"> -->
            <input v-if="showSignup" v-model="user.apartamento" type="text" placeholder="Apartment">
            <input v-if="showSignup" v-model="user.contato" type="text" placeholder="Contact">
            <input v-model="user.password" name="password" type="password" placeholder="Password">
            <input v-if="showSignup" v-model="user.confirmPassword"
                type="password" placeholder="Confirm the Password">

            <button v-if="showSignup" @click="signup">Register</button>
            <button v-else @click="signin">Login</button>

            <a href @click.prevent="showSignup = !showSignup">
                <span v-if="showSignup">Already have registration? Access the Login!</span>
                <span v-else>No registration? Register here!</span>
            </a>
        </div>
    </div>
</template>

<script>
import { baseApiUrl, showError, userKey } from '@/global'
import axios from 'axios'

export default {
    name: 'Auth',
    data: function() {
        return {
            showSignup: false,
            user: {}
        }
    },
    methods: {
        signin() {
            axios.post(`${baseApiUrl}/signin`, this.user)
                .then(res => {
                    this.$store.commit('setUser', res.data)
                    localStorage.setItem(userKey, JSON.stringify(res.data))
                    this.$router.push({ path: '/' })
                })
                .catch(showError)
        },
        signup() {
            axios.post(`${baseApiUrl}/signup`, this.user)
                .then(() => {
                    this.$toasted.global.defaultSuccess()
                    this.user = {}
                    this.showSignup = false
                })
                .catch(showError)
        }
    }
}
</script>

<style>

    .img {
        display: flex;
        position: relative;
        align-content: flex-start;
        align-items: flex-start;
        margin-left: 0;
    }

    .logo { 
         display: flex;
         position: absolute;
         align-content: flex-end;
         align-items: flex-end;
         margin-top: 30px;
         margin-left: 50px;
         padding-left: 30px;
         font-size: 1.1rem;
         font-weight: 100;
         font-family: Verdana, Geneva, Tahoma, sans-serif;

    }

    .auth-content {
        height: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .auth-modal {
        background-color: #FFF;
        width: 350px;
        padding: 35px;
        box-shadow: 0 1px 5px rgba(0, 0, 0, 0.15);

        display: flex;
        flex-direction: column;
        align-items: center;
    }
    
    .auth-title {
        font-size: 1.2rem;
        font-weight: 100;
        margin-top: 10px;
        margin-bottom: 15px;
    }

    .auth-modal input {
        border: 1px solid #BBB;
        width: 100%;
        margin-bottom: 15px;
        padding: 3px 8px;
        outline: none;
    }

    .auth-modal button {
        align-self: flex-end;
        background: #3282CD;  /* fallback for old browsers */
        background: -webkit-linear-gradient(to right, #3282CD, #2b8aa0);  /* Chrome 10-25, Safari 5.1-6 */
        background: linear-gradient(to right, #3282CD, #2b8aa0); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
        color: #FFF;
        padding: 5px 15px;
    }

    .auth-modal a {
        margin-top: 35px;
    }

    .auth-modal hr {
        border: 0;
        width: 100%;
        height: 1px;
        background-image: linear-gradient(to right,
            rgba(120, 120, 120, 0),
            rgba(120, 120, 120, 0.75),
            rgba(120, 120, 120, 0));
    }
    
</style>
