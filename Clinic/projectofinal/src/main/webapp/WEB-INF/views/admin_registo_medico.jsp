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
    <script src="js/registo_medico.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.23/css/dataTables.bootstrap5.min.css">
    <link rel="stylesheet" href="css/style.css"/>
    <title>Centro Hospitalar Upskill</title>
</head>
<body>
<jsp:include page="admin_sidebar.jsp"/>
<div class="main">
    <div class="container">
        <div class="page-title">
            <h2><img src="/images_web/scope.svg" alt=""/><span class="title-logo">Registar Médico</span></h2>
        </div>
        <div class="page-content-registo">
            <form action="/admin_registo_medico" class="user-details" method="post">
                <div class="left-form">
                    <h4>Dados Pessoais</h4>
                    <div class="form-group">
                        <div id="form-row-left-doctor" class="form-row-doctor">
                            <label for="titulo">Título</label><br>
                            <select name="titulo" id="titulo">
                                <option value="Dr.">Dr.</option>
                                <option value="Dra.">Dra.</option>
                            </select>
                        </div>
                        <div id="form-row-right-doctor" class="form-row-doctor">
                            <label for="fullname">Nome Completo</label><br>
                            <input type="text" id="fullname" name="nome">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-row-doctor form-row-left">
                            <label for="birthday">Data de Nascimento</label><br>
                            <input type="date" id="birthday" name="dataNascimentoMedico">
                        </div>
                        <div class="form-row-doctor form-row-right">
                            <label for="especialidade">Especialidade</label><br>
                            <select name="especialidade" id="especialidade">
                                <c:forEach var="especialidade" items="${especialidadeList}">
                                    <option value="${especialidade.getIdEspecialidade()}">${especialidade.getTipo()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-row-doctor form-row-left">
                            <label for="cedula">Nº Cédula Profissional</label><br>
                            <input type="text" id="cedula" name="cedula">
                        </div>
                        <div class="form-row-doctor form-row-right">
                            <label for="nrnif">Nº Identificação Fiscal</label><br>
                            <input type="text" id="nrnif" name="nif">
                        </div>
                    </div>
                </div>
                <div class="right-form">
                    <h4>Dados de Conta</h4>
                    <div class="form-row-doctor">
                        <label for="email_doctor">Email</label><br>
                        <input type="text" id="email_doctor" name="email">
                    </div>
                    <div class="form-group">
                        <div class="form-row-doctor form-row-left">
                            <label for="password_doctor">Password</label><br>
                            <input type="password" id="password_doctor" name="password">
                        </div>
                        <div class="form-row-doctor form-row-right">
                            <label for="check_password_doctor">Confirmar Password</label><br>
                            <input type="password" id="check_password_doctor" onkeyup='check();'><br>
                            <span id='message'></span>
                        </div>
                    </div>
                    <footer class="form-submit">
                        <button type="submit" class="btn btn-registar-utente">Registar Médico</button>
                    </footer>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>