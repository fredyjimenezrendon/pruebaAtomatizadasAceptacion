package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.LibroDao;
import model.Libro;

public class BusquedaLibrosServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fechaDesde = request.getParameter("fechaDesde");
		String fechaHasta = request.getParameter("fechaHasta");
		
		List<Libro> librosResultado = new LibroDao().getLibrosPorFechaDePublicacion(fechaDesde, fechaHasta);
		String json = new Gson().toJson(librosResultado);
		
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}

}
