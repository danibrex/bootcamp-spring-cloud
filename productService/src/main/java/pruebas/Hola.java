package pruebas;

public class Hola {
	
	private final long id;
	private final String contenido;
	
	public Hola(long id, String contenido) {
		this.id = id;
		this.contenido = contenido;
	}

	public long getId() {
		return id;
	}

	public String getContenido() {
		return contenido;
	}
	
}
