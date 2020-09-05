<template>
    <div class="noticia-item">
        <router-link :to="{ name: 'noticiaById', params: { id: noticia.id } }">
            <div class="noticia-item-image d-none d-sm-block">
                <img v-if="noticia.imageUrl"
                    :src="noticia.imageUrl"
                    height="150" width="150" alt="Noticia">
                <img v-else
                    src="@/assets/article.png"
                    height="150" width="150" alt="Noticia">
            </div>
            <div class="noticia-item-info">
                <h2>{{ noticia.title }}</h2>
                <p>{{ noticia.content }}</p>
                <span class="noticia-item-author">
                    <strong>Autor: </strong>{{ noticia.author }}
                </span>
            </div>
        </router-link>
    </div>
</template>

<script>
export default {
    name: 'NoticiaItem',
    props: ['noticia']
}
</script>

<style>
    .noticia-item {
        border-radius: 8px;
        margin-bottom: 20px;
        background-color: #FFF;
        padding: 20px;
        border: 1px solid rgba(0, 0, 0, 0.2);
        box-shadow: 0 1px 5px rgba(0, 0, 0, 0.15);
    }

    .noticia-item a {
        display: flex;
        align-items: flex-start;
        text-decoration: none;
        color: #000;
    }

    .noticia-item-info h2 {
        font-size: 1.7rem;
    }

    .noticia-item-image {
        padding-right: 20px;
        margin-right: 20px;
        border-right: 1px solid #AAA;
    }

    .noticia-item-image img {
        border-radius: 5px;
    }

    .noticia-item-info {
        display: flex;
        align-self: stretch;
        flex-direction: column;
    }

    .noticia-item-info p {
        flex: 1;
        color: #555;
        font-size: 1.1rem;
    }
</style>
