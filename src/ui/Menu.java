package ui;

import java.util.Scanner;

public class Menu {

	Scanner scan = new Scanner(System.in);
	public void start() {
		
		String rta = null;
		System.out.print(" \n-- COMANDOS --");	
		System.out.print("\n abrir bitacora");
		System.out.print("\n cargaIntegrantes");
		System.out.print("\n cargaArmas");
		System.out.print("\n cargaRoles");
		System.out.print("\n cargaRobos");
		System.out.print("\n cargaMedallas");
		System.out.print("\n cargaRangos");
		System.out.print("\n cargaSubdivisiones");
		System.out.print("\n cargaRangoSub");
		System.out.print("\n stockArmas");
		System.out.print("\n registrarUnRol");
		System.out.print("\n registrarUnRango");
		System.out.print("\n registrarHorasJugadas");
		System.out.print("\n registrarUnRobo");
		System.out.print("\n registrarUnaMedalla");
		System.out.print("\n registrarUnRangoSub");
		System.out.print("\n salir");
		do {
			rta = inputCommand();
			switch(rta) {
			case "abrir bitacora":
				break;
			case "cargaIntegrantes":
				break;
			case "cargaArmas":
				break;
				
			case "cargaRoles":
				break;
			
			case "cargaRobos":
				break;
			
			case "cargaMedallas":
				break;
			
			case "cargaRangos":
				break;
			case "cargaSubdivisiones":
				break;
				
			case "cargaRangoSub":
				break;
			case "stockArmas":
				break;
			case "registrarUnRol":
				break;
			case "registrarUnRango":
				break;
			case "registrarHorasJugadas":
				break;
			case "registrarUnRobo":
				break;
			case "registrarUnaMedalla":
				break;
			case "registrarUnRangoSub":
				break;
							
			case "salir":
				close();
				break;
			default:
				System.out.print(" Comando invalido");
				break;
			
			}
		
		
		}while(!rta.equals("salir"));
		
		
	}
	
	private String inputCommand() {
		
		
		System.out.print("\n Escriba un comando:");
		return scan.nextLine();
	}
	
	private void close() {
		scan.close();
	}

}