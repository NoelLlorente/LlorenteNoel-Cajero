package principal.modelo;

public interface Consultas {
	
	public static final String BUSCAR_PIN = "select aes_decrypt(unhex(pin), 'admin') from tarjeta where dni_usuario=?";
	public static final String TIPO_USR = "select tipo_usuario from usuario where dni=?";

	public static final String CARGAR_USR = "select * from usuario where dni=?";
	public static final String CARGAR_TARJETA = "SELECT id, aes_decrypt(unhex(pin), 'admin') AS pin, cvv, fecha_caducidad FROM tarjeta WHERE dni_usuario = ?";
	public static final String CARGAR_CUENTA = "SELECT * FROM cuenta c INNER JOIN tarjeta_cuenta tc ON c.id = tc.id_cuenta WHERE tc.id_tarjeta = ?";
	public static final String CARGAR_CAJERO = "select * from cajero";
	public static final String ACTUALIZAR_PIN = "update tarjeta set pin = hex(aes_encrypt(?, 'admin')) where id=?";
	public static final String INGRESAR_SALDO = "update cuenta set saldo=saldo+? where id=?";
	public static final String ACTUALIZAR_SALDO_CAJERO = "update cajero set saldo=?";
	public static final String CARGAR_HISTORIAL_CUENTA="SELECT * FROM historial_cuenta WHERE id_cuenta = ?";
	public static final String INSERTAR_HISTORIAL = "INSERT INTO historial_cuenta (id_cuenta, id_operacion, fecha, hora, descripcion) VALUES (?, ?, ?, ?, ?)";
	public static final String RETIRAR_SALDO = "update cuenta set saldo=saldo-? where id=?";
	public static final String LISTAR_USUARIOS= "select * from usuario";
	public static final String FILTRAR_USR_DNI = "select * from usuario where dni=";
	public static final String FILTRAR_USR_NOMBRE = "select * from usuario where nombre=";
	public static final String FILTRAR_USR_APELLIDOS = "select * from usuario where apellidos=";
	public static final String FILTRAR_USR_FECHA = "select * from usuario where fecha_nac=";
	public static final String FILTRAR_USR_TELF = "select * from usuario where telefono=";
	public static final String FILTRAR_USR_DIR = "select * from usuario where direccion=";
	public static final String FILTRAR_USR_TIPO = "select * from usuario where tipo_usuario=";
	public static final String MODIFICAR_USR = "update usuario set nombre=?, apellidos=?, fecha_nac=?, telefono=?, direccion=?, tipo_usuario=? where dni=?";
	public static final String ELIMINAR_USR = "delete from usuario where dni=?";
	public static final String INSERTAR_USR = "insert into usuario values(?,?,?,?,?,?,?)";
	
}
