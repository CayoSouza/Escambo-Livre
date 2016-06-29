package br.com.escambo.livre.prototipo.controller;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.com.escambo.livre.prototipo.model.Carrinho;
import br.com.escambo.livre.prototipo.model.Estoque;
import br.com.escambo.livre.prototipo.model.Produto;

@Controller
@SessionAttributes(value={"email", "usuario", "carrinho"})
public class ProdutosController {
	
	@Autowired
	Estoque produtos;
	@Autowired
	Carrinho carrinho;
	
//	@RequestMapping
//	public ModelAndView listar(){
//		ModelAndView mv = new ModelAndView("lista-produtos");
//		mv.addObject("produtos", produtos.getProdutos());
//		mv.addObject(new Produto());
//		
//		return mv;
//	}
//	
//	@RequestMapping(method = RequestMethod.POST)
//	public String adicionar(Produto produto){
//		this.produtos.addProduto(produto);
//		
//		return "redirect:/produtoss";
//	}
//	
//	@RequestMapping("/delete")
//	public String deletar(String nome){
//		this.produtos.deleteProduto(nome);
//		
//		return "redirect:/produtoss";
//	}
	
	

	@RequestMapping("/produto")
	public String produto(BigInteger id, Model model){
		Produto produto = this.produtos.getProduto(id);
		model.addAttribute("produto", produto);
	
		return "produto";
	}
	
	@RequestMapping("/randomProduct")
	public String randomProduct(BigInteger id){
		BigInteger random = new BigDecimal(Math.random() * (produtos.getSize())+1).toBigInteger();
		System.out.println("produtos.getSize="+produtos.getSize()+" random="+random+" id="+id);
		if (random.compareTo(id)==0)
			if (id.intValue()==1)
				return "redirect:/produto?id="+(random.add(new BigInteger("1")));
			else if(id.intValue()==(produtos.getSize()))
				return "redirect:/produto?id="+(random.subtract(new BigInteger("1")));
			else
				return "redirect:/produto?id="+(random.add(new BigInteger("1")));
		
		return "redirect:/produto?id="+random;
	}
	
	@RequestMapping("/comprar")
	public String comprar(BigInteger id, Model model){
		carrinho.addProduto(produtos.getProduto(id));
		model.addAttribute("carrinho", carrinho.getProdutos());
		return "redirect:/produtos";
	}
	
	@RequestMapping("/produtos")
	public String buscar(Model model){
		model.addAttribute("estoque", produtos.getProdutos());
		//System.out.println(produtos.getProdutos());
		//model.addAttribute(new Produto());
		return "produtos";
	}
	
	@RequestMapping("/carrinho")
	public String listarCarrinho(Model model){
		if (!(model.containsAttribute("email")))
			return "entrar";
//		ModelAndView mv = new ModelAndView("carrinho");
//		mv.addObject("carrinho", carrinho.getProdutos());
//		mv.addObject(new Produto());
//		if(carrinho.getProdutos()==null)
//			return "produtos";
		System.out.println(carrinho.getProdutos());
		model.addAttribute("carrinho", carrinho.getProdutos());
		//model.addAttribute(new Produto());
		
		return "carrinho";
	}
	
	@RequestMapping("/deletar")
	public String deletarProduto(BigInteger id){
		try {
			this.carrinho.deletePorId(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "carrinho";
		}
		return "redirect:/carrinho";
	}
	
	@RequestMapping(value="/anunciar", method=RequestMethod.GET)
	public String showAnunciar(Model model){
		if (!(model.containsAttribute("email")))
			return "entrar";
		model.addAttribute("produto", new Produto());
		return "anunciar";
	}
	
	@RequestMapping(value="/anunciar", method=RequestMethod.POST)
	public String anunciar(Model model, String nome, BigDecimal preco, String descricao, String tipo, boolean escambo, String imagem){
		if(imagem=="")
			imagem="/images/noimg.png";
		
		int size = produtos.getSize();
		BigInteger id = BigInteger.valueOf(size+1);
		
		Produto produto = new Produto(id, nome, preco, descricao, tipo, escambo, imagem);
		produtos.addProduto(produto);
		
		model.addAttribute("produtos", produtos.getProdutos());
		return "redirect:/produtos";
	}
	
	@RequestMapping("/limpar-carrinho")
	public String limparCarrinho(){
		
		
		return "redirect:/carrinho";
	}
}
