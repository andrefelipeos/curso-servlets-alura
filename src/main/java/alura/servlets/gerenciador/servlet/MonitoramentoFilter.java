package alura.servlets.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/entrada")
public class MonitoramentoFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long antes = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long depois = System.currentTimeMillis();
		
		String acao = request.getParameter("acao");
		System.out.println("Tempo de execução da ação " + acao + ": " + (depois - antes));
	}

}
