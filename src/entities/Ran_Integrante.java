package entities;

import java.time.LocalDate;

public class Ran_Integrante {
	private int idRango, idIntegrante;
	private LocalDate fecha_desde;
	
	public Ran_Integrante() {
		
	}

	public Ran_Integrante(int idRango, int idIntegrante, LocalDate fecha_desde) {
		super();
		this.idRango = idRango;
		this.idIntegrante = idIntegrante;
		this.fecha_desde = fecha_desde;
	}

	public int getIdRango() {
		return idRango;
	}

	public void setIdRango(int idRango) {
		this.idRango = idRango;
	}

	public int getIdIntegrante() {
		return idIntegrante;
	}

	public void setIdIntegrante(int idIntegrante) {
		this.idIntegrante = idIntegrante;
	}

	public LocalDate getFecha_desde() {
		return fecha_desde;
	}

	@Override
	public String toString() {
		return "Ran_Integrante [idRango=" + idRango + ", idIntegrante=" + idIntegrante + ", fecha_desde=" + fecha_desde
				+ "]";
	}

	public void setFecha_desde(LocalDate fecha_desde) {
		this.fecha_desde = fecha_desde;
	}
}
