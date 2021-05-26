<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <table id="table" class="table is-hoverable is-striped">
        <thead>
            <tr>
                <c:forEach var="element" items="${tableHeader}">
                    <th>${element}</th>
                </c:forEach>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="row" items="${tableBody}" varStatus="rowIndex">
                <c:forEach var="col" items="${row}" varStatus="colIndex">
                    <c:if test="${colIndex.count eq 1}">
                        <c:if test="${col gt 0}">
                            <tr class="clickable"
                                onclick="document.location='/javaweb/backoffice/action?operacion=2&clase=${clase}&id=${col}'"
                                oncontextmenu="openCtxMenu(event, ${clase}, ${col})">
                        </c:if>
                        <c:if test="${col le 0}">
                            <tr class="${ col eq 0 ? 'has-background-warning' : ''  }">
                        </c:if>
                        <td>${rowIndex.count}</td>
                    </c:if>
                    <c:if test="${colIndex.count gt 1}">
                        <td>${col}</td>
                    </c:if>
                </c:forEach>
                </tr>
            </c:forEach>
        </tbody>

        <tfoot>
            <tr>
                <c:forEach var="element" items="${tableHeader}">
                    <th>${element}</th>
                </c:forEach>
            </tr>
        </tfoot>

    </table>