package alura.servlets.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import alura.servlets.gerenciador.acao.Acao;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		String nomeDaClasse = null;
		String link = null;

		nomeDaClasse = "alura.servlets.gerenciador.acao." + paramAcao;
		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			Constructor<?> construtor = classe.getConstructor();
			Acao instanciaAcao = (Acao) construtor.newInstance();
			link = instanciaAcao.executa(request, response);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}

		String parametros[] = link.split(":");
		if (parametros[0].equals("forward")) {
			RequestDispatcher despachador = request.getRequestDispatcher("WEB-INF/view/" + parametros[1]);
			despachador.forward(request, response);
		} else {
			response.sendRedirect(parametros[1]);
		}
	}

}
