import Vue from 'vue'
import App from './App'
import vuetify from './plugins/vuetify';

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

