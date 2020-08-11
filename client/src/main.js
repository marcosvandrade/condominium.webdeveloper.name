import '@babel/polyfill'
import 'mutationobserver-shim'
import Vue from 'vue'
import './plugins/bootstrap-vue'
import './plugins/axios'
import App from './App'
import vuetify from './plugins/vuetify'

import Login from './components/login.vue'
import Cadastro from './components/cadastro.vue'
import homeUser from './components/homeUser.vue'
import Usuarios from './components/usuarios.vue'

Vue.config.productionTip = false
Vue.component('page-login', Login)
Vue.component('page-cadastro', Cadastro)
Vue.component('page-homeUser', homeUser)
Vue.component('page-usuarios', Usuarios)

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

