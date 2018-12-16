package domain;


public class Livro {
	
	private long id;
	private String titulo;
	private String autor;
	private int paginas;
	private String editora;
	private String isbn;
	private int avaliacao;
	
	public Livro() {}
	
	public Livro(long id, String titulo, String autor, int paginas, String editora, String isbn, int avaliacao) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
		this.editora = editora;
		this.isbn = isbn;
		this.avaliacao = avaliacao;
		
	}
	

	public long getId() {
		
		return id;
	}


	public String getAutor() {
	
		return autor;
	}

	public int getAvaliacao() {
	
		return avaliacao;
	}

	public String getEditora() {
	
		return editora;
	}

	public String getIsbn() {

		return isbn;
	}

	public int getPaginas() {
		return paginas;
	}

	public String getTitulo() {
		return titulo;
	}


	public void setAutor(String autor) {
		
		this.autor = autor;
	}

	public void setPaginas(int paginas) {
		
		this.paginas = paginas;
	}

	public void setAvaliação(int avaliacao) {
		
		this.avaliacao = avaliacao;
	}

	public void setEditora(String editora) {
		
		this.editora = editora;
	}

	public void setIsbn(String isbn) {
		
		this.isbn = isbn;
	}

	public void setTitulo(String titulo) {
		
		this.titulo = titulo;
		
	}

	public void setAvaliacao(int avaliacao) {
		
		this.avaliacao = avaliacao;
		
	}

	public void setId(int int1) {
		
		
	}

	public void setId(long id) {
		this.id = id;
	}

}
