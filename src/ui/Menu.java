package ui;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Scanner;

import data.DataArma;
import data.DataHoras;
import data.DataIntegrante;
import data.DataMed_Integrante;
import data.DataMedalla;
import data.DataRanSub_Integrante;
import data.DataRan_Subdivision;
import data.DataRango;
import data.DataRobo;
import data.DataRoboxdia;
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
		Boolean admin = false;
		s = new Scanner(System.in);
		Integrante i = login();
		System.out.println("Bienvenido "+i.getNombre()+" "+i.getApellido());
		System.out.println();
		
		String command;
		do 
		{
			DataRol dr = new DataRol();
			Rol r = dr.getByIdInte(i);
			
			
			if (r.getIdRol() == 1)
			{
				admin = true;
			}
			
			command=getCommand(admin);
			executeCommand(command, i);
			System.out.println();
		} while(!command.equalsIgnoreCase("exit"));
		s.close();
	}

	private void executeCommand(String command, Integrante i) 
	{
			switch(command) 
			{
			case "cargaIntegrantes":{
				newIntegrante();			
			}
				break;
			case "cargaArmas": 
			{
				newArmas();
				break;
			}
			case "cargaRoles":{
				newRoles();
			}
				break;
			case "cargaRobos":{
				newRobos();
				//problemas con la columna descripcion, no va
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
				newRan_Subdivision();					//tuneado
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
				updateRangoSub();					//tuneado
			}
				break;
			
			case "mostrarIntegrantes":{
				System.out.println(showIntegrantes());
			}
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
				System.out.println(showRangoSub());			//tuneado
			}
				break;
			case "registrarUnStock":{
				regStock();									//tuneado
			}
				break;
			case "registrarUnRol":{
				regRol();
			}
				break;
			case "registrarUnRango":{
				regRango();									//ver comentario en metodo
			}
				break;
			case "registrarHorasJugadas":{
				regHorasJugadas(i);							//tuneado
			}
			case "registrarHoraFin":{
				regHoraFin(i);								//tuneado
			}
				break;
			case "registrarUnRobo":{						//tuneado
				regRoboxdia(i);
			}
				break;
			case "registrarUnaMedalla":{
				regMedalla();								//tuneado
			}
				break;
			case "registrarUnRangoSub":{
				regRangoSub();								//tuneado
			}
				break;	
			case "registrarUnaSancion":{
				regSancion();								//tuneado
			}
				break;	
			case "salir":
				close();
				break;
			default:
			{
				System.out.print("Comando invalido.");
				break;
			}
		}
	}
	
	private void regHoraFin(Integrante i) {
		Horas h = new Horas(); 
		DataHoras dh = new DataHoras();
		
		System.out.println("Ingrese la hora de finalizacion: ");
		int hora = Integer.parseInt(s.nextLine());
		System.out.println("Ingrese los minutos de la hora de finalizacion: ");
		int minuto = Integer.parseInt(s.nextLine());
		 
		LocalTime horaFin = LocalTime.of(hora, minuto);
		h.setHoraFin(horaFin);
		
		dh.update(h);
	}

	private void regSancion() {
		System.out.println();
		Sancion san = new Sancion();
		DataSancion ds = new DataSancion();
		Integrante i = new Integrante();
		
		i = find();
		san.setIdIntegrante(i.getIdIntegrante());
		
		System.out.println("Se muestra la lista de sanciones del integrante: ");
		System.out.println(ds.getById(san));
		
		System.out.println("Ingrese Tipo de sancion para el integrante: "); san.setTipoSancion(s.nextLine());
		System.out.println("Ingrese el motivo de la sancion para el integrante: "); san.setMotivo(s.nextLine());
		
		ds.add(san);
	}

	private void regRangoSub() {
		System.out.println();
		Ran_Subdivision rsb = new Ran_Subdivision();
		DataSubdivision dsb = new DataSubdivision();
		DataRan_Subdivision drsb = new DataRan_Subdivision();
		Integrante i = new Integrante();
		Ransub_integrante rsbi = new Ransub_integrante();
		DataRanSub_Integrante drsbi = new DataRanSub_Integrante();
		
		i = find();
		
		System.out.println("Listado de las subdivisiones: ");
		System.out.println(dsb.getAll());
		
		System.out.println("A que subdivision corresponde? Ingrese la ID: ");
		rsb.setIdSub(Integer.parseInt(s.nextLine())); 
		
		System.out.println("Listado de rangos de la subdivision encontrada: ");
		System.out.println(drsb.getByIdSub(rsb));
		
		System.out.println("Ingrese la ID del rango: ");
		int idrangoSub = Integer.parseInt(s.nextLine());
		
		rsbi.setIdIntegrante(i.getIdIntegrante());
		LocalDate fecha = LocalDate.now();
		rsbi.setFecha_desde(fecha);
		rsbi.setIdRangoSub(idrangoSub);
		
		drsbi.add(rsbi);
	}

	private void regMedalla() {
		System.out.println();
		Medalla m = new Medalla();
		DataMedalla dm = new DataMedalla();
		Integrante i = new Integrante();
		Med_integrante medInt = new Med_integrante();
		DataMed_Integrante dataMedInt = new DataMed_Integrante();
		LocalDate fecha = null;
		
		i = find();
		
		System.out.println("Registra tipo de medalla Semanal (S) o Mensual (M): ");
		m.setTipoMedalla(s.nextLine());
		
		if (m.getTipoMedalla().equalsIgnoreCase("S")) {				
			
			System.out.println("Lista de medallas: ");
			System.out.println(dm.getByTipo(m));
			
			System.out.println("Ingrese la ID de la medalla a registrar al integrante: ");
			m.setIdMedalla(Integer.parseInt(s.nextLine()));
			
		}
		else if (m.getTipoMedalla().equalsIgnoreCase("M")) {
			
			System.out.println("Lista de medallas: ");
			System.out.println(dm.getByTipo(m));
			
			System.out.println("Ingrese la ID de la medalla a registrar al integrante: ");
			m.setIdMedalla(Integer.parseInt(s.nextLine()));
			
		}
		
		medInt.setIdIntegrante(i.getIdIntegrante());
		medInt.setIdMedalla(m.getIdMedalla());
		
		System.out.println("Ingrese la recompensa. Seguido de eso, se setea la fecha de hoy. ");
		medInt.setRecompensa(s.nextLine());
		medInt.setFecha_recompensa(fecha = LocalDate.now());
		
		//dataMedInt.setMedallas(i);
		dataMedInt.saveMedalla(i, m, medInt);
	}

	private void regRoboxdia(Integrante i2) {
		System.out.println();
		Robo r = new Robo();
		DataRobo dr = new DataRobo();
		Roboxdia rxd = new Roboxdia();
		DataRoboxdia Datarxd = new DataRoboxdia(); 
		Integrante i = new Integrante();
		LinkedList<Integrante> integrantes= new LinkedList<>();
		String resultado = null;
		
		System.out.println("Listado de todos los robos: ");
		System.out.println(dr.getAll());
		
		System.out.println("Ingrese la ID del robo a registrar: ");
		r.setIdLugarRobo(Integer.parseInt(s.nextLine()));
		rxd.setIdLugarRobo(r.getIdLugarRobo());
		
		System.out.println("Cuantos fueron al robo?");
		int integrantesCant = Integer.parseInt(s.nextLine());
		
		if (integrantesCant >= r.getMinIntregantes() && integrantesCant <= r.getMaxIntegrantes()) {
			
			System.out.println("Ingrese el resultado del robo: (V- Victoria ; E- Empate ; F- Fracaso)");
			String op = s.nextLine();
			if (op.equalsIgnoreCase("S")) {
				resultado = "Victoria";
			}
			else if (op.equalsIgnoreCase("E")) 
			{
				resultado = "Empate";
			}
			else if (op.equalsIgnoreCase("F")) {
				resultado = "Fracaso";
			}
			
			System.out.println("Se setea la fecha y hora actual del robo del dia para el integrante."); 
			LocalDate fecha = LocalDate.now();
			LocalTime hora = LocalTime.now();
			
			for (int j = 0; j <= integrantesCant; j++) {
				
				i = find();	
											
				rxd.setFecha_robo(fecha);
				rxd.setHora_robo(hora);
				
				rxd.setResultado(resultado);
				rxd.setIdIntegrante(i.getIdIntegrante());
				
				Datarxd.saveRobo(i, r, rxd);
			}
			
		}													
	}

	private void regHorasJugadas(Integrante i) {			//no pedir ID
		System.out.println();
		Horas h = new Horas();
		DataHoras dh = new DataHoras();
				//agregar al h el integrante
			h.setIdIntegrante(i.getIdIntegrante());
		
			//se agregan hora inicio y fin
			 System.out.println("Ingrese la hora de inicio: ");
			 int hora = Integer.parseInt(s.nextLine());
			 System.out.println("Ingrese los minutos de la hora de inicio: ");
			 int minuto = Integer.parseInt(s.nextLine());
			 
			 LocalTime horaInicio = LocalTime.of(hora, minuto);
			 h.setHoraInicio(horaInicio);			 			 
			
			//codificar Fecha en el dh
			 LocalDate fecha = LocalDate.now();
			 h.setFecha(fecha);
			 
			 //agrego a DB
			 dh.add(h);
		
	}

	//validar que el nombre no coincida con alguno ya hecho con un try-catch
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


	private void regStock() {
		System.out.println();
		DataArma da = new DataArma();
		Stockarma stockarma = new Stockarma();
		DataStockarma dstock = new DataStockarma();
		
		System.out.println(da.getAll());
		
		System.out.println("Ingrese el ID del arma a registrar stock: ");
		stockarma.setIdArma(Integer.parseInt(s.nextLine()));
	
		int cantidad = 0;
		do {
			System.out.println("Ingrese la cantidad para el stock: ");
			stockarma.setCantidad(Integer.parseInt(s.nextLine()));
			
		} while (cantidad != 0);
			
		//codificar la Fecha 
		LocalDate fecha = LocalDate.now();
		stockarma.setFecha(fecha);
		
		//guardar stock en la DB
		dstock.add(stockarma);
	}

	private Ran_Subdivision showRangoSub() {
		System.out.println();
		Ran_Subdivision rsb = new Ran_Subdivision();
		DataRan_Subdivision drsb = new DataRan_Subdivision();
		DataSubdivision dsb = new DataSubdivision();
		
		System.out.println("Listado de las subdivisiones: ");
		System.out.println(dsb.getAll());
		
		System.out.println("Ingrese la ID de la subdivision para mostrar los rangos: ");
		rsb.setIdSub(Integer.parseInt(s.nextLine()));
		
		drsb.getByIdSub(rsb);
		
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

	private void updateRangoSub() {
		System.out.println();
		Ran_Subdivision rsb = new Ran_Subdivision();
		DataRan_Subdivision drsb = new DataRan_Subdivision();
		Rango r = new Rango();
		
		rsb = findRanSub();
		
		System.out.println("Nombre del rango de la subdivision (ACTUAL): " + rsb.getNombreRangoSub());
		System.out.println();
		System.out.println("Nombre del rango de la subdivision (NUEVO): "); r.setNomRango(s.nextLine());
		
		rsb.setNombreRangoSub(r.getNomRango());
		
		drsb.update(r);
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
		
		System.out.println("Nombre del robo (ACTUAL): " + robo.getNomRobo());
		System.out.println();
		System.out.println("Nombre del robo (NUEVO): "); robo.setNomRobo(s.nextLine());
		
		System.out.println("Lugar del robo (ACTUAL): " + robo.getLugarRobo());
		System.out.println();
		System.out.println("Lugar del robo (NUEVO): "); robo.setLugarRobo(s.nextLine());
		
		System.out.println("Maximo de integrantes (ACTUAL): " + robo.getMaxIntegrantes());
		System.out.println();
		System.out.println("Maximo de integrantes (NUEVO): "); robo.setMaxIntegrantes(Integer.parseInt(s.nextLine()));
		
		System.out.println("Minimo de integrantes (ACTUAL): " + robo.getMinIntregantes());
		System.out.println();
		System.out.println("Minimo de integrantes (NUEVO): "); robo.setMinIntregantes(Integer.parseInt(s.nextLine()));
		
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
		Subdivision sb = new Subdivision();
		DataSubdivision dsb = new DataSubdivision();
		
		System.out.println("Listado de las subdivisiones: ");
		System.out.println(dsb.getAll());
		
		System.out.println("A qué subdivision le crea un rango? Ingrese la ID: ");
		rsb.setIdSub(Integer.parseInt(s.nextLine()));
		
		System.out.println("Ingrese el nombre del rango: ");
		rsb.setNombreRangoSub(s.nextLine());
		
		drsb.add(rsb);
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
		
		System.out.println("Nombre del robo: "); robo.setNomRobo(s.nextLine());
		System.out.println("Lugar del robo: "); robo.setLugarRobo(s.nextLine());
		System.out.println("Ingrese el máximo de integrantes: "); robo.setMaxIntegrantes(Integer.parseInt(s.nextLine()));
		System.out.println("Ingrese el minimo de integrantes: "); robo.setMinIntregantes(Integer.parseInt(s.nextLine()));
		
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

	private String getCommand(Boolean admin) {
		
		System.out.print(" \n-- COMANDOS --");	
		
		System.out.print("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

		if (admin) 
		{
			System.out.print("\n cargaIntegrantes");
			System.out.print("\n cargaArmas");
			System.out.print("\n cargaRoles");
			System.out.print("\n cargaRobos");
			System.out.print("\n cargaMedallas");
			System.out.print("\n cargaRangos");
			System.out.print("\n cargaSubdivisiones");
			System.out.print("\n cargaRangoSub");
			
			System.out.print("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			
			System.out.print("\n actualizarIntegrantes");
			System.out.print("\n actualizarArmas");
			System.out.print("\n actualizarRoles");
			System.out.print("\n actualizarRobos");
			System.out.print("\n actualizarMedallas");
			System.out.print("\n actualizarRangos");
			System.out.print("\n actualizarSubdivisiones");
			System.out.print("\n actualizarRangoSub");
			
			System.out.print("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			
			System.out.print("\n mostrarIntegrantes");
			System.out.print("\n mostrarArmas");
			System.out.print("\n mostrarRoles");
			System.out.print("\n mostrarRobos");
			System.out.print("\n mostrarMedallas");
			System.out.print("\n mostrarRangos");
			System.out.print("\n mostrarSubdivisiones");
			System.out.print("\n mostrarRangoSub");
			
			System.out.print("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			
			System.out.print("\n registrarUnRol");
			System.out.print("\n registrarUnRango");
			System.out.print("\n registrarUnaMedalla");
			System.out.print("\n registrarUnRangoSub");
			System.out.print("\n registrarUnaSancion");
		}
		
		System.out.print("\n registrarUnStock");
		System.out.print("\n registrarHorasJugadas");
		System.out.print("\n registrarHorasFin");
		System.out.print("\n registrarUnRobo");
		
		System.out.print("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		System.out.print("\n \n salir");
		
		System.out.print("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		System.out.print("\n Escriba un comando:");
		return s.nextLine();
	}
	
	private void close() {
		s.close();
	}
	
	public Integrante login() 
	{
		Integrante i=new Integrante();
		
		System.out.print("User: ");
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
		
		System.out.print("Ingrese la ID del integrante: ");
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
		
		System.out.print("Ingrese la ID del rol: "); 
		r.setIdRol(Integer.parseInt(s.nextLine()));
		
		System.out.println("La ID ingresada: ");
		System.out.println(dr.getById(r).toString());
		
		i.addRol(r); // agrego el rol a la persona
		ctrlLogin.add(i); // agrego la persona
		
		dr.saveRole(i,r); // agrego el rol a la tabla de rol_integrante
		
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
		
		System.out.print("Ingrese la ID del rol: "); 
		r.setIdRol(Integer.parseInt(s.nextLine()));		
		
		System.out.println("El rol, actualizado, es: ");
		System.out.println(dr.getById(r).toString());
		
		ctrlLogin.update(i); // agrego la persona
		
		dr.saveRole(i,r); // agrego el rol a la tabla de rol_persona
		
		System.out.println();
		System.out.println("Operacion realizada con Exito");
	}

}