<template>
   <div class="maintenance">
      
            <img src="@/assets/underConstruction.jpg" alt="emconstrucao">
     
    </div>
</template>

<script>

import PageTitle from '../template/PageTitle'

export default {
    name: 'Maintenance',
    components: { PageTitle }
}
</script>

<style>

.maintenance img {
    display: block;
    margin-left: auto;
    margin-right: auto;
    width:84.5%;
}

</style>