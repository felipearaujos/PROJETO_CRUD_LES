package proj.les.servlet;

//package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;










import proj.les.controle.command.*;
import proj.les.controle.command.impl.AlterarCommand;
import proj.les.controle.command.impl.ConsultarCommand;
import proj.les.controle.command.impl.ExcluirCommand;
import proj.les.controle.command.impl.SalvarCommand;
import proj.les.controle.web.AlunoViewHelper;
import proj.les.controle.web.IViewHelper;
import proj.les.core.aplicacao.Resultado;
import proj.les.dominio.*;



public class Servlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Map<String, ICommand> commands;
	private static Map<String, IViewHelper> vhs;
	
	
	 public Servlet() {
	    	commands = new HashMap<String, ICommand>();
	    	commands.put("SALVAR", new SalvarCommand());
	    	commands.put("EXCLUIR", new ExcluirCommand());
	    	commands.put("ALTERAR", new AlterarCommand());
	    	commands.put("CONSULTAR", new ConsultarCommand());
	    	
	    	vhs = new HashMap<String, IViewHelper>();
	    	/*A chave do mapa é o mapeamento da servlet para cada form que 
	    	 * está configurado no web.xml e sendo utilizada no action do html
	    	 */
	    	vhs.put("/PROJ-LES-web/Servlet", new AlunoViewHelper());
	    	
	    	
	    }
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		
		String operacao = request.getParameter("operacao");
		
		IViewHelper vh = vhs.get(uri);
		
		EntidadeDominio entidade = new EntidadeDominio();
		entidade =  vh.getEntidade(request);
		
		
		
		ICommand command = commands.get(operacao);
		Resultado resultado = command.execute(entidade);
		
		vh.setView(resultado, response, request);
    	
	
		
/*		String nome  	= req.getParameter("txtNome");
		String idCurso 	= req.getParameter("txtCurso");
		String cpf 		= req.getParameter("txtCpf");
		String ra 		= req.getParameter("txtRa");	
		//Informações do Endereço
		String rua  	= req.getParameter("txtRua");
		String numero  	= req.getParameter("txtNumero");
		String cep  	= req.getParameter("txtCep");
		String bairro  	= req.getParameter("txtBairro");		
		String cidade  	= req.getParameter("txtCidade");
		String estado  	= req.getParameter("txtEstado");
	*/			
		//PrintWriter out = resp.getWriter();
		
	/*	out.println("Nome: " + nome + "   -   ");
		out.println("Curso: " + idCurso + "   -   ");
		out.println("CPF: " + cpf + "   -   ");
		out.println("RA: " + ra + "   -   ");		
		out.println("Rua: " + rua + "   -   ");
		out.println("Numero: " + numero + "   -   ");
		out.println("Bairro: " + bairro + "   -   ");
		out.println("Cep: " + cep + "   -   ");
		out.println("Cidade: " + cidade + "   -   ");
		out.println("Estado: " + estado + "   -   ");
	*/
		
	/*	Aluno al = new Aluno();	
		
		al.setEndereco(new Endereco());		
		al.getEndereco().setCep(cep); 
		al.getEndereco().setCidade(cidade);
		al.getEndereco().setBairro(bairro);
		al.getEndereco().setEstado(estado);
		al.getEndereco().setNumero(numero); 
		al.getEndereco().setRua(rua);		
		al.setRa(ra);		
		al.setCurso(new Curso()); 
		al.getCurso().setId(Integer.parseInt(idCurso)); 
		al.setCpf(cpf); 
		al.setNome(nome); 
		al.setDtCadastro(null);
		
		
		String msg ="";
		
		//Fachada f = new Fachada();
		//msg = f.salvar(al);
        Resultado r = new Resultado();
		
		Fachada f = new Fachada();
		r = f.salvar(al);
		
		if (r.getMsg() == null){
			out.print("Salvo com sucesso ");					
		}
		else{
			out.print(msg);
			
		}
		//al.setEndereco(new Endereco());		
*/		
	/*	al.getEndereco().setCep("08663120");
		al.setDtCadastro(null);
		al.getEndereco().setCidade("sp");
	 	al.getEndereco().setBairro("sp");
		al.getEndereco().setEstado("SP");
		al.getEndereco().setNumero("24");
		al.getEndereco().setRua("Rua domamute abc");
		al.getEndereco().setId(37);
		al.setRa("1840481312016");
		al.setCurso(new Curso());
		al.getCurso().setId(3);
		al.setCpf("12345678998");
		al.setNome("glueto");
		*/

	}
	
	
	
}


