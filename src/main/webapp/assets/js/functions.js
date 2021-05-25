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

function checkPass(oInput) {
	let pass = document.getElementById("pass");
	if (pass.value != oInput.value) {
		oInput.setCustomValidity("Las contrase\u00f1as no coinciden");
	} else {
		oInput.setCustomValidity("");
	}
}

function openCtxMenu(event, id) {
	// evitamos lanzar el menu original
	event.preventDefault();

	// pintamos y colocamos el menu en la posicion del puntero
	let ctxMenu = document.getElementById("ctxMenu");
	ctxMenu.style.display = "block";
	ctxMenu.style.left = (event.pageX) + "px";
	ctxMenu.style.top = (event.pageY) + "px";

	let edit = document.getElementById("edit");
	let del = document.getElementById("del");

	// tomamos el valor tras la ultima / en la url
	let page = window.location.search;

	// asignamos los valores href a los botones
	if (page.toLowerCase().includes("clase=3")) {
		edit.href = "/javaweb/backoffice/action?operacion=2&clase=3&id=" + id;
		del.addEventListener("click", function(){abrirModal("modalDelete", 3, id)});
	} else if (page.toLowerCase().includes("clase=1")) {
		edit.href = "/javaweb/backoffice/action?operacion=2&clase=1&id=" + id;
		del.addEventListener("click", function(){abrirModal("modalDelete", 1, id)});
	}
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

// abrir ventana modal
function abrirModal(id) {
	let modal = document.getElementById(id);
	modal.classList.add("is-active");
}

// abrir ventana modal
function abrirModal(idModal, clase , idElemento) {
	let modal = document.getElementById(idModal);
	modal.classList.add("is-active");
	let button = modal.querySelector(".is-success")
	button.href = "/javaweb/backoffice/action?operacion=3&clase=" + clase + "&id=" + idElemento;
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
