<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.js"></script>
    <script src="js/fun_tables.js"></script>

    <link rel="stylesheet" href="css/style.css"/>

    <title>Centro Hospitalar Upskill</title>
</head>
<body>
<jsp:include page="med_sidebar.jsp"/>
<div class="main">
    <div class="container">
        <div class="page-title">
            <h2><img src="/images_web/calendar.svg" alt=""/><span class="title-logo">Calendário de Vagas</span></h2>
        </div>
        <div class="page-content">
            <div class="calendar-content">
                <div class="med-calendar">
                    <form action="/med_calendario" method="POST">
                        <h3 id="med-gerar-horario-t">Gerar Horário</h3>
                        <label for="dia_semana">Dia da Semana</label><br>
                        <select name="diaSemana" id="dia_semana">
                            <option value="MONDAY">Segunda-Feira</option>
                            <option value="TUESDAY">Terça-Feira</option>
                            <option value="WEDNESDAY">Quarta-Feira</option>
                            <option value="THURSDAY">Quinta-Feira</option>
                            <option value="FRIDAY">Sexta-Feira</option>
                        </select><br>
                        <label for="inicioTurno">Início do Turno</label><br>
                        <input type="time" id="inicioTurno" name="inicioTurno"><br>
                        <label for="fimTurno">Fim do Turno</label><br>
                        <input type="time" id="fimTurno" name="fimTurno"><br>
                        <label for="inicioIntervalo">Início do Intervalo</label><br>
                        <input type="time" id="inicioIntervalo" name="inicioIntervalo"><br>
                        <label for="fimIntervalo">Fim do Intervalo</label><br>
                        <input type="time" id="fimIntervalo" name="fimIntervalo"><br>
                        <input type="hidden" id="c-medico" name="medico" value="${medicosList.getIdMedico()}">
                        <input type="submit" id="botao-pesquisar" value="Submit">
                    </form>
                </div>
                <div class="med-container-vagas">Vagas:</div>
                <div class="med-calendar-resize-table">
                    <div id="table-scrollable-med-calendario">
                        <table id="table_id" class="table table-borderless">
                            <thead class="table-head">
                            <tr>
                                <th scope="col">Data</th>
                                <th scope="col">Hora</th>
                            </tr>
                            </thead>
                            <tbody class="table-content">
                            <c:forEach var="nome_lista" items="${vagasList}">
                                <tr>
                                    <td>${nome_lista.getData()}</td>
                                    <td>${nome_lista.getHoraInicio()}</td>
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