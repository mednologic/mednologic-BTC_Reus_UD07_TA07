package Pr04;

import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * 
 * @author joseporiollopezbosch
 * BTC_Reus_UD07_TA07
 * Exercise04 - Combinación del ejercicio 02 y 03
 */

public class Exercise04App {
	
	public static Scanner scan = new Scanner(System.in);
	public static Hashtable <String, ArrayList<Float>> productosH = new Hashtable <String, ArrayList<Float>>();
	public static ArrayList <Float> infoProduct 	= new ArrayList<>();
	public static float precioFinal = 0;
	public static int cantidadProductos = 0;

	public static void main(String[] args) {
		
		rellenarInfo();
		menu();
		scan.close();
	}
//Methods
	
		//menu Stock
			public static void menu() {
				int 	opcion	= 0;
				boolean flag 	= false;
				//Output menu
				System.out.println("\n\nMenu:");
				System.out.println("__________________________________________________________\n");
				System.out.println("1-Caja registradora");
				System.out.println("2-Almacen");
				System.out.println("3-Salir\n");
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
						
						if(opcion<1||opcion>3) {
							System.out.println("Opción incorrecta");
						}
					
				}while(opcion<1||opcion>3);
				scan.nextLine();
				
				switch(opcion) {
				
					case 1:
						anyadirProductosCompra();
						break;
					case 2:
						menuStock();
						break;
					case 3:
						System.exit(0);
						break;
				}
			}
	//menu Stock
		public static void menuStock() {
			int 	opcion	= 0;
			boolean flag 	= false;
			//Output menu
			System.out.println("\n\nMenu:");
			System.out.println("__________________________________________________________\n");
			System.out.println("1-Consultar todo");
			System.out.println("2-Consultar artículo");
			System.out.println("3-Añadir artículo");
			System.out.println("4-Menu principal");
			System.out.println("5-Salir\n");
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
					
					if(opcion<1||opcion>5) {
						System.out.println("Opción incorrecta");
					}
				
			}while(opcion<1||opcion>5);
			scan.nextLine();
			
			switch(opcion) {
			
				case 1:
					mostrarTodo();
					break;
				case 2:
					checkProduct();
					break;
				case 3:
					addProduct();
					break;
				case 4:
					menu();
					break;
				case 5:
					System.exit(0);
					break;
			}
		}
		//Add products
		public static void anyadirProductosCompra() {
			//Fitting List of products
			boolean flag 		= false;
			float cantidadPago	= 0;
			float cambio 		= 0;
			
		
			do {
				System.out.println("¿Que producto desea comprar?");
				String product = scan.nextLine();
				
				// KeySet
		        Set<String> productKey = productosH.keySet();
		        //iterate and show
		        for(String key : productKey) {

		        	if(key.toLowerCase().equals(product.toLowerCase())) {
		        		flag = true;
		        		precioFinal =  ((productosH.get(key).get(2))*productosH.get(key).get(1)+productosH.get(key).get(2));
		        		//System.out.println(precioFinal);
		        		cantidadProductos++;
		        	}
		        }
				flag = masProductos();
			}while(!flag);
			System.out.println("Cantidad de productos: "+cantidadProductos);
			System.out.println("Cantidad de pago");
			cantidadPago = scan.nextFloat();
			cambio = cantidadPago-precioFinal;
			System.out.println("Su cambio: "+cambio);
		}
		//Add more products
		public static boolean masProductos() {
			boolean flag = false;
			boolean optionBol = false;
			
			while(optionBol==false) {
				System.out.println("Quiere introducir otro producto? (S/N)");
				String sn= scan.next().toLowerCase();
				//no more products, breaking the bucle
				if(sn.equals("n")) {
					flag 		= true;
					optionBol 	= true;
				//More products	
				}else if(sn.equals("s")) {
					optionBol = true;
				//Not valid option	
				}else {
					System.out.println("Opción no valida");
				}
			}
			scan.nextLine();
			return flag;
			
		}
		//Info Product
				public static void checkProduct() {
					boolean flag = false;
					
					System.out.println("¿Que producto desea consultar?");
					String product = scan.nextLine();
					
					// KeySet
			        Set<String> productKey = productosH.keySet();
			        //iterate and show
			        for(String key : productKey) {

			        	if(key.toLowerCase().equals(product.toLowerCase())) {
			        		flag = true;
			        		System.out.println("Producto : "  +key+ "\t\t info : "  + productosH.get(key));
			        	}
			        }
			        if (!flag) {
			        	System.out.println("El producto no existe");
			        	checkProduct();
			        }
			        menuStock();
			        scan.nextLine();
			        
				}
		//Add Product
		public static void addProduct() {
			//inicializing variables
			boolean flag 	= false;
			int stock 		= -1;
			float iva 		= 0;
			float precio 	= 0;
			
			System.out.println("Nombre del producto a añadir:");
			String key = scan.nextLine();
			
			
			
			System.out.println("Cantidad en stock a añadir:");
			do {
				//Input from user
				if(scan.hasNextInt()){
					stock = scan.nextInt();
		            flag = true;
		        }else{
		        	//Cleaning scan if not float
		            scan.nextLine();
		        }
				
				if(stock<0) {
					System.out.println("Opción incorrecta, determina una cantidad:");
				}
			//We give the option to add a product without stock
			}while(stock<0);
			
			//Adding value of iva
			System.out.println("Tipo de IVA:");
			do {
				//Input from user
				if(scan.hasNextInt()){
					iva = (int)scan.nextInt();
		            flag = true;
		        }else{
		        	//Cleaning scan if not float
		            scan.nextLine();
		        }
				if(iva!=4.0&&iva!=21.0) {
					System.out.println("Opción incorrecta, determina una 4% ó 21%");
				}
			//We give the option to add a product without stock
			}while((int)iva!=4.0&&iva!=21.0);
			System.out.println("Precio bruto:");
			scan.nextLine();
			precio = scan.nextFloat();
			//All ready to add
			if(flag) {
				//Creating new arraylist using the older
				infoProduct 	= new ArrayList<>();
				//stock
				infoProduct.add((float)stock);
				//tipo iva
				infoProduct.add((float)iva/100);
				//precio bruto
				infoProduct.add((float)precio);
				//Add to HashTable
				productosH.put(key, infoProduct);
			}
		menuStock();
		
		}
	//Fitting the info
	public static void rellenarInfo() {
			
			//stock
			infoProduct.add((float)10);
			//tipo iva
			infoProduct.add((float)0.04);
			//precio bruto
			infoProduct.add((float)30);
			productosH.put("Zapatos", infoProduct);
			
			//Creating new arraylist using the older
			infoProduct 	= new ArrayList<>();
			//stock
			infoProduct.add((float)5);
			//tipo iva
			infoProduct.add((float)0.21);
			//precio bruto
			infoProduct.add((float)50);
			productosH.put("Bufandas", infoProduct);
		
		
	}
	public static void mostrarTodo() {
		// KeySet
        Set<String> productKey = productosH.keySet();
        
        //iterate and show
        for(String key : productKey) {
            System.out.println("Producto : "  +key+ "\t\t Info : "  + productosH.get(key));
        }
        menuStock();
	}
}
