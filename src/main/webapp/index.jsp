<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/templates/header.jsp" />
<c:if test="${ usuarioLogeado == null }">
	<jsp:include page="/templates/navbar.jsp" />
	<div class="container is-max-desktop">
		<jsp:include page="/componentes/loginForm.jsp"></jsp:include>
	</div>	
</c:if>
<c:if test="${ usuarioLogeado != null }">
	<jsp:include page="/templates/loggedNavbar.jsp" />
	<h1 class="center">Portada</h1>
	<p class="center green">${mensaje}</p>
	<p class="center">${nombre}</p>
</c:if>
	
<jsp:include page="/templates/footer.jsp" />