package dataservices.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dataservices.conexao.Conexao;
import domain.Livro;

public class LivroDAO implements IDAO<Livro>{
	
	private Connection connection;
	private Conexao conexao;
	
	public LivroDAO() {
		conexao = new Conexao();
		connection = Conexao.abrirConexao();
	}

	//metodo para inserir no banco
	
	public void save(Livro livro) {
		// instrucao sql
		String sql = "INSERT INTO livro (autor, avaliacao, editora, isbn, paginas, titulo) VALUES(?,?,?,?,?,?)";
		PreparedStatement pstmt;
		
		try {
			pstmt = connection.prepareStatement(sql);
			// setar os parametros
			pstmt.setString(1, livro.getAutor());
			pstmt.setInt(2 , livro.getAvaliacao());
			pstmt.setString(3, livro.getEditora());
			pstmt.setString(4, livro.getIsbn());
			pstmt.setInt(5, livro.getPaginas());
			pstmt.setString(6, livro.getTitulo());
			pstmt.execute();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//metodo para  fazer  alteracoes no banco 
	
	@Override
	public void update(Livro livro) {
		
		try {
		
		String sql = "update livro set autor = ?, avaliacao = ?, editora = ?, isbn = ?, paginas = ?, titulo = ? WHERE id = ?";
		
		PreparedStatement pstmt;
		pstmt = connection.prepareStatement(sql);
		// setar os parametros
		pstmt.setString(1, livro.getAutor());
		pstmt.setInt(2, livro.getAvaliacao());
		pstmt.setString(3, livro.getEditora());
		pstmt.setString(4, livro.getIsbn());
		pstmt.setInt(5, livro.getPaginas());
		pstmt.setString(6, livro.getTitulo());
		pstmt.setLong(7, livro.getId());
		pstmt.execute();
		
		} catch(SQLException e) {
			e.printStackTrace();
	   }
	}
	
	//metodo para  selecionar livro pelo id

	@Override
	public Livro getLivro(long id) {
		Livro p = null;
		try {
			Statement sta = connection.createStatement();
			ResultSet elements = sta.executeQuery("select * from livro where id = " + id);
			while (elements.next()) {
				p = new Livro(elements.getLong("id"),
				        elements.getString("titulo"),
				        elements.getString("autor"),
				        elements.getInt("paginas"),
				        elements.getString("editora"),
				        elements.getString("isbn"),
				        elements.getInt("avaliacao"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
	
		return p;
	}

	//metodo para  fazer a listagem do banco
	
	@Override
	public List<Livro> list() {
		List<Livro> result = new ArrayList<Livro>();
		
		try {
			Statement sta = connection.createStatement();
			ResultSet elements = sta.executeQuery("SELECT * FROM livro");
			while (elements.next()) {
				Livro l = new Livro();
				l.setId(elements.getLong("id")); 
				l.setAutor(elements.getString("autor"));
				l.setAvaliacao(elements.getInt("avaliacao"));
				l.setEditora(elements.getString("editora"));
				l.setPaginas(elements.getInt("paginas"));
				l.setIsbn(elements.getString("isbn"));
				l.setTitulo(elements.getString("titulo"));
				result.add(l);
				
			}
			
			 elements.close();
			 sta.close();
			 
		}catch(SQLException ex) {
			ex.printStackTrace();
			
		}
		return result;
	}
	
	//metodo para  deletar dados do banco

	@Override
	public void remove(Livro livro) {
	      String sql = "delete from livro where id = ?";
	      PreparedStatement pstmt;
	      
	      try {
	    	  pstmt = connection.prepareStatement(sql);
	    	  pstmt.setLong(1, livro.getId());
	    	  pstmt.execute();
	    	  
	      }catch(SQLException e) {
	    	  e.printStackTrace();
	    	  
	      }
		
	}



}
