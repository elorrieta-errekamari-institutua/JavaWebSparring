<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/templates/header.jsp" />
<c:if test="${ usuarioLogeado == null }">
	<jsp:include page="/templates/navbar.jsp" />
	<div class="container is-max-desktop block">
		<jsp:include page="/componentes/loginForm.jsp" />
	</div>	
</c:if>
<c:if test="${ usuarioLogeado != null }">
	<jsp:include page="/templates/loggedNavbar.jsp" />
	<jsp:include page="/componentes/dashboard.jsp" />
</c:if>
	
<jsp:include page="/templates/footer.jsp" />