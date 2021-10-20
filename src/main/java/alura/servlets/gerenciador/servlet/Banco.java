package alura.servlets.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Banco {
	
	private static List<Empresa> listaDeEmpresas = new ArrayList<Empresa>();
	
	// bloco estático roda um código estático quando a classe for carregada na JVM
	static {
		Empresa microsoft = new Empresa("Microsoft");
		Empresa google = new Empresa("Google");
		Empresa apple = new Empresa("Apple");
		Banco.listaDeEmpresas.add(microsoft);
		Banco.listaDeEmpresas.add(google);
		Banco.listaDeEmpresas.add(apple);
	}

	public void adiciona(Empresa empresa) {
		Banco.listaDeEmpresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Collections.unmodifiableList(Banco.listaDeEmpresas);
	}

}
