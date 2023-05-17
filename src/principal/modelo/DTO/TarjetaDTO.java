package principal.modelo.DTO;

import java.util.ArrayList;

/**
 * Clase TarjetaDTO en la cual se declarán los atributos de las tarjetas
 * @author Noel
 *
 */
public class TarjetaDTO {
	private String num_tarjeta;
	private String pin;
	private String cvv;
	private String fecha_caducidad;
	private ArrayList<CuentaDTO> cuenta;
	
	public TarjetaDTO(String num_tarjeta, String pin, String cvv, String fecha_caducidad, ArrayList<CuentaDTO> cuenta) {
		this.num_tarjeta = num_tarjeta;
		this.pin = pin;
		this.cvv = cvv;
		this.fecha_caducidad = fecha_caducidad;
		this.cuenta = cuenta;
	}
	
	public TarjetaDTO() {
		
	}

	public String getNum_tarjeta() {
		return num_tarjeta;
	}

	public void setNum_tarjeta(String num_tarjeta) {
		this.num_tarjeta = num_tarjeta;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getFecha_caducidad() {
		return fecha_caducidad;
	}

	public void setFecha_caducidad(String fecha_caducidad) {
		this.fecha_caducidad = fecha_caducidad;
	}

	public ArrayList<CuentaDTO> getCuenta() {
		return cuenta;
	}

	public void setCuenta(ArrayList<CuentaDTO> cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "TarjetaDTO [num_tarjeta=" + num_tarjeta + ", pin=" + pin + ", cvv=" + cvv + ", fecha_caducidad="
				+ fecha_caducidad + ", cuenta=" + cuenta + "]";
	}


	
	
	
	
}
