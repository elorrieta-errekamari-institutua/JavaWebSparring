<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="templates/cabecera.jsp" />
<jsp:include page="templates/navbar.jsp" />

	<h1 class="center">Registro</h1>
	
	<div class="centralBox">
		<form method="post" action="registro" enctype="multipart/form-data">
			<ul>
				<li>
					<div class="linea">
						<label for="nombre">Nombre de usuario:</label>
						<input  type="text" name="nombre" id="nombre" placeholder="Su nombre" autofocus>
					</div>
				</li>
				<li>
					<div class="linea">
						<label for="pass">Contrase&ntilde;a:</label>
						<input type="password" name="pass" id="pass" placeholder="Su contrase&ntilde;a">
					</div>
				</li>
				<li>
					<div class="linea">
						<label for="pass2">Repita la contrase&ntilde;a:</label>
						<input type="password" name="pass2" id="pass2" value="<c:out value="${param.pass2}" />" placeholder="Su contrase&ntilde;a">
						<c:if test="empty param.pass2"><p class="red">Las contraseñas no coinciden</p></c:if>
					</div>
				</li>
				<li>
					<div class="linea">
						<label for="email">E-mail:</label>
						<input type="email" name="email" id="email" placeholder="nombre@dominio.com">
					</div>
				</li>
				<li>
					<div class="linea">
						<label for="img">Avatar:</label>
						<input type="file" name="image" id="img" accept=".jpg, .jpeg, .bmp, .gif, .png" onchange="ValidateImg(this);">
					</div>
				</li>
				<li>
					<br>
					<div class="linea">
						<input type="submit" value="Entrar">
						<a href="login.jsp">Iniciar sesion</a>
					</div>
				</li>
			</ul>
		</form>
	</div>
	
	<script type="text/javascript">
	var _validFileExtensions = [".jpg", ".jpeg", ".bmp", ".gif", ".png"];    
	function ValidateImg(oInput) {
		if (oInput.type == "file") {
			var sFileName = oInput.value;
			if (sFileName.length > 0) {
				var blnValid = false;
				for (var j = 0; j < _validFileExtensions.length; j++) {
					var sCurExtension = _validFileExtensions[j];
					if (sFileName.substr(sFileName.length - sCurExtension.length, sCurExtension.length).toLowerCase() == sCurExtension.toLowerCase()) {
						blnValid = true;
						break;
					}
				}
				if (!blnValid) {
					alert("Sorry, " + sFileName + " is invalid, allowed extensions are: " + _validFileExtensions.join(", "));
					oInput.value = "";
					return false;
				}
			}
		}
	    return true;
	}
</script>

<jsp:include page="templates/footer.jsp" />