<div class="card">
    <header class="card-header">
        <h1 class="card-header-title">Registro</h1>
    </header>
    <div class="card-content">
        <form method="post" action="/javaweb/registro" onreset="resetName()" onsubmit="return validateImg(avatar)">
			<p class="center has-text-danger">${errores}</p>
            <div class="field">
                <label class="label" for="name">Nombre de usuario:</label>
                <div class="control has-icons-left">
                    <input class="input" type="text" name="nombre" id="name" placeholder="Su nombre de usuario"
                        value="${nombre}" autofocus required>
                    <span class="icon is-small is-left">
                        <i class="fas fa-user"></i>
                    </span>
                    <p class="has-text-danger">${error_nombre}</p>
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
                    <p class="has-text-danger">${error_pass}</p>
                </div>
            </div>

            <div class="field">
                <label class="label" for="pass2">Repita la contrase&ntilde;a:</label>
                <div class="control has-icons-left">
                    <input class="input" type="password" name="pass2" id="pass2"
                        placeholder="Repita su contrase&ntilde;a" onchange="checkPass(this)" required>
                    <span class="icon is-small is-left">
                        <i class="fas fa-key"></i>
                    </span>
                </div>
            </div>

            <div class="field">
                <label class="label" for="mail">Email:</label>
                <div class="control has-icons-left">
                    <input class="input" type="email" name="email" id="mail" placeholder="Su email" required>
                    <span class="icon is-small is-left">
                        <i class="fas fa-envelope"></i>
                    </span>
                    <p class="has-text-danger">${error_email}</p>
                </div>
            </div>

            <div class="field">
                <label for="avatar" class="label">Foto:
                    <div class="file has-name is-fullwidth">
                        <label class="file-label">
                            <input type="file" class="file-input" name="avatar" id="avatar" accept=".jpg, .jpeg, .bmp, .gif, .png" onchange="changeName()">
                            <span class="file-cta">
                                <span class="file-icon">
                                    <i class="fas fa-upload"></i>
                                </span>
                                <span class="file-label">
                                    Seleccione un archivo
                                </span>
                            </span>
                            <span class="file-name">
                                No hay archivo
                            </span>
                        </label>
                    </div>
                </label>
            </div>

            <div class="field is-grouped is-grouped-centered">
                <div class="control">
                    <input class="button  is-primary" type="submit" value="Registrarse">
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
                <a class="has-text-primary" href="/javaweb/index.jsp">Iniciar sesion</a>
            </span>
        </p>
    </footer>
</div>