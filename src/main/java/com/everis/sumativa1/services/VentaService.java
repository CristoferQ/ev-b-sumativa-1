package com.everis.sumativa1.services;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.sumativa1.models.Venta;
import com.everis.sumativa1.repositories.VentaRepository;

@Service
public class VentaService {
	@Autowired
	VentaRepository ventaRepository;
	
	@PostConstruct
	public void añadirVentasBase() {
		Venta venta1 = new Venta("Celular", 3, 450000);
		Venta venta2 = new Venta("Notebook", 2, 900000);
		Venta venta3 = new Venta("Impresora", 3, 360000);
		ventaRepository.save(venta1);
		ventaRepository.save(venta2);
		ventaRepository.save(venta3);
	}
	public Venta añadirVenta(Venta venta) {
		return ventaRepository.save(venta);
	}
	public List<Venta> traerVentas() {
		return ventaRepository.findAll();
	}
	public void eliminarVenta(Long id) {
		ventaRepository.deleteById(id);
	}
	public Optional<Venta> traerVenta(Long id) {
		return ventaRepository.findById(id);
	}
	public Venta editarVenta(Venta venta) {
		return ventaRepository.save(venta);
	}
	
}
