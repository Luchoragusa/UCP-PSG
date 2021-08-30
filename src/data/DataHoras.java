package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

import com.mysql.cj.MysqlType;

import entities.Horas;
import entities.Integrante;


public class DataHoras {
	
public Horas getHorasDelIntegrante(int id) {
		
	PreparedStatement stmt=null;
	ResultSet rs=null;
	Horas h = null;
	
	try 
	{
		stmt = DbConnector.getInstancia().getConn().prepareStatement(
		 "select * FROM horas WHERE idIntegrante = ? ORDER BY fecha desc, horaInicio desc limit 1");
		stmt.setInt(1, id);
		rs=stmt.executeQuery();
		
		if(rs!=null) 
		{
			while(rs.next()) 
			{
				h = new Horas();
				h.setIdIntegrante(id);
				h.setFecha(rs.getDate("fecha").toLocalDate());
				h.setHoraInicio(rs.getObject("horaInicio", LocalTime.class));
				h.setHoraFin(rs.getObject("horaFin", LocalTime.class));	
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
	return h;
	}
	
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
					h.setHoraInicio(rs.getObject("horaInicio", LocalTime.class));
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
					h.setHoraInicio(rs.getObject("horaInicio", LocalTime.class));
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
							"insert into horas(idIntegrante,horaInicio,fecha) values(?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setInt(1, hr.getIdIntegrante());
			stmt.setObject (2, hr.getHoraInicio()); 
			stmt.setObject(3, hr.getFecha());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next())
            {
                hr.setHoraFin(keyResultSet.getTime(1).toLocalTime());
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
							"update horas set horaFin = ?, fechaFin = ? where idIntegrante=? and fecha = ? and horaInicio = ?");
			stmt.setObject(1, hr.getHoraFin());		
			stmt.setObject(2, hr.getFechaFin());
			stmt.setInt(3, hr.getIdIntegrante());
			stmt.setObject(4, hr.getFecha());
			stmt.setObject(5, hr.getHoraInicio());
			
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
							"delete from horas where idIntegrante = ? and horaFin is null");
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

	public LinkedList<Horas> getTuplasIntegrante(int id, LocalDate fecha, LocalDate fechaFin) 
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Horas> h = new LinkedList<>();
		
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
			 "select horasJugadas FROM horas WHERE idIntegrante = ? and fecha BETWEEN ? and ? and horaFin is not null ");
			
			stmt.setInt(1, id);
			stmt.setObject(2, fecha);
			stmt.setObject(3, fechaFin);
			
			rs=stmt.executeQuery();
			
			if(rs!=null) 
			{
				while(rs.next()) 
				{
					Horas h1 = new Horas();

					h1.setHorasJugadas(rs.getObject("horasJugadas", LocalTime.class));
					
					h.add(h1);
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
		return h;
		
	}

	public LinkedList<Horas> getAllTuplas(LocalDate fecha, LocalDate fechaFin){
		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Horas> h = new LinkedList<>();
		
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
			 "select horasJugadas, idIntegrante FROM horas WHERE fecha BETWEEN ? and ? and horaFin is not null ");
			
			stmt.setObject(1, fecha);
			stmt.setObject(2, fechaFin);
			
			rs=stmt.executeQuery();
			
			if(rs!=null) 
			{
				while(rs.next()) 
				{
					Horas h1 = new Horas();

					h1.setHorasJugadas(rs.getObject("horasJugadas", LocalTime.class));
					h1.setIdIntegrante(rs.getInt("idIntegrante"));
					
					h.add(h1);
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
		return h;
	}
	
	public void diferenciaHoras(Horas h) {

		PreparedStatement stmt= null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement("update horas set horasJugadas = timediff(horaFin, horaInicio) where idIntegrante = ? and horaInicio = ? and horaFin = ?");
			stmt.setInt(1, h.getIdIntegrante());
			stmt.setObject(2, h.getHoraInicio());	
			stmt.setObject(3, h.getHoraFin());	
			
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
