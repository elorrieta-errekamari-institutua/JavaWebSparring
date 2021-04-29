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

// 1. Display filename when select file
// 2. Clear filename when form reset

document.addEventListener('DOMContentLoaded', () => {
  // 1. Display file name when select file
  let fileInputs = document.querySelectorAll('.file.has-name')
  for (let fileInput of fileInputs) {
    let input = fileInput.querySelector('.file-input')
    let name = fileInput.querySelector('.file-name')
    input.addEventListener('change', () => {
      let files = input.files
      if (files.length === 0) {
        name.innerText = 'No file selected'
      } else {
        name.innerText = files[0].name
      }
    })
  }

  // 2. Remove file name when form reset
  let forms = document.getElementsByTagName('form')
  for (let form of forms) {
    form.addEventListener('reset', () => {
      console.log('a')
      let names = form.querySelectorAll('.file-name')
      for (let name of names) {
        name.innerText = 'No file selected'
      }
    })
  }
})
