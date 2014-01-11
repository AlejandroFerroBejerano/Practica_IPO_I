package dominio;

public class Fisioterapeuta extends Persona{
	private long numColegiado;
	private String fechaAlta;
	private long numCuenta;
	public Fisioterapeuta(String nombre, String apellidos, String password,
			String dni, String sexo, String email, String fechaNacimiento,
			int telefono, String direccion, String poblacion, String codPostal,
			long numColegiado, String fechaAlta, long numCuenta) {
		super(nombre, apellidos, password, dni, sexo, email, fechaNacimiento,
				telefono, direccion, poblacion, codPostal);
		this.numColegiado = numColegiado;
		this.fechaAlta = fechaAlta;
		this.numCuenta = numCuenta;
	}
	public long getNumColegiado() {
		return numColegiado;
	}
	public void setNumColegiado(long numColegiado) {
		this.numColegiado = numColegiado;
	}
	public String getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public long getNumCuenta() {
		return numCuenta;
	}
	public void setNumCuenta(long numCuenta) {
		this.numCuenta = numCuenta;
	}
	
}
