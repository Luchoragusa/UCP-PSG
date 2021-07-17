package ui;

import java.util.LinkedList;
import java.util.Scanner;

import data.DataArma;
import data.DataHoras;
import data.DataIntegrante;
import data.DataMedalla;
import data.DataRan_Subdivision;
import data.DataRango;
import data.DataRobo;
import data.DataRol;
import data.DataSancion;
import data.DataStockarma;
import data.DataSubdivision;
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
				newArmas();
			}
				break;
			case "cargaRoles":{
				newRoles();
			}
				break;
			case "cargaRobos":{
				newRobos();
			}
				break;
			case "cargaMedallas":{
				newMedallas();
			}
				break;
			case "cargaRangos":{
				newRangos();
			}
				break;
			case "cargaSubdivisiones":{
				newSubdivisiones();
			}
				break;
			case "cargaRangoSub":{
				newRan_Subdivision();
			}
				break;
			case "actualizarIntegrantes":{
				updateIntegrante();
			}
				break;
			case "actualizarArmas":{
				updateArmas();
			}
				break;
			case "actualizarRoles":{
				updateRoles();
			}
				break;
			case "actualizarRobos":{
				updateRobos();
			}
				break;
			case "actualizarMedallas":{
				updateMedallas();
			}
				break;
			case "actualizarRangos":{
				updateRangos();
			}
				break;
			case "actualizarSubdivisiones":{
				updateSubdivisiones();
			}
				break;
			case "actualizarRangoSub":{
				updateRangoSub();
			}
				break;
			
			case "mostrarIntegrantes":{
				System.out.println(showIntegrantes());
;			}
				break;
			case "mostrarArmas":{
				System.out.println(showArmas());
			}
				break;
			case "mostrarRoles":{
				System.out.println(showRoles());
			}
				break;
			case "mostrarRobos":{
				System.out.println(showRobos());
			}
				break;
			case "mostrarMedallas":{
				System.out.println(showMedallas());
			}
				break;
			case "mostrarRangos":{
				System.out.println(showRangos());
			}
				break;
			case "mostrarSubdivisiones":{
				System.out.println(showSubdivisiones());
			}
				break;
			case "mostrarRangoSub":{
				System.out.println(showRangoSub());
			}
				break;
			case "registrarUnStock":{
				regStock();
			}
				break;
			case "registrarUnRol":{
				regRol();
			}
				break;
			case "registrarUnRango":{
				regRango();
			}
				break;
			case "registrarHorasJugadas":{
				regHorasJugadas();
			}
				break;
			case "registrarUnRobo":{
				regRobo();
			}
				break;
			case "registrarUnaMedalla":{
				regMedalla();
			}
				break;
			case "registrarUnRangoSub":{
				regRangoSub();
			}
				break;	
			case "registrarUnaSancion":{
				regSancion();
			}
				break;	
			case "salir":
				close();
				break;
			default:
				System.out.print("Comando invalido");
				break;
			}
		}while(!command.equals("salir"));
	}
	
	//delete de ds deberia recibir de parametro al integrante en vez de sancion? hacer saveSancion?
	private void regSancion() {
		System.out.println();
		Sancion san = new Sancion();
		DataSancion ds = new DataSancion();
		Integrante i = new Integrante();
		
		i = find();
		
		//ds.delete(i);
		
		System.out.println("Ingrese Tipo de sancion para el integrante: "); san.setTipoSancion(s.nextLine());
		System.out.println("Ingrese el motivo de la sancion para el integrante: "); san.setMotivo(s.nextLine());
		
		ds.add(san);
		
		//ds.saveSancion(i, san);
	}

	private void regRangoSub() {
		System.out.println();
		Ran_Subdivision rsb = new Ran_Subdivision();
		DataRan_Subdivision drsb = new DataRan_Subdivision();
		Integrante i = new Integrante();
		
		//codificarlo una vez hecho el DB de RangoSub
	}

	//el delete de dm deberia recibir de parametro al integrante en vez de medalla? crear un saveMedalla?
	private void regMedalla() {
		System.out.println();
		Medalla m = new Medalla();
		DataMedalla dm = new DataMedalla();
		Integrante i = new Integrante();
		
		i = find();

		//dm.delete(i);
		
		System.out.println("Ingrese el nombrre de la medalla para el integrante: "); m.setNomMedalla(s.nextLine());
		System.out.println("Ingrese el tipo de medalla para el integrante: "); m.setTipoMedalla(s.nextLine());
		
		dm.add(m);
		
		//dm.saveMedalla(i,m);
	}

	//crear un saveRobo??
	private void regRobo() {
		System.out.println();
		Robo r = new Robo();
		DataRobo dr = new DataRobo();
		Integrante i = new Integrante();
		
		i = find();
		
		System.out.println("Ingrese la descripcion del robo para el integrante: "); r.setDescripcion(s.nextLine());
		System.out.println("Ingrese el nombre del robo para el integrante: "); r.setNomRobo(s.nextLine());
		System.out.println("Ingrese el lugar del robo para el integrante: "); r.setLugarRobo(s.nextLine());
		
		dr.add(r);
		
		//dr.saveRobo(i, r);		
	}

	private void regHorasJugadas() {
		System.out.println();
		Horas h = new Horas();
		DataHoras dh = new DataHoras();
		Integrante i = new Integrante();
		DataIntegrante di = new DataIntegrante();
		
		i = find();
		
		if (i != null) {
			//agregar al dh el integrante
			
			/*
			 
			 System.out.println("Ingrese hora inicio: ");
			 System.out.println("Ingrese hora fin: ");
	
			 esto en el dh
			 
			*/
			
			//codificar Fecha en el dh 
		}
	}

	//validar que el nombre no coincida con alguno ya hecho
	private void regRango() {
		System.out.println();
		Rango r = new Rango();
		DataRango dr = new DataRango();
		Integrante i = new Integrante();
		DataIntegrante di = new DataIntegrante();
		
		i = find();
		
		dr.deleteRango(i);
		
		System.out.println("Ingrese el rango a registrar al integrante: ");
		r.setNomRango(s.nextLine());	
		
		dr.add(r);
		
		dr.saveRango(i, r);
	}

	private void regRol() {
		System.out.println();
		Rol r = new Rol();
		DataRol dr = new DataRol();
		Integrante i = new Integrante();
		
		i = find();
		
		dr.deleteRole(i);
		
		System.out.print("Ingrese la descripcion del rol a registrar en el integrante: "); 
		r.setDescripcion(s.nextLine());
		
		dr.add(r);
		
		dr.saveRole(i, r);
	}

	//codificar la Fecha en el DB de DataStockarma, y que el metodo (cree juani) reciba como parametro el arma
	private void regStock() {
		System.out.println();
		Arma a = new Arma();
		DataArma da = new DataArma();
		Stockarma stockarma = new Stockarma();
		DataStockarma dstock = new DataStockarma();
		
		System.out.println("Ingrese el ID del arma a registrar stock: ");
		a.setIdArma(Integer.parseInt(s.nextLine()));
		
		a = da.getById(a);
		
		if(a != null) {
			stockarma.setIdArma(a.getIdArma());
			
			System.out.println("Ingrese la cantidad para el stock: ");
			stockarma.setCantidad(Integer.parseInt(s.nextLine()));
			
			//codificar la Fecha 
			
			//guardar stock en la DB
		}		
	}

	//falta hacer el getById en DataRan_Subdivision
	private Ran_Subdivision showRangoSub() {
		System.out.println();
		Ran_Subdivision rsb = new Ran_Subdivision();
		DataRan_Subdivision drsb = new DataRan_Subdivision();
		
		System.out.println("Ingrese el ID del rango de la subdivision a mostrar: ");
		rsb.setIdSub(Integer.parseInt(s.nextLine()));
		
		//rsb = drsb.getById(rsb);
		
		return rsb;
	}

	private Subdivision showSubdivisiones() {
		System.out.println();
		Subdivision sb = new Subdivision();
		DataSubdivision dsb = new DataSubdivision();
		
		System.out.println("Ingrese el ID de la subdivision a mostrar: ");
		sb.setIdSub(Integer.parseInt(s.nextLine()));
		
		sb = dsb.getById(sb);
		
		return sb;
	}

	private Rango showRangos() {
		System.out.println();
		Rango r = new Rango();
		DataRango dr = new DataRango();
		
		System.out.println("Ingrese el ID del rango a mostrar: ");
		r.setIdRango(Integer.parseInt(s.nextLine()));
		
		r = dr.getById(r);
		
		return r;
	}

	private Medalla showMedallas() {
		System.out.println();
		Medalla m = new Medalla();
		DataMedalla dm = new DataMedalla();
		
		System.out.println("Ingrese el ID de la medalla a mostrar: ");
		m.setIdMedalla(Integer.parseInt(s.nextLine()));
		
		m = dm.getById(m);
		
		return m;
	}

	private Robo showRobos() {
		System.out.println();
		Robo r = new Robo();
		DataRobo dr = new DataRobo();
		
		System.out.println("Ingrese el ID del lugar del robo a mostrar: ");
		r.setIdLugarRobo(Integer.parseInt(s.nextLine()));
		
		r = dr.getById(r);
		
		return r;
	}

	private Rol showRoles() {
		System.out.println();
		Rol r = new Rol();
		DataRol dr = new DataRol();
		
		System.out.println("Ingrese el ID del rol a mostrar: ");
		r.setIdRol(Integer.parseInt(s.nextLine()));
		
		r = dr.getById(r);
		
		return r;
	}

	private Arma showArmas() {
		System.out.println();
		Arma a = new Arma();
		DataArma da = new DataArma();
		
		System.out.println("Ingrese el ID del arma a mostrar: ");
		a.setIdArma(Integer.parseInt(s.nextLine()));
		
		a = da.getById(a);
		
		return a;
	}

	private LinkedList<Integrante> showIntegrantes() {
		System.out.println();
		Integrante i=new Integrante();
		
		System.out.println("Ingrese el apellido del integrante a mostrar: ");
		i.setApellido(s.nextLine());
		
		LinkedList<Integrante> Integrantes = new LinkedList<>(); 
		Integrantes = ctrlLogin.getByApellido(i);
		return Integrantes;
	}

	//falta hacer el update en DataRan_Subdivision
	private void updateRangoSub() {
		System.out.println();
		Ran_Subdivision rsb = new Ran_Subdivision();
		DataRan_Subdivision drsb = new DataRan_Subdivision();
		
		rsb = findRanSub();
		
		System.out.println("Nombre del rango de la subdivision (ACTUAL): " + rsb.getNombreRangoSub());
		System.out.println();
		System.out.println("Nombre del rango de la subdivision (NUEVO): "); rsb.setNombreRangoSub(s.nextLine());
		
		//drsb.update(rsb);
	}

	private Ran_Subdivision findRanSub() {
		System.out.println();
		Ran_Subdivision rsb = new Ran_Subdivision();
		
		System.out.print("Ingrese la ID de la subdivision a encontrar en la tabla RangoSub: ");
		rsb.setIdSub(Integer.parseInt(s.nextLine()));
		return rsb;
	}

	private void updateSubdivisiones() {
		System.out.println();
		Subdivision sb = new Subdivision();
		DataSubdivision dsb = new DataSubdivision();
		
		sb = findSubdivision();
		
		System.out.println("Descricpion de la subdivision (ACTUAL): " + sb.getDescripcion());
		System.out.println();
		System.out.println("Descripcion de la subdivision (NUEVO): "); sb.setDescripcion(s.nextLine());
		
		System.out.println("Nombre de la subdivision (ACTUAL): " + sb.getNomSubDivision());
		System.out.println();
		System.out.println("Nombre de la subdivision (NUEVO): "); sb.setNomSubDivision(s.nextLine());
		
		dsb.update(sb);
	}

	private Subdivision findSubdivision() {
		System.out.println();
		Subdivision sb = new Subdivision();
		
		System.out.print("Ingrese la ID de la subidivision a encontrar: ");
		sb.setIdSub(Integer.parseInt(s.nextLine()));
		return sb;
	}

	private void updateRangos() {
		System.out.println();
		Rango r = new Rango();
		DataRango dr = new DataRango();
		
		r = findRango();
		
		System.out.println("Nombre del rango (ACTUAL): " + r.getNomRango());
		System.out.println();
		System.out.println("(Nombre del rango (NUEVO): "); r.setNomRango(s.nextLine());
		
		dr.update(r);
	}

	private Rango findRango() {
		System.out.println();
		Rango r = new Rango();
		
		System.out.print("Ingrese la ID del rango a encontrar: ");
		r.setIdRango(Integer.parseInt(s.nextLine()));
		return r;
	}

	private void updateMedallas() {
		System.out.println();
		Medalla m = new Medalla();
		DataMedalla dm = new DataMedalla();
		
		m = findMedalla();
		
		System.out.println("Nombre del robo (ACTUAL): " + m.getNomMedalla());
		System.out.println();
		System.out.println("Nombre del robo (NUEVO): "); m.setNomMedalla(s.nextLine());
		
		System.out.println("Tipo de medalla (ACTUAL): " + m.getTipoMedalla());
		System.out.println();
		System.out.println("Tipo de medalla (NUEVO): "); m.setTipoMedalla(s.nextLine());
				
		dm.update(m);
	}

	private Medalla findMedalla() {
		System.out.println();
		Medalla medalla = new Medalla();
		
		System.out.print("Ingrese la ID de la medalla a encontrar: ");
		medalla.setIdMedalla(Integer.parseInt(s.nextLine()));
		return medalla;
	}

	private void updateRobos() {
		System.out.println();
		Robo robo = new Robo();
		DataRobo dr = new DataRobo();
		
		robo = findRobo();
		
		System.out.println("Descricpion del robo (ACTUAL): " + robo.getDescripcion());
		System.out.println();
		System.out.println("Descripcion del robo (NUEVO): "); robo.setDescripcion(s.nextLine());
		
		System.out.println("Nombre del robo (ACTUAL): " + robo.getNomRobo());
		System.out.println();
		System.out.println("Nombre del robo (NUEVO): "); robo.setNomRobo(s.nextLine());
		
		System.out.println("Lugar del robo (ACTUAL): " + robo.getLugarRobo());
		System.out.println();
		System.out.println("Lugar del robo (NUEVO): "); robo.setLugarRobo(s.nextLine());
		
		dr.update(robo);
	}

	private Robo findRobo() {
		System.out.println();
		Robo robo = new Robo();
		
		System.out.print("Ingrese la ID del lugar del robo a encontrar: ");
		robo.setIdLugarRobo(Integer.parseInt(s.nextLine()));
		return robo;
	}

	private void updateRoles() {
		System.out.println();
		Rol r = new Rol();
		DataRol dr = new DataRol();
		
		r = findRol();
		
		System.out.println("Descripcion del rol (ACTUAL): " + r.getDescripcion());
		System.out.println();
		System.out.println("Descripcion del rol (NUEVO): "); r.setDescripcion(s.nextLine());
		
		dr.update(r);
	}

	private Rol findRol() {
		System.out.println();
		Rol r = new Rol();
		
		System.out.print("Ingrese el ID del rol a encontrar: ");
		r.setIdRol(Integer.parseInt(s.nextLine()));
		return r;
	}

	private void updateArmas() {
		System.out.println();
		Arma a = new Arma();
		DataArma da = new DataArma();
		
		a = findArma();
		
		System.out.println("Tipo arma (ACTUAL): " + a.getTipoArma());
		System.out.println();
		System.out.println("Tipo arma (NUEVO): "); a.setTipoArma(s.nextLine());
		
		System.out.println("Nombre del arma (ACTUAL): " + a.getNombreArma());
		System.out.println();
		System.out.println("Nombre del arma (NUEVO): "); a.setNombreArma(s.nextLine());
		
		da.update(a);
	}

	private Arma findArma() {
		System.out.println();
		Arma a = new Arma();
		
		System.out.print("Ingrese la id del arma a encontrar: ");
		a.setIdArma(Integer.parseInt(s.nextLine()));
		return a;
	}

	private void newRan_Subdivision() {
		System.out.println();
		Ran_Subdivision rsb = new Ran_Subdivision();
		DataRan_Subdivision drsb = new DataRan_Subdivision();
		
		System.out.println("Nombre del rango de la subdivision: "); rsb.setNombreRangoSub(s.nextLine());
		
		//drsb.add(rsb);
	}

	private void newSubdivisiones() {
		System.out.println();
		Subdivision sb = new Subdivision();
		DataSubdivision dsb = new DataSubdivision();
		
		System.out.println("Descripcion de la subdivision: "); sb.setDescripcion(s.nextLine());
		System.out.println("Nombre de la subdivision: "); sb.setNomSubDivision(s.nextLine());
		
		dsb.add(sb);
	}

	private void newRangos() {
		System.out.println();
		Rango r = new Rango();
		DataRango dr = new DataRango();
		
		System.out.println("Nombre del rango: "); r.setNomRango(s.nextLine());
		
		dr.add(r);
	}

	private void newMedallas() {
		System.out.println();
		Medalla m = new Medalla();
		DataMedalla dm = new DataMedalla();
		
		System.out.println("Nombre de la medalla: "); m.setNomMedalla(s.nextLine());
		System.out.println("Tipo medalla: "); m.setTipoMedalla(s.nextLine());
		
		dm.add(m);
	}

	private void newRobos() {
		System.out.println();
		Robo robo = new Robo();
		DataRobo dro = new DataRobo();
		
		System.out.println("Descripcion del robo: "); robo.setDescripcion(s.nextLine());
		System.out.println("Nombre del robo: "); robo.setNomRobo(s.nextLine());
		System.out.println("Lugar del robo: "); robo.setLugarRobo(s.nextLine());
		
		dro.add(robo);
	}

	private void newRoles() {
		System.out.println();
		Rol r = new Rol();
		DataRol dr = new DataRol();
		
		System.out.println("Descripcion del rol: "); r.setDescripcion(s.nextLine());
		
		dr.add(r);
	}

	private void newArmas() {
		System.out.println();
		Arma a = new Arma();
		DataArma da = new DataArma();
		
		System.out.println("Tipo arma: "); a.setTipoArma(s.nextLine());
		System.out.println("Nombre del arma: "); a.setNombreArma(s.nextLine());
		
		da.add(a);
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
		
		System.out.print("Ingrese la id del integrante: ");
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