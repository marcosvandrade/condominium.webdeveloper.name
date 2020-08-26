<template>
    <div class="news5">
        <div class="news5-icon">
            <i :class="icon" :style="style"></i>
        </div>
        <div class="news5-info">
            <div class="news5-title">Avisos e Notícias</div>
            <div class="news5-value">
                The standard Lorem Ipsum passage, used since the 1500s
"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
            </div>
                
        </div>
    </div>
</template>

<script>
export default {
    name: 'News5',
    props: ['icon', 'color'],
    computed: {
        style() {
            return "color: " + (this.color || "#000")
        }
    }
}
</script>

<style>
    .news5 {
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

    .news5-icon {
        display: flex;
    }

    .news5-icon i {
        font-size: 1.5rem;
        padding: 5px;
    }

    .news5-info {
        display: flex;
        flex-direction: column;
        align-items: flex-start;
    }

    .news5-title {
        font-size: 1.3rem;
        align-content: flex-start;
    }

    .news5-value {
        font-size: 1rem;
        padding-top: 20px;
        text-align: justify; 
    }
</style>
