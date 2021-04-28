<jsp:include page="templates/cabecera.jsp" />
<jsp:include page="templates/loggedNavbar.jsp" />

<div class="centralBox ">
	<form action="importar" method="post" enctype="multipart/form-data">
		<div class="field file is-centered is-boxed has-name">
			<label class="file-label">
				<input class="file-input" type="file" name="file">
				<span class="file-cta">
					<span class="file-icon">
						<i class="fas fa-upload"></i>
					</span>
					<span class="file-label">
						Subir archivo
					</span>
				</span>
				<span class="file-name">
					No hay documento <!-- Cambiar esto con javascript -->
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
<jsp:include page="templates/footer.jsp" />