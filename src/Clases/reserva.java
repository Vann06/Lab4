package Clases;

public class reserva {
	
	private String fechaVuelo;
	private boolean tipoVuelo;
	private int cantidadBoletos;
	private String aerolinea;
	private String usuario;
	private String numeroTarjeta;
	private int cuotas;
	private String claseVuelo;
	private String numeroAsiento;
	private int cantidadMaletas;
	
	
	
	
	@Override
	public String toString() {
		return "reserva [fechaVuelo=" + fechaVuelo + ", tipoVuelo=" + tipoVuelo + ", cantidadBoletos=" + cantidadBoletos
				+ ", aerolinea=" + aerolinea + ", usuario=" + usuario + ", numeroTarjeta=" + numeroTarjeta + ", cuotas="
				+ cuotas + ", claseVuelo=" + claseVuelo + ", numeroAsiento=" + numeroAsiento + ", cantidadMaletas="
				+ cantidadMaletas + "]";
	}

	
	public reserva() {
		fechaVuelo = "";
		tipoVuelo = true;
		cantidadBoletos = 0;
		aerolinea = "";
		usuario = "";
		numeroTarjeta = "";
		cuotas = 0;
		claseVuelo = "";
		numeroAsiento = "";
		cantidadMaletas = 0;
	}
	
	
	public reserva(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea, String usuario,
			String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsiento, int cantidadMaletas) {
		super();
		this.fechaVuelo = fechaVuelo;
		this.tipoVuelo = tipoVuelo;
		this.cantidadBoletos = cantidadBoletos;
		this.aerolinea = aerolinea;
		this.usuario = usuario;
		this.numeroTarjeta = numeroTarjeta;
		this.cuotas = cuotas;
		this.claseVuelo = claseVuelo;
		this.numeroAsiento = numeroAsiento;
		this.cantidadMaletas = cantidadMaletas;
	}
	
	
	public String getFechaVuelo() {
		return fechaVuelo;
	}
	public void setFechaVuelo(String fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}
	public boolean isTipoVuelo() {
		return tipoVuelo;
	}
	public void setTipoVuelo(boolean tipoVuelo) {
		this.tipoVuelo = tipoVuelo;
	}
	public int getCantidadBoletos() {
		return cantidadBoletos;
	}
	public void setCantidadBoletos(int cantidadBoletos) {
		this.cantidadBoletos = cantidadBoletos;
	}
	public String getAerolinea() {
		return aerolinea;
	}
	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public int getCuotas() {
		return cuotas;
	}
	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}
	public String getClaseVuelo() {
		return claseVuelo;
	}
	public void setClaseVuelo(String claseVuelo) {
		this.claseVuelo = claseVuelo;
	}
	public String getNumeroAsiento() {
		return numeroAsiento;
	}
	public void setNumeroAsiento(String numeroAsiento) {
		this.numeroAsiento = numeroAsiento;
	}
	public int getCantidadMaletas() {
		return cantidadMaletas;
	}
	public void setCantidadMaletas(int cantidadMaletas) {
		this.cantidadMaletas = cantidadMaletas;
	}
	
	

}
