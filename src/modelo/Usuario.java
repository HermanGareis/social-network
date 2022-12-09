package modelo;

public class Usuario {
	//ID, Nombre, Edad, Género y Ciudad donde vive
	private String codigo;
	private String nombre;
	private int edad;
	private String genero;
	private String ciudad;
	
	
	public Usuario(String codigo, String nombre, int edad, String genero, String ciudad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;	
		this.edad = edad;
		this.genero = genero;
		this.ciudad = ciudad;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String toString() {
		return "["+ codigo + ", " + nombre + ", " + edad + ", " + genero + ", " + ciudad + "]";
	}
	

	public boolean equals(Usuario u) {
		if(this.getCodigo() == u.getCodigo())
			return true;
		return false;
	}
	
	
	
}
