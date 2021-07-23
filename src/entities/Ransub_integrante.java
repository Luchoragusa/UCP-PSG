package entities;

import java.time.LocalDate;

public class Ransub_integrante 
{
	private int idIntegrante, idRangoSub;
	private LocalDate fecha_desde;
	
	public int getIdIntegrante() {
		return idIntegrante;
	}
	public void setIdIntegrante(int idIntegrante) {
		this.idIntegrante = idIntegrante;
	}
	public int getIdRangoSub() {
		return idRangoSub;
	}
	public void setIdRangoSub(int idRangoSub) {
		this.idRangoSub = idRangoSub;
	}
	public LocalDate getFecha_desde() {
		return fecha_desde;
	}
	public void setFecha_desde(LocalDate fecha_desde) {
		this.fecha_desde = fecha_desde;
	}
}
