<%@ page contentType="text/html; charset=UTF-8" %>
<div class="sidenav">
    <img id="centrohospitalar-logo" src="/images_web/logo.svg"/>

    <div class="nav-board">
        <span id="nav-hi">Olá de novo,</span>
        <a href="/admin_perfil">
            <div id="nav-name">${username}</div>
        </a>
        <span id="nav-role">Admin</span>
    </div>

    <div class="nav-logo">
        <a href="/admin_home"
        ><img src="/images_web/house.svg"/><span class="opacity-logo">
            Início</span
        ></a
        >
    </div>
    <div class="nav-logo">
        <a href="/admin_utente"
        ><img src="/images_web/caminho.svg" alt=""/><span class="opacity-logo">
            Utentes</span
        ></a
        >
    </div>
    <div class="nav-logo">
        <a href="/admin_funcionario"
        ><img src="/images_web/clipboard.svg"/><span class="opacity-logo">
            Funcionários</span
        ></a
        >
    </div>
    <div class="nav-logo">
        <a href="/admin_medicos"
        ><img src="/images_web/scope.svg"/><span class="opacity-logo">
            Médicos</span
        ></a
        >
    </div>
    <div class="nav-logo">
        <a href="/admin_consulta"
        ><img src="/images_web/heart.svg"/><span class="opacity-logo">
            Consultas</span
        ></a
        >
    </div>

    <div id="nav-quickaccess">Acessos Rápidos</div>
    <div class="nav-logo">
        <a href="admin_info_gerais"
        ><img src="/images_web/grupo.svg"/><span class="opacity-logo">
            Informações gerais</span
        ></a
        >
    </div>
    <div class="nav-logo">
        <a href="admin_contactos"
        ><img src="/images_web/phone.svg"/><span class="opacity-logo">
            Contactos</span
        ></a
        >
    </div>
    <img id="upskill-logo" src="/images_web/logo1.png"/>
    <div class="nav-logo">
        <div class="footer-nav">
            <a href="/logout"> <img id="all-logos" src="/images_web/logout.svg"/>
                <span class="opacity-logo"> Terminar Sessão</span>
            </a>
        </div>
    </div>
</div>