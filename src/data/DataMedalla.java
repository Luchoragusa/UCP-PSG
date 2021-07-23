package data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.Medalla;

public class DataMedalla {
	
	public LinkedList<Medalla> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Medalla> medallas= new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from medalla");
			if(rs!=null) 
			{
				while(rs.next()) 
				{
					Medalla m = new Medalla();
					m.setIdMedalla(rs.getInt("idMedalla"));
					m.setTipoMedalla(rs.getString("tipomedalla"));
					m.setNomMedalla(rs.getString("nomMedalla"));
					medallas.add(m);
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
		return medallas;
		}

	public Medalla getById(Medalla medallaToSearch) {
		Medalla m = null;
		PreparedStatement stmt = null;
		ResultSet rs=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from medalla where idMedalla=?"
					);
			stmt.setInt(1, medallaToSearch.getIdMedalla());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) 
			{
				m=new Medalla();
				m.setIdMedalla(rs.getInt("idMedalla"));
				m.setTipoMedalla(rs.getString("tipomedalla"));
				m.setNomMedalla(rs.getString("nomMedalla"));
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
		return m;
	}

	public Medalla getByNombre(Medalla medallaToSearch) {
		Medalla m = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from medalla where nomMedalla=?"
					);
			stmt.setString(1, medallaToSearch.getNomMedalla());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) 
			{
				m=new Medalla();
				m.setIdMedalla(rs.getInt("idMedalla"));
				m.setTipoMedalla(rs.getString("tipomedalla"));
				m.setNomMedalla(rs.getString("nomMedalla"));
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
		
		return m;
		
		
		
	}

	public LinkedList<Medalla> getByTipo(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Medalla> medallas= new LinkedList<>();
		
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from medalla where tipoMedalla = ?");
			if(rs!=null) 
			{
				while(rs.next()) 
				{
					Medalla m = new Medalla();
					m.setIdMedalla(rs.getInt("idMedalla"));
					m.setTipoMedalla(rs.getString("tipomedalla"));
					m.setNomMedalla(rs.getString("nomMedalla"));
					medallas.add(m);
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
		
		return medallas;
	
		
	}

	public void add(Medalla m) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into medalla(nomMedalla,tipoMedalla) values(?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, m.getNomMedalla());
			stmt.setString(2, m.getTipoMedalla());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next())
            {
                m.setIdMedalla(keyResultSet.getInt(1));
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

	public void update(Medalla m) {
		PreparedStatement stmt= null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update medalla set nomMedalla=?, tipoMedalla = ? where idMedalla=?");
			stmt.setString(1, m.getNomMedalla());
			stmt.setString(2, m.getTipoMedalla());
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

	public void delete(Medalla m) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement("delete from medalla where  idMedalla = ?");
			stmt.setInt(1, m.getIdMedalla());
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