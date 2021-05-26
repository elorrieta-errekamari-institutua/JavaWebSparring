<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<jsp:include page="/templates/header.jsp" />
	<jsp:include page="/templates/loggedNavbar.jsp" />

	<div class="container">

		<div class="content">

			<h1 class="center">${title}</h1>

			<a class="button is-success" href="/javaweb/backoffice/action?operacion=5&clase=${clase}">Confirmar</a>

			<a class="button is-danger" href="/javaweb/backoffice/fileUpload.jsp">Cancelar</a>

			<jsp:include page="/componentes/genericTable.jsp" />

		</div>
	</div>

	<jsp:include page="/templates/footer.jsp" />