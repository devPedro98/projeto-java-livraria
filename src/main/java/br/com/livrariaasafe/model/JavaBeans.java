package br.com.livrariaasafe.model;

public class JavaBeans {
	private String idBook;
	private String bookName;
	private String bookAuthor;
	private String bookCategory;

	public JavaBeans() {
		super();
	}

	public JavaBeans(String id, String name, String author, String category) {
		super();
		this.idBook = id;
		this.bookName = name;
		this.bookAuthor = author;
		this.bookCategory = category;
	}

	public String getName() {
		return bookName;
	}

	public String getId() {
		return idBook;
	}

	public void setId(String id) {
		this.idBook = id;
	}

	public void setName(String name) {
		this.bookName = name;
	}

	public String getAuthor() {
		return bookAuthor;
	}

	public void setAuthor(String author) {
		this.bookAuthor = author;
	}

	public String getCategory() {
		return bookCategory;
	}

	public void setCategory(String category) {
		this.bookCategory = category;
	}

}
