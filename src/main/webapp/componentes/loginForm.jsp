<div class="card has-background-dark">
	<header class="card-header">
		<p class="card-header-title has-text-light">Login</p>
    </header>
	<div class="card-content">
		<form method="post" action="login">
			<div class="field">
				<label class="label has-text-light" for="name">Nombre de usuario:</label>
				<div class="control has-icons-left">
					<input class="input" type="text" name="nombre" id="name" placeholder="Su nombre de usuario" value="${nombre}" autofocus>
					<span class="icon is-small is-left">
						<i class="fas fa-user"></i>
					</span>
				</div>
			</div>
			
			<div class="field">
				<label class="label has-text-light" for="pass">Contrase&ntilde;a:</label>
				<div class="control has-icons-left">
					<input class="input" type="password" name="pass" id="pass" placeholder="Su contrase&ntilde;a" value="3WiXc6G">
					<span class="icon is-small is-left">
						<i class="fas fa-key"></i>
					</span>
				</div>
			</div>
			
		<!-- 	<div class="field">
				<div class="control">
					<input type="checkbox" name="save" id="save">
					<label class="checkbox has-text-light" for="save">Mantener abierta la sesion</label>
				</div>
			</div> -->
			
			<div class="field is-grouped is-grouped-centered">
				<div class="control">
					<input class="button  is-primary" type="submit" value="Entrar">
				</div>
				<div class="control">
					<input class="button is-light" type="reset" value="Cancelar">
				</div>
			</div>
		</form>
	</div>
	
 	<footer class="card-footer">
		 <p class="card-footer-item">
			 <span>
		 		<a class="has-text-primary" href="/javaweb/registro.jsp">Registrarse</a>
 			</span>
 		</p>
	</footer>
</div>