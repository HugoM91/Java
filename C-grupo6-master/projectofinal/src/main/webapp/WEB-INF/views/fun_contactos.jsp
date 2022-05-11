<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt">
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/style.css"/>
    <title>Centro Hospitalar Upskill</title>
</head>
<body>
<jsp:include page="sidebar.jsp"/>

<div class="main">
    <div class="container">
        <div class="page-title">
            <h2><img src="/images_web/phone.svg" alt=""/><span class="title-logo">Contactos</span></h2>
        </div>

        <div class="ut-c-container">
            <div id="ut-c-shortinfo"> Consulte nesta página a informação necessária para entrar em contacto connosco.
            </div>
            <div id="ut-c-info"><b> Contacto telefónico </b></div>
            <div id="ut-c-info"> 219 191 696</div>
            <div id="ut-c-info"> 919 191 696</div>
            <h4 id="ut-c-info"></h4>
            <div id="ut-c-info"><b> Extensões telefónicas </b></div>
            <div id="ut-c-info"> Admin 219 191 696 9</div>
            <div id="ut-c-info"> 2º Piso 219 191 696 2</div>
            <div id="ut-c-info"> 3º Piso 219 191 696 3</div>
            <div id="ut-c-info"> 4º Piso 219 191 696 4</div>
            <div id="ut-c-info"> Pós Operatório 219 191 696 5</div>
            <div id="ut-c-info"> Recursos Humanos 219 191 696 6</div>
        </div>
        <div class="ut-c-container">
            <div id="ut-c-info"><b> Marcações presenciais </b></div>
            <div id="ut-c-info"> Segunda a Sexta: 7:30h - 21h</div>
            <div id="ut-c-info">Sábados: 8h - 20h</div>
            <div id="ut-c-info">Domingos e Feriados: 9h - 20h</div>
            <h4 id="ut-c-info"></h4>
            <div id="ut-c-info"><b> Marcações pelo telefone </b></div>
            <div id="ut-c-info">Todos os dias: 9h - 20h</div>
        </div>
        <div class="ut-c-container">

            <div id="ut-c-info"><b> Endereço electrónico </b></div>
            <div id="ut-c-info">centrohospitalar@upskill.pt</div>
            <h4 id="ut-c-info"></h4>
            <div id="ut-c-title2"> <b> Quer contactar-nos para efeitos de parceria? </b> </div>
            <div id="ut-c-info">centrohospitalar.partnership@upskill.pt </div>
        </div>
            <div class="ut-c-container">
            <h4 id="ut-c-info"></h4>
            <div id="ut-c-info"><b> Morada </b></div>
            <div id="ut-c-info">Rio de Mouro | R. Retiro dos Pacatos 50, 2635-224 Rio de Mouro</div>
        </div>
    </div>
</div>
</body>
</html>