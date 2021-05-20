package ar.edu.unju.fi.tp6.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp6.model.Compra;
import ar.edu.unju.fi.tp6.model.Producto;
import ar.edu.unju.fi.tp6.service.ICompraService;
import ar.edu.unju.fi.tp6.service.IProductoService;

@Controller
public class CompraController {
	@Autowired
	@Qualifier("compraUtilService")
	private ICompraService compraService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	List<Producto> productos = new ArrayList<>();
	
	@GetMapping("/compra/nuevo")
	public ModelAndView getNuevaCompraPage(Model model) {
		this.productos=productoService.listaProductos();
		model.addAttribute(compraService.getCompra());
		ModelAndView modelo = new ModelAndView("nueva-compra");
		  modelo.addObject("productos", productos);
		 
		return modelo;
	}
	
	@PostMapping("/compra/guardar")
	public String proccesFormCompra(Model model, @ModelAttribute("compra") Compra unaCompra) {
		Producto aux = new Producto();
		for (Producto producto : productos) {
			if (unaCompra.getProducto().getCodigo()==producto.getCodigo()) {
				aux=producto;
			}
		}
		unaCompra.setProducto(aux);
		compraService.addCompra(unaCompra);
		/*
		 * model.addAttribute(compraService.getCompra());
		 * this.getNuevaCompraPage(model);
		 */
		return "resultado-compra";
	}
	
	@GetMapping("/compra/lista")
	public ModelAndView getListaComprasPage() {
		ModelAndView modelView = new ModelAndView("listacompras");
		modelView.addObject("compras", compraService.getCompras());
		
		return modelView;
	}
}
