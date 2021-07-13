package entities;

public class Integrante {

	private int idIntegrante;
	private String nombre, apellido, steamHex, discordId;
	
	public Integrante() {
		
	}

	public Integrante(int idIntegrante, String nombre, String apellido, String steamHex, String discordId) {
		super();
		this.idIntegrante = idIntegrante;
		this.nombre = nombre;
		this.apellido = apellido;
		this.steamHex = steamHex;
		this.discordId = discordId;
	}

	public int getIdIntegrante() {
		return idIntegrante;
	}

	public void setIdIntegrante(int idIntegrante) {
		this.idIntegrante = idIntegrante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSteamHex() {
		return steamHex;
	}

	public void setSteamHex(String steamHex) {
		this.steamHex = steamHex;
	}

	public String getDiscordId() {
		return discordId;
	}

	public void setDiscordId(String discordId) {
		this.discordId = discordId;
	}
	
	
}
