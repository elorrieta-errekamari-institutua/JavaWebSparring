<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
	<ul class="topnav">
		<li><a href="index.jsp">Home</a></li>
		<li><a href="#news">News</a></li>
		<li class="right"><a href="login.jsp">Entrar</a></li>
		<li class="right"><a class="active" href="registro.jsp">Registrate</a></li>
	</ul>
	<h1 class="center">Registro</h1>

	<div class="centralBox">
		<form method="post" action="registro">
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
						<input type="password" name="pass2" id="pass2" placeholder="Su contrase&ntilde;a">
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
						<input type="file" name="image" id="img" accept=".jpg, .jpeg, .bmp, .gif, .png"onchange="ValidateImg(this);">
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
</body>
</html>