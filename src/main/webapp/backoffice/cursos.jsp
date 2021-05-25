<jsp:include page="/templates/header.jsp" />
<jsp:include page="/templates/loggedNavbar.jsp" />

<% // limpiar atributo de session con la lista de participantes
session.removeAttribute("listaParticipantes");
 %>

<jsp:include page="/componentes/contextMenu.jsp" />

<div class="content">

	<h1 class="center">Cursos</h1>

	<div class="container">
		<jsp:include page="/componentes/tablaCursos.jsp" />
	</div>

</div>


<jsp:include page="/templates/footer.jsp" />