package ar.edu.unju.fi.tp6.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp6.service.IProductoService;
import ar.edu.unju.fi.tp6.model.Producto;
import ar.edu.unju.fi.tp6.model.Cliente;
import ar.edu.unju.fi.tp6.service.IClienteService;
@Controller
public class MainController {
	@Autowired
	@Qualifier("clienteUtilService")
	private IClienteService clienteService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@GetMapping("/home")
	public String getIndex(Model model) {
		model.addAttribute(model);
		return "index";
	}
	
	@GetMapping("/cliente/nuevo")
	public String getNuevoClientePage(Model model) {
		model.addAttribute(clienteService.getCliente());
		return "nuevo-cliente";
	}
	@PostMapping("/cliente/guardar")
	public String proccesFormCliente(Model model, @ModelAttribute("cliente") Cliente unCliente) {
		long edad = ChronoUnit.YEARS.between(unCliente.getFechaNacimiento(), LocalDate.now());
		unCliente.setEdad((int)edad);
		clienteService.addCliente(unCliente);
		model.addAttribute(clienteService.getCliente());
		this.getNuevoClientePage(model);
		return "resultado-cliente";
	}
	@GetMapping("/cliente/listado")
	public ModelAndView getClientesPage() {
		ModelAndView model = new ModelAndView("table-clientes");
		if (clienteService.getClientes()==null) {
			clienteService.generateTableClientes();
		}
		model.addObject("clientes",clienteService.getClientes());
		return model;
	}
	/*
	 * 
	 */
	@GetMapping("/producto/nuevo")
	public String getNuevoPage(Model model) {
		model.addAttribute(productoService.getProducto());
		return "nuevo-producto";
	}
	
	@PostMapping("/producto/guardar")
	public String proccesForm(@ModelAttribute("producto") Producto unProducto) {
		productoService.addProducto(unProducto);
		return "resultado-producto";
	}
	
	@GetMapping("/producto/ultimo")
	public ModelAndView getUltimoProductoPage() {
		ModelAndView modelView = new ModelAndView("ultimo-producto");
		
		  if (productoService.listaProductos().isEmpty()) { 
			  Producto primero = new Producto(0, null, 0, null, 0);
			  productoService.addProducto(primero);
		  }
		 
		modelView.addObject("producto", productoService.getUltimoProducto());
		return modelView;
	}
}
