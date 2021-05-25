<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<table id="table" class="table is-hoverable is-striped">
		<thead>
			<tr>
				<th>#</th>
				<th>Nombre</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="element" items="${listaAulas}" varStatus="index">
				<c:if test="${element.id gt 0}">
					<tr class="clickable"
						onclick="document.location='/javaweb/backoffice/action?operacion=2&clase=4&id=${element.id}'"
						oncontextmenu="openCtxMenu(event, 4, ${element.id})">
				</c:if>
				<c:if test="${element.id le 0}">
					<tr class="${ element.guardado eq true ? 'has-background-warning' : ''  }">
				</c:if>
				<th>${index.count}</th>
				<td>${element.nombre}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th>#</th>
				<th>Nombre</th>
			</tr>
		</tfoot>
	</table>