const nameInput = document.getElementById("nome");
const surnameInput = document.getElementById("sobrenome");
const spanName = document.querySelector("#span-validation-name");
const spanSurname = document.querySelector("#span-validation-surname");
const button = document.querySelector("#cadastrar-pessoa");

nameInput.addEventListener("input", ativarBotao);
surnameInput.addEventListener("input", ativarBotao);

function validarNome(name) {
	if (name.length < 4) {
		spanName.classList.remove("name-invisible");
		return true;
	} else if (name.length >= 4) {
		spanName.classList.add("name-invisible");
		return false;
	}

}

function validarSobrenome(surname) {
	if (surname.length < 4) {
		spanSurname.classList.remove("surname-invisible");
		return true;
	} else if (surname.length >= 4) {
		spanSurname.classList.add("surname-invisible");
		return false;
	}
}

function ativarBotao() {
	const name = nameInput.value;
	const surname = surnameInput.value;
	validarNome(name)
	validarSobrenome(surname);
	if (name.length >= 4 && surname.length >= 4) {
		button.disabled = false;
	} else {
		button.disabled = true;
	}
}
