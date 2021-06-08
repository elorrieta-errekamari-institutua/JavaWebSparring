// Burger menu
document.addEventListener('DOMContentLoaded', () => {
	// Get all "navbar-burger" elements
	const $navbarBurgers = Array.prototype.slice.call(document.querySelectorAll('.navbar-burger'), 0);

	// Check if there are any navbar burgers
	if ($navbarBurgers.length > 0) {

		// Add a click event on each of them
		$navbarBurgers.forEach(el => {
			el.addEventListener('click', () => {

				// Get the target from the "data-target" attribute
				const target = el.dataset.target;
				const $target = document.getElementById(target);

				// Toggle the "is-active" class on both the "navbar-burger" and the "navbar-menu"
				el.classList.toggle('is-active');
				$target.classList.toggle('is-active');

			});
		});
	}

});

// Comprobar que las contraseñas son iguales
function checkPass(oInput) {
	let pass = document.getElementById("pass");
	if (pass.value != oInput.value) {
		oInput.setCustomValidity("Las contrase\u00f1as no coinciden");
	} else {
		oInput.setCustomValidity("");
	}
}

// Menu contextual
function openCtxMenu(event, clase, id) {
	// evitamos lanzar el menu original
	event.preventDefault();

	// pintamos y colocamos el menu en la posicion del puntero
	let ctxMenu = document.getElementById("ctxMenu");
	ctxMenu.style.display = "block";
	ctxMenu.style.left = (event.pageX) + "px";
	ctxMenu.style.top = (event.pageY) + "px";

	let edit = document.getElementById("edit");
	let del = document.getElementById("del");

	// asignamos los valores href a los botones
	edit.href = "/javaweb/backoffice/action?operacion=2&clase=" + clase + "&id=" + id;
	del.addEventListener("click", function () { abrirModalDelete(clase, id) });

}

function closeCtxMenu() {
	let ctxMenu = document.getElementById("ctxMenu");
	ctxMenu.style.display = "none";
}

// listener en el body que solo funcionara cuando exista un menu contextual
if (document.getElementById("ctxMenu")) {
	document.addEventListener("click", closeCtxMenu);
}

// validar extension de archivos
const _imgFileExtensions = [".jpg", ".jpeg", ".bmp", ".gif", ".png"];

function validateImg(input) {
	if (input.type == "file") {
		let FileName = input.value;
		if (FileName.length > 0) {
			let valid = false;
			for (let j = 0; j < _imgFileExtensions.length; j++) {
				let curExtension = _imgFileExtensions[j];
				if (FileName.substr(FileName.length - curExtension.length, curExtension.length).toLowerCase() == curExtension.toLowerCase()) {
					valid = true;
					break;
				}
			}
			if (!valid) {
				alert("Sorry, " + FileName + " is invalid, allowed extensions are: " + _imgFileExtensions.join(", "));
				input.value = "";
			}
		}
	}
	return valid;
}

// abrir ventana modal para confirmacion de eliminar
function abrirModalDelete(clase, id) {
	let modal = document.getElementById("modalDelete");
	modal.classList.add("is-active");
	let button = modal.querySelector(".is-success")
	button.href = "/javaweb/backoffice/action?operacion=3&clase=" + clase + "&id=" + id;
		let mensajeEdicion = document.getElementById("mensajeEdicion");
	if (clase == 8) {
		mensajeEdicion.innerHTML = " Eliminar la edicion no eliminara los datos del curso";
	} else {
		mensajeEdicion.innerHTML = "";
	}
}

// cerrar ventanas modales
if (document.querySelector(".modal")) {
	//seleccionamos las ventanas modales
	let modales = document.querySelectorAll(".modal");
	modales.forEach(function (modal) {
		// seleccionamos los hijos que queremos utilizar para cerrar la modal
		let children = modal.querySelectorAll(".modal-background, .modal-close, .is-danger");
		children.forEach(function (child) {
			child.addEventListener("click", function () {
				modal.classList.remove("is-active");
			});
		});
	});
}

// Autorrellenar nombres de aulas
aula0dummy.onkeyup = initializeOptions;
aula0dummy.addEventListener("change", function (event) {
	checkAula(event);
});
aula1dummy.onkeyup = initializeOptions;
aula1dummy.addEventListener("change", function (event) {
	checkAula(event);
});
aula2dummy.onkeyup = initializeOptions;
aula2dummy.addEventListener("change", function (event) {
	checkAula(event);
});
aula3dummy.onkeyup = initializeOptions;
aula3dummy.addEventListener("change", function (event) {
	checkAula(event);
});
aula4dummy.onkeyup = initializeOptions;
aula4dummy.addEventListener("change", function (event) {
	checkAula(event);
});

function initializeOptions() {
	// Recogemos los datos
	let text = this.value;
	if (text.length > 2) {
		let url = '//localhost:8080/javaweb/api/aulas?name=' + text;
		let element = document.getElementById(this.id);
		fetch(url).then(function (response) {
			if (response.ok) {
				return response.json();
			}
			throw response;
		}).then(function (data) {
			renderDatalist(data, element);
		}).catch(function (error) {
			console.warn(error);
		});
	}
}

/**
 * Create and render the datalist element
 * @param  {Array} data  The data to use for the list
 * @param element The element to append to
 */
function renderDatalist(data, element) {

	let datosAulas = document.getElementById('datosAulas');
	// Create the datalist element
	if (datosAulas == null) {
		datosAulas = document.createElement('datalist');
		datosAulas.id = 'datosAulas';
	}
	else {
		datosAulas.innerHTML = '';
	}
	element.setAttribute('list', datosAulas.id);

	// Create fragment for option elements
	let fragment = document.createDocumentFragment();

	// Create list options
	for (let aula of data) {
		let option = document.createElement('option');
		option.textContent = aula.nombre;
		option.setAttribute("data-value", aula.id);
		fragment.append(option);
	}

	// Add options to datalist
	datosAulas.append(fragment);

	// Inject into the DOM
	element.after(datosAulas);

}

function checkAula(event) {
	let element = event.target;
	let text = element.value;
	let url = '//localhost:8080/javaweb/api/aulas';
	fetch(url).then(function (response) {
		if (response.ok) {
			return response.json();
		}
		throw response;
	}).then(function (data) {
		checkDatalist(data, element);
	}).catch(function (error) {
		console.warn(error);
	});
}

function checkDatalist(data, element) {
	// booleno, 0 si no es correcto, 1 si lo es
	let name = element.id.substring(0, 5);
	let hiddenElement = document.getElementById(name);
	let correct = 0;
	if (element.value.length == 0) {
		correct = 1;
	} else {
		for (let aula of data) {
			if (aula.nombre == element.value) {
				correct = 1;
				hiddenElement.value = aula.id;
			}
		}
	}
	if (correct == 1) {

		element.setCustomValidity("");
	} else {
		element.setCustomValidity("Debe crear el aula antes de insertarla");
	}
}