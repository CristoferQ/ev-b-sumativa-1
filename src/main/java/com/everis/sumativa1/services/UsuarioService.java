package com.everis.sumativa1.services;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.sumativa1.models.Usuario;
import com.everis.sumativa1.repositories.UsuarioRepository;

@Service
public class UsuarioService{
	@Autowired //inyeccion de dependencia
	UsuarioRepository usuarioRepository; //interfaz que extiende de crud
	
	@PostConstruct
	public void añadirUsuariosBase() {
		Usuario usuario1 = new Usuario("Pablo", "123", "cris@gmail.com");
		Usuario usuario2 = new Usuario("Andrea", "653", "andrea@gmail.com");
		Usuario usuario3 = new Usuario("Michael", "443", "michael@gmail.com");
		usuarioRepository.save(usuario1);
		usuarioRepository.save(usuario2);
		usuarioRepository.save(usuario3);
	}
	public Usuario añadirUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	public List<Usuario> traerUsuarios() {
		return usuarioRepository.findAll();
	}
	public void eliminarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}
	public Optional<Usuario> traerUsuario(Long id) {
		return usuarioRepository.findById(id);
	}
	public Usuario editarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	

}
