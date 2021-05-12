var labelData = {
	placeholder: "Buscar participante",
	perPage: "Mostrar {select} participantes por pagina",
	noRows: "No hay participantes que mostrar",
	info: "Mostrado resultados entre {start} y {end} de {rows} participantes (Pagina {page} de {pages} paginass)"
};

var columnData = [{
	select: 5,
	type: "date",
	format: "DD/MM/YYYY"
}];
if ( document.getElementById('table') ) {  // !undefined
	console.debug('habilitamos plugin datatable');
	var dataTable = new simpleDatatables.DataTable("#table", {
		columns: columnData,
		labels: labelData,
		footer: true
	});
}else {
	console.debug('No hay #table');
}	
