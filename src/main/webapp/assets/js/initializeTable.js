var labelData = {
		placeholder: "Buscar",
		perPage: "Mostrar {select} resultados por pagina",
		noRows: "No hay resultados que mostrar",
		info: "Mostrado resultados entre {start} y {end} de {rows} resultados (Pagina {page} de {pages} paginass)"
	};

if (document.getElementById('table')) {  // !undefined
	console.debug('habilitamos plugin datatable');
	var dataTable = new simpleDatatables.DataTable("#table", {
		labels: labelData,
		footer: true
	});
} else {
	console.debug('No hay #table');
}
