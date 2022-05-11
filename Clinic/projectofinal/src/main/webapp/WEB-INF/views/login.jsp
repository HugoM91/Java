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
    <script src="https://kit.fontawesome.com/0a1ada860a.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="/css/login.css">
    <title>Centro Hospitalar UPskill</title>
</head>
<body>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-md-6 col-md-auto login-box">
            <div class="top">
                <img src="/images_web/logo.svg" alt="" class="logo-img mx-auto d-block">
                <h1 class="text-center wdi">Bem-Vindo</h1>
            </div>


            <form action="/login" method="POST">
                <div class="form-row">
                    <div class="col-md-12">
                        <input type="text" name="username" class="form-control form-control-lg flat-input"
                               placeholder="Nome">
                    </div>
                    <div class="col-md-12">
                        <input type="password" name="password" class="form-control form-control-lg flat-input"
                               placeholder="Password">
                    </div>
                    <button type="submit" class="btn btn-lg btn-block btn-login" value="Submit">Entrar</button>
                </div>
            </form>


        </div>
    </div>
    <footer>
        <img src="/images_web/Capturadeecra.png" alt="">
    </footer>
</div>
</body>
</html>