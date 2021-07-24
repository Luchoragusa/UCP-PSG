package entities;

import java.time.*;

public class Med_integrante {

	private int idMedalla, idIntegrante;
	private String recompensa;
	private LocalDate fecha_recompensa;
	
	public Med_integrante() {
		
	}

	public int getIdMedalla() {
		return idMedalla;
	}

	public void setIdMedalla(int idMedalla) {
		this.idMedalla = idMedalla;
	}

	public int getIdIntegrante() {
		return idIntegrante;
	}

	public void setIdIntegrante(int idIntegrante) {
		this.idIntegrante = idIntegrante;
	}

	public String getRecompensa() {
		return recompensa;
	}

	public void setRecompensa(String recompensa) {
		this.recompensa = recompensa;
	}

	public LocalDate getFecha_recompensa() {
		return fecha_recompensa;
	}

	public void setFecha_recompensa(LocalDate fecha_recompensa) {
		this.fecha_recompensa = fecha_recompensa;
	}

	@Override
	public String toString() {
		return "Med_integrante [idMedalla=" + idMedalla + ", idIntegrante=" + idIntegrante + ", recompensa="
				+ recompensa + ", fecha_recompensa=" + fecha_recompensa + "]";
	}
	
}
