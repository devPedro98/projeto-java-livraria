function validation(id) {
	let answer = confirm("Você deseja apagar o livro?");
	if (answer === true) {
		window.location.href = "deleteBook?id=" + id;
	}
}