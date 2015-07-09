package proj.les.controle.command.impl;


//package les12015.controle.web;

import proj.les.core.aplicacao.Resultado;
import proj.les.dominio.EntidadeDominio;


public class ExcluirCommand extends AbstractCommand{	
	public Resultado execute(EntidadeDominio entidade) {
		
		return fachada.excluir(entidade);
	}

}
