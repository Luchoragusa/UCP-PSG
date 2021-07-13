package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.Integrante;
import entities.Rol;

public class DataIntegrante {

	public Integrante getByUser(Integrante inte) {
		
		DataRol dr=new DataRol();
		Integrante i=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select idIntegrante,nombre,apellido,discorId,steamHex from persona where usuario=? and pw=?"
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
				i.setDiscordId(rs.getString("discorId"));
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

	public LinkedList<Integrante> getAll() {
		
		DataRol dr=new DataRol();
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Integrante> inte= new LinkedList<>();		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select idIntegrante,nombre,apellido,discorId,steamHex from integrante");
		
			if(rs!=null) {
				while(rs.next()) {
					Integrante i=new Integrante();
					
					i.setIdIntegrante(rs.getInt("idIntegrante"));
					i.setNombre(rs.getString("nombre"));
					i.setApellido(rs.getString("apellido"));
					i.setDiscordId(rs.getString("discorId"));
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
		
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
			 "select idIntegrante,nombre,discorId,steamHex,usuario from persona where apellido = ?");
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
					i.setDiscordId(rs.getString("email"));
					i.setSteamHex(rs.getString("tel"));
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
							"insert into persona(nombre, apellido, discordId, steamHex, usuario, pw) values(?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, i.getNombre());
			stmt.setString(2, i.getApellido());
			stmt.setString(3, i.getDiscordId());
			stmt.setString(4, i.getSteamHex());
			stmt.setString(5, i.getUsuario());
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
		// TODO Esbozo de método generado automáticamente
		
	}

	public void delete(Integrante i) {
		// TODO Esbozo de método generado automáticamente
		
	}

}
