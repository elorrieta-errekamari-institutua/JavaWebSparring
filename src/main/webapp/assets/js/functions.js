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
	var pass = document.getElementById("pass");
	if (pass.value != oInput.value) {
		oInput.setCustomValidity("Las contrase\u00f1as no coinciden");
	} else {
		oInput.setCustomValidity("");
	}
}

function openCtxMenu(event, id) {
	event.preventDefault();
	var ctxMenu = document.getElementById("ctxMenu");
	ctxMenu.style.display = "block";
	ctxMenu.style.left = (event.pageX) + "px";
	ctxMenu.style.top = (event.pageY) + "px";
	var edit = document.getElementById("edit");
	edit.href = "/javaweb/backoffice/insertParticipanteForm?id=" + id;
	var del = document.getElementById("del");
	del.href = "/javaweb/backoffice/borrarParticipante?id=" + id;
}
