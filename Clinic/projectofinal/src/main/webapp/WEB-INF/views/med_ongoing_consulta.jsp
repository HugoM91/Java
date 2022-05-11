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
        <div class="page-title">
            <h2><img src="/images_web/heart.svg" alt=""/><span class="title-logo">Consulta</span></h2>
        </div>
        <div class="page-content">
            <div class="consultation-content">
                <form action="" method="post" id="consultation-form">
                    <div id="page-content-left">
                        <div id="left-title">
                            <h5>Dados do Paciente</h5>
                        </div>
                        <div id="left-content">
                            <div class="row-consultation">
                                <label>Nome</label>
                                <p>${consulta.getIdUtente().getNome()}</p>
                            </div>
                            <div class="row-consultation">
                                <label>Data de Nascimento</label>
                                <p>${consulta.getIdUtente().getDataNascimento()}</p>
                            </div>
                            <div class="row-consultation">
                                <label>Género</label>
                                <p>${consulta.getIdUtente().getGenero()}</p>
                            </div>
                            <div class="row-consultation">
                                <label>Notas sobre Paciente</label>
                                <p>${consulta.getIdUtente().getObservacoes()}</p>
                            </div>
                            <div class="group-row">
                                <div class="row-consultation">
                                    <button type="submit" class="btn btn-end">Terminar consulta</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="page-content-right">
                        <label for="editor">Anamnese</label><br>
                        <textarea id="editor" name="observacoes" rows="10"></textarea>
                    </div>
                </form>
            </div>
        </div>
        <script>
            ClassicEditor
                .create(document.querySelector('#editor'))
                .catch(error => {
                    console.error(error);
                });
        </script>
    </div>
</div>
</body>
</html>