<form method="post" action="/javaweb/backoffice/action?operacion=1&clase=1&id=${ curso.id gt 0 ? curso.id : '-1'}" class="box">

	<a href="/javaweb/backoffice/cursos" class="button is-primary"><i class="fas fa-arrow-left"></i></a>

    <input type="text" name="id" value="${curso.id}" hidden>

    <div class="field is-horizontal">
        <div class="field-label">
            <label class="label" for="name">Nombre:</label>
        </div>
        <div class="field-body">
            <div class="field">
                <div class="control">
                    <input class="input" type="text" name="nombre" id="name" placeholder="Nombre"
                        value="${curso.nombre}" required>
                </div>
            </div>
        </div>
    </div>

    <div class="field is-horizontal">
    </div>

    <div class="field is-horizontal">
        <div class="field-label">
            <label class="label" for="codigoUc">C&oacute;digo UC:</label>
        </div>
        <div class="field-body">
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <textarea class="textarea" type="text" name="codigoUc" id="codigoUc"
                            placeholder="C&oacute;digo UC" required>${curso.codigoUc}</textarea>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="field is-horizontal">
        <div class="field-label">
            <label class="label" for="codigoAaff">C&oacute;digo AAFF:</label>
        </div>
        <div class="field-body">
            <div class="control">
                <div class="field">
                    <input class="input" type="text" name="codigoAaff" id="codigoAaff" placeholder="C&oacute;digo AAFF"
                        value="${curso.codigoAaff}" required>
                </div>
            </div>
            <div class="field-label">
                <label class="label" for="horasCurso">Horas:</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <input class="input" type="number" name="horasCurso" id="horasCurso" placeholder="Horas"
                            value="${curso.horasCurso}" required>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="field is-horizontal">
        <div class="field-label">
            <label class="label" for="cualificacion">Cualificaci&oacute;n:</label>
        </div>
        <div class="field-body">
            <div class="field">
                <div class="control">
                    <input class="input" type="text" name="cualificacion" id="cualificacion"
                        placeholder="Cualificaci&oacute;n" value="${curso.cualificacion}" required>
                </div>
            </div>
        </div>
    </div>

    <div class="field is-horizontal">
        <div class="field-label">
            <label for="competencia" class="label">Competencia:</label>
        </div>
        <div class="field-body">
            <div class="field">
                <div class="control">
                    <textarea name="competencia" id="competencia" class="textarea" placeholder="Competencia"
                        required>${curso.competencia}</textarea>
                </div>
            </div>
        </div>
    </div>

    <div class="field is-horizontal">
        <div class="field-body">
            <div class="field is-grouped">
                <div class="control">
                    <input class="button  is-primary" type="submit" value="${ curso.id gt 0 ? 'Modificar' : 'Insertar' }">
                </div>
                <div class="control">
                    <input class="button is-light" type="reset" value="Reset">
                </div>
            </div>
            <div class="field is-grouped is-grouped-right">
                <div class="control">

                    <!-- TODO pedir confirmacion -->
                    <a class="button is-danger" href="/javaweb/backoffice/action?operacion=3&clase=1&id=${curso.id}">Borrar</a>
                    
                </div>
            </div>
        </div>
    </div>

</form>