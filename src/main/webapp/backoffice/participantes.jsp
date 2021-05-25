<jsp:include page="/templates/header.jsp" />
<jsp:include page="/templates/loggedNavbar.jsp" />

<% // limpiar atributo de session con la lista de cursos
session.removeAttribute("listaCursos");
 %>

<jsp:include page="/componentes/contextMenu.jsp" />

<jsp:include page="/componentes/confirmDelete.jsp" />

<div class="content">

	<h1 class="center">Participantes</h1>

	<div class="container">
		<jsp:include page="/componentes/tablaParticipantes.jsp" />
	</div>

</div>

<jsp:include page="/templates/footer.jsp" />