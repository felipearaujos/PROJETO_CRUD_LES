
package proj.les.controle.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proj.les.core.aplicacao.Resultado;
import proj.les.dominio.EntidadeDominio;


public interface IViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request);
	
	public void setView(Resultado resultado, 
			HttpServletResponse response,
			HttpServletRequest request)throws IOException, ServletException;
}
