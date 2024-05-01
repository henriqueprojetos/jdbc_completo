package br.com.caelum.model;

public class Contato {
	private String nome;
	private String email;
	private String endereço;
	
	public Contato(String nome, String email, String endereco) {
		this.nome = nome;
		this.email = email;
		this.endereço = endereco;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getEndereço() {
		return endereço;
	}
}
