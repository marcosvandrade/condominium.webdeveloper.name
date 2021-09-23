<template>
    <div class="admin-pages">
        <PageTitle icon="fa fa-cogs" main="System Administration" />
        <div class="admin-pages-tabs">
            <b-card no-body>
                <b-tabs card>
                    <!-- <b-tab title="Menu">
                        <CategoryAdmin />
                    </b-tab> -->
                    <b-tab title="Notices" active>
                        <AvisosAdmin />
                    </b-tab>
                    <b-tab title="Owners" >
                        <CondominosAdmin />
                    </b-tab>
                    <b-tab title="Parking" >
                        <EstacionamentosAdmin />
                    </b-tab>
                    <b-tab title="News" >
                        <NoticiasAdmin />
                    </b-tab>
                    <b-tab title="Users">
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
import CondominosAdmin from './CondominosAdmin'
import EstacionamentosAdmin from './EstacionamentosAdmin'
// import CategoryAdmin from './CategoryAdmin'
import UserAdmin from './UserAdmin'

export default {
    name: 'AdminPages',
    components: { PageTitle, AvisosAdmin, NoticiasAdmin,UserAdmin, CondominosAdmin, EstacionamentosAdmin }
}
</script>

<style>

    b-tab {
        outline: none;
    }
</style>
