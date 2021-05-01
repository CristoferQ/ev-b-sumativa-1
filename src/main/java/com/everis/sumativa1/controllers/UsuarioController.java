package com.everis.sumativa1.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.everis.sumativa1.models.Usuario;
import com.everis.sumativa1.services.UsuarioService;


@Controller
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("/usuarios")
	public String usuarios(Model model) {
		List<Usuario> usuariosLista = usuarioService.traerUsuarios();
		model.addAttribute("usuariosLIST", usuariosLista);
		
		return "usuarios.jsp";
	}
	@RequestMapping("/usuarios/agregar")
	public String agregar(@RequestParam(value="nombreForm")String nombreBack,
			@RequestParam(value="passwordForm")String passwordBack,
			@RequestParam(value="emailForm")String emailBack) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre(nombreBack);
		usuario.setPassword(passwordBack);
		usuario.setEmail(emailBack);
		
		usuario = usuarioService.añadirUsuario(usuario);
		
		return "redirect:/usuarios";
	}
	@RequestMapping("/usuarios/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		usuarioService.eliminarUsuario(id);
		return "redirect:/usuarios";
	}
	@RequestMapping("/usuarios/traer/{id}")
	public String traer(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {	
		Optional<Usuario> usuario = usuarioService.traerUsuario(id);
		redirectAttributes.addFlashAttribute("traerId", usuario.get().getId());
		redirectAttributes.addFlashAttribute("traerNombre", usuario.get().getNombre());
		redirectAttributes.addFlashAttribute("traerPassword", usuario.get().getPassword());
		redirectAttributes.addFlashAttribute("traerEmail", usuario.get().getEmail());
		return "redirect:/usuarios/";
	}
	@RequestMapping("/usuarios/editar")
	public String editar(@RequestParam(value="nombreEdit")String nombreBack,
			@RequestParam(value="passwordEdit")String passwordBack,
			@RequestParam(value="emailEdit")String emailBack,
			@RequestParam(value="IdEdit")Long IdBack) {

		Usuario usuario = new Usuario();
		usuario.setId(IdBack);
		usuario.setNombre(nombreBack);
		usuario.setPassword(passwordBack);
		usuario.setEmail(emailBack);
		
		usuario = usuarioService.editarUsuario(usuario);
		
		return "redirect:/usuarios";
	}
}