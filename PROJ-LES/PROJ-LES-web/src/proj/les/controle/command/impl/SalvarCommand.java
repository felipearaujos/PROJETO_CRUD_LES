
package proj.les.controle.command.impl;

import proj.les.core.aplicacao.Resultado;
import proj.les.dominio.EntidadeDominio;


public class SalvarCommand extends AbstractCommand{

	
	public Resultado execute(EntidadeDominio entidade) {
		
		return fachada.salvar(entidade);
	}

}
