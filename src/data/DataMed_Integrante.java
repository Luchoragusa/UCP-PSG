package data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Integrante;
import entities.Medalla;
import entities.Med_integrante;

public class DataMed_Integrante {

	public void saveMedalla(Integrante intg, Medalla med, Med_integrante mi) {

		PreparedStatement stmt=null;
		ResultSet rs=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement( 
					"insert into med_Integrante (idIntegrante, idMedalla,fecha_recompensa, recompensa) values(?,?,?,?)");
			
			stmt.setInt(1, intg.getIdIntegrante());
			stmt.setInt(2, med.getIdMedalla());
			stmt.setObject(3, mi.getFecha_recompensa());
			stmt.setInt(4, mi.getIdMedalla());
			stmt.executeUpdate();
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
	
	}
	
	public void deleteMedalla(Integrante intg) {

		PreparedStatement stmt=null;
		ResultSet rs=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement( 
					"delete from med_integrante where idIntegrante = ?");
			
			stmt.setInt(1, intg.getIdIntegrante());
			stmt.execute();
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
	
	}
	
	public void setMedallas(Integrante intg) {

		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try  
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					  "select medalla.* "
					+ "from medalla "
					+ "inner join med_integrante "
					+ "on medalla.idMedalla = med_integrante.idMedalla "
					+ "where idIntegrante=?"
					);
			stmt.setInt(1, intg.getIdIntegrante());
			rs= stmt.executeQuery();
			if(rs!=null) 
			{
				while(rs.next()) 
				{
					Med_integrante m = new Med_integrante();
					m.setIdMedalla(rs.getInt("idMedalla"));
					m.setIdIntegrante(rs.getInt("idIntegrante"));
					m.setRecompensa(rs.getString("recompensa"));
					m.setFecha_recompensa(rs.getDate("fecha_recompensa").toLocalDate());
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
	
	}
}
