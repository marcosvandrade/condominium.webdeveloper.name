import Vue from 'vue'
import App from './App'
import vuetify from './plugins/vuetify'

import Login from './components/login.vue'
import Cadastro from './components/cadastro.vue'

Vue.config.productionTip = false
Vue.component('page-login', Login)
Vue.component('page-cadastro', Cadastro)

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

