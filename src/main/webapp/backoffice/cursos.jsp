<jsp:include page="/templates/header.jsp" />
<jsp:include page="/templates/loggedNavbar.jsp" />

<% // limpiar la sesion 
session.removeAttribute("listaParticipantes");
session.removeAttribute("listaAulas");
 %>

<jsp:include page="/componentes/contextMenu.jsp" />

<jsp:include page="/componentes/confirmDelete.jsp" />

<div class="content">

	<h1 class="center">Cursos</h1>

	<div class="container">
		<jsp:include page="/componentes/tablaCursos.jsp" />
	</div>

</div>


<jsp:include page="/templates/footer.jsp" />