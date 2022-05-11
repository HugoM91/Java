<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt">
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <script src="https://kit.fontawesome.com/0a1ada860a.js" crossorigin="anonymous"></script>
    <script src="https://cdn.ckeditor.com/ckeditor5/26.0.0/classic/ckeditor.js"></script>
    <script src="js/consulta_text_editor.js"></script>
    <link rel="stylesheet" href="css/style.css"/>
    <title>Centro Hospitalar Upskill</title>
</head>
<body>
<jsp:include page="med_sidebar.jsp"/>
<div class="main">
    <div class="container">
        <h3 id="ep-mtitle">Editar Perfil</h3>
        <form action="/med_editar_perfil" method="post">
            <div class="ep-contboss">
                    <div class="ep-cont">
                        <div class="ep-info">
                            <div class="ep-contacto-cont">
                                <h4 id="ep-titles">Contactos</h4>
                                <label for="ep-contacto-telefone">Telefone: </label>
                                <input type="tel" name="contacto" id="ep-contacto-telefone" value="${medico.getContacto()}"/>
                            </div>
                            <div class="ep-morada-cont">
                                <h4 id="ep-titles">Morada</h4>
                                <label for="ep-endereco">Endereço: </label>
                                <input type="text" name="endereco" id="ep-endereco" value="${medico.getEndereco()}"/>
                                <div class="ep-morada-collumn">
                                    <div id="ep-morada-column-all">
                                        <label for="ep-andar">Andar: </label>
                                        <input type="text" name="andar" id="ep-andar" value="${medico.getAndar()}"/>

                                    </div>
                                    <div id="ep-morada-column-all">

                                        <label for="ep-cp">C.Postal: </label>
                                        <input type="text" name="codigoPostal" id="ep-cp" placeholder="0000-000"
                                               value="${medico.getCodigoPostal()}"/>

                                    </div>
                                    <div id="ep-morada-column-all">
                                        <label for="ep-distrito">Distrito: </label>
                                        <input type="text" name="localidade" id="ep-distrito"
                                               value="${medico.getLocalidade()}"/>
                                    </div>
                                </div>
                            </div>
                            <input type="hidden" name="idMedico" value="${medico.getIdMedico()}"/>
                            <button type="submit" id="ep-botsavee">
                                <div id="ep-inside-botsavee">Guardar</div>
                            </button>
                        </div>

                        </div>
                        <div class="ep-account-med-perfil">
                            <div class="ep-acc-cont-med-perfil">
                                <label for="editor-cv">Currículo</label>
                                <textarea id="editor-cv" name="cv" rows="10"></textarea>
                            </div>
                            <script>
                                ClassicEditor
                                    .create(document.querySelector('#editor-cv'))
                                    .catch(error => {
                                        console.error(error);
                                    });
                            </script>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>