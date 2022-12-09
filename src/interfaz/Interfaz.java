package interfaz;

import modelo.Relacion;
import modelo.Usuario;
import net.datastructures.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Interfaz {
	
	 static Scanner entry = new Scanner(System.in);
	 
	
	 /**
	 * Imprime las opciones y recibe input del usuario.
	 * @return input del usuario.
	 */
	public static int opcion() {
		int opcion = 0;
		System.out.println("Ingrese: "
				+ "\n 1-Para calcular grado promedio del grafo."
				+ "\n 2-Para calcular el camino mas corto entre 2 usuarios."
				+ "\n 3-Para calcular la centralidad del grafo "
				+ "\n 4-Para cerrar el programa");
		
		try {
		opcion = entry.nextInt();
		}catch(InputMismatchException e) {
			displayErrorMessage("Formato inválido. El programa se cerrará.");
			return 4;
		}
		return opcion;
	}
	
	/**
	* Imprime el lenguaje de la app.
	* @param lenguaje.
	*/
	public static void displayLanguage(String s) {System.out.println("App seteada en: " + s );System.out.println();}	
	
	/**
	* Imprime mensaje de error.
	* @param mensaje.
	*/
	public static void displayErrorMessage(String s) {System.err.println(s);System.out.println();}
	
	/**
	* Imprime lista de usuarios cargados.
	* @param mapa de usuarios.
	*/
	public static void displayUsers(TreeMap<String, Usuario> usuarios) {
		System.out.println("Usuarios cargados: ");
		for (Entry<String, Usuario> users : usuarios.entrySet())
			System.out.println(users.getValue());
		System.out.println();
	}
	
	/**
	* Imprime mensaje y solicita al usuario elegir el primer usuario.
	* @param mapa de usuarios.
	* @return usuario.
	*/
	public static Usuario getUser1(TreeMap<String, Usuario> usuarios) {
		String s;
		
		System.out.println("Ingrese codigo del usuario 1: ");
		
		s = entry.next();
		
		return usuarios.get(s);	
	}
	
	/**
	* Imprime mensaje y solicita al usuario elegir el segundo usuario.
	* @param mapa de usuarios.
	* @return usuario.
	*/
	public static Usuario getUser2(TreeMap<String, Usuario> usuarios) {
		String s;
		
		System.out.println("Ingrese codigo del usuario 2: ");
		
		s = entry.next();
		
		return usuarios.get(s);	
	}
	
	/**
	* Imprime el grado promedio del grafo.
	* @param grado.
	*/
	public static void displayGradoPromedio(int grado) {System.out.println("El grado promedio del grafo es: " + grado);System.out.println();}
	
	/**
	* Imprime el camino mas corto entre dos usuarios.
	* @param lista de relaciones.
	* @param nombre del usuario 1.
	* @param nombre del usuario 2.
	*/
	public static void displayCaminoMasCorto(List<Relacion> relaciones, String u1, String u2) {
		int peso = 0;
		
		System.out.println("Camino entre "+ u1 + " y " + u2 + ": ");
		for(Relacion r : relaciones) {
			peso += r.getTiempo();
			System.out.print(r.toString() + " ");
		}
		System.out.println();
		System.out.println("Peso total: " + peso);
		System.out.println();
	}
	
	/**
	* Imprime los usuarios separandolos por cantidad de conexiones.
	* @param mapa de listas de usuarios.
	*/
	public static void displayCentralidad(TreeMap<Integer, List<Usuario>> centralidad) {
		for (Entry<Integer, List<Usuario>> f : centralidad.entrySet()) {
			System.out.println("Tienen " + f.getKey() + " conexiones los usuarios: " + f.getValue().toString() + "\n");
		}
		
	}
}
