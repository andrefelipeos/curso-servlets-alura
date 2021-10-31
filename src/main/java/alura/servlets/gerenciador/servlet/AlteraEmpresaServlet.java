package alura.servlets.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alura.servlets.gerenciador.modelo.Banco;
import alura.servlets.gerenciador.modelo.Empresa;

@WebServlet("/altera_empresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeEmpresa = request.getParameter("nome");
		String strDataAbertura = request.getParameter("data");
		String strId = request.getParameter("id");
		
		Date dataAbertura = null;
		Integer id = Integer.valueOf(strId);
		
		System.out.println("Alterando a empresa " + id);
		
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
		
		response.sendRedirect("lista_empresas");
	}

}
