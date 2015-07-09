<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page
	import="proj.les.core.aplicacao.Resultado, proj.les.dominio.*, java.util.*"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>CONSULTA</title>
</head>
<body>


	<%
		Resultado resultado = (Resultado) request.getAttribute("resultado");
	%>

	<form action="Servlet" method="post">

		<label for="txtRa">RA:</label>    
    	<input type="text" name="txtRa" >   
    	<br>
    	<label for="txtNome">Nome:</label>
    	<input type="text" name="txtNome" id="txtNome">
    	<br>
    
    <input type="submit" id="operacao" name="operacao" value="CONSULTAR" />
	</form>
	
	<%
		List<String> nomes 		= null;
		List<String> cursos 	= null;
		List<String> cpfs 		= null;	
		List<String> ras 		= null;
		List<String> ruas 		= null;
		List<String> numeros	= null;
		List<String> ceps 		= null;
		List<String> bairros	= null;
		List<String> cidades	= null;
		List<String> estados	= null;		

		if (resultado != null) {
			List<EntidadeDominio> entidades = resultado.getEntidades();
			nomes 	= new ArrayList<String>();
			cursos 	= new ArrayList<String>();
			cpfs 	= new ArrayList<String>();
			ras 	= new ArrayList<String>();
			ruas 	= new ArrayList<String>();
			numeros = new ArrayList<String>();
			ceps 	= new ArrayList<String>();
			bairros = new ArrayList<String>();
			cidades = new ArrayList<String>();
			estados = new ArrayList<String>();

			if(entidades != null)
			{
				for (int i = 0; i < entidades.size(); i++) 
				{
					if(entidades.get(i) instanceof Aluno)
					{
						Aluno aluno = (Aluno) entidades.get(i);	
						ras.add("<td>" + aluno.getRa() + "</td>");
						nomes.add("<td>" + aluno.getNome() + "</td>");
						cpfs.add("<td>" + aluno.getCpf() + "</td>");
						cursos.add("<td>" + aluno.getCurso().getId() + "</td>");

						ruas.add("<td>" + aluno.getEndereco().getRua() + "</td>");
						numeros.add("<td>" + aluno.getEndereco().getNumero() + "</td>");
						ceps.add("<td>" + aluno.getEndereco().getCep() + "</td>");
						bairros.add("<td>" + aluno.getEndereco().getBairro() + "</td>");
						cidades.add("<td>" + aluno.getEndereco().getCidade() + "</td>");
						estados.add("<td>" + aluno.getEndereco().getEstado() + "</td>");
					}//if InstanceOf
				}//For
		    }// entidades!= null
		}//reultado!= null
	%>
	


	<table style="width: 100% ; border: 1px solid;">
		<tr>
		<th>RA:</th>

			<%
				if (ras != null) {
					for (String i : ras) {
						out.println(i);
					}
				}
			%>
		</tr>
		<tr>
			<th>Nome:</th>
			<%
				if (nomes != null) {
					for (String i : nomes) {
						out.println(i);
					}
				}
			%>
		</tr>
		
		<tr>
			<th>Cpf:</th>
			<%
				if (cpfs != null) {
					for (String i : cpfs) {
						out.println(i);
					}
				}
			%>
		</tr>
		
		<tr>
			<th>Curso:</th>
			<%
				if (cursos != null) {
					for (String i : cursos) {
						out.println(i);
					}
				}
			%>
		</tr>
		
		<tr>
			<th>Rua:</th>
			<%
				if (ruas != null) {
					for (String i : ruas) {
						out.println(i);
					}
				}
			%>
		</tr>
		
		
		<tr>
			<th>Numero:</th>
			<%
				if (numeros != null) {
					for (String i : numeros) {
						out.println(i);
					}
				}
			%>
		</tr>
		
		
		<tr>
			<th>Cep:</th>
			<%
				if (ceps != null) {
					for (String i : ceps) {
						out.println(i);
					}
				}
			%>
		</tr>
		
		
		<tr>
			<th>Bairro:</th>
			<%
				if (bairros != null) {
					for (String i : bairros) {
						out.println(i);
					}
				}
			%>
		</tr>
		
		<tr>
			<th>Cidade:</th>
			<%
				if (cidades != null) {
					for (String i : cidades) {
						out.println(i);
					}
				}
			%>
		</tr>
		
		
		<tr>
			<th>Estado:</th>
			<%
				if (estados != null) {
					for (String i : estados) {
						out.println(i);
					}
				}
			%>
		</tr>		
		
		
		
		

		

	</table>

</body>
</html>