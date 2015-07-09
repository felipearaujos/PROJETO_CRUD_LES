package proj.les.core.impl.negocio;

import java.util.Calendar;
import java.util.GregorianCalendar;

import proj.les.core.IStrategy;
import proj.les.dominio.EntidadeDominio;

public class ComplementarDtCadastro implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {				
	/*	if(entidade !=null){
			Calendar data = new GregorianCalendar();		
			entidade.setDtCadastro(data);
		}
		else{
			return "Entidade: " + entidade.getClass().getCanonicalName() + " nula!";
		}
		
*/
		return null;
	}//Processar

}
