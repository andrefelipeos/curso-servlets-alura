package alura.servlets.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alura.servlets.gerenciador.modelo.Banco;
import alura.servlets.gerenciador.modelo.Empresa;

public class AlteraEmpresa {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeEmpresa = request.getParameter("nome");
		String strDataAbertura = request.getParameter("data");
		String strId = request.getParameter("id");
		
		Date dataAbertura = null;
		Integer id = Integer.valueOf(strId);
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(strDataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaComId(id);
		empresa.setDataAbertura(dataAbertura);
		empresa.setNome(nomeEmpresa);
		
		return "redirect:entrada?acao=ListaEmpresas";
	}

}
