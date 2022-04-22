package alura.servlets.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alura.servlets.gerenciador.modelo.Banco;
import alura.servlets.gerenciador.modelo.Empresa;

public class EditaEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strId = request.getParameter("id");
		Integer id = Integer.valueOf(strId);

		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaComId(id);

		request.setAttribute("empresa", empresa);

		return "forward:edita_empresa.jsp";
	}

}
