<template>
    <div class="news4">
        <div class="news4-icon">
            <i :class="icon" :style="style"></i>
        </div>
        <div class="news4-info">
            <div class="news4-title">Avisos e Notícias</div>
            <div class="news4-value">

           Where can I get some?
           There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.
                
           </div>
                
        </div>
    </div>
</template>

<script>
export default {
    name: 'News4',
    props: ['icon', 'color'],
    computed: {
        style() {
            return "color: " + (this.color || "#000")
        }
    }
}
</script>

<style>
    .news4 {
         display: flex;
        align-items: baseline;
        border-radius: 8px;
        margin-right: 20px;
        margin-bottom: 20px;
        background-color: #FFF;
        padding: 30px;
        border: 1px solid rgba(0, 0, 0, 0.2);
        box-shadow: 0 1px 5px rgba(0, 0, 0, 0.15);
    }

    .news4-icon {
        display: flex;
    }

    .news4-icon i {
        font-size: 1.5rem;
        padding: 5px;
    }

    .news4-info {
        display: flex;
        flex-direction: column;
        align-items: flex-start;
    }

    .news4-title {
        font-size: 1.3rem;
        align-content: flex-start;
    }

    .news4-value {
        font-size: 1rem;
        padding-top: 20px;
        text-align: justify; 
    }
</style>
