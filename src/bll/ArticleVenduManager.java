package bll;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bo.ArticleVendu;
import bo.Categorie;
import bo.Utilisateur;
import dal.ArticleVenduDAO;
import dal.DAOFactory;

public class ArticleVenduManager {
	
	private ArticleVenduDAO articleVenduDAO;
	
	public ArticleVenduManager() {
		
		this.articleVenduDAO = DAOFactory.getArticleVenduDAO();
		
	}
	
	public void vendreUnArticle(HttpServletRequest request) throws Exception {
		
		ArticleVendu article = new ArticleVendu();
		
		// Je recupere l'utilisateur en session pour l'injecter dans ma creation d'une vente d'un article
		
		HttpSession session = request.getSession();
		
		Utilisateur utilisateurEnSession = (Utilisateur)session.getAttribute("sessionUtilisateur");
		
		
		article.setNomArticle(getFieldValue(request, "nom"));
		
		article.setDescription(getFieldValue(request, "denomination"));
		
		Date dateDebut = Date.valueOf(getFieldValue(request, "dateDebut"));
		Date dateFin = Date.valueOf(getFieldValue(request, "dateFin"));
		
		article.setDateDebutEncheres(dateDebut);
		
		article.setDateFinEncheres(dateFin);
		
		article.setMiseAPrix(Integer.parseInt(getFieldValue(request, "miseAPrix")));
		
		article.setUtilisateur(utilisateurEnSession);
		
		Categorie categorie = new Categorie(Integer.parseInt(getFieldValue(request, "categorie")));
		
		article.setCategorie(categorie);
		
		articleVenduDAO.insert(article);
		
	}
	
	public List<ArticleVendu> recupererToutLesArticlesAVendre() throws Exception {
		
		List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>();
		
		listeArticles = articleVenduDAO.select();
		
		return listeArticles;
		
	}
	
	public List<ArticleVendu> filtrerLesArticlesAVendre(HttpServletRequest request) throws Exception {
		
		if(getFieldValue(request, "categorie") != null && getFieldValue(request, "filtreNom") == null) {
			
			if(getFieldValue(request, "categorie").equalsIgnoreCase("tout")) {
				
				return articleVenduDAO.select();
				
			}
			
			return articleVenduDAO.selectParCategorie(Integer.parseInt(getFieldValue(request, "categorie")));
			
		}
		
		if(getFieldValue(request, "filtreNom") != null && getFieldValue(request, "categorie").equalsIgnoreCase("tout")) {
			
			return articleVenduDAO.selectParFiltreNom(getFieldValue(request, "filtreNom"));
			
		}
		
		if(getFieldValue(request, "filtreNom") != null && !getFieldValue(request, "categorie").equalsIgnoreCase("tout")) {
			
			return articleVenduDAO.selectParCategorieEtFiltreNom(Integer.parseInt(getFieldValue(request, "categorie")), getFieldValue(request, "filtreNom"));
			
		}
		
		return null;
		
	}
	
	
	private static String getFieldValue(HttpServletRequest request, String fieldName) {
		
		String value = request.getParameter(fieldName);
		
		if(value == null || value.trim().length() == 0) {
			return null;
		} else {
			return value;
		}
	}

}
