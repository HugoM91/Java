<html lang="pt">
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <script src="https://kit.fontawesome.com/0a1ada860a.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/style.css"/>
    <title>Centro Hospitalar Upskill</title>
</head>
<body>
<jsp:include page="med_sidebar.jsp"/>
<div class="main">
    <div id="container-med-consulta-details">
        <div class="page-title">
            <h2><img src="/images_web/heart.svg" alt=""/><span class="title-logo">Detalhes da Consulta</span></h2>
        </div>
        <div id="page-content-med-consulta-details">
            <div class="consulta-top">
                <div class="top-title">
                    <h2>Consulta de ${consulta.getVaga().getDisponibilidade().getMedico().getEspecialidade().getTipo()}</h2>
                    <p>para ${consulta.getIdUtente().getNome()}</p>
                </div>
                <div class="top-mid">
                    <img src="https://source.unsplash.com/SakqLf78KVo/200x200" alt="" class="avatar-medico">
                    <figcaption>${consulta.getVaga().getDisponibilidade().getMedico().getTitulo()} ${consulta.getVaga().getDisponibilidade().getMedico().getNome()}</figcaption>
                </div>
            </div>
            <div class="consulta-mid">
                <div class="metade">
                    <div class="nr-consulta">
                        <h5>Número</h5>
                        <p>${consulta.getIdConsulta()}</p>
                    </div>
                    <div class="marcacao">
                        <h5>Marcação</h5>
                        <p>${consulta.getHora()} - ${consulta.getData()}</p>
                    </div>
                </div>
                <div class="metade">
                    <div class="estado-consulta">
                        <h5>Estado da Consulta</h5>
                        <p>${consulta.getEstado()}</p>
                    </div>
                    <br>
                    <br>
                    <br>
                </div>
            </div>
            <div class="consulta-observacoes">
                <h5>Anamnese</h5>
                ${consulta.getObservacoes()}
            </div>
            <div class="consulta-bottom">

            </div>
        </div>
    </div>
</div>
</body>
</html>
