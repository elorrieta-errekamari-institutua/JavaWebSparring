<jsp:include page="/templates/header.jsp" />
<jsp:include page="/templates/loggedNavbar.jsp" />


<% // limpiar atributo de session ccon la lista de participantes session.removeAttribute("listaParticipantes"); %>

	<div class="content">

		<h1 class="center">Importar Ficheros</h1>

		<div class="centralBox">

			<form class="box" action="/javaweb/backoffice/importar" method="post" enctype="multipart/form-data"
				onreset="resetName()">
				<p class="has-text-success block" ${(insertados>0)? '' : 'hidden'}>Se han introducido ${insertados}
					registros</p>
				<div class="field">
					<label for="type" class="label">Tipo de documento:</label>
					<div class="control">
						<div class="select">
							<select name="fileType" id="type" required>
								<option value="" active>Seleccione uno</option>
								<option value="cursos">Cursos</option>
								<option value="participantes">Participantes</option>
							</select>
						</div>
					</div>
				</div>
				<div class="field file has-name is-boxed ">
					<label class="file-label">
						<input class="file-input" type="file" name="file" accept=".xls, .xlsx" onchange="changeName()" required>
						<span class="file-cta">
							<span class="file-icon">
								<i class="fas fa-upload"></i>
							</span>
							<span class="file-label">
								Subir archivo
							</span>
						</span>
						<span class="file-name">
							No hay archivo
						</span>
					</label>
				</div>

				<div class="field is-grouped is-grouped-centered">
					<div class="control">
						<input class="button  is-primary" type="submit" value="Subir">
					</div>
					<div class="control">
						<input class="button is-light" type="reset" value="Cancelar">
					</div>
				</div>
			</form>
		</div>
	</div>


	<jsp:include page="/templates/footer.jsp" />