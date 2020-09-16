<template>
    <div class="condomino-item">
        <router-link :to="{ name: 'condominoById', params: { id: condomino.id } }">
            <div class="condomino-item-image d-none d-sm-block">
                <img v-if="condomino.imageUrl"
                    :src="condomino.imageUrl"
                    height="150" width="150" alt="Condomino">
                <img v-else
                    src="@/assets/article.png"
                    height="150" width="150" alt="Condomino">
            </div>
            <div class="condomino-item-info">
                <h2>{{ condomino.title }}</h2>
                <p>{{ condomino.content }}</p>
                <span class="condomino-item-author">
                    <strong>Autor: </strong>{{ condomino.author }}
                </span>
            </div>
        </router-link>
    </div>
</template>

<script>
export default {
    name: 'CondominoItem',
    props: ['codomino']
}
</script>

<style>
    .codomino-item {
        border-radius: 8px;
        margin-bottom: 20px;
        background-color: #FFF;
        padding: 20px;
        border: 1px solid rgba(0, 0, 0, 0.2);
        box-shadow: 0 1px 5px rgba(0, 0, 0, 0.15);
    }

    .codomino-item a {
        display: flex;
        align-items: flex-start;
        text-decoration: none;
        color: #000;
    }

    .codomino-item-info h2 {
        font-size: 1.7rem;
    }

    .codomino-item-image {
        padding-right: 20px;
        margin-right: 20px;
        border-right: 1px solid #AAA;
    }

    .codomino-item-image img {
        border-radius: 5px;
    }

    .codomino-item-info {
        display: flex;
        align-self: stretch;
        flex-direction: column;
    }

    .codomino-item-info p {
        flex: 1;
        color: #555;
        font-size: 1.1rem;
    }
</style>
