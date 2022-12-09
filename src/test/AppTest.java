package test;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import datos.CargarParametros;
import datos.Dato;
import logica.Calculo;
import net.datastructures.*;
import modelo.*;

class AppTest {
	TreeMap<String, Usuario> usuarios = new TreeMap<String, Usuario>();
	List<Relacion> relaciones = new ArrayList<Relacion>();
	Calculo c;
	String languageApp;

	@Before
	void before() {

		try {
			CargarParametros.parametros();
		} catch (IOException e) {
			System.err.print("Error al cargar parámetros");
			System.exit(-1);
		}

		try {
			usuarios = Dato.cargarUsuarios(CargarParametros.getArchivoUsuario());
			relaciones = Dato.cargarRelaciones(CargarParametros.getArchivoRelaciones(), usuarios);
			languageApp = CargarParametros.getLanguage();

		} catch (FileNotFoundException e) {
			System.err.print("Error al cargar archivos de datos");
			System.exit(-1);
		}
		c = new Calculo(usuarios, relaciones);

	}

	@Test
	void test1() {
		assertTrue(c.grado() == 3);
	}
	
	
	@Test
	void test2() {
		List<Relacion> res = c.antiguedad(usuarios.get("1"), usuarios.get("10"));
		int i = 0;
		for(Relacion r : res) {
			i += r.getTiempo();
		}
		assertTrue(i == 54);
	}
}
