package modelo;

public class Relacion {
	private Usuario usuario1;
	private Usuario usuario2;
	private int tiempo;
	
	public Relacion(Usuario usuario1, Usuario usuario2, int tiempo) {
		super();
		this.usuario1 = usuario1;
		this.usuario2 = usuario2;
		this.tiempo = tiempo;
	}

	public Usuario getUsuario1() {
		return usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}
	
	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

		
	
	
	public String toString() {
		return " [" + usuario1.getCodigo() + ", " + usuario2.getCodigo() + "]";
	}
	
	public boolean equals(Relacion r) {
		if((this.getUsuario1().equals(r.getUsuario1())) && (this.getUsuario2().equals(r.getUsuario2())))
			return true;
		if((this.getUsuario2().equals(r.getUsuario1())) && (this.getUsuario1().equals(r.getUsuario2())))
			return true;
		
		return false;
	}
}
