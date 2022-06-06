package alura.servlets.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alura.servlets.gerenciador.acao.Acao;

public class ControladorFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filtro Controlador iniciado!");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

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
		System.out.println("Filtro Controlador chegou ao fim!");
	}

}
