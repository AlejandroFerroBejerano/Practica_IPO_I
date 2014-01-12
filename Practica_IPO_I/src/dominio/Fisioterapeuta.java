package Dominio;

public class Fisioterapeuta extends Persona{
	private long numColegiado;
	private String fechaAlta;
	private long numCuenta;
	private String user;
	private String password;
	public Fisioterapeuta(String nombre, String apellidos,
			String dni, String sexo, String email, String fechaNacimiento,
			String telefono, String direccion, String poblacion, String codPostal,
			long numColegiado, String fechaAlta, long numCuenta, String user, String password) {
		super(nombre, apellidos, dni, sexo, email, fechaNacimiento,
				telefono, direccion, poblacion, codPostal);
		this.numColegiado = numColegiado;
		this.fechaAlta = fechaAlta;
		this.numCuenta = numCuenta;
		this.setUser(user);
		this.setPassword(password);
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
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
