package logic;

import java.util.LinkedList;

import data.*;
import entities.*;

public class Login 
{
	private DataIntegrante di;
	
	public Login() 
	{
		di=new DataIntegrante();
	}
	
	public Integrante validate(Integrante i) 
	{
		/* para hacer mas seguro el manejo de passwords este sera un lugar 
		 * adecuado para generar un hash de la password utilizando un cifrado
		 * asimétrico como sha256j y utilizar el hash en lugar de la password en plano 
		 */
		return di.getByUser(i);
	}

	public LinkedList<Integrante> getAll()
	{
		return di.getAll();
	}

	public LinkedList<Integrante> getByApellido(Integrante I)
	{
		return di.getByApellido(I);
	}

	public void add(Integrante I)
	{
		di.add(I);
	}
	
	public void update(Integrante I)
	{
		di.update(I);
	}
	
	public void delete(Integrante I)
	{
		di.delete(I);
	}
}
