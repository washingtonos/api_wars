package br.com.washington.api.wars.api_wars.document;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Planeta {

	@Id
	private String id;
	@NotNull(message = "Nome deve ser preenchido")
	private String nome;
	private String clima;
	private String terreno;
	private int totalAparicoes;

	public Planeta(String id, String nome, String clima, String terreno, int totalAparicoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
		this.totalAparicoes = totalAparicoes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public int getTotalAparicoes() {
		return totalAparicoes;
	}

	public void setTotalAparicoes(int totalAparicoes) {
		this.totalAparicoes = totalAparicoes;
	}

}
