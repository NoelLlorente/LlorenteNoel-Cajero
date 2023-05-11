package principal.modelo.DTO;

public class CuentaDTO {
	private String num_cuenta;
	private String nombre;
	private double saldo;
	public CuentaDTO(String num_cuenta, String nombre, double saldo) {
		super();
		this.num_cuenta = num_cuenta;
		this.nombre = nombre;
		this.saldo = saldo;
	}
	
public CuentaDTO() {
		
	}
	
	public String getNum_cuenta() {
		return num_cuenta;
	}
	public void setNum_cuenta(String num_cuenta) {
		this.num_cuenta = num_cuenta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "CuentaDTO [num_cuenta=" + num_cuenta + ", nombre=" + nombre + ", saldo=" + saldo + "]";
	}
	
	
	
}
