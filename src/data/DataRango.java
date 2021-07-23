package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.*;

public class DataRango 
{
	
	public LinkedList<Rango> getAll()
	{
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Rango> rangos= new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from rango");
			if(rs!=null) 
			{
				while(rs.next()) 
				{
					Rango r=new Rango();
					r.setIdRango(rs.getInt("idRango"));
					r.setNomRango(rs.getString("nombRango"));
					rangos.add(r);
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
		return rangos;
	}
	
	public Rango getById(Rango rangoToSearch) 
	{
		Rango r=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from rango where idRango=?"
					);
			stmt.setInt(1, rangoToSearch.getIdRango());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) 
			{
				r=new Rango();
				r.setIdRango(rs.getInt("idRango"));
				r.setNomRango(rs.getString("nomRango"));
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
	
	public Rango getByNomb(Rango rangoToSearch) 
	{
		Rango r=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from rango where nombRango=?"
					);
			stmt.setString(1, rangoToSearch.getNomRango());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) 
			{
				r=new Rango();
				r.setIdRango(rs.getInt("idRango"));
				r.setNomRango(rs.getString("nombRango"));
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
	
	public void add(Rango rango) 
	{
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into rango(nombRango) values(?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, rango.getNomRango());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next())
            {
                rango.setIdRango(keyResultSet.getInt(1));   // creo q es al pedo pq no le devolvemos
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

	public void update(Rango rango) 
	{
		PreparedStatement stmt= null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update rango set nombRango=? where idRango=?");
			stmt.setString(1, rango.getNomRango());
			stmt.setInt(2, rango.getIdRango());
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

	public void remove(Rango rango) 
	{
		PreparedStatement stmt= null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from rango where idRango=?");
			stmt.setInt(1, rango.getIdRango());
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

	public void saveRango(Integrante intg, Rango rango) 
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement( 
					"insert into ran_integrante (idRango, idIntegrante, fecha_desde) values(?,?,?)");
			
			stmt.setInt(1, rango.getIdRango());
			stmt.setInt(2, intg.getIdIntegrante());
			//stmt.setDate(3, ); funcion que de la fecha de hoy
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

	public void deleteRango(Integrante intg) 
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement( 
					"delete from ran_integrante where idIntegrante = ?");
			
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

}
