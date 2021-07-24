package entities;

public class Sancion {

	private int idIntegrante;
	private String motivo, tipoSancion;
	
	public Sancion() {
		
	}

	public int getIdIntegrante() {
		return idIntegrante;
	}

	public void setIdIntegrante(int idIntegrante) {
		this.idIntegrante = idIntegrante;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getTipoSancion() {
		return tipoSancion;
	}

	public void setTipoSancion(String tipoSancion) {
		this.tipoSancion = tipoSancion;
	}

	@Override
	public String toString() {
		return "Sancion [idIntegrante=" + idIntegrante + ", motivo=" + motivo + ", tipoSancion=" + tipoSancion + "]";
	}
	
}
