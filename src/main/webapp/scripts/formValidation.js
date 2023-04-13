const form = document.querySelector("#add-book");
const spans = document.querySelectorAll(".span-off");
const fieldsName = document.querySelectorAll(".form-add-book");
const nameInput = document.querySelector("#book-name");
const authorInput = document.querySelector("#book-author");
const categoryInput = document.querySelector("#book-category");
const submitForm = document.querySelector("#button-cadastrar");

nameInput.addEventListener("input", buttonValidate);
categoryInput.addEventListener("input", buttonValidate);
authorInput.addEventListener("input", buttonValidate);

function setError(index) {
	spans[index].classList.add("span-required");
	fieldsName[index].classList.add("border-error");
}

function removeError(index) {
	spans[index].classList.remove("span-required");
	fieldsName[index].classList.remove("border-error");
}

function buttonValidate() {
	const valueNameInput = nameInput.value;
	const valueCategoryInput = categoryInput.value;
	const valueAuthorInput = authorInput.value;

	if (valueNameInput.length > 4 && valueCategoryInput.length > 4 && valueAuthorInput.length > 4) {
		submitForm.disabled = false;
	} else {
		submitForm.disabled = true;
	}

}

function nameValidate() {
	if (fieldsName[0].value.length <= 4) {
		setError(0);
	} else {
		removeError(0);
	}
}

function authorValidate() {
	if (fieldsName[1].value.length <= 4) {
		setError(1);
	} else {
		removeError(1);
	}
}

function categoryValidate() {
	if (fieldsName[2].value.length <= 4) {
		setError(2);
	} else {
		removeError(2);
	}
}
