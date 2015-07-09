package proj.les.core;

import java.sql.SQLException;
import java.util.List;

import proj.les.dominio.EntidadeDominio;

public interface IDAO {

	
	public void salvar(EntidadeDominio entidade)  throws SQLException;
	public void alterar(EntidadeDominio entidade) throws SQLException;
	public void excluir(EntidadeDominio entidade) throws SQLException;
	public List<EntidadeDominio> consultar(EntidadeDominio entidade)throws SQLException;
	//public void consultar(EntidadeDominio entidade);
	//public EntidadeDominio consultar(EntidadeDominio entidade);
	//public List<EntidadeDominio> consultar(EntidadeDominio entidade)throws SQLException;
	
}
