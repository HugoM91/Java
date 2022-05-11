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
    <script src="js/fun_tables.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>

    <title>Centro Hospitalar Upskill</title>
</head>
<body>
<jsp:include page="sidebar.jsp"/>
<div class="main">
    <div class="marcar-container">
        <div class="page-title">
            <h2><img src="/images_web/calendar.svg" alt=""/><span class="title-logo">Marcar Consulta</span></h2>
        </div>
        <div class="page-content-marcar-consulta">
            <div class="form-side">
                <form action="/fun_registar_consulta/${vaga.getId()}" class="nova-consulta" method="post">
                    <div class="form-row">
                        <label for="utente">Utente</label><br>
                        <select name="idUtente" id="utente">
                            <c:forEach var="utente" items="${utenteList}">
                                <option value="${utente.getIdUtente()}">${utente.getNome()}</option>
                            </c:forEach>
                        </select><br>
                    </div>
                    <div class="form-row">
                        <label for="medico">Médico</label><br>
                        <input type="text"
                               value="${vaga.getDisponibilidade().getMedico().getTitulo()} ${vaga.getDisponibilidade().getMedico().getNome()}"
                               id="marcar-medico" name="idMedico" readonly><br>
                    </div>
                    <div class="form-group">
                        <div class="form-row-left">
                            <label for="date">Data</label><br>
                            <input type="text" value="${vaga.getData()}" id="date" name="data" readonly><br>
                        </div>
                        <div class="form-row-right">
                            <label for="time">Horário</label><br>
                            <input type="time" value="${vaga.getHoraInicio()}" id="time" name="hora" readonly><br>
                        </div>
                    </div>
                    <footer>
                        <button type="submit" id="submit-consulta">Marcar Consulta</button>
                    </footer>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

