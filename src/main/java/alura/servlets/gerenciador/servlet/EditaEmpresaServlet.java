package alura.servlets.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alura.servlets.gerenciador.modelo.Banco;
import alura.servlets.gerenciador.modelo.Empresa;

@WebServlet("/edita_empresa")
public class EditaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strId = request.getParameter("id");
		Integer id = Integer.valueOf(strId);
		
		System.out.println(id);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaComId(id);
		
		System.out.println(empresa.getNome());
		
		request.setAttribute("empresa", empresa);
		RequestDispatcher despachador = request.getRequestDispatcher("edita_empresa.jsp");
		despachador.forward(request, response);
	}

}
