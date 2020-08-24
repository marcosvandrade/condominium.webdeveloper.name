import 'font-awesome/css/font-awesome.css'
import Vue from 'vue'
import App from './App'
import store from './config/store'
import './config/bootstrap'
// import vuetify from './plugins/vuetify'

// import '@babel/polyfill'
import 'mutationobserver-shim'
import './plugins/bootstrap-vue'
import './plugins/axios'
import router from './config/router'

// import './assets/style.scss'

// import Login from './components/login.vue'
// import Cadastro from './components/cadastro.vue'
// import homeUser from './components/homeUser.vue'

Vue.config.productionTip = false
// Vue.component('page-login', Login)
// Vue.component('page-cadastro', Cadastro)
// Vue.component('page-homeUser', homeUser)

// TEMPORÁRIO!
require('axios').default.headers.common['Authorization'] = 'bearer TOKEN'

new Vue({
    // vuetify,
    router,
    store,
    render: h => h(App)
}).$mount("#app")

// new Vue({
//     el: '#app',
//     render(createElement) {
//         return createElement(App)
//     }
// })

