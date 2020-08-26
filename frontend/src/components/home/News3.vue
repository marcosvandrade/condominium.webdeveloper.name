<template>
    <div class="news3">
        <div class="news3-icon">
            <i :class="icon" :style="style"></i>
        </div>
        <div class="news3-info">
            <div class="news3-title">Avisos e Notícias</div>
            <div class="news3-value">
            Where does it come from?
            Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. 
            </div>
                
        </div>
    </div>
</template>

<script>
export default {
    name: 'News3',
    props: ['icon', 'color'],
    computed: {
        style() {
            return "color: " + (this.color || "#000")
        }
    }
}
</script>

<style>
    .news3 {
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

    .news3-icon {
        display: flex;
    }

    .news3-icon i {
        font-size: 1.5rem;
        padding: 5px;
    }

    .news3-info {
        display: flex;
        flex-direction: column;
        align-items: flex-start;
    }

    .news3-title {
        font-size: 1.3rem;
        align-content: flex-start;
    }

    .news3-value {
        font-size: 1rem;
        padding-top: 20px;
        text-align: justify; 
    }
</style>
