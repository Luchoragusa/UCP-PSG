package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.Subdivision;

public class DataSubdivision {



	public LinkedList<Subdivision> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Subdivision> subdivisiones= new LinkedList<>();
		
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from subdivision");
			if(rs!=null) 
			{
				while(rs.next()) 
				{
					Subdivision s = new Subdivision();
					s.setIdSub(rs.getInt("idSub"));
					s.setDescripcion(rs.getString("descripcion"));
					s.setNomSubDivision(rs.getString("nomSubdivision"));
					subdivisiones.add(s);
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
		
		return subdivisiones;
	}
	
	public Subdivision getById(Subdivision subdivisionesToSearch) {
		Subdivision s = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from subdivision where idSub=?"
					);
			stmt.setInt(1, subdivisionesToSearch.getIdSub());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) 
			{
				s=new Subdivision();
				s.setIdSub(rs.getInt("idSub"));
				s.setDescripcion(rs.getString("tipoDescripcion"));
				s.setNomSubDivision(rs.getString("nomSubdivision"));
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
		return s;
	}

	public Subdivision getByNombre(Subdivision subdivisionesToSearch) {
		Subdivision s = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from subdivisiones where nomSubdivision=?"
					);
			stmt.setString(1, subdivisionesToSearch.getNomSubDivision());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) 
			{
				s = new Subdivision();
				s.setIdSub(rs.getInt("idSub"));
				s.setDescripcion(rs.getString("descripcion"));
				s.setNomSubDivision(rs.getString("nomSubdivision"));
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
		
		return s;
	}

	public LinkedList<Subdivision> getByDescripcion(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Subdivision> subdivisiones= new LinkedList<>();
		
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from subdivision where descripcion = ?");
			if(rs!=null) 
			{
				while(rs.next()) 
				{
					Subdivision s = new Subdivision();
					s.setIdSub(rs.getInt("idSub"));
					s.setDescripcion(rs.getString("descripcion"));
					s.setNomSubDivision(rs.getString("nomSubdivision"));
					subdivisiones.add(s);
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
		
		return subdivisiones;
	}

	public void add(Subdivision s) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into subdivision(descripcion,nomSubdivision) values(?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, s.getDescripcion());
			stmt.setString(2, s.getNomSubDivision());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next())
            {
                s.setIdSub(keyResultSet.getInt(1));
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

	public void update(Subdivision s) {
		PreparedStatement stmt= null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update subdivision set descripcion=?, nomSubdivision = ? where idSub=?");
			stmt.setString(1, s.getDescripcion());
			stmt.setString(2, s.getNomSubDivision());
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

	public void delete(Subdivision s) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement("delete from subdivision where  idSub = ?");
			stmt.setInt(1, s.getIdSub());
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

	
}
