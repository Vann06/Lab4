package Clases;

import java.util.Scanner;

public class main {
	/*
	 * POO 2 Semestre
	 * Facultad de Ingenieria
	 * Departamento de Ciencias de la Computacion
	 * Fecha inicio: 12/11/2023
	 * Fecha final: 15/11/2023
	 *
	 * @author Vianka Castro 23201
	 * 
	 * El propósito de esta clase es mostrar e interactuar con el usuario. 
	 *  
	 */
	
	private static kayak kaya;
    private static Scanner scanner = new Scanner(System.in);
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		kaya = new kayak();
		menuPrincipal();	
	}

	/**
	 * Muestra el Menú Principal y gestiona las opciones seleccionadas por el usuario.
	 * Las opciones incluyen iniciar sesión, crear cuenta y salir del programa.
	 * El usuario puede ingresar la opción deseada, y se gestionan posibles excepciones.
	 */
	private static void menuPrincipal(){
		int opcion = 0;
		
		do {
			 pr("\n*******  Bienvenido al Menú Principal *******");
	         pr("1. Iniciar Sesión");
	         pr("2. Crear Cuenta");
	         pr("3. Salir");
	         pr("Ingrese la opción:");
	         
	         opcion = scanner.nextInt();
	         scanner.nextLine();
	         
	         try {
	        	 switch(opcion) {
	        	 	case 1: 
	        	 		iniciarSesion();
	        	 		break;
	        	 	case 2:
	        	 		crearCuenta();
	        	 		break;
	        	 	case 3:
	        	 		pr("Gracias por entrar al menu!");
	        	 		break;
	        	 	default:
	        	 		pr("opcion invalida");
	        	 }//swtitch
	        	 
			
		}catch(Exception e) {
			pr("Ocurrio un Error " + e.getMessage());
			scanner.nextLine();
		}
		
		
	}while(opcion !=3)	;

}//menu main
	
	/**
	 * Inicia sesión solicitando al usuario ingresar sus credenciales.
	 * Después de la autenticación, redirige al usuario a un menú específico según su tipo (VIP o BASE).
	 * En caso de credenciales incorrectas o errores, se manejan las excepciones correspondientes.
	 */
	private static void iniciarSesion() {
		pr("Opción 1 - Iniciar Sesión");
		
        pr("Ingrese sus Credenciales : ");
        pr("Usuario --> ");
        String user = scanner.nextLine();
        pr("Contraseña --> ");
        String pass = scanner.nextLine();

        try {
            usuario ruser = kaya.login(user, pass);
            if (ruser.isLogeado()) {
                if (ruser.getTipo().equals("VIP")) {
                    menuVip();
                } else if (ruser.getTipo().equals("BASE")) {
                    menuBase();
                }
            } else {
                pr("Credenciales incorrectas.");
            }
        } catch (Exception e) {
            pr("Error: " + e.getMessage());
        }
		
	}//inicarsesion
	
	/**
	 * Crea una nueva cuenta solicitando al usuario ingresar nuevas credenciales y el tipo de usuario.
	 * Después de la creación exitosa, redirige al usuario a un menú específico según su tipo (VIP o BASE).
	 * En caso de error en la elección del tipo de usuario, se proporciona un mensaje y se vuelve al Menú Principal.
	 */
	private static void crearCuenta() {
		 pr("Opción 2 - Crear Cuenta");
		 
		 
        pr("Ingrese sus Nuevas Credenciales : ");
        pr("Usuario --> ");
        String newUser = scanner.nextLine();
        pr("Contraseña --> ");
        String newPass = scanner.nextLine();
        pr("Tipo de Usuario (VIP o BASE)");
       
        String newTipo = scanner.nextLine().toUpperCase();
        //scanner.nextLine();
        if(newTipo.equals("VIP") || newTipo.equals("BASE")) {
        	kaya.registroUsuario(newUser, newPass, newTipo);
        	pr("Cuenta Creada con exito!!");
        	pr("Puede Ingresar a su Cuenta");
        	if (newTipo.equals("VIP")) {
                    menuVip();
                } else if (newTipo.equals("BASE")) {
                    menuBase();
                }
        	}else {
            	pr("No ingreso correctamente el tipo de usuario");
            	menuPrincipal();
        	}
        }
     
	
	/**
	 * Muestra el Menú VIP y gestiona las opciones seleccionadas por un usuario VIP.
	 * Las opciones incluyen reservar vuelo, confirmar vuelo, cambiar contraseña y salir/cerrar sesión.
	 * El usuario puede ingresar la opción deseada, y se gestionan posibles excepciones.
	 */
	private static void menuVip() {
		int opcion;
		Scanner in = new Scanner(System.in);

		
		do {
			 pr("\n*******  Bienvenido al Menú VIP *******");
	         pr("1. Reservar Vuelo");
	         pr("2. Confirmar Vuelo");
	         pr("3. Cambiar Contraseña");
	         pr("4. Salir-Cerrar Sesión");
	         pr("Ingrese la opción:");

	         opcion = scanner.nextInt();
	         scanner.nextLine(); 
	            
	         try {
	           switch(opcion) {
	            	case 1: 
	            		pr("Reservar Vuelo");
	            		pr("Define la fecha del viaje -->");
	            		String fecha = in.nextLine();
	            		pr("Defina si es 1. Ida y Vuelta 2. Solo ida ");
	            		int opcion1 = in.nextInt();
	            		boolean vuelo = true;//set boolean
	            		in.nextLine();
	            		if(opcion1 == 1) {
	            			 vuelo = true;
	            		}else if(opcion1 == 2) {
	            			 vuelo = false;
	            		}else {
	            			pr("Opcion invalida");
	            			menuVip();
	            		}
	            		pr("Defina cantidad de boletos");
	            		int boletos = in.nextInt();
	            		in.nextLine();
	            		pr("Defina aerolinea");
	            		String aerolinea = in.nextLine();
	            		
	            		pr("Escriba su nombre de confirmacion");
	            		String nombre = in.nextLine();
	            		kaya.reservacion(fecha,vuelo, boletos, aerolinea, nombre);
	            		break;
	            	case 2:
	            		pr("Confirmar Vuelo");
	            		
	            		pr("Defina el numero de tarjeta -->");
	            		String tarjeta = in.nextLine();
	            		
	            		pr("Selecciona numero de asiento --> ");
	            		String asiento = in.nextLine();
	            		//in.nextLine();
	            		pr("Defina cantidad de maletas --> ");
	            		int maletas = in.nextInt();
	            		in.nextLine();
	            		pr("A continuacion se imprime el itinerario");
	            		kaya.confirmacion(tarjeta,0,"Primera Clase",asiento,maletas);
	            		kaya.itinerario();
	            		
	           			break;
	           		case 3:
	           			pr("Cambiar Contrasena");
	           			pr("Ingrese la nueva contrasena -->");
	           			//scanner.nextLine(); 
	        	  		String nuevoPass = in.nextLine();
	           			kaya.cambiarPassword(nuevoPass);
	           			break;
	           		case 4:
	           			pr("Saliendo de Cuenta...");
	           		
	           			return;
	           		 default:
	                    pr("Opción no válida. Inténtelo de nuevo.");
	           	}
	            	
	           }catch(Exception e) {
                pr("Error: " + e.getMessage());
                scanner.nextLine();
	            }

		} while (opcion != 4);
		
	}
	
	/**
	 * Muestra el Menú Base y gestiona las opciones seleccionadas por un usuario de tipo BASE.
	 * Las opciones incluyen reservar vuelo, confirmar vuelo, cambiar contraseña, modificar tipo de cliente,
	 * aplicar cupón y salir/cerrar sesión. El usuario puede ingresar la opción deseada, y se gestionan posibles excepciones.
	 */
	private static void menuBase() {
		
		int opcion;
		//boolean salir = false;
		Scanner in = new Scanner(System.in);
		
		do {
			  pr("\n*******  Bienvenido al Menú Base *******");
	          pr("1. Reservar Vuelo");
	          pr("2. Confirmar Vuelo");
	          pr("3. Cambiar Contraseña");
	          pr("4. Modificar tipo Cliente");
	          pr("5. Aplicar cupon");
	          pr("6. Salir-Cerrar Sesión");
	          pr("Ingrese la opción:");

	          opcion = scanner.nextInt();
	          scanner.nextLine(); 
	          
	          try {
	        	  switch(opcion) {
	        	  	case 1: 
	   
	        	  		pr("Reservar Vuelo");
	            		pr("Define la fecha del viaje -->");
	            		String fecha = in.nextLine();
	            		pr("Defina si es 1. Ida y Vuelta 2. Solo ida ");
	            		int opcion1 = in.nextInt();
	            		boolean vuelo = true;//set boolean
	            		in.nextLine();
	            		if(opcion1 == 1) {
	            			 vuelo = true;
	            		}else if(opcion1 == 2) {
	            			 vuelo = false;
	            		}else {
	            			pr("Opcion invalida");
	            			menuVip();
	            		}
	            		pr("Defina cantidad de boletos");
	            		int boletos = in.nextInt();
	            		in.nextLine();
	            		pr("Defina aerolinea");
	            		String aerolinea = in.nextLine();
	            		
	            		pr("Escriba su nombre de confirmacion");
	            		String nombre = in.nextLine();
	            		kaya.reservacion(fecha,vuelo, boletos, aerolinea, nombre);
	            		break;
	      
	        	  	case 2:
	        			pr("Confirmar Vuelo");

	            		pr("Defina el numero de tarjeta -->");
	            		String tarjeta = in.nextLine();
	            		
	            		pr("Defina cantidad de cuotas --> ");
	            		int cuotas = in.nextInt();
	            		in.nextLine();
	            		
	            		pr("Defina clase de vuelo 1.Coach 2.Primera Clase");
	            		int opcion2 = in.nextInt();
	            		in.nextLine();
	            		String claseVuelo = "";
	            		if(opcion2 == 1) {
	            			claseVuelo = "Coach";
	            		}else if(opcion2 == 2) {
	            			claseVuelo = "Primera Clase";
	            		}else {
	            			pr("Opcion invalida, intente de nuevo!");
	            			menuBase();
	            		}
	            		
	            		pr("Selecciona numero de asiento --> ");
	            		String asiento = in.nextLine();
	            		//in.nextLine();
	            		
	            		pr("A continuacion se imprime el itinerario");
	            		kaya.confirmacion(tarjeta,cuotas,claseVuelo,asiento,1);
	            		kaya.itinerario();
	            		
	        	  		break;
	        	  		
	        	  	case 3:
	        	  		pr("Cambiar Contrasena");
	        	  		pr("Ingrese la nueva contrasena");
	        	  		String nuevoPass = in.nextLine();
						kaya.cambiarPassword(nuevoPass);
	        	  		break;
	        	  		
	        	  	case 4:
	        	  		pr("Modificar tipo Cliente");
	        	  		pr("Usted desea modificar su tipo de Cliente? 1.SI  2. NO");
	        	  		int opcion3 = in.nextInt();
	        	  		if(opcion3 == 1) {
	        	  			kaya.cambiarTipoUsuario();
	        	  			menuPrincipal();
	        	  		}else if(opcion3 == 2) {
	        	  			menuBase();
	        	  		}else {
	        	  			pr("Opcion invalida!");
	        	  		}
	        	  		
	        	  		break;
	        	  	case 5:
	        	  		pr("Aplicar Cupon");
	        	  		pr("Se ha aplicado un cupon con exito!");
	        	  		
	        	  		break;
	        	  	
	        	  	case 6:
	        	  		pr("Saliendo de Cuenta"); 
	        	  		return;
	        	  }
	          }catch(Exception e) {
	                pr("Error: " + e.getMessage());
	                scanner.nextLine(); 
	            }
		
		}while(opcion != 6);
		
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
