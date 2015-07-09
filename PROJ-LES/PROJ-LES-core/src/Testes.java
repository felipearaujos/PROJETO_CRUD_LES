
import proj.les.core.aplicacao.Resultado;
import proj.les.core.impl.controle.Fachada;
import proj.les.dominio.Aluno;
import proj.les.dominio.Curso;
import proj.les.dominio.Endereco;


public class Testes {

	public static void main(String[] args) {	
		//String msg;		
		Aluno al = new Aluno();
      /*  al.setEndereco(new Endereco());		
	    al.getEndereco().setCep("08663120");
		al.getEndereco().setCidade("Rio de Janeiro");
	 	al.getEndereco().setBairro("Rio de Janeiro");
		al.getEndereco().setEstado("Rio de Janeiro");
		al.getEndereco().setNumero("11");
		al.getEndereco().setRua("Rua do pcc");
		//al.getEndereco().setId(37);
		al.setRa("1840481312021");
		al.setCurso(new Curso());
		al.getCurso().setId(2);
		al.setCpf("12345678998");
		al.setNome("maroquino");
		al.setDtCadastro(null);
*/
        
        //al.setId(61);
        al.setRa("18404813120218");
       // al.setNome("fe");
		//Endereco end = new Endereco();
		//end.setId(126);
		
		Resultado r = new Resultado();
		
		Fachada f = new Fachada();
		r = f.consultar(al);
		
		
		//msg = f.salvar(al);
		System.out.println(r.getMsg());
		System.out.println(r.getEntidades().size());
		for( int i = 0 ; i < r.getEntidades().size(); i ++){
			if(r.getEntidades().get(i) instanceof Aluno){
				System.out.println(((Aluno)r.getEntidades().get(i)).getNome());
				System.out.println(((Aluno)r.getEntidades().get(i)).getCpf());
				System.out.println(((Aluno)r.getEntidades().get(i)).getRa());
				System.out.println(((Aluno)r.getEntidades().get(i)).getCurso().getId());
				System.out.println(((Aluno)r.getEntidades().get(i)).getEndereco().getEstado());
				System.out.println(((Aluno)r.getEntidades().get(i)).getEndereco().getCidade());
				System.out.println(((Aluno)r.getEntidades().get(i)).getEndereco().getRua());
				System.out.println(((Aluno)r.getEntidades().get(i)).getEndereco().getNumero());
				System.out.println(((Aluno)r.getEntidades().get(i)).getEndereco().getBairro());
				
			}
			System.out.println("-------------------------------");
			
		}
		
		/*if(r.getEntidades().get(0) instanceof Endereco){
			System.out.println(
					//(Endereco(r.getEntidades().get(0)).
							((Endereco)r.getEntidades().get(0)).getCidade()
					);
			
		}*/
		
	
		
		//f.alterar(al);
		
		//f.salvar(al);
		
		//f.alterar(al.getEndereco());
		
	//	f.alterar(entidade);
		
		
		
		
		/*
		Fachada f = new Fachada();
		
		
		Endereco end = new Endereco();
		end.setBairro("Itepupa");
		end.setCep("0000000");
		end.setCidade("New java");
		end.setCidade("Guiné");
		end.setEstado("RS");
		end.setDtCadastro(null);
		end.setId(37);
		end.setNumero("2");
		end.setRua("Rua dos tutanos verdes");
		f.alterar(end);
		*/
		
		
		
		
		//System.out.println(msg);
		
		
		
		//al = new Aluno();
		
		//Fachada f = new Fachada();
	//	System.out.println(msg);
		
	//	al.setRa("1840481312011");		
	//	al = (Aluno) f.consultar(al);
		/*
		al.setEndereco(new Endereco());		
		al.getEndereco().setCep("08333190");
		al.getEndereco().setCidade("Mato Grosso do Sul");
	 	al.getEndereco().setBairro("Itaim");
		al.getEndereco().setEstado("SP");
		al.getEndereco().setNumero("3");
		al.getEndereco().setRua("Rua do Status");
		*/
		
	/*	Fachada f = new Fachada();
		
		al = new Aluno();
		al.setRa("1840481312011");
		al = (Aluno) f.consultar(al);
		//System.out.println(al.getEndereco().getId());

		System.out.println("Nome:" + al.getNome());
		System.out.println("ID endereco: " + al.getEndereco().getId());
		System.out.println("CPF: " + al.getCpf());
		System.out.println("ra: " + al.getRa());
		System.out.println("id curso: " + al.getCurso().getId());
		System.out.println(al.getEndereco().getBairro());
		System.out.println(al.getEndereco().getRua());
	*/	
	/*	Endereco end = new Endereco();
		end.setBairro("Flores");
		end.setCep("0000000");
		end.setCidade("Carapicuiva");		
		end.setEstado("RS");
		end.setDtCadastro(null);
		end.setId(al.getEndereco().getId());
		end.setNumero("2");
		end.setRua("Rua Pelicanos");
		f.alterar(end);
		
		*/
		
	/*	Endereco end = new Endereco();
		end.setId(1);
		end.setId(al.getEndereco().getId());
		
		end = (Endereco) f.consultar(end);
		System.out.println(end.getBairro()+" " + 
		end.getEstado());
		*/
		
		//System.out.println("Nome " + al.getNome());
		
		
		
		
		

				
			}
}