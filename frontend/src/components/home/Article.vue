<template>
    <div class="article">
        <!-- <div class="article-icon">
            <i :class="icon" :style="style"></i>
        </div> -->
        <div class="article-info">
            <span class="article-title">Título do Artigo</span>
            <span class="article-value">Conteúdo</span>
        </div>
    </div>
</template>

<script>
export default {
    name: 'Article',
    // props: ['title', 'value', 'icon', 'color'],
    // computed: {
    //     style() {
    //         return "color: " + (this.color || "#000")
    //     }
    // }
}
</script>

<style>
    .article {
        flex: 1;
        display: flex;
        border-radius: 8px;
        margin-right: 20px;
        margin-bottom: 20px;
        background-color: #FFF;
        padding: 20px;
        border: 1px solid rgba(0, 0, 0, 0.2);
        box-shadow: 0 1px 5px rgba(0, 0, 0, 0.15);
    }

    .article-icon {
        display: flex;
        align-items: center;
    }

    .article-icon i {
        font-size: 5rem;
    }

    .article-info {
        flex: 1;
        display: flex;
        flex-direction: column;
        align-items: flex-end;
    }

    .article-title {
        font-size: 1.2rem;
    }

    .article-value {
        font-size: 3rem;
    }
</style>
