<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="modalDelete" class="modal">
    <div class="modal-background"></div>
    <div class="modal-content">
        <div class="box">
        <p>&iquest;Esta seguro de que desea eliminarlo?</p>
        <c:if test="${ listaParticipantes ne null }">
            <a href="/javaweb/backoffice/action?operacion=3&clase=3&id=${participante.id}" class="button is-success">Eliminar</a>
        </c:if>
        <c:if test="${ listaCursos ne null }">
            <a href="/javaweb/backoffice/action?operacion=3&clase=1&id=${curso.id}" class="button is-success">Eliminar</a>
        </c:if>
        <a class="button is-danger close">No</a></div>
    </div>
    <button class="modal-close is-large" aria-label="close"></button>
</div>