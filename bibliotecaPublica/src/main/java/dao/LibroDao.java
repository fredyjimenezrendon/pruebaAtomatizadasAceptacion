package dao;

import java.util.ArrayList;
import java.util.List;

import model.Libro;

public class LibroDao {
	
	public List<Libro> getLibrosPorFechaDePublicacion(String fechaDesde, String fechaHasta){
		
		List<Libro> listaLibros = new ArrayList<Libro>();
		
		Libro libro1 = new Libro();
		libro1.setTitulo("Algebra lineal");
		libro1.setAnio(2013);
		
		Libro libro2 = new Libro();
		libro2.setTitulo("Calculo II");
		libro2.setAnio(2013);
		
		listaLibros.add(libro1);
		listaLibros.add(libro2);
		
		return listaLibros;
	}

}
