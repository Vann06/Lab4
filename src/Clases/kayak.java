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
 * En kayak será la clase controladora para manejar los requisitos 
 * funcionales del sistema. Se crearán arreglos de las clases que se van a utilizar.
 *  
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;

//import classes.Archivo;

public class kayak implements IReserva {
	
	
	private static ArrayList<usuario> usuarios;
	private static ArrayList<reserva> reservas;
	private archivo usuariosCSV;
	private archivo reservasCSV;
    private archivo archivo;

	
	public kayak() {
		usuarios = new ArrayList<usuario>();
		reservas = new ArrayList<reserva>();
		usuariosCSV = new archivo("usuarios.csv");
		reservasCSV = new archivo("reservas.csv");
		
	}
	
	usuario userActual = new usuario();
	reserva reservaActual = new reserva();
	
	
	
	/**
	 * Valida para iniciar sesión con las credenciales proporcionadas.
	 * 
	 * @param puser El nombre de usuario.
	 * @param pass La contraseña del usuario.
	 * @return Un objeto de tipo usuario que representa al usuario actual después de iniciar sesión.
	 *         Si la autenticación falla, se devuelve un usuario con el estado de inicio de sesión falso.
	 */
	@Override
	public usuario login(String puser, String pass) {
		
		pr("Iniciar Sesion ");
		
		//leer csv y validar user y  pass
		//guardarUsuario();
		leerUsuario();
		pr("tamanio " + usuarios.size());
		
		if(usuarios != null) {
		for(usuario us: usuarios) {
			if(puser.equals(us.getUser().toString()) && pass.equals(us.getPass().toString())){
				//pr("usuario "+ us.getUser());
				//pr("usuario "+ us.getPass());
				userActual.setLogeado(true);
				userActual.setTipo(us.getTipo());
				pr("Se ha iniciado sesion con exito!");
				userActual.setUser(puser);
				userActual.setPass(pass);
				pr(userActual + " ");
				//break;
			}else {
				pr("Usuario o Contrasena no encontrados!");
			}
			
			}
		}else {
			pr("Usuario o Contrasena no encontrados!");
		}
		return userActual;
	}


	/**
	 * Registra un nuevo usuario con las credenciales proporcionadas y lo almacena en la lista de usuarios.
	 * Además, actualiza el usuario actual con la información del nuevo usuario registrado.
	 * 
	 * @param user El nombre de usuario para el nuevo usuario.
	 * @param pass La contraseña para el nuevo usuario.
	 * @param tipo El tipo de usuario (puede ser administrador, cliente, etc.).
	 */
	@Override
	public void registroUsuario(String user, String pass, String tipo) {
		// TODO Auto-generated method stub		
		
		usuario usuario = new usuario(user, pass, tipo);
		usuarios.add(usuario);
		userActual.setUser(user);
		userActual.setPass(pass);
		userActual.setTipo(tipo);
		pr("usuarios" + usuarios);
		
		try {
			usuariosCSV.escribirUsuario(usuarios);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	/**
	 * Cambia la contraseña del usuario actual a la nueva contraseña especificada.
	 * 
	 * @param newPass La nueva contraseña que se asignará al usuario actual.
	 */
	@Override
	public void cambiarPassword(String newPass) {
		// TODO Auto-generated method stub
		pr("El nuevo pass es "+newPass);
		pr("tamanio " + usuarios.size());
		
		pr("cambiando contraseña...");
		pr("usuario: " + userActual);
		
		for(usuario us:usuarios) {
			if(userActual.getUser().equals(us.getUser())) {
				pr("user " + userActual.getPass());
				
				userActual.setPass(newPass);
				pr("despues " + userActual);
				pr("Contrasena cambiada con exito!");
				break;
			}
			else {
				pr("peto :(");
			}
		}
		
	}

	/**
	 * Cambia el tipo de usuario actual de "BASE" a "VIP" si es posible.
	 * Si el tipo de usuario actual no es "BASE", se muestra un mensaje indicando que no se puede cambiar.
	 */
	@Override
	public void cambiarTipoUsuario() {
		if(userActual.getTipo().equals("BASE")){
			pr("user antes" + userActual.getTipo());
			for(usuario us: usuarios) {
				if(us.getUser().equals(userActual.getUser())) {
					us.setTipo("VIP");
					
				}else {
					pr("Usuario no encontrado!");
				}
				
			}
			pr("user " + userActual.getTipo());
			pr("" + userActual);
			
			pr("Se ha cambiado su tipo de usuario con exito!");
		}
		else {
			pr("No se puede cambiar su plan");
		}
	}


	/**
	 * Crea una nueva reserva con la información proporcionada y la agrega a la lista de reservas.
	 * 
	 * @param pfecha La fecha del vuelo para la reserva.
	 * @param ptipo El tipo de vuelo (true para vuelo nacional, false para vuelo internacional).
	 * @param cantBoletos La cantidad de boletos que se están reservando.
	 * @param aerolinea El nombre de la aerolínea para la reserva.
	 * @param username El nombre de usuario asociado a la reserva.
	 */
	@Override
	public void reservacion(String pfecha, boolean ptipo, int cantBoletos, String aerolinea, String username) {
		// TODO Auto-generated method stub
		this.reservaActual.setFechaVuelo(pfecha);
		this.reservaActual.setTipoVuelo(ptipo);
		this.reservaActual.setCantidadBoletos(cantBoletos);
		this.reservaActual.setAerolinea(aerolinea);
		this.reservaActual.setUsuario(username);
		//pr("Se ha creado una reserva con exito!");
		//pr(" reserva " + reservaActual);
		
		reservas.add(reservaActual);
		pr("reservas en totales " + reservas);
		try {
			reservasCSV.escribirReserva(reservas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pr("Se ha creado una reserva con exito!");
	}



	/**
	 * Completa la confirmación de una reserva con la información proporcionada y actualiza la lista de reservas.
	 * 
	 * @param numTarjeta El número de tarjeta de crédito asociado a la confirmación.
	 * @param pcuotas El número de cuotas para el pago.
	 * @param claseVuelo La clase de vuelo seleccionada para la confirmación.
	 * @param numAsiento El número de asiento seleccionado para la confirmación.
	 * @param cantMaletas La cantidad de maletas incluidas en la confirmación.
	 */
	@Override
	public void confirmacion(String numTarjeta, int pcuotas, String claseVuelo, String numAsiento, int cantMaletas) {
		// TODO Auto-generated method stub
		reservaActual.setNumeroTarjeta(numTarjeta);
		reservaActual.setCuotas(pcuotas);
		reservaActual.setClaseVuelo(claseVuelo);
		reservaActual.setNumeroAsiento(numAsiento);
		reservaActual.setCantidadMaletas(cantMaletas);
		pr("Se ha creado una confirmacion con exito!");
		pr(" reserva " + reservaActual);
		
		
		
		try {
			reservasCSV.escribirReserva(reservas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	/**
	 * Muestra el itinerario de vuelo del usuario actual, incluyendo información sobre la reserva.
	 * La información se imprime en la consola y se actualiza en la lista de reservas del csv.
	 */
	@Override
	public void itinerario() {
		// TODO Auto-generated method stub
		pr(" **** A continuacion de muetra su itinerario de vuelo ****");
		pr("Usuario " +    userActual.getUser());
		pr("Reserva echa por: " + reservaActual.getUsuario());
		pr("" + reservaActual.toString());
		
		try {
			reservasCSV.escribirReserva(reservas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	/**
	 * Guarda la lista de usuarios en un archivo CSV para su persistencia.
	 * La información se guarda en el archivo correspondiente y se imprime en la consola.
	 */
	@Override
	public void guardarUsuario() {
		// TODO Auto-generated method stub
		try {	
			usuariosCSV.escribirUsuario(usuarios);
			pr("pls " + usuarios);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	/**
	 * Lee la información de usuarios desde un archivo CSV y actualiza la lista de usuarios.
	 * Si el archivo no se encuentra, se maneja la excepción correspondiente.
	 */
	@Override
	public void leerUsuario() {
		// TODO Auto-generated method stub
		try {
			usuarios = usuariosCSV.leerUsuarios();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Lee la información de reservas desde un archivo CSV y actualiza la lista de reservas.
	 * Si el archivo no se encuentra, se maneja la excepción correspondiente.
	 */
	@Override
	public void leerReserva() {
		// TODO Auto-generated method stub
		try {
			reservas = reservasCSV.leerReserva();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * Guarda la lista de reservas en un archivo CSV para su persistencia.
	 * La información se guarda en el archivo correspondiente y se manejan posibles excepciones.
	 */
	@Override
	public void guardarReserva() {
		// TODO Auto-generated method stub
		try {
			reservasCSV.escribirReserva(reservas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 /**
	  * Método privado utilizado para imprimir un mensaje en la consola.
	  *
	  * Este método imprime el mensaje proporcionado como parámetro en la consola estándar.
	  * Se utiliza para simplificar la impresión de mensajes en varias partes del código.
	  *
	  * @param x El mensaje que se desea imprimir en la consola.
	  */
	 private static void pr(String x) {
			System.out.println(x);
		}

	

}
