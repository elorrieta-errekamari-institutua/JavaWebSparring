<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="templates/cabecera.jsp" />
<c:if test="${ usuarioLogeado == null }">
	<jsp:include page="templates/navbar.jsp" />
</c:if>
<c:if test="${ usuarioLogeado != null }">
	<jsp:include page="templates/loggedNavbar.jsp" />
</c:if>


	<h1 class="center">Portada</h1>
	<p style="color: orange">${usuarioLogeado}</p>
	<p class="center green">${mensaje}</p>
	<p class="center red">${nombre}</p>
	
<jsp:include page="templates/footer.jsp" />