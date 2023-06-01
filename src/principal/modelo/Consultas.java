package principal.modelo;

public interface Consultas {
	/**
	 * 
	 * @author Noel
	 *Es una interfaz con todas las consultas que realizaremos a la base de datos
	 */
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
	public static final String LISTAR_TARJETAS= "select * from tarjeta";
	public static final String FILTRAR_TARJETA_ID= "select * from tarjeta where id=";
	public static final String FILTRAR_TARJETA_CVV= "select * from tarjeta where cvv=";
	public static final String FILTRAR_TARJETA_FECHA= "select * from tarjeta where fecha_caducidad=";
	public static final String FILTRAR_TARJETA_DNI= "select * from tarjeta where dni_usuario=";
	public static final String VALIDAR_TARJETA_USR= "select id, dni_usuario from tarjeta where dni_usuario=?";
	public static final String MODIFICAR_TARJETA = "update tarjeta set pin=hex(aes_encrypt(?, 'admin')), cvv=?, fecha_caducidad=?, dni_usuario=? where id=?";
	public static final String MODIFICAR_TARJETA_PINCIF = "update tarjeta set pin=?, cvv=?, fecha_caducidad=?, dni_usuario=? where id=?";
	public static final String ELIMINAR_TARJETA = "delete from tarjeta where id=?";
	public static final String INSERTAR_TARJETA = "insert into tarjeta values(?,hex(aes_encrypt(?,'admin')),?,?,?)";
	public static final String SALDO_CAJERO = "select saldo from cajero where id=1";
	public static final String LISTAR_CUENTAS = "select c.id,c.nombre,c.saldo, tc.id_tarjeta from cuenta c inner join tarjeta_cuenta tc on c.id=tc.id_cuenta";
	public static final String FILTRAR_CUENTA_ID= "select c.id,c.nombre,c.saldo, tc.id_tarjeta from cuenta c inner join tarjeta_cuenta tc on c.id=tc.id_cuenta where c.id=";
	public static final String FILTRAR_CUENTA_NOMBRE= "select c.id,c.nombre,c.saldo, tc.id_tarjeta from cuenta c inner join tarjeta_cuenta tc on c.id=tc.id_cuenta where c.nombre=";
	public static final String FILTRAR_CUENTA_SALDO= "select c.id,c.nombre,c.saldo, tc.id_tarjeta from cuenta c inner join tarjeta_cuenta tc on c.id=tc.id_cuenta where c.saldo=";
	public static final String FILTRAR_CUENTA_ID_TARJETA= "select c.id,c.nombre,c.saldo, tc.id_tarjeta from cuenta c inner join tarjeta_cuenta tc on c.id=tc.id_cuenta where tc.id_tarjeta=";
	public static final String MODIFICAR_CUENTA = "update cuenta c inner join tarjeta_cuenta tc on c.id=tc.id_cuenta set c.nombre=?, c.saldo=?, tc.id_tarjeta=? where c.id=?";
	public static final String ELIMINAR_CUENTA = "delete from cuenta where id=?";
	public static final String INSERTAR_CUENTA = "insert into cuenta values(?,?,?)";
	public static final String INSERTAR_TARJETA_CUENTA = "insert into tarjeta_cuenta (id_cuenta, id_tarjeta) values (?,?)";
	public static final String ID_TARJETA = "select * from tarjeta where id=?";
	public static final String LISTAR_HISTORIAL = "select * from historial_cuenta where id_cuenta=";
	public static final String FILTRAR_HISTORIAL_ID = "select * from historial_cuenta where id=";
	public static final String FILTRAR_HISTORIAL_FECHA = "select * from historial_cuenta where fecha=";
	public static final String FILTRAR_HISTORIAL_HORA = "select * from historial_cuenta where hora=";
	public static final String FILTRAR_HISTORIAL_DESCRIPCION = "select * from historial_cuenta where descripcion=";
	public static final String ELIMINAR_FILA_HISTORIAL = "delete from historial_cuenta where id=?";
	public static final String VACIAR_HISTORIAL = "delete from historial_cuenta";
	public static final String PIN_CIFRADO = "select pin from tarjeta where id=?";
}
