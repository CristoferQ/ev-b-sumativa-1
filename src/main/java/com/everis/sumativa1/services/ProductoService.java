package com.everis.sumativa1.services;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.sumativa1.models.Producto;
import com.everis.sumativa1.models.Usuario;
import com.everis.sumativa1.repositories.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	ProductoRepository productoRepository;
	
	@PostConstruct
	public void añadirUsuariosBase() {
		Producto producto1= new Producto("31A1239N", "Celular", 150000);
		Producto producto2 = new Producto("AOSDK923", "Notebook", 450000);
		Producto producto3 = new Producto("10239JS", "Impresora", 120000);
		productoRepository.save(producto1);
		productoRepository.save(producto2);
		productoRepository.save(producto3);
	}
	public Producto añadirProducto(Producto producto) {
		return productoRepository.save(producto);
	}
	public List<Producto> traerProductos() {
		return productoRepository.findAll();
	}
	public void eliminarProducto(Long id) {
		productoRepository.deleteById(id);
	}
	public Optional<Producto> traerProducto(Long id) {
		return productoRepository.findById(id);
	}
	public Producto editarProducto(Producto producto) {
		return productoRepository.save(producto);
	}
}
