// if (sessionStorage.getItem("listaParticipantes")) {
// 	var labelData = {
// 		placeholder: "Buscar participante",
// 		perPage: "Mostrar {select} participantes por pagina",
// 		noRows: "No hay participantes que mostrar",
// 		info: "Mostrado resultados entre {start} y {end} de {rows} participantes (Pagina {page} de {pages} paginass)"
// 	};
// } else if (sessionStorage.getItem("listaCursos")) {
// 	var labelData = {
// 		placeholder: "Buscar curso",
// 		perPage: "Mostrar {select} cursos por pagina",
// 		noRows: "No hay cursos que mostrar",
// 		info: "Mostrado resultados entre {start} y {end} de {rows} cursos (Pagina {page} de {pages} paginass)"
// 	};
// }

var labelData = {
		placeholder: "Buscar",
		perPage: "Mostrar {select} resultados por pagina",
		noRows: "No hay resultados que mostrar",
		info: "Mostrado resultados entre {start} y {end} de {rows} resultados (Pagina {page} de {pages} paginass)"
	};

var columnData = [{
	select: 5,
	type: "date",
	format: "dd/MM/yyyy"
}];

if (document.getElementById('table')) {  // !undefined
	console.debug('habilitamos plugin datatable');
	var dataTable = new simpleDatatables.DataTable("#table", {
		columns: columnData,
		labels: labelData,
		footer: true
	});
} else {
	console.debug('No hay #table');
}
