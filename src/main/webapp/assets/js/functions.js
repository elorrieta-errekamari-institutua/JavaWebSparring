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

// agregar un input de aula en el formulario de ediciones
var aulaIndex = 50;

function agregarAula() {
	let contenedor = document.getElementById("aulasExtra");
	contenedor.innerHTML += "<div class='field is-horizontal'><div class='field-label'></div><div class='field-body'><div class='field'><div class='control'><input type='text' class='input' name='aula" + aulaIndex + "' placeholder='Aula'></div></div></div></div>";
	aulaIndex ++;
}
