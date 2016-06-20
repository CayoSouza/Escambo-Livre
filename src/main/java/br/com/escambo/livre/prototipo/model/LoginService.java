package br.com.escambo.livre.prototipo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	private static final List<Usuario> usuarios = new ArrayList<>();
	
	static {
		usuarios.add(new Usuario("teste", "teste@gmail.com", "123"));
		usuarios.add(new Usuario("Bruno", "brunao@gmail.com", "hardcore88"));
		usuarios.add(new Usuario("Carla", "carlete@gmail.com", "ninguemvaisaber"));
		usuarios.add(new Usuario("Zidane", "zizizi@gmail.com", "ironhead"));
	}
	
	public void addUsuario(String nome, String email, String senha){
		usuarios.add(new Usuario(nome, email, senha));
	}
	
	public List<Usuario> getUsuarios(){
		return usuarios;
	}
	
	public boolean validaUsuario(String email, String senha){
		for (Usuario usuario : usuarios)
			if (usuario.getEmail().equalsIgnoreCase(email)
					&& usuario.getSenha().equals(senha)){
					System.out.println(">>>>>LOGADO<<<<<");		
				return true;
			}				
		return false;
	}

	public void addUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
}
