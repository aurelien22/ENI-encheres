package bll;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bo.ArticleVendu;
import bo.Enchere;
import bo.Utilisateur;
import dal.DAOFactory;
import dal.EnchereDAO;
import dal.UtilisateurDAO;

public class EnchereManager {

	private EnchereDAO enchereDAO;
	private UtilisateurDAO utilisateurDAO;
	
	public EnchereManager() {
		
		this.enchereDAO = DAOFactory.getEnchereDAO();
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
		
	}
	
	public String ajouterUneEnchere(HttpServletRequest request) throws Exception {
		
		Enchere enchere = new Enchere();
		HttpSession session = request.getSession();
		Calendar calendrier = Calendar.getInstance();
		ArticleVendu article = new ArticleVendu(Integer.parseInt(request.getParameter("noArticle")));
		Utilisateur utilisateur = (Utilisateur)session.getAttribute("sessionUtilisateur");
		
		enchere.setArticle(article);
		enchere.setUtilisateur(utilisateur);
		enchere.setMontantEnchere(Integer.parseInt(request.getParameter("proposition")));
		enchere.setDateEnchere(calendrier.getTime());
		
		if(enchereDAO.verifierPresenceEnchere(utilisateur.getNoUtilisateur(), article.getNoArticle())) {
			
			return "Vous avez déjà mis une enchère sur cet article";
			
		} else {
			
			if(utilisateur.getCredit() >= enchere.getMontantEnchere()) {
				
				utilisateurDAO.recrediterAncienEncherisseurSiIlExiste(article, utilisateur);
				
				utilisateurDAO.debiterEnchere(utilisateur, enchere.getMontantEnchere());
				
				enchereDAO.insert(enchere);
				
				return "Enchère bien prise en compte";
				
			} else {
				
				return "Votre solde est insuffisant";
				
			}
		}
	}
}
