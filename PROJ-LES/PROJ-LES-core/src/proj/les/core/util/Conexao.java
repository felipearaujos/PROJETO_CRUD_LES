
package proj.les.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexao {	
	public static Connection getConnection() 
			throws ClassNotFoundException, 
		SQLException{
		/*String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/les";
		String user = "postgres";
		String password = "postgres";
		Class.forName( driver );
		Connection conn = DriverManager.getConnection( url, user, password);
		*/
		
		
		/*
		 * OBSERVAÇÕES
		 * Criar um banco de dados para esta aplicação
		 * Criar um usuário exclusivo para esta aplicação
		 */
		
		String driver = "com.mysql.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/sistemales";
		String user = "felipe";
		String password = "123";
		Class.forName( driver );
		Connection conn = 
				DriverManager.getConnection( url, user, password);		
		return conn;				
	}
}//Class
