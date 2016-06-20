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
		produtos.add(new Produto(new BigInteger("1"), "Nike Shox", new BigDecimal("500.00"), "Modelo v3"));
		produtos.add(new Produto(new BigInteger("2"), "Conta de LoL", new BigDecimal("300.00"), "Platina 1"));
		produtos.add(new Produto(new BigInteger("3"), "AWP Asiimov", new BigDecimal("130.00"), "Veterana de Guerra"));
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
