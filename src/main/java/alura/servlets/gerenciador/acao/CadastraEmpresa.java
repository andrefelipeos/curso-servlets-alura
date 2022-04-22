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

public class CadastraEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeEmpresa = request.getParameter("nome");
		String strDataAbertura = request.getParameter("data");
		Date dataAbertura = null;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(strDataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Empresa novaEmpresa = new Empresa(nomeEmpresa, dataAbertura);

		Banco banco = new Banco();
		banco.adiciona(novaEmpresa);

		return "redirect:entrada?acao=ListaEmpresas";
	}

}
