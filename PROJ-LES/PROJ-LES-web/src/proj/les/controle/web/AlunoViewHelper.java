
package proj.les.controle.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proj.les.core.aplicacao.Resultado;
import proj.les.dominio.Aluno;
import proj.les.dominio.Curso;
import proj.les.dominio.Endereco;
import proj.les.dominio.EntidadeDominio;
import proj.les.dominio.Aluno;

public class AlunoViewHelper implements IViewHelper {


	public EntidadeDominio getEntidade(HttpServletRequest request) {
		//String nome = request.getParameter("txtNome");
		//String cpf = request.getParameter("txtCpf");
		//String id = request.getParameter("txtId");
		String nome  	= request.getParameter("txtNome");
		String idCurso 	= request.getParameter("txtCurso");
		String cpf 		= request.getParameter("txtCpf");
		String ra 		= request.getParameter("txtRa");	
		//Informações do Endereço
		String rua  	= request.getParameter("txtRua");
		String numero  	= request.getParameter("txtNumero");
		String cep  	= request.getParameter("txtCep");
		String bairro  	= request.getParameter("txtBairro");		
		String cidade  	= request.getParameter("txtCidade");
		String estado  	= request.getParameter("txtEstado");

		
		Aluno al = new Aluno();

		al.setEndereco(new Endereco());		
		al.getEndereco().setCep(cep); 
		al.getEndereco().setCidade(cidade);
		al.getEndereco().setBairro(bairro);
		al.getEndereco().setEstado(estado);
		al.getEndereco().setNumero(numero); 
		al.getEndereco().setRua(rua);		
		al.setRa(ra);		
		al.setCurso(new Curso());
		
		if(idCurso != null && !idCurso.equals(""))
			al.getCurso().setId(Integer.parseInt(idCurso));
		
		al.setCpf(cpf); 
		al.setNome(nome); 
		//al.setDtCadastro(null);
		
		
		return al;
	}

	
	public void setView(Resultado resultado, HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		String operacao = request.getParameter("operacao");
		//PrintWriter out = response.getWriter();
		
		if(resultado.getMsg() != null){
			out.print(resultado.getMsg() );
		}else{
			
			if(operacao.equals("SALVAR")){
				out.print("<h1>");
				out.print("Aluno cadastrado com sucesso!");
				out.print("</h1>");
			}else if(operacao.equals("ALTERAR")){
				out.print("<h1>");
				out.print("Aluno Alterado com sucesso!");
				out.print("</h1>");
			}else if(operacao.equals("EXCLUIR")){
				out.print("<h1>");
				out.print("Aluno Excluido com sucesso!");
				out.print("</h1>");
			}else if(operacao.equals("CONSULTAR")){
				/*
				out.print("<h1>");
				out.print("consutar");

				out.print("</h1>");

				out.println("<br>");
				for( int i = 0 ; i < resultado.getEntidades().size(); i ++){
					if(resultado.getEntidades().get(i) instanceof Aluno){
						out.println("Nome: "     + ((Aluno)resultado.getEntidades().get(i)).getNome());
						out.println("Cpf: "      +((Aluno)resultado.getEntidades().get(i)).getCpf());
						out.println("<br>");
						out.println("RA: "       +((Aluno)resultado.getEntidades().get(i)).getRa());
						out.println("ID Curso: " +((Aluno)resultado.getEntidades().get(i)).getCurso().getId());
						out.println("<br>");
						out.println("Endereco: " +((Aluno)resultado.getEntidades().get(i)).getEndereco().getEstado());
						out.println("Cidade: "   +((Aluno)resultado.getEntidades().get(i)).getEndereco().getCidade());
						out.println("Rua: " 	 +((Aluno)resultado.getEntidades().get(i)).getEndereco().getRua());
						out.println("Numero: "   +((Aluno)resultado.getEntidades().get(i)).getEndereco().getNumero());
						out.println("Bairro: "   +((Aluno)resultado.getEntidades().get(i)).getEndereco().getBairro());
					}//if
					out.println("<hr>");
					out.println("<br>");
				}//for
				
				*/
				
				request.setAttribute("resultado", resultado);
				RequestDispatcher d= request.getRequestDispatcher("FormConsultaAluno.jsp");  
				d.forward(request,response); 
			}
			
			
			
		}
		
		
		
	}


	
	
			
		
		
		
		
	
	


	

}
