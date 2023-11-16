package Clases;
/*
 * POO 2 Semestre
 * Facultad de Ingenieria
 * Departamento de Ciencias de la Computacion
 * Fecha inicio: 12/11/2023
 * Fecha final: 15/11/2023
 *
 * @author Vianka Castro 23201
 * 
 * El propósito de esta interfaz controladora es lograr crear todos 
 * los métodos principales las cuales son implementadas dependiendo 
 * de lo que es requerido. Interactuar con el usuario. 
 *  
 */

public interface IReserva {
	
	
	
	public usuario login(String user, String pass);
	
	
	public void registroUsuario(String user, String pass, String tipo);
	
	
	public void cambiarPassword(String newPass);
	
	
	public void cambiarTipoUsuario();
	
	
	public void reservacion(String pfehca, boolean ptipo, int cantBoletos, String aerolinea, String username);
	
	
	public void confirmacion(String numTarjeta, int pcuotas, String claseVuelo, String numAsiento, int cantMaletas);
	
	
	public void itinerario();
	
	
	public void guardarUsuario();
	
	
	public void leerUsuario();
	
	
	public void leerReserva();
	
	
	public void guardarReserva();


}
