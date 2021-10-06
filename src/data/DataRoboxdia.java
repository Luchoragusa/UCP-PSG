package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import entities.Integrante;
import entities.Robo;
import entities.Roboxdia;

public class DataRoboxdia {
	
	public void saveRobo(Integrante intg, Robo rob, Roboxdia rd) {

		PreparedStatement stmt=null;
		ResultSet rs=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement( 
					"insert into roboxdia (idLugarRobo, idIntegrante, fecha_robo, hora_robo,resultado, idRobo) values(?,?,?,?,?,?)");
			
			stmt.setInt(1, rd.getIdLugarRobo());
			stmt.setInt(2, intg.getIdIntegrante());
			stmt.setObject(3, rd.getFecha_robo());
			stmt.setObject(4, rd.getHora_robo());
			stmt.setString(5, rd.getResultado());
			stmt.setInt(6, rd.getIdRobo());
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
	
	public void deleteRobo(Integrante intg) {

		PreparedStatement stmt=null;
		ResultSet rs=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement( 
					"delete from roboxdia where idIntegrante = ?");
			
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

	public void setRobos(Integrante intg) 
	{	
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					  "select robo.* "
					+ "from robo "
					+ "inner join roboxdia "
					+ "on robo.idLugarRobo = roboxdia.idLugarRobo "
					+ "where idIntegrante=?"
					);
			stmt.setInt(1, intg.getIdIntegrante());
			rs= stmt.executeQuery();
			if(rs!=null) 
			{
				while(rs.next()) 
				{
					Robo r=new Robo();
					r.setIdLugarRobo(rs.getInt("idLugarRobo"));
					r.setNomRobo(rs.getString("nomRobo"));
					r.setLugarRobo(rs.getString("lugarRobo"));
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
	
	public Roboxdia getLastIdRobo() 
	{	
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Roboxdia rd = null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement("select max(idRobo) from roboxdia");
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()) 
			{
				rd = new Roboxdia();
				rd.setIdRobo(rs.getInt("idRobo"));
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
		return rd;
	}
	
	public void getLastRobos() 
	{	
		LinkedList<Roboxdia> lastR = null;
		Roboxdia rd = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement( "select * from roboxdia where idLugarRobo = (select max(idLugarRobo) from roboxdia )");
			rs= stmt.executeQuery();
			if(rs!=null) 
			{
				while(rs.next()) 
				{
					Robo r=new Robo();
					r.setIdLugarRobo(rs.getInt("idLugarRobo"));
					r.setNomRobo(rs.getString("nomRobo"));
					r.setLugarRobo(rs.getString("lugarRobo"));
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
