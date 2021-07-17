package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Date;
import java.util.GregorianCalendar;
import entities.Horas;

public class DataHoras {
	public LinkedList<Horas> getAll(){

		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Horas> horas= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from horas");
			if(rs!=null) 
			{
				while(rs.next()) 
				{
					Horas h = new Horas();
					h.setIdIntegrante(rs.getInt("idIntegrante"));
					horas.add(h);
				}
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		
		return horas;
		//NO ESTA TERMINADO
	}
	
	
}
