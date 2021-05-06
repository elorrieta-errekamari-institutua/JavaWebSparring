<jsp:include page="/templates/header.jsp" />
<jsp:include page="/templates/loggedNavbar.jsp" />

<div class="container">
	<jsp:include page="/componentes/tablaParticipantes.jsp" />

	<a class="button is-primary" href="/javaweb/backoffice/guardar">Confirmar</a>

	<button class="button" href="/javaweb/fileUpload.jsp">Cancelar</button>
</div>

<jsp:include page="/templates/footer.jsp" />