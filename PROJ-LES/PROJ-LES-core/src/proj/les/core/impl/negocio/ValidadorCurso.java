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
			return "Curso n�o pode ser v�lidado, pois entidade n�o � um Curso!";
		}
		
		
		return null;
	}

}//Class
