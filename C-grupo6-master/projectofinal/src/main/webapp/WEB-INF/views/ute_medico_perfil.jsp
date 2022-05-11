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
<jsp:include page="ute_sidebar.jsp"/>
<div class="main">
    <div class="profile-container">
        <div class="page-title">
            <h2><img src="/images_web/scope.svg" alt=""><span class="title-logo">Detalhes de Perfil</span></h2>
        </div>
        <div class="profile-page">
            <div class="profile-page-top">
                <div class="personal-details-card">
                    <div class="personal-details-card-left">
                        <div class="personal-details-card-left-top">
                            <img src="https://source.unsplash.com/SakqLf78KVo/200x200" alt="" class="avatar-utente">
                            <figcaption>${medico.getTitulo()} ${medico.getNome()}</figcaption>
                            <p>${medico.getEspecialidade().getTipo()}</p>
                        </div>
                        <div class="personal-details-card-left-bottom">
                            <div class="personal-details-group">
                                <div class="personal-details-row personal-details-row-left">
                                    <label>Email</label>
                                </div>
                                <div class="personal-details-row personal-details-row-right">
                                    <p>${medico.getEmail()}</p>
                                </div>
                            </div>
                            <div class="personal-details-group">
                                <div class="personal-details-row personal-details-row-left">
                                    <label>Contacto</label>
                                </div>
                                <div class="personal-details-row personal-details-row-right">
                                    <p>${medico.getContacto()}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="personal-details-card-right">
                        <h4>Horário</h4>
                        <c:forEach var="disponibilidade" items="${disponibilidadeList}">
                            <div class="personal-details-group">
                                <div class="personal-details-row personal-details-row-left">
                                    <label>${disponibilidade.getDiaSemanaPt()}</label>
                                </div>
                                <div class="personal-details-row personal-details-row-right">
                                    <p>${disponibilidade.getInicioTurno()} - ${disponibilidade.getFimTurno()}</p>
                                </div>
                            </div>
                        </c:forEach>
                        <footer>
                            <a href="/ute_calendario" type="button" class="btn btn-editar-utente">Marcar Consulta</a>
                        </footer>
                    </div>
                </div>
                <div class="personal-notes-card">
                    <h4>Dados Pessoais</h4>
                    <div class="personal-notes-content">
                        <div class="personal-details-row">
                            <p><span><i class="fas fa-user-md"></i></span>Idade: ${medico.getIdade()}</p>
                        </div>
                        <div class="personal-details-row">
                            <p><span><i class="fas fa-map-marker-alt"></i></span> ${medico.getDistrito()}</p>
                        </div>
                        <div class="personal-details-row">
                            <p><span><i class="fas fa-hospital"></i></span> Centro Hospitalar Upskill</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="profile-page-bottom">
                <div class="personal-cv-card">
                    <div class="personal-cv-top">
                        <h4>Currículo</h4>
                    </div>
                    <div class="personal-cv-bottom">
                        ${medico.getCv()}
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>