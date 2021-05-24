package ar.edu.unju.fi.tp6.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp6.model.Producto;
import ar.edu.unju.fi.tp6.repository.IProductoRepository;
import ar.edu.unju.fi.tp6.service.IProductoService;

@Service("productoServiceMysql")
public class ProductoServiceMysqlImp implements IProductoService{
	
	@Autowired
	IProductoRepository productoRepository;
	
	@Autowired
	Producto producto;

	@Override
	public void addProducto(Producto producto) {
		// TODO Auto-generated method stub
		productoRepository.save(producto);
	}

	@Override
	public Producto getUltimoProducto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto getProducto() {
		// TODO Auto-generated method stub
		return producto;
	}

	@Override
	public List<Producto> listaProductos() {
		// TODO Auto-generated method stub
		List<Producto> productos = productoRepository.findAll();
		return productos;
	}

	@Override
	public void eliminarProducto(Long codigo) {
		// TODO Auto-generated method stub
		productoRepository.deleteById(codigo);
	}

	@Override
	public Optional<Producto> getProducto(Long codigo){
		return productoRepository.findById(codigo);
	}
}
