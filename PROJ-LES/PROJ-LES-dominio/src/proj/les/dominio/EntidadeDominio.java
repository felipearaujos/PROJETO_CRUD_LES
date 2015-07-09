package proj.les.dominio;
import java.util.Calendar;

public class EntidadeDominio implements IEntidade{
	
	private Integer id;
//	private Calendar dtCadastro;
	
	public Integer getId() {
		return id;
	}	
	public void setId(Integer id) {
		this.id = id;
	}
	
	/*
	public Calendar getDtCadastro() {
		return dtCadastro;
	}	
	public void setDtCadastro(Calendar dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	*/
	
}//Class