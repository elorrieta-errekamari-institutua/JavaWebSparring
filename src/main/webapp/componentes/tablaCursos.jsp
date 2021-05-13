<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table id="table" class="table is-hoverable is-striped">
	<thead>
		<tr>
			<th>#</th>
			<th>Nombre</th>
			<th>Cualificaci&oacute;n</th>
			<th>C&oacute;digo UC</th>
			<th>Competencia</th>
			<th>C&oacute;digo AAFF</th>
			<th>Horas</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="element" items="${listaCursos}" varStatus="index">
			<c:if test="${element.id > 0}">
				<tr class="clickable" onclick="document.location='/javaweb/backoffice/insertCursoForm?id=${element.id}'">
			</c:if>
			<c:if test="${element.id <= 0}">
				<tr class="${ (element.guardado) ? 'has-background-warning' : ''  }">
			</c:if>
					<th>${index.count}</th>
					<td>${element.nombre}</td>
					<td>${element.cualificacion}</td>
					<td>${element.codigoUc}</td>
					<td>${element.competencia}</td>
					<td>${element.codigoAaff}</td>
					<td>${element.horasCurso}</td>
					<td><a href="/javaweb/backoffice/borrarCurso?id=${element.id}" class="button">Borrar curso</a></td>
				</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<th>#</th>
			<th>Nombre</th>
			<th>Cualificaci&oacute;n</th>
			<th>C&oacute;digo UC</th>
			<th>Competencia</th>
			<th>C&oacute;digo AAFF</th>
			<th>Horas</th>
		</tr>
	</tfoot>
</table>
