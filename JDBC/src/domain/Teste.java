package domain;

import java.util.List;
import dataservices.dao.LivroDAO;

public class Teste {

	public static void main(String[] args) {
		
		//Insere livros no Banco de Dados
		
		Livro livro = new Livro(); 
		livro.setAutor("Mauricio Godinho Delgado");  livro.setPaginas(300);
		livro.setEditora("LTr");  livro.setAvaliação(5);
		livro.setIsbn("8536191058");  livro.setTitulo("Direito Coletivo do Trabalho");
		
		LivroDAO dao = new LivroDAO();
		dao.save(livro);
		
		Livro livro2 = new Livro(); 
		livro2.setAutor("Luke Dormehl");  livro2.setPaginas(300);
		livro2.setEditora("Alta books");  livro2.setAvaliação(5);
		livro2.setIsbn("857608824X");  livro2.setTitulo("A revolução Apple");
		dao.save(livro2);

		List<Livro> result = dao.list();
		
		//Lista os livros inseridos
		
		System.out.println("Registros do Banco de Dados - Tabela Livro\n");

		
		for (Livro l : result) {
			

			System.out.println("=====================================");
			System.out.println("ID: " + l.getId());
			System.out.println("Nome: " + l.getAutor());
			System.out.println("Avaliação: " + l.getAvaliacao());
			System.out.println("Editora: " + l.getEditora());
			System.out.println("ISBN: " + l.getIsbn());
			System.out.println("Páginas: " + l.getPaginas());
			System.out.println("Título: " + l.getTitulo());
		
			
		}


	}

}
