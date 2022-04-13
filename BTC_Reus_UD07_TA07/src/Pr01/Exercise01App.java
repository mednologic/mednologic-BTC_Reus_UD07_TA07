package Pr01;

/**
 * 
 * @author joseporiollopezbosch
 * BTC_Reus_UD07_TA07
 * Exercise01 - Alumnos y su nota media
 */

import java.util.Scanner;
import java.util.Set;
import java.util.Hashtable;


public class Exercise01App {
	
	public static Scanner scan = new Scanner(System.in);
	public static boolean fin = false;
	
	public static Hashtable <String, String> alumnosHash =new Hashtable<String, String>();

	public static void main(String[] args) {
		
		do {
			nuevoAlumno();
		}while(!fin);
		showHastable();
		
		scan.close();
	}
//Methods
	//Create pupil + petition of new pupil
	public static void nuevoAlumno() {
		//Creating new pupil
		System.out.println("Introduce el nombre del alumno");
		String name = scan.next();
		System.out.println("Introduce nota1");
		float nota1 = scan.nextFloat();
		System.out.println("Introduce nota2");
		float nota2 = scan.nextFloat();
		float notaMedia = (nota1 + nota2)/2;
		
		//Petition of new pupil
		System.out.println("\n Quiere introducir otro alumno? (S/N)");
		String sn = scan.next();
		alumnosHash.put(name, Float.toString(notaMedia));
		if(!sn.equals("s")) {
			fin = true;
		}
		
	}
	//Show Hashtable
	public static void showHastable() {
		// KeySet
        Set<String> alumnosKey = alumnosHash.keySet();
        //iterate and show
        for(String key : alumnosKey) {
            System.out.println("Alumno : "  +key+ "\t\t Nota Media : "  + alumnosHash.get(key));
        }
	}
}
