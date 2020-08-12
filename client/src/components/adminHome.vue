<template>
  <aside class="logo">
      <a href="#" class="logo"></a>
      <img src="../assets/logoCondominio.png" alt="logoCondominio">
  </aside>
</template>

<script>
export default {

}
</script>

<style>
    aside.logo {
        background-color: #1A2F3A;
        
    }

    aside.logo a {
        display: block;
        padding: 4px;
    }

    aside.logo img {
        width: 80%;
    }

    @media(max-width: 767px) {
        aside.logo {
            display: flex;
            justify-content: center;
        }

        aside.logo img {
            padding: 0px 15px;
            width: 225px;
        }
    }
</style>