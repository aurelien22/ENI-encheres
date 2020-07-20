package dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class ConnectionProvider {
	
	private static DataSource datasource;
	
	/**
	 * Au chargement de la classe, la DataSource est recherchée dans l'arbre JNDI
	 */
	static
	{
		Context context;
		
		try {
			
			context = new InitialContext();
			
			ConnectionProvider.datasource = (DataSource)context.lookup("java:comp/env/jdbc/co");
			
			
		} catch (NamingException e) {
			
			e.printStackTrace();
			
			throw new RuntimeException("Impossible d'accéder à la base de données");
		
		}	
	}
	
	/**
	 * Cette méthode retourne une connection opérationelle issue du pool de connexion
	 * 
	 * @return Une connection opérationelle issue du pool de connexion
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException
	{
		return ConnectionProvider.datasource.getConnection();
	}

}
