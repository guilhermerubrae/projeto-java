package ecommerce.model;

public class User {

	private String nome;

	public User(String nome, String endereco) {
	        this.nome = nome;
	    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}