package br.com.escambo.livre.prototipo.model;

import java.math.BigDecimal;

public class Produto {
	private String nome;
	private BigDecimal preco;
	private String descricao;
	
	public Produto() {
	}
	
	public Produto(String nome, BigDecimal preco, String descricao) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
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
	
}
