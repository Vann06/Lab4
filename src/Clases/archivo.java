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
 * El propósito de esta clase es guardar y leer en un archivo CSV 
 */



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;


public class archivo {
	
	
	private File archivo;
	
	/**
	 * Constructor de la clase Archivo que recibe el nombre del archivo y crea una instancia de la clase File con ese nombre.
	 * @param nombreArchivo Nombre del archivo a ser manipulado.
	 * @return 
	*/
    public archivo(String nombreArchivo){
        archivo = new File(nombreArchivo);

    }
    
    
    public void escribirUsuario(ArrayList<usuario> usuarios) throws Exception {
    	//ArrayList<usuario> usuar = new ArrayList<>();
        PrintWriter escritor = new PrintWriter(archivo, "UTF-8");
        String linea = "user,pass,tipo";
        escritor.println(linea);
        
        for(usuario user: usuarios) {
        	linea = user.getUser() + "," + user.getPass() + "," + user.getTipo();
        	escritor.println(linea);
        	      	
        }
        
        escritor.close();
        
    }
    
    public ArrayList<usuario> leerUsuarios() throws FileNotFoundException{
    	ArrayList<usuario> usuarios = new ArrayList<>();
    	
    	File usuariosCSV = new File("usuarios.csv");
    	
    	if(usuariosCSV.exists()) {
	    	try {
	    		try (BufferedReader br = new BufferedReader(new FileReader("usuarios.csv"))) {
	    		String linea = br.readLine();
	    		while(linea != null) {
	        		linea = br.readLine();
	    			
	    			if(linea != null && !linea.equals(",,,")) {
	        			String[] lineas = linea.split(",");
	        			System.out.println("Linea" + linea);
	        			
	        			String user = lineas[0];
	    				String pass = lineas[1];
	    				String tipo = lineas[2];
	    				
	    				usuario newUser = new usuario (user,pass,tipo);
	    				usuarios.add(newUser);
	    			}
	    		}
	    		}
	    	}catch (FileNotFoundException ex) {
				System.err.println("err "+ex.getMessage());
			} catch (IOException ex) {
				System.err.println("err2 "+ex.getMessage());
			}
    	}else {
    		try {
				usuariosCSV.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
	    	
	    	return usuarios;
    	
    }
    	
    	

    
    public ArrayList<reserva> leerReserva() throws FileNotFoundException{
    	ArrayList<reserva> reservas = new ArrayList<>();
    	
    	try(Scanner scanner = new Scanner(new File("reservas.csv"))){
    		scanner.nextLine();
    		
    		while(scanner.hasNextLine()) {
    			String linea = scanner.nextLine();
    			String[] lineas = linea.split(",");
    			
    			if(lineas.length >= 3) {
    				String fechaVuelo = lineas[0].trim();
    				String tipoVuelo = lineas[1].trim();
    				String cantBoletos = lineas[2].trim();
    				String aerolinea = lineas[3].trim();
    				String username = lineas[4].trim();
    				String numTarjeta = lineas[5].trim();
    				//no esta terminado, le perdi el uso al metodo 
    			}
    			
    		}
    	}
    	return reservas;
    }
    
    public void escribirReserva(ArrayList<reserva> reservas)throws Exception{
    	PrintWriter escritor = new PrintWriter(archivo, "UTF-8");
        String linea = "fechaVuelo,tipoVuelo,cantidadBoletos,aerolinea,username,numTarjeta,cuotas,claseVuelo,numAsiento,cantMaletas";
        escritor.println(linea);
        
        for(reserva res: reservas) {
        	linea = res.getFechaVuelo() + "," + res.isTipoVuelo() + "," + res.getCantidadBoletos() + "," + res.getAerolinea() + ","  + res.getUsuario() + "," + res.getNumeroTarjeta() + "," + res.getCuotas() + "," + res.getClaseVuelo() + "," + res.getNumeroAsiento() + "," + res.getCantidadMaletas();
        	escritor.println(linea);
        }
        escritor.close();
        
    }
    
    
    
	
	
	
	
	

}
