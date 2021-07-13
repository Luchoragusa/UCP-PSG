package ui;

import java.util.Scanner;
import data.DataRol;
import entities.*;
import logic.Login;
public class Menu 
{
	Scanner s=null;
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
		do {
			switch(command) 
			{
			case "abrirBitacora":{
				
			}
				break;
			case "cerrarBitacora":{
				
			}
				break;
			case "cargaIntegrantes":{
				newIntegrante();
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
			case "actualizarIntegrantes":{
				updateIntegrante();
			}
				break;
			case "actualizarArmas":{
				
			}
				break;
			case "actualizarRoles":{
				
			}
				break;
			case "actualizarRobos":{
				
			}
				break;
			case "actualizarMedallas":{
				
			}
				break;
			case "actualizarRangos":{
				
			}
				break;
			case "actualizarSubdivisiones":{
				
			}
				break;
			case "actualizarRangoSub":{
				
			}
				break;
			
			case "mostrarIntegrantes":{
				
			}
				break;
			case "mostrarArmas":{
				
			}
				break;
			case "mostrarRoles":{
				
			}
				break;
			case "mostrarRobos":{
				
			}
				break;
			case "mostrarMedallas":{
				
			}
				break;
			case "mostrarRangos":{
				
			}
				break;
			case "mostrarSubdivisiones":{
				
			}
				break;
			case "mostrarRangoSub":{
				
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
		}while(!command.equals("salir"));
	}
	
	private String getCommand() {
		
		System.out.print(" \n-- COMANDOS --");	
		
		System.out.print("\n cargaIntegrantes");
		System.out.print("\n cargaArmas");
		System.out.print("\n cargaRoles");
		System.out.print("\n cargaRobos");
		System.out.print("\n cargaMedallas");
		System.out.print("\n cargaRangos");
		System.out.print("\n cargaSubdivisiones");
		System.out.print("\n cargaRangoSub");
		
		System.out.print("\n actualizarIntegrantes");
		System.out.print("\n actualizarArmas");
		System.out.print("\n actualizarRoles");
		System.out.print("\n actualizarRobos");
		System.out.print("\n actualizarMedallas");
		System.out.print("\n actualizarRangos");
		System.out.print("\n actualizarSubdivisiones");
		System.out.print("\n actualizarRangoSub");
		
		System.out.print("\n mostrarIntegrantes");
		System.out.print("\n mostrarArmas");
		System.out.print("\n mostrarRoles");
		System.out.print("\n mostrarRobos");
		System.out.print("\n mostrarMedallas");
		System.out.print("\n mostrarRangos");
		System.out.print("\n mostrarSubdivisiones");
		System.out.print("\n mostrarRangoSub");
		
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
		
		System.out.print("\n Escriba un comando:");
		return s.nextLine();
	}
	
	private void close() {
		s.close();
	}
	
	public Integrante login() 
	{
		Integrante i=new Integrante();
		
		System.out.print("Email: ");
		i.setUsuario(s.nextLine());

		System.out.print("Password: ");
		i.setPw(s.nextLine());
		
		i=ctrlLogin.validate(i);
		
		return i;
	}
	
	private Integrante find() 
	{
		System.out.println();
		Integrante i=new Integrante();
		
		System.out.print("Ingrese una id: ");
		i.setIdIntegrante(Integer.parseInt(s.nextLine()));
		
		return ctrlLogin.getByIdIntegrante(i);
	}
	
	private void newIntegrante()
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
		ctrlLogin.add(i); // agrego la persona
		dr.saveRole(i,r); // agrego el rol a la tabla de rol_persona
		
		System.out.println("Operacion realizada con Exito");
	}
	
	private void updateIntegrante() 
	{
		System.out.println();
		Integrante i=new Integrante();

		Rol r = new Rol(); i.addRol(r);
		DataRol dr = new DataRol();
		
		i = find();

		System.out.print("Apellido(ACTUAL): " + i.getApellido());
		System.out.println();
		System.out.print("Apellido(NUEVO): "); i.setApellido(s.nextLine());
		
		System.out.print("Nombre(ACTUAL): " + i.getNombre());
		System.out.println();
		System.out.print("Nombre(NUEVO): "); i.setNombre(s.nextLine());

		System.out.print("Usuario(ACTUAL): " + i.getUsuario());
		System.out.println();
		System.out.print("Usuario(NUEVO): "); i.setUsuario(s.nextLine());
		
		System.out.print("Usuario(ACTUAL): " + i.getUsuario());
		System.out.println();
		System.out.print("Usuario(NUEVO): "); i.setUsuario(s.nextLine());
		
		System.out.print("SteamHex(ACTUAL): " + i.getSteamHex());
		System.out.println();
		System.out.print("SteamHex(NUEVO): "); i.setSteamHex(s.nextLine());
		
		System.out.print("DiscordId(ACTUAL): " + i.getDiscordId());
		System.out.println();
		System.out.print("DiscordId(NUEVO): "); i.setDiscordId(s.nextLine());
		
		System.out.print("PW(NUEVO): "); i.setPw(s.nextLine());
		System.out.println();
		
		dr.deleteRole(i);
		
		System.out.println("Lista de roles ");
		System.out.println(dr.getAll());
		
		System.out.print("Ingrese la descripcion del rol: "); 
		r.setDescripcion(s.nextLine());
		
		r = dr.getByDesc(r);
		
		System.out.println(r.toString());
		
		ctrlLogin.update(i); // agrego la persona
		
		dr.saveRole(i,r); // agrego el rol a la tabla de rol_persona
		
		System.out.println();
		System.out.println("Operacion realizada con Exito");
	}

}