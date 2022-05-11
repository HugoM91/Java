<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt">
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <title>Centro Hospitalar Upskill</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.23/css/dataTables.bootstrap5.min.css">
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<jsp:include page="admin_sidebar.jsp"/>
<div class="main">
    <div class="container">
        <h3 id="ep-mtitle">Editar Perfil</h3>
        <div class="ep-contboss">
            <div class="ep-cont">

                <form action="/admin_editar_perfil" method="post">
                    <div class="ep-info">
                        <div class="ep-contacto-cont">
                            <h4 id="ep-titles">Contactos</h4>

                            <label for="ep-contacto-telemovel">Telemóvel: </label>
                            <input type="tel" name="telemovel" id="ep-contacto-telemovel"
                                   value="${admin.getTelemovel()}"/>

                        </div>

                        <div class="ep-morada-cont">
                            <h4 id="ep-titles">Morada</h4>

                            <label for="ep-endereco">Endereço: </label>
                            <input type="text" name="endereco" id="ep-endereco" value="${admin.getEndereco()}"/>

                            <div class="ep-morada-collumn">
                                <div id="ep-morada-column-all">

                                    <label for="ep-andar">Andar: </label>
                                    <input type="text" name="andar" id="ep-andar" value="${admin.getAndar()}"/>

                                </div>
                                <div id="ep-morada-column-all">


                                    <label for="ep-cp">C.Postal: </label>
                                    <input type="text" name="codigoPostal" id="ep-cp" placeholder="0000-000"
                                           value="${admin.getCodigoPostal()}"/>

                                </div>
                                <div id="ep-morada-column-all">

                                    <label for="ep-distrito">Distrito: </label>
                                    <input type="text" name="localidade" id="ep-distrito"
                                           value="${admin.getLocalidade()}"/>

                                </div>
                            </div>
                        </div>
                        <input type="hidden" name="idAdmin" value="${admin.getIdAdmin()}"/>
                        <button type="submit" id="ep-botsavee">
                            <div id="ep-inside-botsavee">Guardar</div>
                        </button>
                    </div>
                </form>

            </div>
            <div class="ep-account">
                <div class="ep-acc-cont">
                    <h4>Alterar Palavra-Passe</h4>
                    <label for="ep-account-app" id="ep-pp">Palavra-Passe Actual:</label>
                    <input type="text" name="ppactual" id="ep-account-app"/>
                    <label for="ep-account-npp" id="ep-pp">Nova Palavra-Passe: </label>
                    <input type="text" name="ppnova" id="ep-account-npp"/>
                    <label for="ep-account-cpp" id="ep-pp">Confirmar Palavra-Passe: </label>
                    <input type="text" name="ppconfirmar" id="ep-account-cpp"/>
                    <button id="ep-botsave">
                        <div id="ep-inside-botsave">Guardar</div>
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>