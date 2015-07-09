
package proj.les.controle.command;

import proj.les.core.aplicacao.Resultado;
import proj.les.dominio.EntidadeDominio;


public interface ICommand {

	public Resultado execute(EntidadeDominio entidade);
	
}
