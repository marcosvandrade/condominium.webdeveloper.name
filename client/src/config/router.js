import Vue from 'vue'
import VueRouter from 'vue-router'

import Home from '@/components/home/Home'
import AdminPages from '@/components/admin/AdminPages'
import AvisosByCategory from '@/components/aviso/AvisosByCategory'
import NoticiasByCategory from '@/components/noticia/NoticiasByCategory'
import CondominosByCategory from '@/components/condomino/CondominosByCategory'
import AvisoById from '@/components/aviso/AvisoById'
import NoticiaById from '@/components/noticia/NoticiaById'
import CondominoById from '@/components/condomino/CondominoById'
import Auth from '@/components/auth/Auth'
import Maintenance from '@/components/home/PageInConstruction'
import About from '@/components/home/About'

import { userKey } from '@/global'

Vue.use(VueRouter)

const routes = [{
    name: 'home',
    path: '/',
    component: Home
}, { name: 'maintance',
    path: '/maintenance',
    component: Maintenance
}, { name: 'about',
    path: '/about',
    component: About
}, {
    name: 'adminPages',
    path: '/admin',
    component: AdminPages,
    meta: { requiresAdmin: true }
}, {
    name: 'avisosByCategory',
    path: '/categories/:id/avisos',
    component: AvisosByCategory
}, {
    name: 'noticiasByCategory',
    path: '/categories/:id/noticias',
    component: NoticiasByCategory
},{
    name: 'condominosByCategory',
    path: '/categories/:id/condominos',
    component: CondominosByCategory
},{
    name: 'avisoById',
    path: '/avisos/:id',
    component: AvisoById
}, {
    name: 'noticiaById',
    path: '/noticias/:id',
    component: NoticiaById
}, {
    name: 'condominoById',
    path: '/condominos/:id',
    component: CondominoById
}, {
    name: 'auth',
    path: '/auth',
    component: Auth
}]

const router = new VueRouter({
    mode: 'history',
    routes
})

router.beforeEach((to, from, next) => {
    const json = localStorage.getItem(userKey)

    if(to.matched.some(record => record.meta.requiresAdmin)) {
        const user = JSON.parse(json)
        user && user.admin ? next() : next({ path: '/' })
    } else {
        next()
    }
})

export default router
