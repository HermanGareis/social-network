package datos;

import java.io.*;
import java.util.Properties;


public class CargarParametros {

	private static String archivoUsuario;
	private static String archivoRelaciones;
	private static String idiomaApp;

	  /** 
	   * Lee el archivo .config y carga los atributos.
	   */
	public static void parametros() throws IOException {

		Properties prop = new Properties();
		//"C:\\Users\\USUARIO\\eclipse-workspace\\TP9-2022\\config.properties
		InputStream input = new FileInputStream("config.properties");
		// load a properties file
		prop.load(input);
		// get the property value
		archivoUsuario = prop.getProperty("usuario");
		archivoRelaciones = prop.getProperty("relaciones");
		idiomaApp = prop.getProperty("language");
	}

	  /**
	   * Retorna el archivo de usuarios del .config.
	   * @return archivo.
	   */
	public static String getArchivoUsuario() {
		return archivoUsuario;
	}
	
	  /**
	   * Retorna el archivo de relaciones del .config.
	   * @return archivo.
	   */
	public static String getArchivoRelaciones() {
		return archivoRelaciones;
	}
	
	  /**
	   * Retorna lenguaje de la app del .config.
	   * @return lenguaje.
	   */
	public static String getLanguage() {
		return idiomaApp;
	}

}
