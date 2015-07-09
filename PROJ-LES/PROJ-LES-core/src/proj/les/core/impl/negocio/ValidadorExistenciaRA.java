package proj.les.core.impl.negocio;

import proj.les.core.IStrategy;
import proj.les.core.aplicacao.Resultado;
import proj.les.core.impl.controle.Fachada;
import proj.les.dominio.Aluno;
import proj.les.dominio.EntidadeDominio;

public class ValidadorExistenciaRA implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		if(entidade instanceof Aluno){
			Aluno al = new Aluno();
			al = (Aluno)entidade;	
			
			
			Resultado r = new Resultado();
			
			Fachada f = new Fachada();
			r = f.consultar(al);
			
			if(r.getEntidades().size() == 0){
				return "Ra n�o encontrado";
			}	
			
			
		}
		
		else{
			return "Somente � possivel validar a existencia de um ALUNO";
		}
		
		return null;
	}//metodo
	
	

}//class
