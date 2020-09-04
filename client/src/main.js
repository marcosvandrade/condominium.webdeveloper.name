import 'font-awesome/css/font-awesome.css'
import Vue from 'vue'
import App from './App'
import store from './config/store'
import './config/bootstrap'
import './config/msgs'
// import vuetify from './plugins/vuetify'

// import '@babel/polyfill'
// import 'mutationobserver-shim'
// import './plugins/bootstrap-vue'
import './config/axios'
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
// require('axios').defaults.headers.common['Authorization'] = 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJleHAiOjE1OTk2OTk3ODd9.xA5TsL19tGC0GE4RT6jy-YPlQ18EH-bj_Wp8oVy5hBzpvHntW12wPPlqYdzebJK2HUU2yvkLn7ZPbaF34TJ8KQ'

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

