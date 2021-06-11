<div class="card">
	<header class="card-header">
		<h1 class="card-header-title">Inicio de sesion</h1>
	</header>
	<div class="card-content">
		<form method="post" action="/javaweb/login">
			<div class="field">
				<label class="label" for="name">Nombre de usuario:</label>
				<div class="control has-icons-left">
					<input class="input" type="text" name="nombre" id="name" placeholder="Su nombre de usuario"
						value="${nombre}" autofocus required>
					<span class="icon is-small is-left">
						<i class="fas fa-user"></i>
					</span>
				</div>
			</div>

			<div class="field">
				<label class="label" for="pass">Contrase&ntilde;a:</label>
				<div class="control has-icons-left">
					<input class="input" type="password" name="pass" id="pass" placeholder="Su contrase&ntilde;a"
						required>
					<span class="icon is-small is-left">
						<i class="fas fa-key"></i>
					</span>
				</div>
			</div>

			<div class="field">
				<div class="control">
					<label for="keep" class="checkbox">
						<input type="checkbox" name="keep" id="keep">
						Mantener sesion iniciada
					</label>
				</div>
			</div>

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