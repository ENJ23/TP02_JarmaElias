package ar.edu.unju.fi.ejecicio01.main;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.ejecicio01.model.Producto;
import ar.edu.unju.fi.ejecicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejecicio01.model.Producto.origenFabricacion;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <Producto> listado = new ArrayList<Producto>();
		
		Producto prod01 = new Producto("p01", "caracteristica p01", 23.4, origenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS);
		Producto prod02 = new Producto(null, null, null, null, null);
		prod02.setCategoria(Categoria.HERRAMIENTAS);
		prod02.setOrigenFabricacion(origenFabricacion.BRASIL);
		prod02.setDescripcion("p02");
		prod02.setCodigo("p02");
		prod02.setPrecioU(2345.234);
		listado.add (prod01);
		listado.add (prod02);
		
		
	}

}
