package proj.les.core.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;








import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import proj.les.dominio.Aluno;
import proj.les.dominio.Curso;
import proj.les.dominio.Endereco;
import proj.les.dominio.EntidadeDominio;

public class AlunoDAO extends AbstractJdbcDAO {

		
	protected AlunoDAO(String table, String idTable) {
		super("tab_aluno", "id_aluno");	
	}
	
	public AlunoDAO(Connection cx){
		super(cx, "tab_aluno", "id_aluno");
	}
	
	public AlunoDAO(){
		super("tab_aluno", "id_aluno");			
	}
	
	public void salvar(EntidadeDominio entidade) {
	//	if(connection == null){
			openConnection();
	//	}
			
			
			
			
		// [INSERINDO O ENDEREÇO]
		
		
		
		//connection.setAutoCommit(false);			
		//EnderecoDAO endDAO = new EnderecoDAO();
		//endDAO.connection = connection;
		//endDAO.ctrlTransaction = false;
		//endDAO.salvar(end);
		
		
		PreparedStatement pst = null;
		
		try{					
			Aluno objAluno = new Aluno();
			objAluno.setEndereco(new Endereco());	
			objAluno = (Aluno)entidade;
				
			connection.setAutoCommit(false);			
			EnderecoDAO endDAO = new EnderecoDAO();
			endDAO.connection = connection;
			endDAO.ctrlTransaction = false;
		
			endDAO.salvar(objAluno.getEndereco());
				
			StringBuilder sql = new StringBuilder();
		
			sql.append("INSERT INTO tab_aluno(ra, nome, ");
			sql.append("cpf, id_curso, id_endereco, dt_cadastro) ");
			sql.append(" VALUES ( ?, ?, ?, ?, ? , ?)");	
		
			//connection.setAutoCommit(false);
								
			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, objAluno.getRa());
			pst.setString(2, objAluno.getNome());
			pst.setString(3, objAluno.getCpf());
			pst.setString(4, String.valueOf(objAluno.getCurso().getId()));
			pst.setString(5, String.valueOf(objAluno.getEndereco().getId()));
			//pst.setString(6, String.valueOf(objAluno.getDtCadastro())); [COMO CONVERTER DA DATA DO JAVA PRA SQL DATE?]
			pst.setString(6, null);//[COMO CONVERTER DA DATA DO JAVA PRA SQL DATE?]
			pst.executeUpdate();		
					
	      /*ResultSet rs = pst.getGeneratedKeys();
			int idEnd=0;
			if(rs.next())
				idEnd = rs.getInt(1);
			end.setId(idEnd);
		   */
			connection.commit();	
			
			//pst.close();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}//catch
			e.printStackTrace();	
		} finally{
			if(ctrlTransaction){
				try {
					pst.close();
					if(ctrlTransaction)
						connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//chatch
			}
			//if			
		}
	}//Salvar

	
	@Override
	public  List<EntidadeDominio> consultar(EntidadeDominio entidade) {
	/*if(connection == null){
		openConnection();
	}

	
	Aluno objAluno = new Aluno();
	objAluno.setRa(((Aluno)entidade).getRa());
	PreparedStatement pst = null;
	
	
	//StringBuilder sql = new StringBuilder();
	
	//sql.append("SELECT ra, nome, ");
	//sql.append("cpf, id_curso, id_endereco,dt_cadastro FROM tab_aluno ");
	//sql.append(" WHERE ra = '1840481312010'");	
	String sql = "SELECT ra, nome, cpf, id_curso, id_endereco,dt_cadastro FROM tab_aluno where ra = '"+ objAluno.getRa() +"'";    
	
	 
	 
	try {
		connection.setAutoCommit(false);         
         
		 pst = (PreparedStatement) connection.prepareStatement(sql);    	  	             
         ResultSet rs = pst.executeQuery(); 
        while (rs.next())  
		{
        	//objAluno.setId(rs.getInt("id_aluno"));
			objAluno.setRa(rs.getString("ra"));
			objAluno.setNome(rs.getString("nome"));
			objAluno.setCpf(rs.getString("cpf"));
			objAluno.setCurso(new Curso());
			objAluno.getCurso().setId(rs.getInt("id_curso"));
			objAluno.setEndereco(new Endereco());
			objAluno.getEndereco().setId((rs.getInt("id_endereco")));
			objAluno.setDtCadastro(null);//dtCadastro
		  
		}
        
        EnderecoDAO d = new EnderecoDAO();
		objAluno.setEndereco((Endereco) d.consultar(objAluno.getEndereco()));			
	
	         rs.close();  	
	         connection.commit();	        
	         
	         return objAluno;
	         
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

	return objAluno;*/
		
		PreparedStatement pst = null;
		
		Aluno aluno = (Aluno)entidade;
		String sql=null;
		
		if(aluno.getRa().equals("") && aluno.getNome().equals("")){
			sql = " select * FROM tab_aluno";
			
		}
		
		else if(!aluno.getRa().equals("")) 
		{ 
			sql = "SELECT * FROM tab_aluno where ra ='"+ aluno.getRa() +"'";
		}
		
		else if(!aluno.getNome().equals("")){
			sql = "SELECT * FROM tab_aluno WHERE nome LIKE'" + aluno.getNome() + "%'";
		}
		
		/*else if(produto.getId() == null && !produto.getDescricao().equals("")){
			sql = "SELECT * FROM tb_produto WHERE descricao like ?";
		
		}*/
	
	
	
	try {
		openConnection();
		pst = connection.prepareStatement(sql);
		
		//if(produto.getId() != null && produto.getDescricao().equals("")){
		/*if(!aluno.getRa().equals(""))
		pst.setInt(1, produto.getId());
		}else if(produto.getId() == null && !produto.getDescricao().equals("")){
			pst.setString(1, "%"+produto.getDescricao()+"%");			
		}
		
*/
		
		ResultSet rs = pst.executeQuery();
		List<EntidadeDominio> alunos = new ArrayList<EntidadeDominio>();
		
		EnderecoDAO d = new EnderecoDAO();
		while (rs.next()) {
			
			Aluno objAluno = new Aluno();
			objAluno.setRa(rs.getString("ra"));
			objAluno.setNome(rs.getString("nome"));
			objAluno.setCpf(rs.getString("cpf"));
			objAluno.setCurso(new Curso());
			objAluno.getCurso().setId(rs.getInt("id_curso"));
			objAluno.setEndereco(new Endereco());
			objAluno.getEndereco().setId((rs.getInt("id_endereco")));
			//objAluno.setDtCadastro(null);//dtCadastro
			
			// Busca do endereco
			objAluno.setEndereco((Endereco) d.consultar(objAluno.getEndereco()).get(0));	
			
			alunos.add(objAluno);
		}
		
		
		 
			
		
		return alunos;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
	}//metodo

	
	public void alterar(EntidadeDominio entidade) {
	if(connection == null){
		openConnection();
	}
	
	Aluno objAluno = new Aluno();
	objAluno.setEndereco(new Endereco());
	objAluno = (Aluno)entidade;

	AlunoDAO da = new AlunoDAO();
	Aluno AlAux = new Aluno();
	
	EnderecoDAO d = new EnderecoDAO();
	
	AlAux.setEndereco(new Endereco());
	
	
		
	if(da.consultar(objAluno).size() > 0){
		
		AlAux = (Aluno)da.consultar(objAluno).get(0);
	
	objAluno.getEndereco().setId(AlAux.getEndereco().getId());
	
	d.alterar(objAluno.getEndereco());
	
	//d.salvar(entidade);
	
	//end = (Endereco)d.consultar(objAluno2.getEndereco());
	//objAluno.getEndereco().setId(objAluno2.getEndereco().getId());
	
	
	
	
	PreparedStatement pst = null;
	//d.salvar(objAluno.getEndereco());
	
	//objAluno = (Aluno)consultar(entidade);
	
	//EnderecoDAO d = new EnderecoDAO();
	//d.alterar(objAluno2.getEndereco());
	
	//objAluno.getEndereco().setId((((Aluno)consultar(objAluno)).getEndereco().getId()));
	 //d.alterar(objAluno.getEndereco());
	
	
	String sql = "UPDATE tab_aluno "
			   + "SET " + "nome = '" + objAluno.getNome() + "' , "
			            + "cpf  = '" + objAluno.getCpf() + "' "			 
			   + "WHERE ra = '"+ objAluno.getRa()+"'" ;    
	try {
		connection.setAutoCommit(false);							
		
		 pst = (PreparedStatement) connection.prepareStatement(sql);    	  	             
		 pst.executeUpdate();
		 		 				 
		 		
		 
	     connection.commit();	        
	         	     
	         
	} catch (SQLException ew) {
		try {
			connection.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}//catch
		ew.printStackTrace();	
	}finally{
		if(ctrlTransaction){
			try {
				pst.close();
				if(ctrlTransaction)
					connection.close();
			} catch (SQLException ew) {
				ew.printStackTrace();
			}//catch
		}//if			
	}
	}

	//return objAluno;
	}//metodo
	
	
	
	

	
	public void excluir(EntidadeDominio entidade) {
		if(connection == null){
			openConnection();
		}
		Aluno objAluno = new Aluno();
		objAluno.setEndereco(new Endereco());
		objAluno = (Aluno)entidade;
		PreparedStatement pst=null;		
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM ");
		sb.append("tab_aluno ");
		sb.append(" WHERE ");
		sb.append("ra ");
		sb.append("=");
		sb.append("?");	
		try {
			connection.setAutoCommit(false);
			pst = connection.prepareStatement(sb.toString());
			pst.setString(1, objAluno.getRa());

			pst.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();			
		}finally{
			
			try {
				pst.close();
				if(ctrlTransaction)
					connection.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}		
	
	
	
}//class
