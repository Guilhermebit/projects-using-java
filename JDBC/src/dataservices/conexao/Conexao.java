package dataservices.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



	public class Conexao {
		
	private static Connection conexao;
	private final static String URL = "jdbc:mysql://localhost:3306/uniasselvi?useTimezone=true&serverTimezone=UTC";
	private final static String USER = "root"; private final static String PASSWORD = "root";
	private final static String TPCONEXAO = "com.mysql.cj.jdbc.Driver";
		

		public static Connection abrirConexao() {
			try {
				Class.forName(TPCONEXAO);
				conexao = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (ClassNotFoundException | SQLException ex) {
				ex.printStackTrace();
			}
			return conexao;
			
		}
		
		public void fecharConexao() {
			if(conexao != null) {
				try {
					conexao.close();
				}catch (SQLException e) {
					 e.printStackTrace();
				}
			}
		}

		public static Connection getConnection() {
			return conexao;
		}

	}

