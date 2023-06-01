package principal.modelo.DTO;

import java.util.ArrayList;

public class CuentaDTO {
	/**
	 * Clase CuentaDTO en la cual se declarán los atributos de las cuentas
	 * @author Noel
	 *
	 */
	private String num_cuenta;
	private String nombre;
	private double saldo;
	private ArrayList<HistorialDTO>operaciones;
	
	public CuentaDTO(String num_cuenta, String nombre, double saldo, ArrayList<HistorialDTO>operaciones) {
		this.num_cuenta = num_cuenta;
		this.nombre = nombre;
		this.saldo = saldo;
		this.operaciones = operaciones;
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

	public ArrayList<HistorialDTO> getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(ArrayList<HistorialDTO> operaciones) {
		this.operaciones = operaciones;
	}

	@Override
	public String toString() {
		return "CuentaDTO [num_cuenta=" + num_cuenta + ", nombre=" + nombre + ", saldo=" + saldo + ", operaciones="
				+ operaciones + "]";
	}

	
	
	
	
}
