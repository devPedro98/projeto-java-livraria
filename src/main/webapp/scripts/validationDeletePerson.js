function validation(id) {
	let answer = confirm("Você deseja apagar o leitor?");
	if (answer === true) {
		window.location.href = "deleteperson?id=" + id;
	}
}