package alura.servlets.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/entrada")
public class AutorizacaoFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String paramAcao = request.getParameter("acao");

		boolean acaoProtegida = !(paramAcao.equals("ExibeFormularioDeLogin") || paramAcao.equals("Login"));

		HttpSession sessao = request.getSession();
		boolean semLogin = (sessao.getAttribute("usuarioLogado") == null);

		if (acaoProtegida && semLogin) {
			response.sendRedirect("entrada?acao=ExibeFormularioDeLogin");
			return;
		}

		chain.doFilter(request, response);
	}

}
