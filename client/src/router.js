import Vue from "vue";
import Router from "vue-router";
import Login from "./components/login.vue";
import Cadastro from "./components/cadastro.vue";
import adminHome from "./components/adminHome.vue";
 
Vue.use(Router);
 
 export default new Router({
    // mode: "history",
    routes: [
        {
            path: "/",
            // name: "login",
            component: Login
          },  {
                path: "/cadastro",
                // name: "cadastro",
                component: Cadastro
          },   {
                path: "/adminHome",
                // name: "homeuser",
                component: adminHome
          },   {
                path: '*',
                redirect: '/'
          }

    ]
  });