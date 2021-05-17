<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/templates/header.jsp" />
<jsp:include page="/templates/navbar.jsp" />

<div class="container">
	${errores}
</div>

<div class="container is-max-desktop block">
	<jsp:include page="/componentes/registerForm.jsp" />
</div>



<jsp:include page="/templates/footer.jsp" />