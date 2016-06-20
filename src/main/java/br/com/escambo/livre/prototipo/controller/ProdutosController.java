package br.com.escambo.livre.prototipo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.com.escambo.livre.prototipo.model.Estoque;
import br.com.escambo.livre.prototipo.model.Produto;

@Controller
@RequestMapping("/produtoss")
@SessionAttributes("email")
public class ProdutosController {
	
	@Autowired
	Estoque produtos;
	
	@RequestMapping
	public ModelAndView listar(){
		ModelAndView mv = new ModelAndView("lista-produtos");
		mv.addObject("produtos", produtos.getProdutos());
		mv.addObject(new Produto());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String adicionar(Produto produto){
		this.produtos.addProduto(produto);
		return "redirect:/produtoss";
	}
	
	@RequestMapping("/delete")
	public String deletar(String nome){
		this.produtos.deleteProduto(nome);
		return "redirect:/produtoss";
	}

}
