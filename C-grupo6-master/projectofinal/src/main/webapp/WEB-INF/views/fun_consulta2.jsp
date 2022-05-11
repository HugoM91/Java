<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="css/style.css"/>
    <title>Centro Hospitalar Upskill</title>
</head>
<body>
<jsp:include page="sidebar.jsp"/>
<div class="main">
    <div class="container">
        <div class="page-title">
            <h2><img src="/images_web/heart.svg" alt=""/><span class="title-logo">Consultas</span></h2>
        </div>
        <div class="page-content">
            <form action="" method="POST" class="table-search">
                <div class="search-bar">
                    <div class="input-group">
                        <span class="input-group-text" id="basic-addon1"><i class="bi bi-search"></i></span>
                        <input type="text" class="form-control" id="search-box" placeholder="Procurar"
                               aria-label="Procurar" aria-describedby="basic-addon1" value="procurar">
                    </div>
                </div>
                <div class="dropdown-especialidade">
                    <div class="input-group">
                        <button class="btn dropdown-toggle" type="button" id="dropdownMenuButton1"
                                data-bs-toggle="dropdown" aria-expanded="false">Especialidade
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                            <li><a class="dropdown-item" href="#">Cardiologia</a></li>
                            <li><a class="dropdown-item" href="#">Dermatologia</a></li>
                            <li><a class="dropdown-item" href="#">Medicina Geral e Familiar</a></li>
                            <li><a class="dropdown-item" href="#">Otorrinolaringologia</a></li>
                            <li><a class="dropdown-item" href="#">Urologia</a></li>
                        </ul>
                    </div>
                </div>
                <div class="dropdown-estado">
                    <div class="input-group">
                        <button class="btn dropdown-toggle" type="button" id="dropdownMenuButton2"
                                data-bs-toggle="dropdown" aria-expanded="false">Estado da Consulta
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                            <li><a class="dropdown-item" href="#">Marcada</a></li>
                            <li><a class="dropdown-item" href="#">Realizada</a></li>
                            <li><a class="dropdown-item" href="#">Faturada</a></li>
                            <li><a class="dropdown-item" href="#">Paga</a></li>
                            <li><a class="dropdown-item" href="#">Cancelada</a></li>
                        </ul>
                    </div>
                </div>
                <div class="datepicker">
                    <div class="input-group">
                        <input type="date" class="form-control" placeholder="Data" aria-label="Data"
                               aria-describedby="basic-addon1">
                    </div>
                </div>
                <div class="nova-consulta">
                    <button type="submit" class="btn btn-block btn-nova-consulta" value="submit">Pesquisar</button>
                </div>
            </form>
            <div class="table-responsive table-scrollable">
                <table class="table table-borderless">
                    <thead class="table-head">
                    <tr>
                        <th scope="col">Nr</th>
                        <th scope="col">Hora</th>
                        <th scope="col">Utente</th>
                        <th scope="col">Médico</th>
                        <th scope="col">Funcionario</th>
                        <th scope="col">Especialidade</th>
                        <th scope="col">Estado</th>
                        <th scope="col">Observacoes</th>
                    </tr>
                    </thead>
                    <tbody class="table-content">
                    <c:forEach var="nome_lista" items="${consultaList}">
                        <tr>
                            <td scope="row">15243</td>
                            <td>${nome_lista.getIdConsulta()}</td>
                            <td>${nome_lista.getData()}</td>
                            <td>${nome_lista.getIdUtente()} </td>
                            <td>${nome_lista.getIdMedico()} </td>
                            <td>${nome_lista.getIdFuncionario()}</td>
                            <td>${nome_lista.getEstado()} </td>
                            <td>
                                <button type="button" class="btn btn-primary btn-md btn-details"><i
                                        class="bi bi bi-info-circle"></i></button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
