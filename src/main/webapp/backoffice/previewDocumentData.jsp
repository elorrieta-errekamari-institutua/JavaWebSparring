<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/templates/header.jsp" />
<jsp:include page="/templates/loggedNavbar.jsp" />

<div class="container">


	<c:if test="${listaParticipantes != null}">
	<div class="container">
		<a class="button is-success" href="/javaweb/backoffice/guardarParticipantes">Confirmar</a>

		<a class="button is-danger" href="/javaweb/backoffice/fileUpload.jsp">Cancelar</a>
	</div>
		<jsp:include page="/componentes/tablaParticipantes.jsp" />
	</c:if>
	<c:if test="${listaCursos != null}">
	<div class="container">
		<a class="button is-success" href="/javaweb/backoffice/guardarCursos">Confirmar</a>

		<a class="button is-danger" href="/javaweb/backoffice/fileUpload.jsp">Cancelar</a>
	</div>
		<jsp:include page="/componentes/tablaCursos.jsp" />
	</c:if>

</div>

<jsp:include page="/templates/footer.jsp" />