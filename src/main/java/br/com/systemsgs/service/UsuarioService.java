package br.com.systemsgs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.systemsgs.exception.EmailUsuarioJaCadastradoException;
import br.com.systemsgs.model.ModelUsuario;
import br.com.systemsgs.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public void salvarUsuario(ModelUsuario modelUsuario) {
		Optional<ModelUsuario> usuarioExistente = usuarioRepository.findByEmail(modelUsuario.getEmail());
		
		if(usuarioExistente.isPresent()) {
			throw new EmailUsuarioJaCadastradoException("E-mail já Cadastrado!");
		}
		
		usuarioRepository.save(modelUsuario);
		
	}
	
}
