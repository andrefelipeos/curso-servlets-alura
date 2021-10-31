package alura.servlets.gerenciador.modelo;

import java.util.Date;

public class Empresa {

	private int id;
	private String nome;
	private Date dataAbertura;

	public Empresa(String nome) {
		this.nome = nome;
		this.dataAbertura = new Date();
	}
	
	public void setId(int id) {
		this.id = id;
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

	public void setNome(String nomeEmpresa) {
		this.nome = nomeEmpresa;
	}
	
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
}
