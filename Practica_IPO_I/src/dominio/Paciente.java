package dominio;

public class Paciente extends Persona {
	public Paciente(String nombre, String apellidos, String password,
			String dni, String sexo, String email, String fechaNacimiento,
			int telefono, String direccion, String poblacion, String codPostal,
			String mutua, String fechaAlta, String numTarjeta) {
		super(nombre, apellidos, password, dni, sexo, email, fechaNacimiento,
				telefono, direccion, poblacion, codPostal);
		this.mutua = mutua;
		this.fechaAlta = fechaAlta;
		this.numTarjeta = numTarjeta;
	}
	private String mutua;
	private String fechaAlta;
	private String numTarjeta;
	public String getMutua() {
		return mutua;
	}
	public void setMutua(String mutua) {
		this.mutua = mutua;
	}
	public String getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public String getNumTarjeta() {
		return numTarjeta;
	}
	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

}
