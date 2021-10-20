package alura.servlets.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lista_empresas")
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();
		
		request.setAttribute("listaEmpresas", empresas);
		RequestDispatcher despachador = request.getRequestDispatcher("lista_de_empresas.jsp");
		despachador.forward(request, response);
	}

}
