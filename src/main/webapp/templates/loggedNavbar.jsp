<nav class="navbar is-dark block" role="navigation" aria-label="main navigation">
  <div class="navbar-brand">
    <a class="navbar-item" href="https://elorrieta.hezkuntza.net/es/inicio">
      <img src="assets/img/logoapp.svg" alt="logo">
    </a>

    <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="loggedNavbar">
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
    </a>
  </div>

  <div id="loggedNavbar" class="navbar-menu">
    <div class="navbar-start">
      <a class="navbar-item" href="index.jsp">
        Home
      </a>

      <a class="navbar-item" href="participantes">
        Participantes registrados
      </a>

      <div class="navbar-item has-dropdown is-hoverable">
        <a class="navbar-link">
          More
        </a>

        <div class="navbar-dropdown">
          <a class="navbar-item">
            About
          </a>
          <a class="navbar-item">
            Jobs
          </a>
          <a class="navbar-item">
            Contact
          </a>
          <hr class="navbar-divider">
          <a class="navbar-item">
            Report an issue
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
          <a class="navbar-item" href="historial.jsp">
            Historial
          </a>
          <a class="navbar-item" href="fileUpload.jsp">
            Subir documentos
          </a>
          <hr class="navbar-divider">
          <a class="navbar-item" href="logout">
            Salir
          </a>
        </div>
      </div>
    </div>
  </div>
</nav>