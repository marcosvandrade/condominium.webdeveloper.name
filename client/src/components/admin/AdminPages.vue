<template>
    <div class="admin-pages">
        <PageTitle icon="fa fa-cogs" main="Administração do Sistema"
            sub="Cadastro de Usuários" />
        <div class="admin-pages-tabs">
            <b-card no-body>
                <b-tabs card>
                    <b-tab title="Avisos" active>
                        <AvisosAdmin />
                    </b-tab>
                    <b-tab title="Notícias" active>
                        <NoticiasAdmin />
                    </b-tab>
                    <b-tab title="Usuários">
                        <UserAdmin />
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
import UserAdmin from './UserAdmin'

export default {
    name: 'AdminPages',
    components: { PageTitle, AvisosAdmin, NoticiasAdmin,UserAdmin }
}
</script>

<style>

</style>
