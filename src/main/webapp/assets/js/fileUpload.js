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
/*
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
*/