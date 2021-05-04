<jsp:include page="/templates/header.jsp" />
<jsp:include page="/templates/loggedNavbar.jsp" />

<div class="container">
	<jsp:include page="/componentes/tablaParticipantes.jsp" />

	<a class="button is-primary" href="/javaweb/guardar">Confirmar</a>

	<button class="button" onclick="emptySession()">Cancelar</button>
</div>

<jsp:include page="/templates/footer.jsp" />