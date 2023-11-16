package Clases;
/*
 * POO 2 Semestre
 * Facultad de Ingenieria
 * Departamento de Ciencias de la Computacion
 * Fecha inicio: 12/11/2023
 * Fecha final: 12/11/2023
 *
 * @author Vianka Castro 23201
 * 
 *El propósito de esta clase es representar información básica para 
 *un usuario y obtener todos sus valores planteados y necesarios.  
 */

public class usuario {
	
	
	private String user;
	private String pass;
	private String tipo;
	private boolean logeado;
	
	
	public boolean isLogeado() {
		return logeado;
	}



	public void setLogeado(boolean logeado) {
		this.logeado = logeado;
	}



	@Override
	public String toString() {
		return "usuario [user=" + user + ", pass=" + pass + ", tipo=" + tipo + "]";
	}

	
	
	public usuario() {
		user = "";
		pass = "";
		tipo = "";
	}
	
	public usuario(String user, String pass, String tipo) {
		super();
		this.user = user;
		this.pass = pass;
		this.tipo = tipo;
	}




	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	

}
