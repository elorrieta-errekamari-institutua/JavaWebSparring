<jsp:include page="/templates/header.jsp" />
<jsp:include page="/templates/loggedNavbar.jsp" />

<div class="container">
	
	<div class="container">
		<a class="button is-success" href="/javaweb/backoffice/guardar">Confirmar</a>

		<a class="button is-danger" href="/javaweb/backoffice/fileUpload.jsp">Cancelar</a>
	</div>

	<jsp:include page="/componentes/tablaParticipantes.jsp" />

</div>

<jsp:include page="/templates/footer.jsp" />