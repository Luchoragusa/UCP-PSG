package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import entities.Horas;


public class DataHoras {
	public LinkedList<Horas> getById(Horas hr){
		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Horas> hras= new LinkedList<>();
		
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
			 "select horaInicio,horaFin,fecha from horas where idIntegrante = ?");
			stmt.setInt(1, hr.getIdIntegrante());
			rs=stmt.executeQuery();
			
			if(rs!=null) 
			{
				while(rs.next()) 
				{
					Horas h=new Horas();
					h.setIdIntegrante(hr.getIdIntegrante());
					h.setFecha(rs.getDate("fecha").toLocalDate());
					h.setHoraInicio(rs.getTime("horaInicio").toLocalTime());
					h.setHoraFin(rs.getTime("horaFin").toLocalTime());	
					hras.add(h);
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
		return hras;
	}
	
	public LinkedList<Horas> getByFecha(Horas hr){
		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Horas> hras= new LinkedList<>();
		
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
			 "select idIntegrante, horaInicio, horaFin from horas where fecha = ?");
			stmt.setInt(1, hr.getIdIntegrante());
			rs=stmt.executeQuery();
			
			if(rs!=null) 
			{
				while(rs.next()) 
				{
					Horas h=new Horas();
					h.setIdIntegrante(rs.getInt("idIntegrante"));
					h.setFecha(hr.getFecha());
					h.setHoraInicio(rs.getTime("horaInicio").toLocalTime());
					h.setHoraFin(rs.getTime("horaFin").toLocalTime());	
					hras.add(h);
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
		return hras;
	}

	public void add (Horas hr) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into horas(idIntegrante,horaInicio,horaFin,fecha) values(?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setInt(1, hr.getIdIntegrante());
			stmt.setObject(2, hr.getHoraInicio());
			stmt.setObject(3, hr.getHoraFin());
			stmt.setObject(4, hr.getFecha());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next())
            {
                hr.setIdIntegrante(keyResultSet.getInt(1));
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
	
	public void update(Horas hr) {

		PreparedStatement stmt= null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update horas set horaInicio=?, horaFin = ?, fecha = ? where idIntegrante=?");
			stmt.setObject(1, hr.getHoraInicio());
			stmt.setObject(2, hr.getHoraFin());
			stmt.setObject(3, hr.getFecha());
			
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
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } 
            catch (SQLException e) 
            {
            	e.printStackTrace();
            }
		}
	
	}

	public void remove(Horas hr) {

		PreparedStatement stmt= null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from horas where idIntegrante=?");
			stmt.setInt(1, hr.getIdIntegrante());
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
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } 
            catch (SQLException e) 
            {
            	e.printStackTrace();
            }
		}
	
	}
}
