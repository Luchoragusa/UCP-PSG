package entities;
import java.time.*;

public class Horas 
{
	private int idIntegrante;
	private LocalTime horaInicio, horaFin, horasJugadas;
	private LocalDate fecha, fechaFin;
	
	public Horas () {
		
	}
	public Horas(int idIntegrante, LocalTime horaInicio, LocalTime horaFin, LocalDate fecha, LocalDate fechaFin, LocalTime horasJugadas) {
		super();
		this.idIntegrante = idIntegrante;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.fecha = fecha;
		this.fechaFin = fechaFin;
		this.horasJugadas = horasJugadas;
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
				+ ", fecha=" + fecha + ", fechaFin=" + fechaFin + "]";
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	public LocalTime getHorasJugadas() {
		return horasJugadas;
	}
	public void setHorasJugadas(LocalTime horasJugadas) {
		this.horasJugadas = horasJugadas;
	}

}
