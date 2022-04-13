package Pr03;

/**
 * 
 * @author joseporiollopezbosch
 * BTC_Reus_UD06_TA06
 * Exercise03 - Base de datos articulos
 */

import java.util.Scanner;
import java.util.Set;
import java.util.Hashtable;

public class Exercise03App {
	
	public static Scanner scan = new Scanner(System.in);
	public static Hashtable <String, Integer> dbHash = new Hashtable<String, Integer>();

	public static void main(String[] args) {
		
		rellenarTable();
		menu();

		
		scan.close();
	}
//Methods
	//initial db
	public static void rellenarTable() {
		dbHash.put("Zapatos", 10);
		dbHash.put("Camisas", 5);
		dbHash.put("Shorts", 7);
		dbHash.put("Fulares", 4);
		dbHash.put("Gafas", 15);
		dbHash.put("Pendientes", 20);
		dbHash.put("Calcetines", 1);
		dbHash.put("Chaquetas", 1);
		dbHash.put("Gorros", 2);
		dbHash.put("Pantalones", 5);
		
	}
	//menu
	public static void menu() {
		int 	opcion	= 0;
		boolean flag 	= false;
		//Output menu
		System.out.println("\n\nMenu:");
		System.out.println("__________________________________________________________\n");
		System.out.println("1-Consultar todo");
		System.out.println("2-Consultar artículo");
		System.out.println("3-Añadir artículo");
		System.out.println("4-Salir\n");
		do {
				System.out.println("Seleccione opción: ");
				//Input from user
				if(scan.hasNextInt()){
		            opcion = scan.nextInt();
		            flag = true;
		        }else{
		        	//Cleaning scan if not int
		            scan.nextLine();
		        }
				
				if(opcion<1||opcion>4) {
					System.out.println("Opción incorrecta");
				}
			
		}while(opcion<1||opcion>3);
		scan.nextLine();
		
		switch(opcion) {
		
			case 1:
				showDB();
				break;
			case 2:
				checkProduct();
				break;
			case 3:
				addProduct();
				break;
			case 4:
				System.exit(0);
				break;
		}
	}
	//Show database
	public static void showDB() {
		// KeySet
        Set<String> productKey = dbHash.keySet();
        //iterate and show
        for(String key : productKey) {
            System.out.println("Producto : "  +key+ "\t\t Stock : "  + dbHash.get(key));
        }
        menu();
	}
	//Info Product
	public static void checkProduct() {
		boolean flag = false;
		
		System.out.println("¿Que producto desea consultar?");
		String product = scan.nextLine();
		
		// KeySet
        Set<String> productKey = dbHash.keySet();
        //iterate and show
        for(String key : productKey) {

        	if(key.toLowerCase().equals(product.toLowerCase())) {
        		flag = true;
        		System.out.println("Producto : "  +key+ "\t\t Stock : "  + dbHash.get(key));
        	}
        }
        if (!flag) {
        	System.out.println("El producto no existe");
        	checkProduct();
        }
        menu();
        scan.nextLine();
        
	}
	//Add Product
	public static void addProduct() {
		boolean flag = false;
		int stock = -1;
		System.out.println("Nombre del producto a añadir:");
		String key = scan.nextLine();
		System.out.println("Cantidad en stock a añadir:");
		
		do {
			//Input from user
			if(scan.hasNextInt()){
				stock = scan.nextInt();
	            flag = true;
	        }else{
	        	//Cleaning scan if not int
	            scan.nextLine();
	        }
			
			if(stock<0) {
				System.out.println("Opción incorrecta, determina una cantidad:");
			}
		//We give the option to add a product without stock
	}while(stock<0);
		if(flag) {
			dbHash.put(key, stock);
		}
	menu();
	
	}
}
