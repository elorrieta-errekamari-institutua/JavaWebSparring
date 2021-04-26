<form method="post" action="login">
	<ul>
		<li>
			<div class="linea">
				<label for="nombre">Nombre de usuario:</label>
				<input  type="text" value="${nombre}" name="nombre" id="nombre" placeholder="Su nombre" autofocus>
			</div>
		</li>
		<li>
			<div class="linea">
				<label for="pass">Contrase&ntilde;a:</label>
				<input type="password" name="pass" id="pass" placeholder="Su contrase&ntilde;a">
			</div>
		</li>
		<li>
			<label for="save">Mantener abierta la sesion</label>
			<input type="checkbox" name="save" id="save">
		</li>
		<li>
			<br>
			<div class="linea">
				<input type="submit" value="Entrar">
				<a href="registro.jsp">Registrarse</a>
			</div>
		</li>
		
	</ul>
</form>
