<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<jsp:include page="/templates/header.jsp" />
	<jsp:include page="/templates/loggedNavbar.jsp" />

	<jsp:include page="/componentes/contextMenu.jsp" />

	<jsp:include page="/componentes/confirmDelete.jsp" />

	<div class="content">

		<h1 class="center">${title} (${fn:length(tableBody)})</h1>

		<div class="container">
			<jsp:include page="/componentes/genericTable.jsp" />
		</div>

	</div>


	<jsp:include page="/templates/footer.jsp" />