function changeName() {
	var input = document.querySelector('.file-input')
	var name = document.querySelector('.file-name')
	var files = input.files
	if (files.length === 0) {
		name.innerHTML = 'No hay documento'
	} else {
		name.innerHTML = files[0].name
	}
}

function resetName() {
	var name = document.querySelector('.file-name')
	name.innerHTML = 'No hay documento'
}