package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
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
					rd.setIdRobo(rs.getInt("max(idRobo)"));
					rd.setIdRobo(rd.getIdRobo()+1);
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

	public void getUltimos5robos() // hacer el Hash para las 3 entidades
	{	
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Integrante i = null;
		Robo r = null;
		Roboxdia rxd = null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					  "select i.nombre, i.apellido, r.nomRobo, resultado, hora_robo, idRobo "
					+ "from roboxdia "
					+ "inner join integrante i on roboxdia.idIntegrante = i.idIntegrante "
					+ "where idRobo between ((select max(idRobo)-5 from roboxdia)) and (select max(idRobo) from roboxdia) "
					+ "order by idRobo asc"
					);
			rs= stmt.executeQuery();
			if(rs!=null) 
			{
				while(rs.next()) 
				{
					r=new Robo();
					r.setNomRobo(rs.getString("nomRobo"));
					
					rxd=new Roboxdia();
					rxd.setResultado(rs.getString("resultado"));
					rxd.setIdRobo(rs.getInt("idRobo"));
					rxd.setHora_robo(rs.getObject("hora_robo", LocalTime.class));
					
					i=new Integrante();
					i.setNombre(rs.getString("nombre"));
					i.setApellido(rs.getString("apellido"));
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
