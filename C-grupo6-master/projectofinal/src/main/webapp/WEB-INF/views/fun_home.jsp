<html lang="pt">
  <head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <title>Centro Hospitalar Upskill</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.23/css/dataTables.bootstrap5.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css"/>
  </head>
  <body>
    <jsp:include page="sidebar.jsp"/>

    <div class="main">

      <header class="high-main">
        <img id="high-img" src="/images_web/Grupo7.svg" />
        <div id="high-text-container">
          <div id="high-text-title">CUIDE DE SI E DOS SEUS.</div>
          <div id="high-text-info">
            O Centro Hospitalar UPskill inspira-se nos seus clientes para estar
            na vanguarda na proteção das famílias. Estamos mais inovadores na
            prestação de cuidados de saúde, mais próximos e mais ágeis.
          </div>
        </div>
      </header>

      <div id="mid-text-title">VISTA GERAL</div>
      <div class="mid-main">


          <div class="mid-first-container">
            <img id="mid-wait-img" src="/images_web/wait.svg" />
            <div id="mid-text-utentes">
              <span id="mid-text-utentes-variable">${aguardar}</span> UTENTES
            </div>
            <div id="mid-text-await">A AGUARDAR CONSULTA</div>
            <div id="mid-text-late">${atrasados} utentes estão atrasados</div>
            <button id="mid-first-button">
              <a href="/fun_lista_espera"><div id="mid-first-list">VER SALA DE ESPERA</div></a>
            </button>
          </div>
        <form action="/fun_home" method="post">
          <div class="mid-second-container">
            <div id="mid-checkin">CHECKIN</div>
            <div id="mid-consulta-info">Introduza o número de consulta</div>
            <input type="text" name="idConsulta" id="mid-consulta-id" placeholder="Nº de Consulta"/>
            <button type="submit" id="mid-second-button">
              <div id="mid-second-submit">EFETUAR CHECKIN ></div>
            </button>
          </div>
        </form>
        </div>
      <div class="carousel-align-center">
        <div id="carouselSite" class="carousel slide" data-ride="carousel">
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img src="/images_web/Grupo302x.png" class="img-fluid d-block">
              <div class="carousel-caption d-none d-md-block">
              </div>
            </div>
            <div class="carousel-item">
              <img src="/images_web/banner-saudee.jpeg" class="img-fluid d-block">
              <div class="carousel-caption d-none d-md-block">

              </div>
            </div>
            <div class="carousel-item">
              <img src="/images_web/bannersaude.jpg" class="img-fluid d-block">
              <div class="carousel-caption d-none d-md-block">
              </div>
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselSite" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselSite" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
      </div>
    </div>
  </body>
</html>
