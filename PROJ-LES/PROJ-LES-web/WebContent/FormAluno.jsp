<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Aluno</title>
</head>
<body>
  <h1>Cadastro aluno</h1>
      
  <% ArrayList<String> cursos = new ArrayList<String> (); 
  	 cursos.add("Análise e Desenvolvimento de Sistemas");
  	 cursos.add("Recursos Humanos");  	 
  	 cursos.add("Agronegócio");
  	 cursos.add("Logistica");
   %>
  
  <form id="frmAluno" name="frmAluno" action="Servlet" method="POST">    
    <label for="txtNome">Nome:</label>
    <input type="text" name="txtNome" id="txtNome">
    <br>
  	
  	<label for="txtCurso">Curso:</label>
    <select name="txtCurso" > 
    
      <% for(int i = 0 ; i < cursos.size(); i++){ %>	 
        <option value=<%= i + 1 %> > <%=cursos.get(i)%></option>
      <%}%>
    </select> 
    <br>

  	<label for="txtCpf">CPF:</label>    
    <input type="text" name="txtCpf">
    <br>
    
    <label for="txtRa">RA:</label>    
    <input type="text" name="txtRa" >
    <br>
    
    <hr>
    <label for="txtRua">Rua:</label>    
    <input type="text" name="txtRua">    

    <label for="txtNumero">Numero:</label>    
    <input type="text" name="txtNumero" maxlength="5" size="5">
    
    <label for="txtCep">CEP:</label>    
    <input type="text" name="txtCep">
    
    <br>
    
    <label for="txtBairro">Bairro:</label>    
    <input type="text" name="txtBairro">
    
    <label for="txtCidade">Cidade:</label>    
    <input type="text" name="txtCidade">
    
    <label for="txtEstado">Estado:</label>    
    <input type="text" name="txtEstado">
      
  
  <center>
    <br><br><br>
      <input type="submit" id="operacao" name="operacao" value="SALVAR"/>		
	  <input type="submit" id="operacao" name="operacao" value="EXCLUIR"/>
	  <input type="submit" id="operacao" name="operacao" value="ALTERAR"/>
	  <input type="submit" id="operacao" name="operacao" value="CONSULTAR"/>
  </center>
  </form>


    
</body>
</html>