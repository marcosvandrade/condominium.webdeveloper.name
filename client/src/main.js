import Vue from 'vue'
import App from './App.vue'
import router from './router'

Vue.config.productionTip = false

new Vue({
  router, // inject the router to make whole app router-aware
  render: h => h(App),
}).$mount('#app')
