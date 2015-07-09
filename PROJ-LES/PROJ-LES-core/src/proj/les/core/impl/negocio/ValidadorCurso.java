package proj.les.core.impl.negocio;

import proj.les.core.IStrategy;
import proj.les.dominio.Aluno;
import proj.les.dominio.EntidadeDominio;

public class ValidadorCurso  implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {		
		if(entidade instanceof Aluno){
			Aluno aluno = (Aluno)entidade;
			
			if(aluno.getCurso().equals("")){
				return "O curso deve ser cadastrado";
			}
			
		}else{
			return "Curso não pode ser válidado, pois entidade não é um Curso!";
		}
		
		
		return null;
	}

}//Class
