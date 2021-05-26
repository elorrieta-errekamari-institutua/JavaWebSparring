<jsp:include page="/templates/header.jsp" />
<jsp:include page="/templates/loggedNavbar.jsp" />

<jsp:include page="/componentes/contextMenu.jsp" />

<jsp:include page="/componentes/confirmDelete.jsp" />

<div class="content">

	<h1 class="center">${title}</h1>

	<div class="container">
		<jsp:include page="/componentes/genericTable.jsp" />
	</div>

</div>


<jsp:include page="/templates/footer.jsp" />