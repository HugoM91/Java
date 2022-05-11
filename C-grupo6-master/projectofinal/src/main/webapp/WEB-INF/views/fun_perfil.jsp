<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt">
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <title>Centro Hospitalar Upskill</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.23/css/dataTables.bootstrap5.min.css">
    <script src="https://kit.fontawesome.com/0a1ada860a.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<jsp:include page="sidebar.jsp"/>
<div class="main">
    <div class="p-title-cont">
        <div class="p-resizeimage">
            <img src="/images_web/perfil.svg"/>
        </div>
        <h3 id="p-title">Perfil</h3>
    </div>
    <div class="p-botaoeditar-cont">
        <div class="p-info-cont">
            <div class="p-infopessoais">
                <h5 id="p-ip-title">Dados Pessoais:</h5>

                <c:forEach var="lista" items="${funcionario}">
                    <c:set var="nome" value="${lista.getNome()}"/>
                    <c:if test="${nome==username}">
                        <div id="p-info">Nome: ${lista.getNome()}</div>
                        <div id="p-info">Data de Nascimento: ${lista.getDataNascimento()}</div>
                        <div id="p-info">NIF: ${lista.getNif()}</div>
                        <h5>Dados de Contacto:</h5>
                        <div id="p-info">Morada: ${lista.getEndereco()}, ${lista.getCodigoPostal()} - ${lista.getLocalidade()}</div>
                        <div id="p-info">Email: ${lista.getEmail()}</div>
                        <div id="p-info">Telefone: ${lista.getTelefone()}</div>
                        <div id="p-info">Telemóvel: ${lista.getTelemovel()}</div>

                    </c:if>
                </c:forEach>
            </div>

            <div class="p-acc-boss">
                <div class="p-acc-cont">
                    <div class="p-acc-resizeimage">
                        <img src="/images_web/placeholder.png"/>
                    </div>
                </div>
                <a href="fun_editar_perfil" id="p-botaoeditar">
                    <div id="p-inside-botaoeditar"><i class="fas fa-user-edit"></i>Editar</div>
                </a>
            </div>
        </div>

    </div>
</div>
</body>
</html>