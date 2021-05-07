<nav class="navbar block" role="navigation" aria-label="main navigation">
  <div class="navbar-brand">
    <a class="navbar-item" href="https://elorrieta.hezkuntza.net/es/inicio">
      <img src="/javaweb/assets/img/logoapp.svg" alt="logo">
    </a>

    <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="loggedNavbar">
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
    </a>
  </div>

  <div id="loggedNavbar" class="navbar-menu">
    <div class="navbar-start">
      <a class="navbar-item" href="/javaweb/index.jsp">
        Home
      </a>

      <div class="navbar-item has-dropdown is-hoverable">
        <a class="navbar-link" href="/javaweb/backoffice/participantes">
          Gestionar participantes
        </a>

        <div class="navbar-dropdown">
          <a class="navbar-item" href="/javaweb/backoffice/participantes">
            Lista de participantes
          </a>
          <a class="navbar-item" href="/javaweb/backoffice/insertForm?id=-1">
            Insertar participante
          </a>
          <a class="navbar-item" href="/javaweb/backoffice/fileUpload.jsp">
            Importar fichero
          </a>
        </div>
      </div>
    </div>

    <div class="navbar-end">
      <div class="navbar-item has-dropdown is-hoverable">
        <a class="navbar-link">
          ${usuarioLogeado.nombre}
        </a>
        <div class="navbar-dropdown is-right">
          <a class="navbar-item">
            Perfil
          </a>
          <hr class="navbar-divider">
          <a class="navbar-item" href="/javaweb/logout">
            Salir
          </a>
        </div>
      </div>
    </div>
  </div>
</nav>
<main role="main">