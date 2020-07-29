package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bo.Enchere;
import bo.Utilisateur;

public class EnchereDAOJdbcImpl implements EnchereDAO {

	@Override
	public void insert(Enchere enchere) throws Exception {
		
			
			java.sql.Timestamp dateSQL = new java.sql.Timestamp(enchere.getDateEnchere().getTime());
					
			try {
			
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement ps = cnx.prepareStatement("INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?, ?, ?, ?);");
			
			ps.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
			ps.setInt(2, enchere.getArticle().getNoArticle());
			ps.setTimestamp(3, dateSQL);
			ps.setInt(4, enchere.getMontantEnchere());
			
			ps.executeUpdate();
			
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public List<Enchere> select() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verifierPresenceEnchere(int noUtilisateur, int noArticle) throws Exception {
		
		ResultSet rs = null;
		
		try {
			
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement ps = cnx.prepareStatement("SELECT no_utilisateur, no_article FROM encheres WHERE no_utilisateur = ? AND no_article = ? ");
			
			ps.setInt(1, noUtilisateur);
			ps.setInt(2, noArticle);

			rs = ps.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		while(rs.next()) {
			
			return true;
			
		}
		
		return false;
	}

}
