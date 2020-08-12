<template>
  <div>
  <aside class="logo">
      <a href="#" class="logo"></a>
      <img src="../assets/logoCondominio.png" alt="logoCondominio">
  </aside>

  <aside class="menu-area">
        <nav class="menu">
            <a wm-link="#/paginas/inicio.html">
                <i class="fa fa-home"></i> Início
            </a>
            <a wm-link="#/paginas/cursos.html">
                <i class="fa fa-bars"></i> Cursos
            </a>
            <a wm-link="#/paginas/suporte.html">
                <i class="fa fa-life-ring"></i> Suporte
            </a>
            <a wm-link="#/paginas/sobre.html">
                <i class="fa fa-info-circle"></i> Sobre
            </a>
        </nav>
    </aside>
    <main class="conteudo" wm-link-destino></main>
    <footer class="rodape">
        <span>
            Desenvolvido com
            <i class="fa fa-heart red"></i>
            por
            <strong>Cod<span class="red">3</span>r</strong>
        </span>
    </footer>
  </div>
</template>

<script>

export default {

}
</script>

<style lang="scss">

$fonte-principal: 'Montserrat', sans-serif;

// Cores
$cor-vermelha-1: #f43a59;
$cor-azul-1: #007bff;
$cor-branca: #FFF;

$cor-bg-escura: #1A2F3A;

$gradiente-1: linear-gradient(135deg, #07a7e3 0%, #32dac3 100%);
$gradiente-2: linear-gradient(135deg, #4f5b60 0%, #97a9b2 100%);
$gradiente-3: linear-gradient(135deg, #fc4a1a 0%, #f7b733 100%);
$gradiente-4: linear-gradient(135deg, #7474BF 0%, #348AC7 100%);

// Tamanhos
$altura-logo: 80px;
$altura-cabecalho: 80px;
$altura-menu-top: 80px;
$largura-barra-lateral: 225px;
$altura-rodape: 40px;

// Tamanho dos dispositivos
$largura-xl-min: 1200px;
$largura-lg-max: 1199px;
$largura-lg-min: 992px;
$largura-md-max: 991px;
$largura-md-min: 768px;
$largura-sm-max: 767px;
$largura-sm-min: 576px;
$largura-xs-max: 575px;
$largura-xs-min: 0px;

aside.logo {
    background-color: $cor-bg-escura;
}

aside.logo a {
    display: block;
    padding: 22px 15px;
}

aside.logo img {
    width: 100%;
}

@media(max-width: $largura-sm-max) {
    aside.logo {
        display: flex;
        justify-content: center;
    }

    aside.logo img {
        padding: 0px 15px;
        width: $largura-barra-lateral;
    }
}

    aside.menu-area {
    background-color: $cor-bg-escura;
    color: $cor-branca;
    box-shadow: 2px 0 10px 0 rgba(0, 0, 0, 0.12), 2px 0 15px 0 rgba(0, 0, 0, 0.09);
}

.menu a {
    display: block;
    cursor: pointer;
    text-decoration: none;
    color: #FFF;
    font-weight: 400;
    padding: 15px;
}

.menu a:hover, .menu .selecionado {
    background: $gradiente-1;
}

.menu a.logo:hover {
    background: none;
}

@media(max-width: $largura-sm-max) {
    .menu {
        display: flex;
        justify-content: flex-start;
        align-items: center;
    }
    
    .menu a {
        display: inline;
        padding: 10px;
        margin: 0px;
    }
}

@media(max-width: $largura-sm-max) {
    .menu {
        height: 100%;
        justify-content: space-around;
    }
}

@media(max-width: $largura-xs-max) {
    .menu {
        height: 100%;
    }
}

.conteudo {
    padding: 30px;
    overflow-y: scroll;
}

.conteudo .titulo {
    color: #72848c;
    font-weight: 400;
    /* text-transform: uppercase; */
    margin: 0px 0px 15px 0px;
}

footer.rodape {
    display: flex;
    align-items: center;
    justify-content: flex-end;
    padding: 0 25px;
    background-color: #FFF;
    box-shadow: 0 2px 23px 0 rgba(0, 0, 0, 0.1), 0 2px 49px 0 rgba(0, 0, 0, 0.06);
}

</style>