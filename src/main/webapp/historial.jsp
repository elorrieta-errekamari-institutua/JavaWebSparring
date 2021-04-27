<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="templates/cabecera.jsp" />
<jsp:include page="templates/loggedNavbar.jsp" />

<div class="container">
	<table class="table">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>DNI</th>
				<th>Telefono</th>
				<th><abbr title="Fecha de nacimiento">Fecha</abbr></th>
				<th>Direccion</th>
				<th><abbr title="Codigo postal">CP</abbr></th>
				<th>Municipio]</th>
				<th>Provincia</th>
				<th>ERTE</th>
				<th><abbr title="Situacion laboral">Laboral</abbr></th>
				<th><abbr title="Situacion administrativa">Administrativa</abbr></th>
				<th>Titulacion</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>Nombre</th>
				<th>DNI</th>
				<th>Telefono</th>
				<th><abbr title="Fecha de nacimiento">Fecha</abbr></th>
				<th>Direccion</th>
				<th><abbr title="Codigo postal">CP</abbr></th>
				<th>Municipio]</th>
				<th>Provincia</th>
				<th>ERTE</th>
				<th><abbr title="Situacion laboral">Laboral</abbr></th>
				<th><abbr title="Situacion administrativa">Administrativa</abbr></th>
				<th>Titulacion</th>
			</tr>
		</tfoot>
	</table>
</div>
	
<jsp:include page="templates/footer.jsp" />