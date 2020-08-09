import Vue from "vue";
import Router from "vue-router";
import cadastro from "./components/cadastro.vue";
import login from "./components/login.vue";
// import AddCustomer from "./components/AddCustomer.vue";
// import SearchCustomers from "./components/SearchCustomers.vue";
// import Customer from "./components/Customer.vue";
 
Vue.use(Router);
 
 export default new Router({
    mode: "history",
    routes: [
        {
            path: "/",
            name: "login",
            component: login
          },  
        {
            path: "/cadastro",
            name: "cadastro",
            component: cadastro
        }     
    ]
  });