package principal.modelo;

public interface Consultas {
	
	public static final String BUSCAR_PIN = "select aes_decrypt(unhex(pin), 'admin') from tarjeta where dni_usuario=?";
	public static final String TIPO_USR = "select tipo_usuario from usuario where dni=?";
	public static final String CARGAR_USR = "select * from usuario";
	public static final String CARGAR_TARJETA = "SELECT id, aes_decrypt(unhex(pin), 'admin') AS pin, cvv, fecha_caducidad FROM tarjeta WHERE dni_usuario = ?";
	public static final String CARGAR_CUENTA = "SELECT * FROM cuenta c INNER JOIN tarjeta_cuenta tc ON c.id = tc.id_cuenta WHERE tc.id_tarjeta = ?";
	public static final String CARGAR_CAJERO = "select * from cajero";
}
