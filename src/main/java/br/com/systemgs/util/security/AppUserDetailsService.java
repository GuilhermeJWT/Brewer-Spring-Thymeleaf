package br.com.systemgs.util.security;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.systemsgs.model.ModelUsuario;
import br.com.systemsgs.repository.UsuarioRepository;

@Service
public class AppUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<ModelUsuario> usuarioOptional = usuarioRepository.porEmailEAtivo(email);
		ModelUsuario usuario = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou Senha Inválidos!"));
		
		return new User(usuario.getEmail(), usuario.getSenha(), new HashSet<>());
	}

}
