package principal.modelo.DTO;

public class UsuarioAdministrador extends UsuarioDTO{
	private int tipo;
	
	public UsuarioAdministrador(String dni, String nombre, String apellidos, String fecha_nacimiento, String telefono, String direccion) {
		super(dni, nombre, apellidos, fecha_nacimiento, telefono, direccion);
		this.tipo = 2;
	}

	
	
	
}
