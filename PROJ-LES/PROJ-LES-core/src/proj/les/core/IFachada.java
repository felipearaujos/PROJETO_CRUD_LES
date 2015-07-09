package proj.les.core;

import proj.les.core.aplicacao.Resultado;
import proj.les.dominio.EntidadeDominio;

public interface IFachada {

	public Resultado salvar(EntidadeDominio entidade);
	//public void alterar(EntidadeDominio entidade);
	public Resultado alterar(EntidadeDominio entidade);
	public Resultado excluir(EntidadeDominio entidade);
	//public void excluir(EntidadeDominio entidade);
	//public void consultar(EntidadeDominio entidade);
	//public EntidadeDominio consultar(EntidadeDominio entidade);
	public Resultado consultar(EntidadeDominio entidade);
}
