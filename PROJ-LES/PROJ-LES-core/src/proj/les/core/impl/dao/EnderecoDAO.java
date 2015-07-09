
package proj.les.core.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;









import proj.les.dominio.Aluno;
import proj.les.dominio.Curso;
import proj.les.dominio.Endereco;
import proj.les.dominio.EntidadeDominio;


public class EnderecoDAO extends AbstractJdbcDAO {

	protected EnderecoDAO(String table, String idTable) {
		super("tab_endereco", "id_endereco");	
	}
	
	public EnderecoDAO(Connection cx){
		super(cx, "tab_endereco", "id_endereco");
	}
	
	public EnderecoDAO(){
		super("tab_endereco", "id");			
	}
	
	public void salvar(EntidadeDominio entidade) {
		if(connection == null){
			openConnection();
		}
		PreparedStatement pst=null;
		Endereco end = (Endereco)entidade;
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO tab_endereco(rua, ");
		sql.append("cidade, estado, cep, numero, bairro, dt_cadastro) ");
		sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?)");	
		
		
		
		
		
		
		try {
			connection.setAutoCommit(false);
			
					
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, end.getRua());
			pst.setString(2, end.getCidade());
			pst.setString(3, end.getEstado());
			pst.setString(4, end.getCep());	
			pst.setString(5, end.getNumero());	
			pst.setString(6, end.getBairro());
			pst.setString(7, null);	
			pst.execute();//pst.executeUpdate(); ????
					
			ResultSet rs = pst.getGeneratedKeys();
			
			int idEnd=0;
			if(rs.next())
				idEnd = rs.getInt(1);
			end.setId(idEnd);
			
			connection.commit();					
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}//catch
			e.printStackTrace();	
		}finally{
			if(ctrlTransaction){
				try {
					pst.close();
					if(ctrlTransaction)
						connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//catch
			}//if
		}//F
	}//Class
		
	
	
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		if(connection == null){
			openConnection();
		}
		Endereco objEndereco = new Endereco();
		//if(entidade instanceof Aluno){
			objEndereco.setId(((Endereco)entidade).getId());			
		//}
		PreparedStatement pst = null;
	
		String sql = 
				"SELECT id_endereco,rua, cidade, estado, cep, numero, bairro, dt_cadastro "
				+ "FROM tab_endereco WHERE id_endereco = '"+ objEndereco.getId() +"'";    
		 
		try {
			connection.setAutoCommit(false);
										     
	         pst = (PreparedStatement) connection.prepareStatement(sql);    	  	             
	         ResultSet rs = pst.executeQuery(); 
	         List<EntidadeDominio> enderecos = new ArrayList<EntidadeDominio>();
	         
	        while (rs.next())  
			{
	        	objEndereco.setId(objEndereco.getId());
	        	objEndereco.setRua(rs.getString("rua"));
	        	objEndereco.setCidade(rs.getString("cidade"));
	        	objEndereco.setEstado(rs.getString("estado"));
	        	objEndereco.setCep(rs.getString("cep"));
	        	objEndereco.setNumero(rs.getString("numero"));
	        	objEndereco.setBairro(rs.getString("bairro"));
	        	//objEndereco.setDtCadastro(rs.getString("dt_cadastro"));
	        //	objEndereco.setDtCadastro(null);
	        	
	        	enderecos.add(objEndereco);
	        }
			return enderecos;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		  
		}//metodo
	
	
	
	@Override
	public void alterar(EntidadeDominio entidade) {
		if(connection == null){
			openConnection();
		}
		
		Endereco objEndereco = new Endereco();
		objEndereco = (Endereco)entidade;		
		objEndereco.setId(((Endereco)entidade).getId());
		
		
		PreparedStatement pst = null;
		
		//objAluno = (Aluno)consultar(entidade);
		
		String sql = "UPDATE tab_endereco "
				   + "SET "
				   + "rua = '" 	     + objEndereco.getRua()      + "', "
				   + "cidade = '"    + objEndereco.getCidade()   + "', "
				   + "estado =  '"   + objEndereco.getEstado()   + "', "
				   + "cep = '"       + objEndereco.getCep()      + "', "
				   + "numero = '"    + objEndereco.getNumero()   + "', "
				   + "bairro = '"    + objEndereco.getBairro()   + "' "				   
				   + "WHERE id_endereco = "+ objEndereco.getId() +" " ;    
		try {
			connection.setAutoCommit(false);							
			
			 pst = (PreparedStatement) connection.prepareStatement(sql);    	  	             
			 pst.executeUpdate();
			 connection.commit();	        
		         
		        // return objAluno;
		         
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}//catch
			e.printStackTrace();	
		}finally{
			if(ctrlTransaction){
				try {
					pst.close();
					if(ctrlTransaction)
						connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}//catch
			}//if			
		}
		

		//return objAluno;
		}//metodo

}//Class