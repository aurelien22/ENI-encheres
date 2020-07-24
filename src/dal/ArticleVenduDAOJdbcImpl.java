package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import bo.ArticleVendu;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {

	@Override
	public void insert(ArticleVendu article) throws Exception {
		
		try {
			
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement ps = cnx.prepareStatement("INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie) VALUES (?, ?, ?, ?, ?, ?, ?);");
			
			ps.setString(1, article.getNomArticle());
			ps.setString(2, article.getDescription());
			ps.setDate(3, article.getDateDebutEncheres());
			ps.setDate(4, article.getDateFinEncheres());
			ps.setInt(5, article.getMiseAPrix());
			ps.setInt(6, article.getUtilisateur().getNoUtilisateur());
			ps.setInt(7, article.getCategorie().getNo_categorie());
			
			ps.executeUpdate();
			
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<ArticleVendu> select() throws Exception {

		
		
		return null;
	}

	
	
}
