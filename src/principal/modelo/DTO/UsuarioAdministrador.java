package principal.modelo.DTO;

public class UsuarioAdministrador extends UsuarioDTO{
	/**
	 * Clase UsuarioAdministrador que hereda de UsuarioDTO
	 * @author Noel
	 *
	 */
	
	public UsuarioAdministrador(String dni, String nombre, String apellidos, String fecha_nacimiento, String telefono, String direccion, TarjetaDTO tarjeta) {
		super(dni, nombre, apellidos, fecha_nacimiento, telefono, direccion, tarjeta);

	}
	
	public UsuarioAdministrador() {
		
	}
}
