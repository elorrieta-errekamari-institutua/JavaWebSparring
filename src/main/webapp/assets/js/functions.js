document.addEventListener('DOMContentLoaded', () => {
  // Get all "navbar-burger" elements
  const $navbarBurgers = Array.prototype.slice.call(document.querySelectorAll('.navbar-burger'), 0);

  // Check if there are any navbar burgers
  if ($navbarBurgers.length > 0) {

    // Add a click event on each of them
    $navbarBurgers.forEach( el => {
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

// inicializar las tablas
var labelData = {
		placeholder : "Buscar participante",
		perPage : "Mostrar {select} participantes por pagina",
		noRows : "No hay participantes que mostrar",
		info : "Mostrado resultados entre {start} y {end} de {rows} participantes (Pagina {page} de {pages} paginass)"
	};

var columnData = [ {
	select : 5,
	type : "date",
	format : "DD/MM/YYYY"
} ];

var dataTable = new DataTable("#table", {
	columns : columnData,
	labels: labelData
});
