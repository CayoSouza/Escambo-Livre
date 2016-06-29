package br.com.escambo.livre.prototipo.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class Carrinho {
	private static List<Produto> carrinho = new ArrayList<>();
	
	static {
		carrinho.add(new Produto(new BigInteger("1"), "Nike Shox", new BigDecimal("500.00"), "Modelo V3"));
	}

	
	public void addProduto(Produto produto){
		carrinho.add(produto);
	}
	
	public void addProduto(BigInteger id, String nome, BigDecimal preco, String descricao){
		carrinho.add(new Produto(id, nome, preco, descricao));
	}
	
	public void deleteProduto(Produto produto){
		carrinho.remove(produto);
	}
	
	public Produto buscaProdutoPorId(BigInteger id){
		for(Iterator<Produto> iter = carrinho.listIterator(); iter.hasNext();){
			Produto especifico = iter.next();
			if(especifico.getId().equals(id))
				return especifico;
		}
		return null;
	}
	
	public void deletePorId(BigInteger id){
		for(Iterator<Produto> iter = carrinho.listIterator(); iter.hasNext();){
			Produto especifico = iter.next();
			if(especifico.getId().equals(id))
				this.deleteProduto(especifico);
		}
	}
	
	public List<Produto> getProdutos(){
		return carrinho;
	}
	
	public static BigDecimal total(){
		BigDecimal total = new BigDecimal("0");
		
		for(Iterator<Produto> iter = carrinho.listIterator(); iter.hasNext();){
			Produto especifico = iter.next();
			total = total.add(especifico.getPreco());
		}
		
		return total;
	}
	
	public static void limparCarrinho(){
		carrinho.clear();
	}
	
	public static int getSize(){
		
		return carrinho.size();
	}
	
}
