package alura.servlets.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alura.servlets.gerenciador.acao.AlteraEmpresa;
import alura.servlets.gerenciador.acao.CadastraEmpresa;
import alura.servlets.gerenciador.acao.EditaEmpresa;
import alura.servlets.gerenciador.acao.ListaEmpresas;
import alura.servlets.gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		String link = null;
		
		if (paramAcao.equals("ListaEmpresas")) {
			link = (new ListaEmpresas()).executa(request, response);
		} else if (paramAcao.equals("RemoveEmpresa")) {
			link = (new RemoveEmpresa()).executa(request, response);
		} else if (paramAcao.equals("EditaEmpresa")) {
			link = (new EditaEmpresa()).executa(request, response);
		} else if (paramAcao.equals("AlteraEmpresa")) {
			link = (new AlteraEmpresa()).executa(request, response);
		} else if (paramAcao.equals("CadastraEmpresa")) {
			link =(new CadastraEmpresa()).executa(request, response);
		}
		
		String parametros[] = link.split(":");
		if (parametros[0].equals("forward")) {
			RequestDispatcher despachador = request.getRequestDispatcher(parametros[1]);
			despachador.forward(request, response);
		} else {
			response.sendRedirect(parametros[1]);
		}
	}

}
