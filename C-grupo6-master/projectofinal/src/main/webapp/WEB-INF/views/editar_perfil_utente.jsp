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
<jsp:include page="sidebar.jsp"/>
<div class="main">
    <div class="profile-container">
        <div class="page-title">
            <h2><img src="/images_web/caminho.svg" alt=""><span class="title-logo">Detalhes de Perfil</span></h2>
        </div>
        <div class="profile-page">
            <form action="/update-utente/${utente.getIdUtente()}" method="post" class="form-edit-patient">
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
                                    <label for="edit_phonenr">Telefone</label>
                                    <input type="text" id="edit_phonenr" name="telefone"
                                           value="${utente.getTelefone()}">
                                </div>
                                <div class="personal-details-row personal-details-row-right">
                                    <label for="edit_cellphonenr">Telemóvel</label>
                                    <input type="text" id="edit_cellphonenr" name="telemovel"
                                           value="${utente.getTelemovel()}">
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
                            <label for="edit_morada">Endereço</label><br>
                            <textarea id="edit_morada" name="morada" rows="2">${utente.getMorada()}</textarea>
                        </div>
                        <div class="personal-details-group">
                            <div class="personal-details-row personal-details-row-left">
                                <label for="edit_postal-code">Código Postal</label><br>
                                <input type="text" id="edit_postal-code" name="codigoPostal"
                                       value="${utente.getCodigoPostal()}">
                            </div>
                            <div class="personal-details-row personal-details-row-right">
                                <label for="edit_locality">Localidade</label><br>
                                <input type="text" id="edit_locality" name="localidade"
                                       value="${utente.getLocalidade()}">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="personal-notes-card">
                    <label for="edit_notes">Notas</label><br>
                    <textarea name="observacoes" id="edit_notes" rows="10">${utente.getObservacoes()}</textarea>
                    <button type="submit" class="btn btn-editar-utente">Atualizar</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>