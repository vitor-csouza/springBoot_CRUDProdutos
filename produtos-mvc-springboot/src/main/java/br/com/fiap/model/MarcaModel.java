package br.com.fiap.model;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
public class MarcaModel {
	
	private long id;
	
	private String nome;

	
	public MarcaModel() {
		super();
	
	}


	public MarcaModel(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}


	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}


	@NotNull(message="Nome da marca é obrigatório")
	@Size(min=2,max=50,message="Nome deve ser entre 2 e 50 caracteres")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
