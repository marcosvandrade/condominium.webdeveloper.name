<template>
    <div class="page-title">
        <h1><i v-if="icon" :class="icon"></i> {{ main }}</h1>
        <h2>{{ sub }}</h2>
    </div>
</template>

<script>
export default {
    name: 'PageTitle',
    props: ['icon', 'main', 'sub']
}
</script>

<style>
    .page-title h1 {
        margin-left: 25px;
        font-size: 1.4rem;
    }

    .page-title h2 {
        color: #777;
        margin-top: 5px;
        margin-left: 25px;
        font-size: 1.1rem;
    }
</style>
