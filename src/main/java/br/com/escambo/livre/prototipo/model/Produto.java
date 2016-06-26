package br.com.escambo.livre.prototipo.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Produto {
	private BigInteger id;
	private String nome;
	private BigDecimal preco;
	private String descricao;
	private String tipo;
	private boolean escambo;
	private String imagem;
	
	public Produto() {
	}
	
	public Produto(BigInteger id, String nome, BigDecimal preco, String descricao) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}
	
	public Produto(BigInteger id, String nome, BigDecimal preco, String descricao, String tipo, boolean escambo) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.setTipo(tipo);
		this.setEscambo(escambo);
	}
	
	public Produto(BigInteger id, String nome, BigDecimal preco, String descricao, String tipo, boolean escambo, String imagem) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.tipo = tipo;
		this.escambo = escambo;
		this.imagem = imagem;
	}
	
	public BigInteger getId() {
		return id;
	}
	
	public String idToString(){
		return String.valueOf(id.intValue());
	}

	public void setId(BigInteger id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isEscambo() {
		return escambo;
	}

	public void setEscambo(boolean escambo) {
		this.escambo = escambo;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String img) {
		this.imagem = img;
	}
	
}
