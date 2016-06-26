package br.com.escambo.livre.prototipo.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Estoque {

	private static List<Produto> produtos = new ArrayList<>();
	
	static {
		produtos.add(new Produto(new BigInteger("1"), "Nike Shox", new BigDecimal("500.00"), "Modelo v3", "novo", true));
		produtos.add(new Produto(new BigInteger("2"), "Conta de LoL", new BigDecimal("300.00"), "Platina 1", "novo", false));
		produtos.add(new Produto(new BigInteger("3"), "Nintendo 3DS", new BigDecimal("660.00"), "Acompanha 4 jogos originais", "usado", false));
		produtos.add(new Produto(new BigInteger("4"), "AWP Asiimov", new BigDecimal("130.00"), "Pouco usada (minimal wear)", "usado", true));
	}
	
	public void addProduto(BigInteger id, String nome, BigDecimal preco, String descricao){
		produtos.add(new Produto(id, nome, preco, descricao));
	}
	
	public List<Produto> getProdutos(){
		return Estoque.produtos;
	}

	public void addProduto(Produto produto) {
		Estoque.produtos.add(produto);
	}
	
	public void deleteProduto(String nome){
		for(Iterator<Produto> iter = produtos.listIterator(); iter.hasNext();){
			Produto especifico = iter.next();
			if (especifico.getNome().equalsIgnoreCase(nome))
				iter.remove();
		}
	}
	
	public Produto getProduto(BigInteger id){
		for (Iterator<Produto> iter = produtos.listIterator(); iter.hasNext();){
			Produto especifico = iter.next();
			if (especifico.getId().equals(id))
				return especifico;
		}
		return null;
	}
}
