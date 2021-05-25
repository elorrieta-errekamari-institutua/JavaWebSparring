<form method="post" action="/javaweb/backoffice/action?operacion=1&clase=3&id=${ participante.id gt 0 ? participante.id : '-1'}" class="box">

	<a href="/javaweb/backoffice/action?operacion=4&clase=3" class="button is-primary"><i class="fas fa-arrow-left"></i></a>

	<input type="text" name="id" value="${participante.id}" hidden>

	<div class="field is-horizontal">
		<div class="field-label">
			<label class="label" for="name">Nombre:</label>
		</div>
		<div class="field-body">
			<div class="field">
				<div class="control">
					<input class="input" type="text" name="nombreCompleto" id="name" placeholder="Nombre completo"
						value="${participante.nombreCompleto}" required>
				</div>
			</div>
		</div>
	</div>

	<div class="field is-horizontal">
		<div class="field-label">
			<label class="label" for="dni">DNI:</label>
		</div>
		<div class="field-body">
			<div class="field">
				<div class="control">
					<input class="input" type="text" name="dni" id="dni" placeholder="DNI" value="${participante.dni}"
						required>
				</div>
			</div>
		</div>
	</div>

	<div class="field is-horizontal">
		<div class="field-label">
			<label class="label" for="phone">Tel&eacute;fono:</label>
		</div>
		<div class="field-body">
			<div class="field">
				<div class="control">
					<input class="input" type="text" name="telefono" id="phone" placeholder="Telefono"
						value="${participante.telefono}" required>
				</div>
			</div>
			<div class="field-label">
				<label class="label" for="date">Fecha de nacimiento:</label>
			</div>
			<div class="field-body">
				<div class="control">
					<div class="field">
						<input class="input" type="date" name="fechaDeNacimiento" id="date"
							placeholder="Fecha de nacimiento" value="${participante.fechaDeNacimiento}" required>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="field is-horizontal">
		<div class="field-label">
			<label class="label" for="address">Direcci&oacute;n:</label>
		</div>
		<div class="field-body">
			<div class="field">
				<div class="control">
					<input class="input" type="text" name="direccion" id="address" placeholder="Direccion"
						value="${participante.direccion}" required>
				</div>
			</div>
		</div>
	</div>


	<div class="field is-horizontal">
		<div class="field-label">
			<label class="label" for="town">Municipio:</label>
		</div>
		<div class="field-body">
			<div class="field">
				<div class="control">
					<input class="input" type="text" name="municipio" id="town" placeholder="Municipio"
						value="${participante.municipio}" required>
				</div>
			</div>
			<div class="field-label">
				<label class="label" for="cp">C&oacute;digo postal:</label>
			</div>
			<div class="field-body">
				<div class="field">
					<div class="control">
						<input class="input" type="text" name="codigoPostal" id="cp" placeholder="Codigo postal"
							value="${participante.codigoPostal}" required>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="field is-horizontal">
		<div class="field-label">
			<label class="label" for="district">Provincia:</label>
		</div>
		<div class="field-body">
			<div class="field">
				<div class="control">
					<input class="input" type="text" name="provincia" id="district" placeholder="Provincia"
						value="${participante.provincia}" required>
				</div>
			</div>
		</div>
	</div>


	<div class="field is-horizontal">
		<div class="field-label">
			<label class="label" for="labo">Situaci&oacute;n laboral:</label>
		</div>
		<div class="field-body">
			<div class="field">
				<div class="control">
					<div class="select">
						<select name="situacionLaboral" id="labo" required>
							<option value="">Seleccione una</option>
							<option value="Desempleado" ${participante.situacionLaboral eq 'Desempleado' ? 'selected'
								: '' }>Desempleado</option>
							<option value="En activo" ${participante.situacionLaboral eq 'En activo' ? 'selected' :''}>En
								activo</option>
						</select>
					</div>
				</div>
			</div>
			<div class="field-label">
				<label class="label" for="admin">Situaci&oacute;n administrativa:</label>
			</div>
			<div class="field-body">
				<div class="field">
					<div class="control">
						<div class="select">
							<select name="situacionAdministrativa" id="admin" required>
								<option value="">Seleccione una</option>
								<option value="Alta" ${ participante.situacionAdministrativa eq 'Alta' ? 'selected' : '' }>
									Alta</option>
								<option value="Baja" ${ participante.situacionAdministrativa eq 'Baja' ? 'selected' : '' }>
									Baja</option>
							</select>
						</div>
					</div>
				</div>
			</div>
			<div class="field-label">
				<div class="control">
					<label class="label" for="erte">Erte:
						<input type="checkbox" name="erte" id="erte" ${ participante.erte ? 'checked' : '' }>
					</label>
				</div>
			</div>
		</div>
	</div>

	<div class="field is-horizontal">
		<div class="field-label">
			<label class="label" for="titulacion">Titulaci&oacute;n:</label>
		</div>
		<div class="field-body">
			<div class="field">
				<div class="control">
					<input class="input" type="text" name="titulacion" id="titulacion" placeholder="Titulacion"
						value="${participante.titulacion}" required>
				</div>
			</div>
		</div>
	</div>

	<div class="field is-horizontal">
		<div class="field-body">
			<div class="field is-grouped">
				<div class="control">
					<input class="button  is-primary" type="submit"
						value="${ participante.id gt 0 ? 'Modificar' : 'Insertar'}">
				</div>
				<div class="control">
					<input class="button is-light" type="reset" value="Reset">
				</div>
			</div>
			<div class="field is-grouped is-grouped-right">
				<div class="control">
					<a onclick="abrirModalDelete(3, ${participante.id})" class="button is-danger">Borrar</a>
				</div>
			</div>
		</div>
	</div>

</form>