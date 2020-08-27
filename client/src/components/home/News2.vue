<template>
    <div class="news2">
        <div class="news2-icon">
            <i :class="icon" :style="style"></i>
        </div>
        <div class="news2-info">
            <div class="news2-title">Avisos e Notícias</div>
            <div class="news2-value">

            Why do we use it?

           It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.
                
             </div>
                
        </div>
    </div>
</template>

<script>
export default {
    name: 'news2',
    props: ['icon', 'color'],
    computed: {
        style() {
            return "color: " + (this.color || "#000")
        }
    }
}
</script>

<style>
    .news2 {
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

    .news2-icon {
        display: flex;
    }

    .news2-icon i {
        font-size: 1.5rem;
        padding: 5px;
    }

    .news2-info {
        display: flex;
        flex-direction: column;
        align-items: flex-start;
    }

    .news2-title {
        font-size: 1.3rem;
        align-content: flex-start;
    }

    .news2-value {
        font-size: 1rem;
        padding-top: 20px;
        text-align: justify; 
    }
</style>
