package alura.servlets.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alura.servlets.gerenciador.modelo.Banco;

public class RemoveEmpresa {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("id");
		Integer id = Integer.valueOf(strId);
		
		Banco banco = new Banco();
		banco.removeEmpresaComId(id);
		
		return "redirect:entrada?acao=ListaEmpresas";
	}

}
