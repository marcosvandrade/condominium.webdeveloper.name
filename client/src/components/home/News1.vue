<template>
    <div class="news1">
        <div class="news1-icon">
            <i :class="icon" :style="style"></i>
        </div>
        <div class="news1-info">
            <div class="news1-title">Avisos e Notícias</div>
            <div class="news1-value">
                Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. 
             </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'News1',
    props: ['icon', 'color'],
    computed: {
        style() {
            return "color: " + (this.color || "#000")
        }
    }
}
</script>

<style>
    .news1 {
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

    .news1-icon {
        display: flex;
    }

    .news1-icon i {
        font-size: 1.5rem;
        padding: 5px;
    }

    .news1-info {
        display: flex;
        flex-direction: column;
        align-items: flex-start;
    }

    .news1-title {        
        font-size: 1.3rem;
        align-content: flex-start;
    }

    .news1-value {
        padding-top: 20px;
        font-size: 1rem;
        text-align: justify;    
    }
</style>
