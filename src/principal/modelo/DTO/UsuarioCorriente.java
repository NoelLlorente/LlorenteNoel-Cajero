package principal.modelo.DTO;

public class UsuarioCorriente extends UsuarioDTO{
	private int tipo;
	public UsuarioCorriente(String dni, String nombre, String apellidos, String fecha_nacimiento, String telefono,String direccion) {
		super(dni, nombre, apellidos, fecha_nacimiento, telefono, direccion);
		this.tipo = 1;
	}

}
