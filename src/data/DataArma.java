package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.Arma;


public class DataArma {

	public LinkedList<Arma> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Arma> armas= new LinkedList<>();
		
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from arma");
			if(rs!=null) 
			{
				while(rs.next()) 
				{
					Arma a = new Arma();
					a.setIdArma(rs.getInt("idArma"));
					a.setTipoArma(rs.getString("tipoArma"));
					a.setNombreArma(rs.getString("nombreArma"));
					armas.add(a);
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
		
		return armas;
	}
	
	public Arma getById(Arma armaToSearch) {
		Arma a = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from arma where idArma=?"
					);
			stmt.setInt(1, armaToSearch.getIdArma());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) 
			{
				a=new Arma();
				a.setIdArma(rs.getInt("idArma"));
				a.setTipoArma(rs.getString("tipoArma"));
				a.setNombreArma(rs.getString("nombreArma"));
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
		return a;
	}

	public Arma getByNombre(Arma armaToSearch) {
		Arma a = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from arma where nombreArma=?"
					);
			stmt.setString(1, armaToSearch.getNombreArma());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) 
			{
				a=new Arma();
				a.setIdArma(rs.getInt("idArma"));
				a.setTipoArma(rs.getString("tipoArma"));
				a.setNombreArma(rs.getString("nombreArma"));
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
		
		return a;
	}

	public LinkedList<Arma> getByTipo(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Arma> armas= new LinkedList<>();
		
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from arma where tipoArma = ?");
			if(rs!=null) 
			{
				while(rs.next()) 
				{
					Arma a = new Arma();
					a.setIdArma(rs.getInt("idArma"));
					a.setTipoArma(rs.getString("tipoArma"));
					a.setNombreArma(rs.getString("nombreArma"));
					armas.add(a);
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
		
		return armas;
	}

	public void add(Arma a) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into arma(nombreArma,tipoArma) values(?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, a.getNombreArma());
			stmt.setString(2, a.getTipoArma());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next())
            {
                a.setIdArma(keyResultSet.getInt(1));
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

	public void update(Arma a) {
		PreparedStatement stmt= null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update arma set nombreArma=?, tipoArma = ? where idArma=?");
			stmt.setString(1, a.getNombreArma());
			stmt.setString(2, a.getTipoArma());
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

	public void delete(Arma a) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement("delete from arma where  idArma = ?");
			stmt.setInt(1, a.getIdArma());
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
