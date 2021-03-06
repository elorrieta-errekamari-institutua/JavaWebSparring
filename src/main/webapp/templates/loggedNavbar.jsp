<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

  <nav class="navbar block" role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
      <a class="navbar-item" href="https://elorrieta.hezkuntza.net/es/inicio">
        <img class="has-background-primary" src="/javaweb/assets/img/logoapp.svg" alt="logo">
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
          Inicio
        </a>

        <c:if test="${ usuarioLogeado.rolUsuario eq 'Admin' }">
          <div class="navbar-item has-dropdown is-hoverable">
            <a class="navbar-link" href="/javaweb/backoffice/action?operacion=4&clase=3">
              Participantes
            </a>
            <div class="navbar-dropdown">
              <a class="navbar-item" href="/javaweb/backoffice/action?operacion=4&clase=3">
                Lista de participantes
              </a>
              <a class="navbar-item" href="/javaweb/backoffice/action?operacion=2&clase=3&id=-1">
                Insertar participante
              </a>
            </div>
          </div>

          <a class="navbar-item" href="/javaweb/backoffice/action?operacion=4&clase=8">
            Ediciones
          </a>

          <div class="navbar-item has-dropdown is-hoverable">
            <a class="navbar-link" href="/javaweb/backoffice/action?operacion=4&clase=1">
              Cursos
            </a>
            <div class="navbar-dropdown">
              <a class="navbar-item" href="/javaweb/backoffice/action?operacion=4&clase=1">
                Lista de cursos
              </a>
              <a class="navbar-item" href="/javaweb/backoffice/action?operacion=2&clase=1&id=-1">
                Insertar curso
              </a>
            </div>
          </div>

          <div class="navbar-item has-dropdown is-hoverable">
            <a class="navbar-link" href="/javaweb/backoffice/action?operacion=4&clase=4">
              Aulas
            </a>
            <div class="navbar-dropdown">
              <a class="navbar-item" href="/javaweb/backoffice/action?operacion=4&clase=4">
                Lista de aulas
              </a>
              <a class="navbar-item" href="/javaweb/backoffice/action?operacion=2&clase=4&id=-1">
                Insertar aula
              </a>
            </div>
          </div>

          <a class="navbar-item" href="/javaweb/backoffice/fileUpload.jsp">
            Importar fichero
          </a>
        </c:if>
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