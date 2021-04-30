<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table id="table" class="table is-hoverable is-striped">
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
			<tr class="${ (element.guardado) ? 'has-background-warning' : ''  }">
				<th>${(element.id > 0) ? element.id : index.count}</th>
				<td>${element.nombreCompleto}</td>
				<td>${element.dni}</td>
				<td>${element.telefono}</td>
				<td>${element.fechaDeNacimiento}</td>
				<td>${element.direccion}</td>
				<td>${element.codigoPostal}</td>
				<td>${element.municipio}</td>
				<td>${element.provincia}</td>
				<td>${element.erte}</td>
				<td>${element.situacionLaboral}</td>
				<td>${element.situacionAdministrativa}</td>
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
