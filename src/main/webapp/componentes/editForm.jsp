<form method="post" action="/javaweb/backoffice/detalle">

	<div class="field">
		<label class="label has-text-light" for="name">Nombre:</label>
		<div class="control">
			<input class="input" type="text" name="nombreCompleto" id="name" placeholder="Nombre completo" value="${participante.nombreCompleto}">
		</div>
	</div>
	
	<div class="field">
		<label class="label has-text-light" for="dni">DNI:</label>
		<div class="control">
			<input class="input" type="text" name="dni" id="dni" placeholder="DNI" value="${participante.dni}">
		</div>
	</div>
	
	<div class="field">
		<label class="label has-text-light" for="phone">Tel&eacute;fono:</label>
		<div class="control">
			<input class="input" type="text" name="telefono" id="phone" placeholder="Telefono" value="${participante.telefono}">
		</div>
	</div>

	<div class="field">
		<label class="label has-text-light" for="date">Fecha de nacimiento:</label>
		<div class="control">
			<input class="input" type="date" name="fechaDeNacimiento" id="date" placeholder="Fecha de nacimiento" value="${participante.fechaDeNacimiento}">
		</div>
	</div>
	
	<div class="field">
		<label class="label has-text-light" for="address">Direcci&oacute;n:</label>
		<div class="control">
			<input class="input" type="text" name="direccion" id="address" placeholder="Direccion" value="${participante.direccion}">
		</div>
	</div>
	
	<div class="field">
		<label class="label has-text-light" for="cp">C&oacute;digo postal:</label>
		<div class="control">
			<input class="input" type="text" name="codigoPostal" id="cp" placeholder="Codigo postal" value="${participante.codigoPostal}">
		</div>
	</div>
	
	<div class="field">
		<label class="label has-text-light" for="town">Municipio:</label>
		<div class="control">
			<input class="input" type="text" name="municipio" id="town" placeholder="Municipio" value="${participante.municipio}">
		</div>
	</div>
	
	<div class="field">
		<label class="label has-text-light" for="district">Provincia:</label>
		<div class="control">
			<input class="input" type="text" name="provincia" id="district" placeholder="Provincia" value="${participante.provincia}">
		</div>
	</div>
	
	<div class="field">
		<div class="control">
			<label class="label has-text-light" for="erte">Erte:
				<input class="input" type="checkbox" name="erte" id="erte"  value="${participante.erte}">
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

<!--
	private boolean erte;
	private String situacionLaboral;
	private String situacionAdministrativa;
	private String titulacion; -->