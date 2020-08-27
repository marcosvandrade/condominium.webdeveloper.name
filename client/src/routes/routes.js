import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

const router = new Router({
    mode: "history",  // Use browser history

    routes: [
        {
            path: "/",
            name: "Login",
            component: () => import("../components/login")
        },

        {
            path: "/cadastro",
            name: "Cadastro",
            component: () => import("../components/cadastro")
        }

    ]
});

export default router;
