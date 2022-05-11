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
<jsp:include page="ute_sidebar.jsp"/>
<div class="main">
    <div class="container-edit-utente">
        <h3 id="ep-mtitle">Editar Perfil</h3>
        <div class="ep-contboss">
            <div class="ep-cont">
                <form action="/ute_editar_perfil" method="post">
                    <div class="ep-info">
                        <div class="ep-contacto-cont">
                            <h4 id="ep-titles">Contactos</h4>


                            <label for="ep-contacto-telefone">Telefone: </label>
                            <input type="tel" name="telefone" id="ep-contacto-telefone"
                                   value="${utente.getTelefone()}"/>
                            <label for="ep-contacto-telemovel">Telemóvel: </label>
                            <input type="tel" name="telemovel" id="ep-contacto-telemovel"
                                   value="${utente.getTelemovel()}"/>

                        </div>

                        <div class="ep-morada-cont">
                            <h4 id="ep-titles">Morada</h4>

                            <label for="ep-endereco">Endereço: </label>
                            <input type="text" name="morada" id="ep-endereco" value="${utente.getMorada()}"/>

                            <div class="ep-morada-collumn">
                                <div id="ep-morada-column-all">


                                    <label for="ep-cp">C.Postal: </label>
                                    <input type="text" name="codigoPostal" id="ep-cp" placeholder="0000-000"
                                           value="${utente.getCodigoPostal()}"/>

                                </div>
                                <div id="ep-morada-column-all">

                                    <label for="ep-distrito">Distrito: </label>
                                    <input type="text" name="localidade" id="ep-distrito"
                                           value="${utente.getLocalidade()}"/>

                                </div>
                            </div>
                            <div class="ep-morada-column">
                                <div id="ep-morada-column-all">
                                    <label for="observacoes">Observações:</label>
                                    <textarea name="observacoes" id="observacoes" cols="30" rows="5">${utente.getObservacoes()}</textarea>
                                </div>
                            </div>
                        </div>
                        <input type="hidden" name="idUtente" value="${utente.getIdUtente()}"/>
                        <button type="submit" id="ep-botsavee">
                            <div id="ep-inside-botsavee">Guardar</div>
                        </button>
                    </div>
                </form>


            </div>
            <div class="ep-account">
                <div class="ep-acc-cont">
                    <h4>Alterar Palavra-Passe</h4>
                    <label for="ep-account-app" id="ep-pp"
                    >Palavra-Passe Actual:
                    </label>
                    <input type="text" name="ppactual" id="ep-account-app"/>
                    <label for="ep-account-npp" id="ep-pp">Nova Palavra-Passe: </label>
                    <input type="text" name="ppnova" id="ep-account-npp"/>
                    <label for="ep-account-cpp" id="ep-pp"
                    >Confirmar Palavra-Passe:
                    </label>
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