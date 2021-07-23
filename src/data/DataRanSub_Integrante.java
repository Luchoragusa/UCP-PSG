package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Ransub_integrante;

public class DataRanSub_Integrante {
	public void add(Ransub_integrante rsi) 									
	{
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into ransub_integrante(idIntegrante, fecha_desde, idRangoSub) values(?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setInt(1, rsi.getIdIntegrante());
			stmt.setObject(2, rsi.getFecha_desde());
			stmt.setInt(3, rsi.getIdRangoSub());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next())
            {
            	rsi.setIdIntegrante(keyResultSet.getInt(1));
            	rsi.setFecha_desde(keyResultSet.getDate(2).toLocalDate()); 
            	rsi.setIdRangoSub(keyResultSet.getInt(3)); // creo q es al pedo pq no le devolvemos
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

}
