package alura.servlets.gerenciador.servlet;

public class Empresa {

	private int id;
	private String nome;
	
	public Empresa(String nome) {
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
}
