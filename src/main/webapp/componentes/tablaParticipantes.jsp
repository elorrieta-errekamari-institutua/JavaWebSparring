<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="table is-hoverable is-striped">
	<thead>
		<tr>
			<th>#</th>
			<th>Nombre</th>
			<th>DNI</th>
			<th>Telefono</th>
			<th><abbr title="Fecha de nacimiento">Fecha</abbr></th>
			<th>Direccion</th>
			<th><abbr title="Codigo postal">CP</abbr></th>
			<th>Municipio</th>
			<th>Provincia</th>
			<th>ERTE</th>
			<th><abbr title="Situacion laboral">Laboral</abbr></th>
			<th><abbr title="Situacion administrativa">Administrativa</abbr></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="element" items="${listaParticipantes}" varStatus="index">
			<tr>
				<th>${index.count}</th>
				<td>${element.getNombreCompleto()}</td>
				<td>${element.getDni()}</td>
				<td>${element.getTelefono()}</td>
				<td>${element.getFechaDeNacimiento()}</td>
				<td>${element.getDireccion()}</td>
				<td>${element.getCodigoPostal()}</td>
				<td>${element.getMunicipio()}</td>
				<td>${element.getProvincia()}</td>
				<td>${element.isErte()}</td>
				<td>${element.getSituacionLaboral()}</td>
				<td>${element.getSituacionAdministrativa()}</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<th>#</th>
			<th>Nombre</th>
			<th>DNI</th>
			<th>Telefono</th>
			<th><abbr title="Fecha de nacimiento">Fecha</abbr></th>
			<th>Direccion</th>
			<th><abbr title="Codigo postal">CP</abbr></th>
			<th>Municipio</th>
			<th>Provincia</th>
			<th>ERTE</th>
			<th><abbr title="Situacion laboral">Laboral</abbr></th>
			<th><abbr title="Situacion administrativa">Administrativa</abbr></th>
		</tr>
	</tfoot>
</table>