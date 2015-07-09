package proj.les.core.impl.controle;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;









import proj.les.core.IDAO;
import proj.les.core.aplicacao.Resultado;
import proj.les.dominio.Endereco;
import proj.les.dominio.EntidadeDominio;
import proj.les.dominio.Aluno;
import proj.les.core.IFachada;
import proj.les.core.IStrategy;
import proj.les.core.impl.dao.AlunoDAO;
import proj.les.core.impl.dao.EnderecoDAO;
import proj.les.core.impl.negocio.*;


public class Fachada implements IFachada {

	private Map<String, IDAO> daos;
	
	//private Map<String, List<IStrategy>> rns;
	private Map<String, Map<String, List<IStrategy>>> rns;
	private Resultado resultado = new Resultado();
	
	public Fachada(){
		daos = new HashMap<String, IDAO>();
		//rns = new HashMap<String, List<IStrategy>>();
		rns = new HashMap<String, Map<String, List<IStrategy>>>();
		
		daos.put(Aluno.class.getName(), new AlunoDAO());
		daos.put(Endereco.class.getName(), new EnderecoDAO());
		
		
		List<IStrategy> regrasAlunos = new ArrayList<IStrategy>();
		regrasAlunos.add(new ValidadorRa());
		//regrasAlunos.add(new ValidadorCurso());
		regrasAlunos.add(new ValidarEndereco());
		
		
		
		
		
		Map<String, List<IStrategy>> rnsSalvarAluno = new HashMap<String, List<IStrategy>>();		
		rnsSalvarAluno.put(Aluno.class.getName(), regrasAlunos);				
		rns.put("SALVAR", rnsSalvarAluno);
		
		
		List<IStrategy> regrasAltAlunos = new ArrayList<IStrategy>();
		regrasAltAlunos.add(new ValidadorExistenciaRA());
		
		
		Map<String, List<IStrategy>> rnsAltAluno = new HashMap<String, List<IStrategy>>();		
		rnsAltAluno.put(Aluno.class.getName(), regrasAltAlunos);				
		rns.put("ALTERAR", rnsAltAluno);
		rns.put("CONSULTAR", rnsAltAluno);
		rns.put("EXCLUIR", rnsAltAluno);
		
		//	
	}//Fachada
	
	
	
	

	
	public Resultado salvar(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "SALVAR");
		
		
		if(msg == null){
			IDAO dao = daos.get(nmClasse);
			try {
				dao.salvar(entidade);
				List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("Não foi possível realizar o registro!");
				
			}
		}else{
			resultado.setMsg(msg);
					
			
		}
		
		return resultado;
	}

	
	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "ALTERAR");
		
		
		if(msg == null){
			IDAO dao = daos.get(nmClasse);
			try {
				dao.alterar(entidade);
				List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("Não foi possível alterar o registro!");
				
			}
		}else{
			resultado.setMsg(msg);
					
			
		}
		
		return resultado;

	}//Alterar

	
	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "EXCLUIR");
		
		
		if(msg == null){
			IDAO dao = daos.get(nmClasse);
			try {
				dao.excluir(entidade);
				List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("Não foi possível realizar o registro!");
				
			}
		}else{
			resultado.setMsg(msg);
					
			
		}
		
		return resultado;

	}//eXCLUIR


	
	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		StringBuilder msg = new StringBuilder();
		
			if(msg.length() == 0){
			IDAO dao = daos.get(nmClasse);
			try {
				
				resultado.setEntidades(dao.consultar(entidade));
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("Não foi possível realizar a consulta!");
				
			}
		}else{
			resultado.setMsg(msg.toString());		
		}
		
		return resultado;

	}
	
	private String executarRegras(EntidadeDominio entidade, String operacao){
		String nmClasse = entidade.getClass().getName();		
		StringBuilder msg = new StringBuilder();
		
		Map<String, List<IStrategy>> regrasOperacao = rns.get(operacao);
		
		
		if(regrasOperacao != null){
			List<IStrategy> regras = regrasOperacao.get(nmClasse);
			
			if(regras != null){
				for(IStrategy s: regras){			
					String m = s.processar(entidade);			
					
					if(m != null){
						msg.append(m);
						msg.append("\n");
					}			
				}	
			}			
			
		}
		
		if(msg.length()>0)
			return msg.toString();
		else
			return null;
	}
}
