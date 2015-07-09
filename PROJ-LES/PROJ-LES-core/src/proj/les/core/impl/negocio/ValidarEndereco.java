package proj.les.core.impl.negocio;

import proj.les.core.IStrategy;
import proj.les.dominio.Aluno;
import proj.les.dominio.Endereco;
import proj.les.dominio.EntidadeDominio;

public class ValidarEndereco implements IStrategy{
	public String processar(EntidadeDominio entidade) {		
		//if(entidade instanceof Endereco){
		if(entidade instanceof Aluno){
			Aluno al = (Aluno)entidade;
			//Endereco end = (Endereco)entidade;
			
			//if(end.getCep() == null || end.getBairro() == null || end.getCidade() == null 
			// || end.getEstado() == null || end.getNumero() == null || end.getRua() == null){
			if(al.getEndereco().getCep().equals("")    || al.getEndereco().getBairro().equals("") ||
			   al.getEndereco().getCidade().equals("") || al.getEndereco().getEstado().equals("") || 
			   al.getEndereco().getNumero().equals("") || al.getEndereco().getRua().equals("")){
					
				return "Todos os dados do endereço devem ser cadastrados";
			}			
		}else{
			return "Endereco não pode ser válidado, pois entidade não é um Endereco!";
		}
		return null;	
	}
}//Class
