<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="templates/cabecera.jsp" />
<jsp:include page="templates/navbar.jsp" />

	<h1 class="center">Historial de partidas</h1>
	
	<%
	//	ArrayList<Integer> values= (ArrayList) request.getAttribute("valuesarray");
	%>
	<table>
    <%
		int k=0;
		int noOfRows=5;
		int noOftds=4;
		for(int i = 0; i<noOfRows; i++) {
		//	if(k==values.size()){break;}
	%>
				<tr>
				<%for(int j = 0; j<noOftds; j++){%>
					<td><%=//values.get(k)%></td>
					<%k++;%>
			<%}%>
			</tr>
		<% //}%>
    </table>
	
<jsp:include page="templates/footer.jsp" />