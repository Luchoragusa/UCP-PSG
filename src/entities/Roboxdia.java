package entities;

import java.time.*;

public class Roboxdia {

	private LocalTime hora_robo;
	private LocalDate fecha_robo;
	private int idIntegrante, idLugarRobo;
	private String resultado;
	
	public Roboxdia() {
		
	}

	public LocalTime getHora_robo() {
		return hora_robo;
	}

	public void setHora_robo(LocalTime hora_robo) {
		this.hora_robo = hora_robo;
	}

	public LocalDate getFecha_robo() {
		return fecha_robo;
	}

	public void setFecha_robo(LocalDate fecha_robo) {
		this.fecha_robo = fecha_robo;
	}

	public int getIdIntegrante() {
		return idIntegrante;
	}

	public void setIdIntegrante(int idIntegrante) {
		this.idIntegrante = idIntegrante;
	}

	public int getIdLugarRobo() {
		return idLugarRobo;
	}

	public void setIdLugarRobo(int idLugarRobo) {
		this.idLugarRobo = idLugarRobo;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
}
