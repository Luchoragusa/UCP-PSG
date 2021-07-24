package entities;

public class Rango {

	private int idRango;
	private String nomRango;
	
	public Rango () {
		
	}

	public int getIdRango() {
		return idRango;
	}

	public void setIdRango(int idRango) {
		this.idRango = idRango;
	}

	public String getNomRango() {
		return nomRango;
	}

	public void setNomRango(String nomRango) {
		this.nomRango = nomRango;
	}

	@Override
	public String toString() {
		return "Rango [idRango=" + idRango + ", nomRango=" + nomRango + "]";
	}
}
