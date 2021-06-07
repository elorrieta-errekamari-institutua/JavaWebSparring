<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <form method="post"
        action="/javaweb/backoffice/action?operacion=1&clase=8&id=${ edicion.id gt 0 ? edicion.id : '-1'}" class="box">

        <a href="/javaweb/backoffice/action?operacion=4&clase=8" class="button is-primary block"><i
                class="fas fa-arrow-left"></i></a>

        <input type="text" name="idEdicion" value="${edicion.id}" hidden>
        <input type="text" name="idCurso" value="${edicion.curso.id}" hidden>
        <input type="text" name="idHorario" value="${edicion.horario.id}" hidden>

        <div class="field is-horizontal">
            <div class="field-label">
                <label class="label" for="codigoLanbide">Codigo Lanbide:</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <input class="input" type="text" name="codigoLanbide" id="codigoLanbide"
                            placeholder="Codigo Lanbide" value="${edicion.codigoLanbide}" required>
                    </div>
                </div>

                <div class="field-label">
                    <label class="label" for="codigoAaff">C&oacute;digo AAFF:</label>
                </div>
                <div class="field">
                    <div class="control">
                        <input class="input" type="text" name="codigoAaff" id="codigoAaff"
                            placeholder="C&oacute;digo AAFF" value="${edicion.curso.codigoAaff}" required>
                    </div>
                </div>
            </div>
        </div>

        <div class="field is-horizontal">
            <div class="field-label">
                <label class="label" for="name">Nombre:</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <input class="input" type="text" name="nombre" id="name" placeholder="Nombre"
                            value="${edicion.curso.nombre}" required>
                    </div>
                </div>
            </div>
        </div>

        <div class="field is-horizontal">
            <div class="field-label">
                <label class="label" for="codigoUc">C&oacute;digo UC:</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <textarea class="textarea" type="text" name="codigoUc" id="codigoUc"
                            placeholder="C&oacute;digo UC" rows="1" required>${edicion.curso.codigoUc}</textarea>
                    </div>
                </div>
            </div>
        </div>

        <div class="field is-horizontal">
            <div class="field-label">
                <label class="label" for="fechaInicio">Fecha de inicio:</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <input class="input" type="date" name="fechaInicio" id="fechaInicio"
                            value="${edicion.fechaInicio}" required>
                    </div>
                </div>
                <div class="field-label">
                    <label class="label" for="fechaFin">Fecha de fin:</label>
                </div>
                <div class="field">
                    <div class="control">
                        <input class="input" type="date" name="fechaFin" id="fechaFin" value="${edicion.fechaFin}"
                            required>
                    </div>
                </div>
            </div>
        </div>

        <div class="field is-horizontal">
            <div class="field-label">
                <label class="label" for="lunesInicio">Lunes:</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <input type="time" class="input" name="lunesInicio" id="lunesInicio"
                            value="${edicion.horario.lunesInicio}">
                    </div>
                </div>
                <div class="field">
                    <div class="control">
                        <input type="time" class="input" name="lunesFin" value="${edicion.horario.lunesFin}">
                    </div>
                </div>
                <div class="field-label">
                    <label class="label" for="martesInicio">Martes:</label>
                </div>
                <div class="field">
                    <div class="control">
                        <input type="time" class="input" name="martesInicio" id="martesInicio"
                            value="${edicion.horario.martesInicio}">
                    </div>
                </div>
                <div class="field">
                    <div class="control">
                        <input type="time" class="input" name="martesFin" value="${edicion.horario.martesFin}">
                    </div>
                </div>
            </div>
        </div>

        <div class="field is-horizontal">
            <div class="field-label">
                <label class="label" for="miercolesInicio">Miercoles:</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <input type="time" class="input" name="miercolesInicio" id="miercolesInicio"
                            value="${edicion.horario.miercolesInicio}">
                    </div>
                </div>
                <div class="field">
                    <div class="control">
                        <input type="time" class="input" name="miercolesFin" id="miercolesFin"
                            value="${edicion.horario.miercolesFin}">
                    </div>
                </div>
                <div class="field-label">
                    <label class="label" for="juevesInicio">Jueves:</label>
                </div>
                <div class="field">
                    <div class="control">
                        <input type="time" class="input" name="juevesInicio" id="juevesInicio"
                            value="${edicion.horario.juevesInicio}">
                    </div>
                </div>
                <div class="field">
                    <div class="control">
                        <input type="time" class="input" name="juevesFin" id="juevesFin"
                            value="${edicion.horario.juevesFin}">
                    </div>
                </div>
            </div>
        </div>

        <div class="field is-horizontal">
            <div class="field-label">
                <label class="label" for="viernesInicio">Viernes:</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <input type="time" class="input" name="viernesInicio" id="viernesInicio"
                            value="${edicion.horario.viernesInicio}">
                    </div>
                </div>
                <div class="field">
                    <div class="control">
                        <input type="time" class="input" name="viernesFin" value="${edicion.horario.viernesFin}">
                    </div>
                </div>
                <div class="field-label">
                    <label class="label" for="horasCurso">Horas:</label>
                </div>
                <div class="field">
                    <div class="control">
                        <input class="input" type="number" name="horasCurso" id="horasCurso" placeholder="Horas"
                            value="${edicion.curso.horasCurso}" required>
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
                            placeholder="Cualificaci&oacute;n" value="${edicion.curso.cualificacion}" required>
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
                            rows="1" required>${edicion.curso.competencia}</textarea>
                    </div>
                </div>
            </div>
        </div>

        <div class="field is-horizontal">
            <div class="field-label">
                <label class="label">Aulas:</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <input type="text" class="input" name="aula0dummy" id="aula0dummy" placeholder="Aula">
                        <input type="number" name="aula0" id="aula0" hidden>
                    </div>
                </div>
            </div>
        </div>

        <div class="field is-horizontal">
            <div class="field-label"></div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <input type="text" class="input" name="aula1dummy" id="aula1dummy" placeholder="Aula">
                        <input type="number" name="aula1" id="aula1" hidden>
                    </div>
                </div>
            </div>
        </div>

        <div class="field is-horizontal">
            <div class="field-label"></div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <input type="text" class="input" name="aula2dummy" id="aula2dummy" placeholder="Aula">
                        <input type="number" name="aula2" id="aula2" hidden>
                    </div>
                </div>
            </div>
        </div>

        <div class="field is-horizontal">
            <div class="field-label"></div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <input type="text" class="input" name="aula3dummy" id="aula3dummy" placeholder="Aula">
                        <input type="number" name="aula3" id="aula3" hidden>
                    </div>
                </div>
            </div>
        </div>

        <div class="field is-horizontal">
            <div class="field-label"></div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <input type="text" class="input" name="aula4dummy" id="aula4dummy" placeholder="Aula">
                        <input type="number" name="aula4" id="aula4" hidden>
                    </div>
                </div>
            </div>
        </div>

        <!-- <div id="aulasExtra" class="field">

            <c:forEach var="aula" items="${edicion.aulas}" varStatus="index">
                <div class="field is-horizontal">
                    <div class="field-label"></div>
                    <div class="field-body">
                        <div class="field">
                            <div class="control">
                                <input type="text" class="input" name="aula${index.count}" id="aula${index.count}"
                                    value="${aula.nombre}" placeholder="Aula">
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div> -->

        <div class="field is-horizontal">
            <div class="field-body">
                <div class="field is-grouped">
                    <div class="control">
                        <input class="button is-primary" type="submit"
                            value="${ edicion.id gt 0 ? 'Modificar' : 'Insertar' }">
                    </div>
                    <div class="control">
                        <input class="button is-light" type="reset" value="Reset">
                    </div>
                </div>
                <div class="field is-grouped is-grouped-right">
                    <div class="control">
                        <a onclick="abrirModalDelete(8, ${edicion.id})" class="button is-danger">Borrar</a>
                    </div>
                </div>
            </div>
        </div>

    </form>