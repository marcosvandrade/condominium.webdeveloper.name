<template>
    <div class="news6">
        <div class="news6-icon">
            <i :class="icon" :style="style"></i>
        </div>
        <div class="news6-info">
            <div class="news6-title">Avisos e Notícias</div>
            <div class="news6-value">
                What is Lorem Ipsum?
                Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum
                has been the industry's standard dummy text ever since the 1500s, when an unknown printer
                took a galley of type and scrambled it to make a type specimen book. </div>
                
        </div>
    </div>
</template>

<script>
export default {
    name: 'News6',
    props: ['icon', 'color'],
    computed: {
        style() {
            return "color: " + (this.color || "#000")
        }
    }
}
</script>

<style>
    .news6 {
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

    .news6-icon {
        display: flex;
    }

    .news6-icon i {
        font-size: 1.5rem;
        padding: 5px;
    }

    .news6-info {
        display: flex;
        flex-direction: column;
        align-items: flex-start;
    }

    .news6-title {
        font-size: 1.3rem;
        align-content: flex-start;
    }

    .news6-value {
        font-size: 1rem;
        padding-top: 20px;
        text-align: justify; 
    }
</style>
