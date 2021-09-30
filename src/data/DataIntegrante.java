package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.Integrante;

public class DataIntegrante {

	public Integrante getByUser(Integrante inte) {
		
		DataRol dr=new DataRol();
		Integrante i=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select idIntegrante,nombre,apellido,discordId,steamHex from integrante where usuario=? and pw=?"
					);
			stmt.setString(1, inte.getUsuario());
			stmt.setString(2, inte.getPw());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				i=new Integrante();
				i.setIdIntegrante(rs.getInt("idIntegrante"));
				i.setNombre(rs.getString("nombre"));
				i.setApellido(rs.getString("apellido"));
				i.setSteamHex(rs.getString("steamHex"));
				i.setDiscordId(rs.getString("discordId"));
				//
				dr.setRoles(i);
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return i;
	}

	public Integrante getByIdIntegrante(Integrante inte) {


		DataRol dr=new DataRol();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Integrante i=null;
		
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
			 "select nombre,apellido, discordId,steamHex,usuario from integrante where idIntegrante = ?");
			stmt.setInt(1, inte.getIdIntegrante());
			rs=stmt.executeQuery();
			
			if(rs!=null && rs.next()) 
			{
					i=new Integrante();					
					i.setNombre(rs.getString("nombre"));
					i.setApellido(rs.getString("apellido"));
					i.setIdIntegrante(inte.getIdIntegrante());
					i.setDiscordId(rs.getString("discordId"));
					i.setSteamHex(rs.getString("steamHex"));
					i.setUsuario(rs.getString("usuario"));
					
					dr.setRoles(i);
			}	
		} catch (SQLException e) {
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
		return i;
	}
	
	public LinkedList<Integrante> getAll() 
	{
		DataRol dr=new DataRol();
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Integrante> inte= new LinkedList<>();		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select idIntegrante,nombre,apellido,discordId,steamHex from integrante");
		
			if(rs!=null) {
				while(rs.next()) {
					Integrante i=new Integrante();
					
					i.setIdIntegrante(rs.getInt("idIntegrante"));
					i.setNombre(rs.getString("nombre"));
					i.setApellido(rs.getString("apellido"));
					i.setDiscordId(rs.getString("discordId"));
					i.setSteamHex(rs.getString("steamHex"));
					dr.setRoles(i);
					
					inte.add(i);
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
		return inte;
	}
	
	public LinkedList<Integrante> getByApellido(Integrante inte) {

		DataRol dr=new DataRol();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Integrante> integ= new LinkedList<>();
		//rfrfr
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
			 "select idIntegrante,nombre,discordId,steamHex,usuario from integrante where apellido = ?");
			stmt.setString(1, inte.getApellido());
			rs=stmt.executeQuery();
			
			if(rs!=null) 
			{
				while(rs.next()) 
				{
					Integrante i=new Integrante();
					i.setIdIntegrante(rs.getInt("idIntegrante"));
					i.setNombre(rs.getString("nombre"));
					i.setApellido(inte.getApellido());
					i.setDiscordId(rs.getString("discordId"));
					i.setSteamHex(rs.getString("steamHex"));
					i.setUsuario(rs.getString("usuario"));
					
					dr.setRoles(i);
					
					integ.add(i);
				}
			}	
		} catch (SQLException e) {
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
		return integ;
	
	}

	public void add(Integrante i) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into integrante(nombre, apellido, discordId, steamHex, usuario, pw) values(?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, i.getNombre());
			stmt.setString(2, i.getApellido());
			stmt.setString(3, i.getDiscordId());
			stmt.setString(4, i.getSteamHex());
			stmt.setString(5, i.getUsuario());
			stmt.setString(6, i.getPw());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next())
            {
                i.setIdIntegrante(keyResultSet.getInt(1));
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
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } 
            catch (SQLException e) 
            {
            	e.printStackTrace();
            }
		}
	}

	public void update(Integrante i) {

		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update integrante set nombre=?, apellido=?, usuario=?, pw=?, discordId=?, steamHex=? where idIntegrante = ?");
			
			stmt.setString(1, i.getNombre());
			stmt.setString(2, i.getApellido());
			stmt.setString(3, i.getUsuario());
			stmt.setString(4, i.getPw());
			stmt.setString(5, i.getDiscordId());
			stmt.setString(6, i.getSteamHex());	
			stmt.setInt(7, i.getIdIntegrante());	
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
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } 
            catch (SQLException e) 
            {
            	e.printStackTrace();
            }
		}
    
	}

	public void delete(Integrante i) {

		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement("delete from integrante where idIntegrante = ?");
			stmt.setInt(1, i.getIdIntegrante());	
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
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } 
            catch (SQLException e) 
            {
            	e.printStackTrace();
            }
		}
    
	}

	public LinkedList<Integrante> getServicio() 
	{
		DataRol dr=new DataRol();
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Integrante> uActivos= new LinkedList<>();		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select nombre, apellido, i.idIntegrante\r\n"
					+ "from horas\r\n"
					+ "inner join integrante i on horas.idIntegrante = i.idIntegrante\r\n"
					+ "where horaInicio is not null and horaFin is null");
		
			if(rs!=null) 
			{
				while(rs.next()) 
				{
					Integrante i=new Integrante();
					
					i.setIdIntegrante(rs.getInt("idIntegrante"));
					i.setNombre(rs.getString("nombre"));
					i.setApellido(rs.getString("apellido"));
					uActivos.add(i);
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
		return uActivos;
	}

}
