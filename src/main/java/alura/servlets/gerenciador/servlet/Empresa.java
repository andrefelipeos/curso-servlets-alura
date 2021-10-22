package alura.servlets.gerenciador.servlet;

import java.util.Date;

public class Empresa {

	private int id;
	private String nome;
	private Date dataAbertura;

	public Empresa(String nome) {
		this.nome = nome;
		this.dataAbertura = new Date();
	}
	
	public Empresa(String nome, Date data) {
		this.nome = nome;
		this.dataAbertura = data;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Date getDataAbertura() {
		return dataAbertura;
	}
	
}
