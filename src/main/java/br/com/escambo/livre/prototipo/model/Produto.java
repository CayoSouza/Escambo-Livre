package br.com.escambo.livre.prototipo.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Produto {
	private BigInteger id;
	private String nome;
	private BigDecimal preco;
	private String descricao;
	
	public Produto() {
	}
	
	public Produto(BigInteger id, String nome, BigDecimal preco, String descricao) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}
	
	public BigInteger getId() {
		return id;
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
	
}
