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
    <script type="text/javascript" src="js/nova_consulta.js"></script>
    <link rel="stylesheet" href="css/style.css"/>
    <title>Centro Hospitalar Upskill</title>
</head>
<body>
<jsp:include page="ute_sidebar.jsp"/>
<div class="main">
    <div class="container">
        <div class="page-title">
            <h2><img src="/images_web/calendar.svg" alt=""/><span class="title-logo">Calendário de Vagas</span></h2>
        </div>
        <div class="page-content">
            <div class="calendar-content">
                <div class="ute-calendar">
                    <h3 id="med-gerar-horario-t">Marcar Consulta</h3>
                    <form action="/ute_calendario" method="POST">
                        <label for="data">Data</label><br>
                        <input type="date" id="data" name="data" value="data"><br>
                        <br>
                        <p><b>Escolha apenas uma opção</b></p>
                        <select name="idMedico" id="medico">
                            <option disabled selected value> -- Médico --</option>
                            <c:forEach var="medico" items="${medicosList}">
                                <option value="${medico.getIdMedico()}">${medico.getNome()}</option>
                            </c:forEach>
                        </select><br>
                        <select name="especialidade" id="medico">
                            <option disabled selected value> -- Especialidade --</option>
                            <c:forEach var="especialidade" items="${especialidadeList}">
                                <option value="${especialidade.getIdEspecialidade()}">${especialidade.getTipo()}</option>
                            </c:forEach>
                        </select><br><br>
                        <input type="submit" id="botao-pesquisar" value="Submit">
                    </form>
                </div>
                <div id="calendar-table-scrollable">
                    <table id="table_ute_calendario" class="table table-borderless">
                        <thead class="table-head">
                        <tr>
                            <th scope="col">Data</th>
                            <th scope="col">Hora</th>
                            <th scope="col">Médico</th>
                        </tr>
                        </thead>
                        <tbody class="table-content">
                        <c:forEach var="nome_lista" items="${vagaList}">
                            <tr>
                                <td>${nome_lista.getData()}</td>
                                <td>${nome_lista.getHoraInicio()}</td>
                                <td>${nome_lista.getDisponibilidade().getMedico().getTitulo()} ${nome_lista.getDisponibilidade().getMedico().getNome()}</td>
                                <td>
                                    <a href="/ute-nova-consulta/${nome_lista.getId()}" type="button"
                                       class="btn btn-sm btn-nova-consulta">Nova Consulta</a>
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
</body>
</html>