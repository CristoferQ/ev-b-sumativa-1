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

import com.everis.sumativa1.models.Venta;
import com.everis.sumativa1.services.VentaService;

@Controller
public class VentaController {
	@Autowired
	VentaService ventaService;
	
	@RequestMapping("/ventas")
	public String ventas(Model model) {
		List<Venta> ventasLista = ventaService.traerVentas();
		model.addAttribute("ventasLIST", ventasLista);
		
		return "ventas.jsp";
	}
	@RequestMapping("/ventas/agregar")
	public String agregar(@RequestParam(value="productoForm")String productoBack,
			@RequestParam(value="cantidadForm")int cantidadBack,
			@RequestParam(value="totalForm")int totalBack) {
		
		Venta venta = new Venta();
		venta.setProducto(productoBack);
		venta.setCantidad(cantidadBack);
		venta.setTotal(totalBack);
		
		venta = ventaService.añadirVenta(venta);
		
		return "redirect:/ventas";
	}
	@RequestMapping("/ventas/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		ventaService.eliminarVenta(id);
		return "redirect:/ventas";
	}
	@RequestMapping("/ventas/traer/{id}")
	public String traer(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {	
		Optional<Venta> venta = ventaService.traerVenta(id);
		redirectAttributes.addFlashAttribute("traerId", venta.get().getId());
		redirectAttributes.addFlashAttribute("traerProducto", venta.get().getProducto());
		redirectAttributes.addFlashAttribute("traerCantidad", venta.get().getCantidad());
		redirectAttributes.addFlashAttribute("traerTotal", venta.get().getTotal());
		return "redirect:/ventas/";
	}
	@RequestMapping("/ventas/editar")
	public String editar(@RequestParam(value="productoEdit")String productoBack,
			@RequestParam(value="cantidadEdit")int cantidadBack,
			@RequestParam(value="totalEdit")int totalBack,
			@RequestParam(value="IdEdit")Long IdBack) {

		Venta venta = new Venta();
		venta.setId(IdBack);
		venta.setProducto(productoBack);
		venta.setCantidad(cantidadBack);
		venta.setTotal(totalBack);
		
		venta = ventaService.editarVenta(venta);
		
		return "redirect:/ventas";
	}
}