<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
				<c:if test="${element.id gt 0}">
					<tr class="clickable"
						onclick="document.location='/javaweb/backoffice/action?operacion=2&clase=1&id=${element.id}'"
						oncontextmenu="openCtxMenu(event, 1, ${element.id})">
				</c:if>
				<c:if test="${element.id le 0}">
					<tr class="${ element.guardado eq true ? 'has-background-warning' : ''  }">
				</c:if>
				<th>${index.count}</th>
				<td>${element.nombre}</td>
				<td>${element.cualificacion}</td>
				<td>${element.codigoUc}</td>
				<td>${element.competencia}</td>
				<td>${element.codigoAaff}</td>
				<td>${element.horasCurso}</td>
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