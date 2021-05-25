<form method="post" action="/javaweb/backoffice/action?operacion=1&clase=4&id=${ aula.id gt 0 ? aula.id : '-1'}" class="box">

	<a href="/javaweb/backoffice/action?operacion=4&clase=4" class="button is-primary"><i class="fas fa-arrow-left"></i></a>

    <input type="text" name="id" value="${aula.id}" hidden>

    <div class="field is-horizontal">
        <div class="field-label">
            <label class="label" for="name">Nombre:</label>
        </div>
        <div class="field-body">
            <div class="field">
                <div class="control">
                    <input class="input" type="text" name="nombre" id="name" placeholder="Nombre"
                        value="${aula.nombre}" required>
                </div>
            </div>
        </div>
    </div>

    <div class="field is-horizontal">
        <div class="field-body">
            <div class="field is-grouped">
                <div class="control">
                    <input class="button  is-primary" type="submit" value="${ aula.id gt 0 ? 'Modificar' : 'Insertar' }">
                </div>
                <div class="control">
                    <input class="button is-light" type="reset" value="Reset">
                </div>
            </div>
            <div class="field is-grouped is-grouped-right">
                <div class="control">
					<a onclick="abrirModalDelete(4, ${aula.id})" class="button is-danger">Borrar</a>
                </div>
            </div>
        </div>
    </div>

</form>