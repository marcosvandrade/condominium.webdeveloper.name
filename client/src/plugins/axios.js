// import Vue from 'vue'
import axios from "axios"

// axios.defaults.baseURL = 'http://localhost:8082/api/'

// Vue.use({
//     install(Vue) {
//         Vue.prototype.$http = http
//     }
// })


export const http = axios.create({
    baseURL:'http://localhost:8083/api/'
});

