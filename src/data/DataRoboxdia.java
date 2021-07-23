package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
					"insert into roboxdia (idLugarRobo, idIntegrante, fecha_robo, hora_robo,resultado) values(?,?,?,?,?)");
			
			stmt.setInt(1, rd.getIdLugarRobo());
			stmt.setInt(2, intg.getIdIntegrante());
			stmt.setObject(3, rd.getFecha_robo());
			stmt.setObject(3, rd.getHora_robo());
			stmt.setString(3, rd.getResultado());
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

	public void setRobos(Integrante intg) {	
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
					r.setDescripcion(rs.getString("descripcion"));
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
