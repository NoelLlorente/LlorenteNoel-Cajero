package principal.modelo.DTO;

public class CajeroDTO {
	/**
	 * Clase CajeroDTO en la cual se declarán los atributos del cajero
	 * @author Noel
	 *
	 */
	
	private int num_cajero;
	private double saldo;
	
	public CajeroDTO(int num_cajero, double saldo) {
		this.num_cajero = num_cajero;
		this.saldo = saldo;
	}
	
	public CajeroDTO() {
		
	}


	public int getNum_cajero() {
		return num_cajero;
	}

	public void setNum_cajero(int num_cajero) {
		this.num_cajero = num_cajero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "CajeroDTO [num_cajero=" + num_cajero + ", saldo=" + saldo + "]";
	}
	
	
	
	
}
