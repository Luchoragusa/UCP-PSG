package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.*;

public class DataRobo 
{
	
	public LinkedList<Robo> getAll()
	{
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Robo> robos= new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from robo");
			if(rs!=null) 
			{
				while(rs.next()) 
				{
					Robo r=new Robo();
					r.setIdLugarRobo(rs.getInt("idLugarRobo"));
					r.setDescripcion(rs.getString("descripcion"));
					r.setNomRobo(rs.getString("nomRobo"));
					r.setLugarRobo(rs.getString("lugarRobo"));
					robos.add(r);
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
		return robos;
	}
	
	public Robo getById(Robo roboToSearch) 
	{
		Robo r=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from robo where idLugarRobo=?"
					);
			stmt.setInt(1, roboToSearch.getIdLugarRobo());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) 
			{
				r=new Robo();
				r.setIdLugarRobo(rs.getInt("idLugarRobo"));
				r.setDescripcion(rs.getString("descripcion"));
				r.setNomRobo(rs.getString("nomRobo"));
				r.setLugarRobo(rs.getString("lugarRobo"));
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
		return r;
	}
	
	public Robo getByNomb(Robo roboToSearch) 
	{
		Robo r=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from rol where nomRobo=?"
					);
			stmt.setString(1, roboToSearch.getNomRobo());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) 
			{
				r=new Robo();
				r.setIdLugarRobo(rs.getInt("idLugarRobo"));
				r.setDescripcion(rs.getString("descripcion"));
				r.setNomRobo(rs.getString("nomRobo"));
				r.setLugarRobo(rs.getString("lugarRobo"));
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
		return r;
	}
	
	public void add(Robo robo) 
	{
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into robo(descripcion, nomRobo, lugarRobo) values(?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, robo.getDescripcion());
			stmt.setString(2, robo.getNomRobo());
			stmt.setString(3, robo.getLugarRobo());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next())
            {
                robo.setIdLugarRobo(keyResultSet.getInt(1));   // creo q es al pedo pq no le devolvemos
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

	public void update(Robo robo) 
	{
		PreparedStatement stmt= null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update robo set descripcion=?, nomRobo=?, lugarRobo=? where idLugarRobo=?");
			stmt.setString(1, robo.getDescripcion());
			stmt.setString(2, robo.getNomRobo());
			stmt.setString(3, robo.getLugarRobo());
			stmt.setInt(4, robo.getIdLugarRobo());
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

	public void remove(Robo robo) 
	{
		PreparedStatement stmt= null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from robo where idLugarRobo=?");
			stmt.setInt(1, robo.getIdLugarRobo());
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
