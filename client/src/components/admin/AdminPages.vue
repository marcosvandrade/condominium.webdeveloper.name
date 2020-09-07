<template>
    <div class="admin-pages">
        <PageTitle icon="fa fa-cogs" main="Administração do Sistema" />
        <div class="admin-pages-tabs">
            <b-card no-body>
                <b-tabs card>
                    <b-tab title="Usuários" active>
                        <UserAdmin />
                    </b-tab>
                    <b-tab title="Menu">
                        <CategoryAdmin />
                    </b-tab>
                    <b-tab title="Avisos">
                        <AvisosAdmin />
                    </b-tab>
                    <b-tab title="Notícias" >
                        <NoticiasAdmin />
                    </b-tab>
                </b-tabs>
            </b-card>
        </div>
    </div>
</template>

<script>
import PageTitle from '../template/PageTitle'
import AvisosAdmin from './AvisosAdmin'
import NoticiasAdmin from './NoticiasAdmin'
import CategoryAdmin from './CategoryAdmin'
import UserAdmin from './UserAdmin'

export default {
    name: 'AdminPages',
    components: { PageTitle, AvisosAdmin, NoticiasAdmin,CategoryAdmin,UserAdmin }
}
</script>

<style>
    b-tab {
        outline: none;
    }
</style>
