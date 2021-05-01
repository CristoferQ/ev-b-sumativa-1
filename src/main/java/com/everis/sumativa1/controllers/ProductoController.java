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

import com.everis.sumativa1.models.Producto;
import com.everis.sumativa1.services.ProductoService;

@Controller
public class ProductoController {
	@Autowired
	ProductoService productoService;
	
	@RequestMapping("/productos")
	public String productos(Model model) {
		List<Producto> productosLista = productoService.traerProductos();
		model.addAttribute("productosLIST", productosLista);
		
		return "productos.jsp";
	}
	@RequestMapping("/productos/agregar")
	public String agregar(@RequestParam(value="codigoForm")String codigoBack,
			@RequestParam(value="nombreForm")String nombreBack,
			@RequestParam(value="precioForm")int precioBack) {
		
		Producto producto = new Producto();
		producto.setCodigo(codigoBack);
		producto.setNombre(nombreBack);
		producto.setPrecio(precioBack);
		
		producto= productoService.añadirProducto(producto);
		
		return "redirect:/productos";
	}
	@RequestMapping("/productos/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		productoService.eliminarProducto(id);
		return "redirect:/productos";
	}
	@RequestMapping("/productos/traer/{id}")
	public String traer(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {	
		Optional<Producto> producto = productoService.traerProducto(id);
		redirectAttributes.addFlashAttribute("traerId", producto.get().getId());
		redirectAttributes.addFlashAttribute("traerCodigo", producto.get().getCodigo());
		redirectAttributes.addFlashAttribute("traerNombre", producto.get().getNombre());
		redirectAttributes.addFlashAttribute("traerPrecio", producto.get().getPrecio());
		return "redirect:/productos/";
	}
	@RequestMapping("/productos/editar")
	public String editar(@RequestParam(value="codigoEdit")String codigoBack,
			@RequestParam(value="nombreEdit")String nombreBack,
			@RequestParam(value="precioEdit")int precioBack,
			@RequestParam(value="IdEdit")Long IdBack) {

		Producto producto = new Producto();
		producto.setId(IdBack);
		producto.setCodigo(codigoBack);
		producto.setNombre(nombreBack);
		producto.setPrecio(precioBack);
		
		producto = productoService.editarProducto(producto);
		
		return "redirect:/productos";
	}
}
