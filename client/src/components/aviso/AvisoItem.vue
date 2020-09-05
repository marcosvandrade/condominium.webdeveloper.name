<template>
    <div class="aviso-item">
        <router-link :to="{ name: 'avisoById', params: { id: aviso.id } }">
            <div class="aviso-item-image d-none d-sm-block">
                <img v-if="aviso.imageUrl"
                    :src="aviso.imageUrl"
                    height="150" width="150" alt="Aviso">
                <img v-else
                    src="@/assets/article.png"
                    height="150" width="150" alt="Aviso">
            </div>
            <div class="aviso-item-info">
                <h2>{{ aviso.title }}</h2>
                <p>{{ aviso.content }}</p>
                <span class="aviso-item-author">
                    <strong>Autor: </strong>{{ aviso.author }}
                </span>
            </div>
        </router-link>
    </div>
</template>

<script>
export default {
    name: 'AvisoItem',
    props: ['aviso']
}
</script>

<style>
    .aviso-item {
        border-radius: 8px;
        margin-bottom: 20px;
        background-color: #FFF;
        padding: 20px;
        border: 1px solid rgba(0, 0, 0, 0.2);
        box-shadow: 0 1px 5px rgba(0, 0, 0, 0.15);
    }

    .aviso-item a {
        display: flex;
        align-items: flex-start;
        text-decoration: none;
        color: #000;
    }

    .aviso-item-info h2 {
        font-size: 1.7rem;
    }

    .aviso-item-image {
        padding-right: 20px;
        margin-right: 20px;
        border-right: 1px solid #AAA;
    }

    .aviso-item-image img {
        border-radius: 5px;
    }

    .aviso-item-info {
        display: flex;
        align-self: stretch;
        flex-direction: column;
    }

    .aviso-item-info p {
        flex: 1;
        color: #555;
        font-size: 1.1rem;
    }
</style>
