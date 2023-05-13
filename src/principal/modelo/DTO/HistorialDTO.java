package principal.modelo.DTO;

public class HistorialDTO {
	private int id_operacion;
	private String fecha;
	private String hora;
	private String descripcion;
	
	
	
	public HistorialDTO(int id_operacion, String fecha, String hora, String descripcion) {
		this.id_operacion = id_operacion;
		this.fecha = fecha;
		this.hora = hora;
		this.descripcion = descripcion;
	}

	public HistorialDTO() {
	
	}

	public int getId_operacion() {
		return id_operacion;
	}

	public void setId_operacion(int id_operacion) {
		this.id_operacion = id_operacion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "HistorialDTO [id_operacion=" + id_operacion + ", fecha=" + fecha + ", hora=" + hora + ", descripcion="
				+ descripcion + "]";
	}
	

	
	
	
}
