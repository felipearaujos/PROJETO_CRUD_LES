package proj.les.core.impl.negocio;

import proj.les.core.IStrategy;
import proj.les.dominio.EntidadeDominio;
import proj.les.dominio.Aluno;

public class ValidadorRa implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {		
		if(entidade instanceof Aluno){
			Aluno aluno = (Aluno)entidade;
			if(aluno.getRa() == null){
				return "RA é deve ser preenchido";
			}
			
			if(aluno.getRa().length() < 11){
				return "RA deve conter 11 digitos!";
			}
			
		}else{
			return "RA não pode ser válidado, pois entidade não é um ALUNO!";
		}
		
		
		return null;
	}

}
