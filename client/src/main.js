import '@babel/polyfill'
import 'mutationobserver-shim'
import Vue from 'vue'
import './plugins/bootstrap-vue'
import App from './App'
import vuetify from './plugins/vuetify'

import Login from './components/login.vue'
import Cadastro from './components/cadastro.vue'
import homeUser from './components/homeUser.vue'

import './assets/css/app.css'
import './assets/css/login.css'
import './assets/css/cadastro.css'

Vue.config.productionTip = false
Vue.component('page-login', Login)
Vue.component('page-cadastro', Cadastro)
Vue.component('page-homeUser', homeUser)

new Vue({
    vuetify,
    render: h => h(App)
}).$mount("#app")

// new Vue({
//     el: '#app',
//     render(createElement) {
//         return createElement(App)
//     }
// })

