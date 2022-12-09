package aplicacion;

import java.io.FileNotFoundException;
import java.io.IOException;

import datos.CargarParametros;
import datos.Dato;
import interfaz.Interfaz;
import logica.Calculo;
import modelo.Relacion;
import modelo.Usuario;
import net.datastructures.List;
import net.datastructures.TreeMap;



/**
 * @author Gareis F. Nehuen
 */
public class Aplicacion {

	static boolean DIRECTED = false;

	public static void main(String[] args) {

		// leo del archivo de configuraciones los parametros usados al iniciar la
		// aplicacion
		try {
			CargarParametros.parametros();
		} catch (IOException e) {
			Interfaz.displayErrorMessage("Error al cargar parámetros");
			System.exit(-1);
		}

		// cargo el contenido del archivo al mapa "usuarios"
		TreeMap<String, Usuario> usuarios = null;
		List<Relacion> relaciones = null;

		String languageApp = null;
		try {
			usuarios = Dato.cargarUsuarios(CargarParametros.getArchivoUsuario());
			relaciones = Dato.cargarRelaciones(CargarParametros.getArchivoRelaciones(), usuarios);
			languageApp = CargarParametros.getLanguage();

		} catch (FileNotFoundException e) {
			Interfaz.displayErrorMessage("Error al cargar archivos de datos");
			System.exit(-1);
		}

		Interfaz.displayLanguage(languageApp);
		
		Calculo c = new Calculo(usuarios, relaciones);

		for(;;) {
			int opcion = Interfaz.opcion();

			// Realizar cálculo

			switch (opcion) {
			case 1:
				Interfaz.displayGradoPromedio(c.grado());
				break;
			case 2:
				Usuario u1, u2;
				Interfaz.displayUsers(usuarios);
				u1 = Interfaz.getUser1(usuarios);
				u2 = Interfaz.getUser2(usuarios);
				try {
					Interfaz.displayCaminoMasCorto(c.antiguedad(u1, u2), u1.getNombre(), u2.getNombre());
				} catch (NullPointerException e) {
					Interfaz.displayErrorMessage("Usuario no válido");
				}
				break;
			case 3:
				Interfaz.displayCentralidad(c.centralidad(usuarios));
				break;
			case 4:				
				System.exit(1);
				break;
			default:
				Interfaz.displayErrorMessage("Opción no válida");
				break;

			}
		}		
	}
}
