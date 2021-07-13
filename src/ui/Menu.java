package ui;

import java.util.Scanner;

import data.DataRol;
import entities.*;
import logic.Login;
public class Menu 
{
	Login ctrlLogin = new Login();

	public void start() 
	{
		s = new Scanner(System.in);
		Integrante i = login();
		System.out.println("Bienvenido "+i.getNombre()+" "+i.getApellido());
		System.out.println();
		
		String command;
		do 
		{
			command=getCommand();
			executeCommand(command);
			System.out.println();
		} while(!command.equalsIgnoreCase("exit"));
		s.close();
	}

	private void executeCommand(String command) 
	{
		String rta = null;
		System.out.print(" \n-- COMANDOS --");	
		
		System.out.print("\n cargaIntegrantes");
		System.out.print("\n cargaArmas");
		System.out.print("\n cargaRoles");
		System.out.print("\n cargaRobos");
		System.out.print("\n cargaMedallas");
		System.out.print("\n cargaRangos");
		System.out.print("\n cargaSubdivisiones");
		System.out.print("\n cargaRangoSub");
		
		System.out.print("\n registrarUnStock");
		System.out.print("\n registrarUnRol");
		System.out.print("\n registrarUnRango");
		System.out.print("\n registrarHorasJugadas");
		System.out.print("\n registrarUnRobo");
		System.out.print("\n registrarUnaMedalla");
		System.out.print("\n registrarUnRangoSub");
		System.out.print("\n registrarUnaSancion");
		
		System.out.print("\n abrirBitacora");
		System.out.print("\n cerrarBitacora");
		
		System.out.print("\n salir");
		do {
			rta = inputCommand();
			switch(rta) 
			{
			case "abrirBitacora":{
				
			}
				break;
			case "cerrarBitacora":{
				
			}
				break;
			case "cargaIntegrantes":{
				cargaIntegrante();
			}
				break;
			case "cargaArmas":{
				
			}
				break;
			case "cargaRoles":{
				
			}
				break;
			case "cargaRobos":{
				
			}
				break;
			case "cargaMedallas":{
				
			}
				break;
			case "cargaRangos":{
				
			}
				break;
			case "cargaSubdivisiones":{
				
			}
				break;
			case "cargaRangoSub":{
				
			}
				break;
			case "registrarUnStock":{
				
			}
				break;
			case "registrarUnRol":{
				
			}
				break;
			case "registrarUnRango":{
				
			}
				break;
			case "registrarHorasJugadas":{
				
			}
				break;
			case "registrarUnRobo":{
				
			}
				break;
			case "registrarUnaMedalla":{
				
			}
				break;
			case "registrarUnRangoSub":{
				
			}
				break;	
			case "registrarUnaSancion":{
						
					}
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
	
	private void cargaIntegrante()
	{
		System.out.println();
		Integrante i=new Integrante();
		
		Rol r = new Rol();
		DataRol dr = new DataRol();
		
		System.out.print("Apellido: "); i.setApellido(s.nextLine());
		System.out.print("Nombre: "); i.setNombre(s.nextLine());
		System.out.print("SteamHex: "); i.setSteamHex(s.nextLine());
		System.out.print("DiscordID: "); i.setDiscordId(s.nextLine());
		System.out.print("Usuario: "); i.setUsuario(s.nextLine());
		System.out.print("PW: "); i.setPw(s.nextLine());
		
		System.out.println("Lista de roles ");
		System.out.println(dr.getAll());
		
		System.out.print("Ingrese la descripcion del rol: "); 
		r.setDescripcion(s.nextLine());
		
		r = dr.getByDesc(r);
		
		System.out.println(r.toString());
		
		i.addRol(r); // agrego el rol a la persona
		
		ctrlLogin.add(p); // agrego la persona
		
		dr.saveRole(p,r); // agrego el rol a la tabla de rol_persona
		
		System.out.println("Operacion realizada con Exito");
	}

}