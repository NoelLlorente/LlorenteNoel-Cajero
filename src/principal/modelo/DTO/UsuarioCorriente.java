package principal.modelo.DTO;


public class UsuarioCorriente extends UsuarioDTO{
	/**
	 * 
	 * @author Noel
	 *Clase UsuarioCorriente que hereda de UsuarioDTO
	 */
	
	public UsuarioCorriente(String dni, String nombre, String apellidos, String fecha_nacimiento, String telefono, String direccion, TarjetaDTO tarjeta) {
		super(dni, nombre, apellidos, fecha_nacimiento, telefono, direccion, tarjeta);
	}

	
	public UsuarioCorriente() {
		
	}
}
