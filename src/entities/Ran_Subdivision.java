package entities;

public class Ran_Subdivision {

	private String nombreRangoSub;
	private int idSub, idRanSub;
	
	public int getIdRanSub() {
		return idRanSub;
	}
	public void setIdRanSub(int idRanSub) {
		this.idRanSub = idRanSub;
	}
	public String getNombreRangoSub() {
		return nombreRangoSub;
	}
	public void setNombreRangoSub(String nombreRangoSub) {
		this.nombreRangoSub = nombreRangoSub;
	}
	public int getIdSub() {
		return idSub;
	}
	public void setIdSub(int idSub) {
		this.idSub = idSub;
	}
	@Override
	public String toString() {
		return "Ran_Subdivision [nombreRangoSub=" + nombreRangoSub + ", idSub=" + idSub + ", idRanSub=" + idRanSub
				+ "]";
	}
}
