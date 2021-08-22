package entities;
import java.time.*;

public class Horas 
{
	private int idIntegrante;
	private LocalTime horaInicio, horaFin;
	private LocalDate fecha;
	
	public Horas () {
		
	}
	public Horas(int idIntegrante, LocalTime horaInicio, LocalTime horaFin, LocalDate fecha) {
		super();
		this.idIntegrante = idIntegrante;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.fecha = fecha;
	}
	
	public int getIdIntegrante() {
		return idIntegrante;
	}
	public void setIdIntegrante(int idIntegrante) {
		this.idIntegrante = idIntegrante;
	}
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	public LocalTime getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}
	@Override
	public String toString() {
		return "Horas [idIntegrante=" + idIntegrante + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin
				+ ", fecha=" + fecha + "]";
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

}
