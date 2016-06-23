package br.com.escambo.livre.prototipo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.escambo.livre.prototipo.model.Carrinho;
import br.com.escambo.livre.prototipo.model.LoginService;
import br.com.escambo.livre.prototipo.model.Usuario;

@Controller
@SessionAttributes(value = {"email", "usuario", "carrinho"})
public class LoginController {

	@Autowired
	LoginService login;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String logIn(@RequestParam(required=true) String email, @RequestParam(required=true) String senha, Model model, RedirectAttributes redir){
		if(login.validaUsuario(email, senha)){
			model.addAttribute("email", email);
			model.addAttribute("usuario", login.getUsuario(email));
			return "index";
		}
		redir.addFlashAttribute("message", "Login ou senha inválida!");
		return "redirect:/entrar";
	}
	
	@RequestMapping(value={"/", "/login"})
	public String showPage(Model model){
		if (model.containsAttribute("usuario"))
			return "index";
		model.addAttribute("usuario", new Usuario());
		return "index";
	}
	
//	@RequestMapping(value="/painel-controle")
//	public String panelManager(Model model){
//		return (model.containsAttribute("email")) ? "painel-controle" : "redirect:/login";
//	}
	
	@RequestMapping(value="/logout")
	public String logout(SessionStatus status, Model model){
		Carrinho.limparCarrinho();
		status.setComplete();
		return "redirect:/login";
	}
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.POST)
	public String cadastrar(Usuario usuario, Model model){
		this.login.addUsuario(usuario);
		model.addAttribute("email", usuario.getEmail());
		return "index";
	}
	
	@RequestMapping(value={"/index"})
	public String welcomePage(Model model, SessionStatus status){
		try {
			return "index";
		} catch (Exception e) {
			Carrinho.limparCarrinho();
			status.setComplete();
			return "redirect:/login";
		}
	}
	
	@RequestMapping("/about")
	public String sobre(){
		
		return "about";
	}
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.GET)
	public String cadastrar(Model model){
		if (model.containsAttribute("usuario"))
			return "cadastrar";
		model.addAttribute("usuario", new Usuario());
		return "cadastrar";
	}
	
	@RequestMapping("/entrar")
	public String entrar(Model model){
		try {
			if (model.containsAttribute("email"))
				return "index";
			if (model.containsAttribute("usuario"))
				return "entrar";
		} catch (Exception e) {
			model.addAttribute("usuario", new Usuario());
		}
		
		return "entrar";
		
	}
	

	
	@RequestMapping("/feature")
	public String anunciar(){
		
		return "feature";
	}
	
	@RequestMapping("/contact")
	public String contato(){
		
		return "contact";
	}
}
