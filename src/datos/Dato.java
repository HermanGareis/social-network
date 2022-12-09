package datos;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import modelo.Relacion;
import modelo.Usuario;
import net.datastructures.*;


public class Dato {

	  /**
	   * Carga un mapa con usuarios a partir de un archivo de texto.
	   * @param archivo de usuarios 
	   * @return mapa de usuarios.
	   */
	
	public static TreeMap<String, Usuario> cargarUsuarios(String fileName) throws FileNotFoundException {
		Scanner read;

		TreeMap<String, Usuario> usuarios = new TreeMap<String, Usuario>();
		
		read = new Scanner(new File(fileName));
		read.useDelimiter("\\s*;\\s*");
		String codigo, nombre, genero, ciudad;
		Integer edad;
		
		while (read.hasNext()) {
			codigo = read.next();
			nombre = read.next();
			edad = Integer.valueOf(read.next());
			genero = read.next();
			ciudad = read.next();
			
			usuarios.put(codigo, new Usuario(codigo,nombre,edad,genero,ciudad));
		}
		read.close();
	

	return usuarios;
	}
	
	
	  /**
	   * Crea una lista de relaciones.
	   * @param archivo de relaciones
	   * @param mapa de usuarios
	   * @return mapa de usuarios.
	   */
	public static List<Relacion> cargarRelaciones(String fileName, TreeMap<String, Usuario> usuarios) throws FileNotFoundException {
		Scanner read;
		List<Relacion> relaciones = new ArrayList<Relacion>();
		
		read = new Scanner(new File(fileName));
		read.useDelimiter("\\s*;\\s*");
		Usuario u1, u2;
		int tiempo;

		while (read.hasNext()) {
			u1 = usuarios.get(read.next());
			u2 = usuarios.get(read.next());
			tiempo = Integer.valueOf(read.next()); 
			relaciones.add(0, new Relacion(u1, u2, tiempo));

		}
		read.close();
	

	return relaciones;
	}
	
	
}
