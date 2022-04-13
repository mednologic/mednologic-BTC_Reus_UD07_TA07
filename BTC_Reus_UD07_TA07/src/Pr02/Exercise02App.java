package Pr02;

/**
 * 
 * @author joseporiollopezbosch
 * BTC_Reus_UD07_TA07
 * Exercise02 - Flujo de ventas
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Exercise02App {
	
	public static Scanner scan = new Scanner(System.in);
	public static ArrayList <Float> cantidadesL 	= new ArrayList<>();
	public static ArrayList <Float> iva21L 			= new ArrayList<>();
	public static ArrayList <Float> iva4L 			= new ArrayList<>();
	public static ArrayList <Float> totalPrice21 	= new ArrayList<>();
	public static ArrayList <Float> totalPrice4 	= new ArrayList<>();
	public static float precioFinal21 = 0;
	public static float precioFinal4 = 0;

	public static void main(String[] args) {
		
		anyadirProductos();
		calculateIva();
		showInfo();
		pagar();
		scan.close();
	}
//Methods
	//Add products
	public static void anyadirProductos() {
		//Fitting List of products
		boolean flag = false;
	
		do {
			System.out.println("Introduce precio: ");
			float precio = scan.nextInt();
			//Add to list
			cantidadesL.add(precio);
			//add more products?
			flag = masProductos();
		}while(!flag);
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
		return flag;
	}
	//Calculate IVA 21%, and total
	public static void calculateIva() {
		
		for(Float flo : cantidadesL)
		{	
		    iva21L.add((float)(flo*0.21));
		    iva4L.add((float)(flo*0.04));
		    totalPrice21.add(flo+(float)(flo*0.21));
		    totalPrice4.add(flo+(float)(flo*0.04));
		}
	}
	//Show info
	public static void showInfo(){
		
		System.out.println("Total de productos: "+cantidadesL.size());
		System.out.println("____________________________________________________________");
		
		System.out.println("Precio\tIva 21%\tIva 4%\tTotal 21%\tTotal 4%");
		for(int i=0; i<cantidadesL.size();i++) {
			System.out.println(cantidadesL.get(i)+"\t"+iva21L.get(i)+"\t"+iva4L.get(i)+"\t"+totalPrice21.get(i)+"\t\t"+totalPrice4.get(i));	
			precioFinal21 = precioFinal21+totalPrice21.get(i);
			precioFinal4 = precioFinal4+totalPrice4.get(i);
		}
		System.out.println("____________________________________________________________");
		
		System.out.println("Precio final 21%: \t"	+precioFinal21);
		System.out.println("Precio final 4%: \t"	+precioFinal4);
		
	}
	//PayMethod
	public static void pagar() {
		float recibido	= 0;
		float cambio21	= 0;
		float cambio4	= 0;
		do {
			System.out.println("Introduzca cantidad de pago:");
			recibido = scan.nextFloat();
			cambio21 = recibido-precioFinal21;
			cambio4 = recibido-precioFinal4;
			if(recibido<precioFinal21) System.out.println("Cantidad insuficiente");
		}while(recibido<precioFinal21);
		System.out.println("Su cambio (21%): "	+cambio21);
		System.out.println("Su cambio (4%): "	+cambio4);
	}
}
