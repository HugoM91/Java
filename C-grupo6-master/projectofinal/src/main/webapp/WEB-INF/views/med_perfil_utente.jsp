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
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.23/css/dataTables.bootstrap5.min.css">
    <script type="text/javascript" charset="utf8"
            src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath}/js/fun_tables.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <title>Centro Hospitalar Upskill</title>
</head>
<body>
<jsp:include page="med_sidebar.jsp"/>
<div class="main">
    <div class="profile-container">
        <div class="page-title">
            <h2><img src="/images_web/caminho.svg" alt=""><span class="title-logo">Detalhes de Perfil</span></h2>
        </div>
        <div class="profile-page">
            <div class="profile-page-top">
                <div class="personal-details-card">
                    <div class="personal-details-card-left">
                        <div class="personal-details-card-left-top">
                            <img src="https://www.placecage.com/150/150" alt="" class="avatar-utente">
                            <figcaption>${utente.getNome()}</figcaption>
                            <p>${utente.getEmail()}</p>
                        </div>
                        <div class="personal-details-card-left-bottom">
                            <div class="personal-details-group">
                                <div class="personal-details-row personal-details-row-left">
                                    <label>Data Nascimento</label>
                                    <p>${utente.getDataNascimento()}</p>
                                </div>
                                <div class="personal-details-row personal-details-row-right">
                                    <label>Género</label>
                                    <p>${utente.getGenero()}</p>
                                </div>
                            </div>
                            <div class="personal-details-group">
                                <div class="personal-details-row personal-details-row-left">
                                    <label>Telefone</label>
                                    <p>${utente.getTelefone()}</p>
                                </div>
                                <div class="personal-details-row personal-details-row-right">
                                    <label>Telemóvel</label>
                                    <p>${utente.getTelemovel()}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="personal-details-card-right">
                        <h4>Dados Adicionais</h4>
                        <div class="personal-details-group">
                            <div class="personal-details-row personal-details-row-left">
                                <label>NIF</label>
                                <p>${utente.getNif()}</p>
                            </div>
                            <div class="personal-details-row personal-details-row-right">
                                <label>Nº SNS</label>
                                <p>${utente.getSns()}</p>
                            </div>
                        </div>
                        <div class="personal-details-row">
                            <label>Endereço</label>
                            <p>${utente.getMorada()}</p>
                        </div>
                        <div class="personal-details-group">
                            <div class="personal-details-row personal-details-row-left">
                                <label>Código Postal</label>
                                <p>${utente.getCodigoPostal()}</p>
                            </div>
                            <div class="personal-details-row personal-details-row-right">
                                <label>Localidade</label>
                                <p>${utente.getLocalidade()}</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="personal-notes-card">
                    <h4>Notas</h4>
                    <p>${utente.getObservacoes()}</p>
                </div>
            </div>
            <div class="profile-page-bottom">
                <div class="personal-appointments-history-card">
                    <div class="personal-appointments-history-top">
                    </div>
                    <div class="table-scrollable">
                        <table id="table_fun_consultas_utente" class="table table-borderless">
                            <thead class="table-head">
                            <tr>
                                <th scope="col">Nr</th>
                                <th scope="col">Hora</th>
                                <th scope="col">Data</th>
                                <th scope="col">Estado</th>
                                <th scope="col">Detalhes</th>
                            </tr>
                            </thead>
                            <tbody class="table-content">
                            <c:forEach var="consultas" items="${consultasList}">
                                <tr>
                                    <td>${consultas.getIdConsulta()}</td>
                                    <td>${consultas.getHora()}</td>
                                    <td>${consultas.getData()}</td>
                                    <td>${consultas.getEstado()}</td>
                                    <td>
                                        <a href="/med_consulta_details/${consultas.getIdConsulta()}" type="button" class="btn btn-primary btn-md btn-details"><i class="bi bi bi-info-circle"></i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>