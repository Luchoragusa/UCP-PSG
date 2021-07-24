package entities;

public class Robo {

	private int idLugarRobo, minIntregantes, maxIntegrantes;
	public int getMinIntregantes() {
		return minIntregantes;
	}

	public void setMinIntregantes(int minIntregantes) {
		this.minIntregantes = minIntregantes;
	}

	public int getMaxIntegrantes() {
		return maxIntegrantes;
	}

	public void setMaxIntegrantes(int maxIntegrantes) {
		this.maxIntegrantes = maxIntegrantes;
	}

	private String nomRobo, lugarRobo;
	
	public Robo() {
		
	}

	public int getIdLugarRobo() {
		return idLugarRobo;
	}

	public void setIdLugarRobo(int idLugarRobo) {
		this.idLugarRobo = idLugarRobo;
	}

	public String getNomRobo() {
		return nomRobo;
	}

	public void setNomRobo(String nomRobo) {
		this.nomRobo = nomRobo;
	}

	public String getLugarRobo() {
		return lugarRobo;
	}

	public void setLugarRobo(String lugarRobo) {
		this.lugarRobo = lugarRobo;
	}

	@Override
	public String toString() {
		return "Robo [idLugarRobo=" + idLugarRobo + ", minIntregantes=" + minIntregantes + ", maxIntegrantes="
				+ maxIntegrantes + ", nomRobo=" + nomRobo + ", lugarRobo=" + lugarRobo + "]";
	}
}
