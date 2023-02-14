const form = document.querySelector("#add-book");
const spans = document.querySelectorAll(".span-off");
const fieldsName = document.querySelectorAll(".form-add-book");


function setError(index) {
	spans[index].classList.add("span-required");
	fieldsName[index].classList.add("border-error");
}

function removeError(index) {
	spans[index].classList.remove("span-required");
	fieldsName[index].classList.remove("border-error");
}

function nameValidate() {
	if (fieldsName[0].value.length <= 8) {
		setError(0);
	} else {
		removeError(0);
	}
}

function authorValidate() {
	if (fieldsName[1].value.length <= 8) {
		setError(1);
	} else {
		removeError(1);
	}
}

function categoryValidate() {
	if (fieldsName[2].value.length <= 5) {
		setError(2);
	} else {
		removeError(2);
	}
}