package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.Integrante;
import entities.Ran_Subdivision;
import entities.Rango;
import entities.Ran_Integrante;

public class DataRan_Subdivision {

	public LinkedList<Ran_Subdivision> getAll()
	{
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Ran_Subdivision> rangosSub= new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from ran_subdivision");
			if(rs!=null) 
			{
				while(rs.next()) 
				{
					Ran_Subdivision rsb =new Ran_Subdivision();
					rsb.setIdSub(rs.getInt("idSub"));
					rsb.setNombreRangoSub(rs.getString("nombreRangoSub"));
					rangosSub.add(rsb);
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
		return rangosSub;
	}
	
	public LinkedList<Ran_Subdivision> getByIdSub(Ran_Subdivision rsub) 
	{

		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Ran_Subdivision> rsubs= new LinkedList<>();
		
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
			 "select nombreRangoSub from ran_subdivision where idSub = ?");
			stmt.setInt(1, rsub.getIdSub());
			rs=stmt.executeQuery();
			
			if(rs!=null) 
			{
				while(rs.next()) 
				{
					Ran_Subdivision s =new Ran_Subdivision();
					s.setIdSub(rsub.getIdSub());
					s.setNombreRangoSub(rs.getString("nombreRangoSub"));			
					rsubs.add(s);
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
		return rsubs;
	
	}
	
	public Ran_Subdivision getByNombre(Ran_Subdivision rsub) 
	{
		Ran_Subdivision rsb = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from ran_subdivision where nombreRangoSub=?"
					);
			stmt.setString(1, rsub.getNombreRangoSub());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) 
			{
				rsb = new Ran_Subdivision();
				rsb.setIdSub(rs.getInt("idSub"));
				rsb.setNombreRangoSub(rs.getString("nombreRangoSub"));
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
		return rsb;
	}
	
	public void add(Rango rango) 									
	{
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into ran_subdivision(idSub, nombRango) values(?)",
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
							"delete from rol where idRango=?");
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

	public void saveRango(Integrante intg, Rango rango, Ran_Integrante ri) 
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement( 
					"insert into ran_integrante (idRango, idIntegrante, fecha_desde) values(?,?,?)");
			
			stmt.setInt(1, rango.getIdRango());
			stmt.setInt(2, intg.getIdIntegrante());
			stmt.setObject(3, ri.getFecha_desde());
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
