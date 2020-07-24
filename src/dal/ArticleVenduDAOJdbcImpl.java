package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.ArticleVendu;
import bo.Categorie;
import bo.Utilisateur;

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

		List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>();
		
		try {
			
			Connection cnx = ConnectionProvider.getConnection();
			
			System.out.println(listeArticles.size());
			
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM ARTICLES_VENDUS av INNER JOIN UTILISATEURS u ON av.no_utilisateur = u.no_utilisateur INNER JOIN CATEGORIES c ON c.no_categorie = av.no_categorie;");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				ArticleVendu articleVendu = new ArticleVendu();
				
				articleVendu.setNoArticle(rs.getInt("no_article"));
				
				articleVendu.setNomArticle(rs.getString("nom_article"));
				
				articleVendu.setDescription(rs.getString("description"));
				
				articleVendu.setDateDebutEncheres(rs.getDate("date_debut_encheres"));
				
				articleVendu.setDateFinEncheres(rs.getDate("date_fin_encheres"));
				
				articleVendu.setMiseAPrix(rs.getInt("prix_initial"));
				
				articleVendu.setPrixVente(rs.getInt("prix_vente"));
				
				articleVendu.setUtilisateur(utilisateurBuilder(rs));
				
				articleVendu.setCategorie(categorieBuilder(rs));
				
				listeArticles.add(articleVendu);
				
			}
			
			cnx.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}
		
		System.out.println(listeArticles.size());
		
		return listeArticles;
	}
	
	private Utilisateur utilisateurBuilder(ResultSet rs) {
		
		Utilisateur utilisateurCourant = new Utilisateur();
		
		try {
			utilisateurCourant.setNoUtilisateur(rs.getInt("no_utilisateur"));
			utilisateurCourant.setPseudo(rs.getString("pseudo"));
			utilisateurCourant.setNom(rs.getString("nom"));
			utilisateurCourant.setPrenom(rs.getString("prenom"));
			utilisateurCourant.setEmail(rs.getString("email"));
			utilisateurCourant.setTelephone(rs.getString("telephone"));
			utilisateurCourant.setRue(rs.getString("rue"));
			utilisateurCourant.setCodePostal(rs.getString("code_postal"));
			utilisateurCourant.setVille(rs.getString("ville"));
			utilisateurCourant.setMotDePasse(rs.getString("mot_de_passe"));
			utilisateurCourant.setCredit(rs.getInt("credit"));
			utilisateurCourant.setAdministrateur(rs.getInt("administrateur"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return utilisateurCourant;
		
	}

	private Categorie categorieBuilder(ResultSet rs) {
		
		Categorie categorieCourante = new Categorie();
		
		try {
			
			categorieCourante.setNo_categorie(rs.getInt("no_categorie"));
			categorieCourante.setLibelle(rs.getString("libelle"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return categorieCourante;
	}
	
}
































