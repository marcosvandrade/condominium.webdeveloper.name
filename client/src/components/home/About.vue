<template>
   <div>
        <div class="about-section">
        <h1>About Us</h1>
        <p>Encontre os Desenvolvedores</p>
        <p>Esta equipe foi formada para o TCC do IFB Campus Brasília apoiados pelos docentes
            daquela digníssima Instituição.
        </p>
        </div>

        <h2 style="text-align:center">Nosso Time</h2>
        <div class="row">
        <div class="column">
            <div class="card">
            <img src="@/assets/IFBVertical.png" alt="Jane" style="width:57%">
            <div class="container">
                <p>cgpl@ifb.edu.br</p>
                <p><button class="button">Contact</button></p>
            </div>
            </div>
        </div>

        <div class="column">
            <div class="card">
            <img src="@/assets/jp.jpg" alt="jp" style="width:50%">
            <div class="container">
                <h2>João Paulo</h2>
                <p class="title">Desenvolvedor Web</p>
                <p>jpprogramadorucb@gmail.com</p>
                <p><button class="button">Contact</button></p>
            </div>
            </div>
        </div>

        <div class="column">
            <div class="card">
            <img src="@/assets/mva.jpg" alt="mva" style="width:50%">
            <div class="container">
                <h2>Marcos V. Andrade</h2>
                <p class="title">Desenvolvedor Web</p>
                <p>vascorj2006@gmail.com</p>
                <p><button class="button">Contact</button></p>
            </div>
            </div>
        </div>
        </div>
   </div>
</template>

<script>

import PageTitle from '../template/PageTitle'

export default {
    name: 'Maintenance',
    components: { PageTitle }
}
</script>

<style>

body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
}

html {
  box-sizing: border-box;
}

*, *:before, *:after {
  box-sizing: inherit;
}

img {
    display: block;
    margin-left: auto;
    margin-right: auto;
    margin-top: 15px;
}

.column {
  float: left;
  width: 33.3%;
  margin-bottom: 16px;
  padding: 0 8px;
}

.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  margin: 8px;
}

.about-section {
  padding: 50px;
  text-align: center;
  background-color: #474e5d;
  color: white;
}

h2 {
    font-size: 1.5rem;
    text-align: center;
    margin-top: 10px;
}

.container {
  padding: 0 30px;
}

.container::after, .row::after {
  content: "";
  clear: both;
  display: table;
}

.title {
  color: grey;
}

.button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
}

.button:hover {
  background-color: #555;
}

@media screen and (max-width: 650px) {
  .column {
    width: 100%;
    display: block;
  }
}

</style>