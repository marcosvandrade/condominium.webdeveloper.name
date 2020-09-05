import Vue from 'vue'
import VueRouter from 'vue-router'

import Home from '@/components/home/Home'
import AdminPages from '@/components/admin/AdminPages'
import AvisosByCategory from '@/components/aviso/AvisosByCategory'
import AvisoById from '@/components/aviso/AvisoById'
import NoticiasByCategory from '@/components/noticia/NoticiasByCategory'
import NoticiaById from '@/components/noticia/NoticiaById'
import Auth from '@/components/auth/Auth'

import { userKey } from '@/global'

Vue.use(VueRouter)

const routes = [{
    name: 'home',
    path: '/',
    component: Home
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
    name: 'avisoById',
    path: '/avisos/:id',
    component: AvisoById
}, {
    name: 'noticiasByCategory',
    path: '/categories/:id/noticias',
    component: NoticiasByCategory
}, {
    name: 'noticiaById',
    path: '/noticias/:id',
    component: NoticiaById
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
