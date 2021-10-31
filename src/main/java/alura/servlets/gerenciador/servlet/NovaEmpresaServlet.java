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

@WebServlet("/nova_empresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
		System.out.println("Empresa " + novaEmpresa.getNome() + " foi cadastrada no banco.");
		
		response.sendRedirect("lista_empresas");
	}

}
