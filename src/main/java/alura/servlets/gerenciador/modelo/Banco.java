package alura.servlets.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> listaDeEmpresas = new ArrayList<Empresa>();
	private static List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
	private static int chaveSequencial = 1;

	// bloco estático roda um código estático quando a classe for carregada na JVM
	static {
		Empresa microsoft = new Empresa("Microsoft");
		microsoft.setId(chaveSequencial++);
		Empresa google = new Empresa("Google");
		google.setId(chaveSequencial++);
		Empresa apple = new Empresa("Apple");
		apple.setId(chaveSequencial++);
		Banco.listaDeEmpresas.add(microsoft);
		Banco.listaDeEmpresas.add(google);
		Banco.listaDeEmpresas.add(apple);
		
		Usuario andre = new Usuario("andre", "andre123");
		Banco.listaDeUsuarios.add(andre);
		Usuario felipe = new Usuario("felipe", "felipe123");
		Banco.listaDeUsuarios.add(felipe);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		Banco.listaDeEmpresas.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return Collections.unmodifiableList(Banco.listaDeEmpresas);
	}

	public void removeEmpresaComId(Integer id) {
		Empresa empresa;
		Iterator<Empresa> it = listaDeEmpresas.iterator();

		while (it.hasNext()) {
			empresa = it.next();
			
			if (empresa.getId() == id) {
				it.remove();
			}
		}
	}

	public Empresa buscaEmpresaComId(Integer id) {
		for (Empresa empresa : listaDeEmpresas) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		
		return null;
	}

}
