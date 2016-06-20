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

import br.com.escambo.livre.prototipo.model.LoginService;
import br.com.escambo.livre.prototipo.model.Usuario;

@Controller
@SessionAttributes(value = {"email"})
public class LoginController {

	@Autowired
	LoginService login;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String logIn(@RequestParam(required=true) String email, @RequestParam(required=true) String senha, Model model, RedirectAttributes redir){
		if(login.validaUsuario(email, senha)){
			model.addAttribute("email", email);
			return "index";
		}
		redir.addFlashAttribute("message", "Login ou senha inválida!");
		return "redirect:/entrar";
	}
	
	@RequestMapping(value={"/login", "/"})
	public String showPage(Model model){
		model.addAttribute("active", "active");
		if (model.containsAttribute("email"))
			return "painel-controle";
		model.addAttribute("usuario", new Usuario());
		return "index";
	}
	
	@RequestMapping(value="/painel-controle")
	public String panelManager(Model model){
		return (model.containsAttribute("email")) ? "painel-controle" : "redirect:/login";
	}
	
	@RequestMapping(value="/logout")
	public String logout(SessionStatus status){
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
	public String welcomePage(Model model){
		
		return "index";
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
		if (model.containsAttribute("email"))
			return "index";
		if (model.containsAttribute("usuario"))
			return "entrar";
		model.addAttribute("usuario", new Usuario());
		return "entrar";
	}
	
	@RequestMapping("/produtos")
	public String buscar(){
		
		return "produtos";
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
