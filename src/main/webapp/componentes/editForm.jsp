<form method="post" action="/javaweb/backoffice/insertForm" class="box">

	<input type="text" name="id" value="${participante.id}" hidden>

	<div class="field">
		<label class="label" for="name">Nombre:</label>
		<div class="control">
			<input class="input" type="text" name="nombreCompleto" id="name" placeholder="Nombre completo"
				value="${participante.nombreCompleto}">
		</div>
	</div>

	<div class="field">
		<label class="label" for="dni">DNI:</label>
		<div class="control">
			<input class="input" type="text" name="dni" id="dni" placeholder="DNI" value="${participante.dni}">
		</div>
	</div>

	<div class="field">
		<label class="label" for="phone">Tel&eacute;fono:</label>
		<div class="control">
			<input class="input" type="text" name="telefono" id="phone" placeholder="Telefono"
				value="${participante.telefono}">
		</div>
	</div>

	<div class="field">
		<label class="label" for="date">Fecha de nacimiento:</label>
		<div class="control">
			<input class="input" type="date" name="fechaDeNacimiento" id="date" placeholder="Fecha de nacimiento"
				value="${participante.fechaDeNacimiento}">
		</div>
	</div>

	<div class="field">
		<label class="label" for="address">Direcci&oacute;n:</label>
		<div class="control">
			<input class="input" type="text" name="direccion" id="address" placeholder="Direccion"
				value="${participante.direccion}">
		</div>
	</div>

	<div class="field">
		<label class="label" for="cp">C&oacute;digo postal:</label>
		<div class="control">
			<input class="input" type="text" name="codigoPostal" id="cp" placeholder="Codigo postal"
				value="${participante.codigoPostal}">
		</div>
	</div>

	<div class="field">
		<label class="label" for="town">Municipio:</label>
		<div class="control">
			<input class="input" type="text" name="municipio" id="town" placeholder="Municipio"
				value="${participante.municipio}">
		</div>
	</div>

	<div class="field">
		<label class="label" for="district">Provincia:</label>
		<div class="control">
			<input class="input" type="text" name="provincia" id="district" placeholder="Provincia"
				value="${participante.provincia}">
		</div>
	</div>

	<div class="field">
		<div class="control">
			<label class="checkbox " for="erte">Erte:
				<input type="checkbox" name="erte" id="erte" ${(participante.erte)? 'checked' : '' }> <!-- value? -->
			</label>
		</div>
	</div>

	<div class="field">
		<label class="label" for="labo">Situaci&oacute;n laboral:</label>
		<div class="control">
			<input class="input" type="text" name="situacionLaboral" id="labo" placeholder="Situacion laboral"
				value="${participante.situacionLaboral}">
		</div>
	</div>

	<div class="field">
		<label class="label" for="admin">Situaci&oacute;n administrativa:</label>
		<div class="control">
			<input class="input" type="text" name="situacionAdministrativa" id="admin"
				placeholder="Situacion administrativa" value="${participante.situacionAdministrativa}">
		</div>
	</div>

	<div class="field">
		<label class="label" for="titulacion">Titulaci&oacute;n:</label>
		<div class="control">
			<input class="input" type="text" name="titulacion" id="titulacion" placeholder="Titulacion"
				value="${participante.titulacion}">
		</div>
	</div>

	<div class="field is-horizontal">
		<div class="field-body">
			<div class="field is-grouped">
				<div class="control">
					<input class="button  is-primary" type="submit" value="Modificar">
				</div>
				<div class="control">
					<input class="button is-light" type="reset" value="Reset">
				</div>
			</div>
			<div class="field is-grouped is-grouped-right">
				<div class="control">
					<a class="button" href="/javaweb/backoffice/participantes.jsp">Cancelar</a>
				</div>
			</div>
		</div>
	</div>


</form>