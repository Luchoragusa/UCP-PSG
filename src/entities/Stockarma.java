package entities;

import java.time.*;

public class Stockarma {

	private LocalDate fecha;
	private int idArma, cantidad;
	
	public Stockarma() {
		
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getIdArma() {
		return idArma;
	}

	public void setIdArma(int idArma) {
		this.idArma = idArma;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Stockarma [fecha=" + fecha + ", idArma=" + idArma + ", cantidad=" + cantidad + "]";
	}
	
}
