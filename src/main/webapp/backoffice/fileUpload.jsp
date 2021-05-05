<jsp:include page="/templates/header.jsp" />
<jsp:include page="/templates/loggedNavbar.jsp" />


<%
	// limpiar atributo de session ccon la lista de participantes
	session.removeAttribute("listaParticipantes");

%>

<div class="centralBox">

	<p class="has-text-success block" ${(insertados>0)? '' : 'hidden'}>Se han introducido ${insertados} registros</p>

	<form action="/javaweb/backoffice/importar" method="post" enctype="multipart/form-data" onreset="resetName()">
		<div class="field file has-name is-centered is-boxed ">
			<label class="file-label">
				<input class="file-input" type="file" name="file" onchange="changeName()">
				<span class="file-cta">
					<span class="file-icon">
						<i class="fas fa-upload"></i>
					</span>
					<span class="file-label">
						Subir archivo
					</span>
				</span>
				<span class="file-name">
					No hay documento
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

<script src="/javaweb/assets/js/fileUpload.js"></script>

<jsp:include page="/templates/footer.jsp" />