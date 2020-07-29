package bo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class Enchere implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date dateEnchere;
	
	private int montantEnchere;
	
	private Utilisateur utilisateur;
	
	private ArticleVendu article;

	/* CONSTRUCTEURS */
	
	public Enchere() {
		
	}

	public Enchere(Date dateEnchere, int montantEnchere, Utilisateur utilisateur, ArticleVendu article) {
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.utilisateur = utilisateur;
		this.article = article;
	}

	/* GETTERS ET SETTERS */
	
	public Date getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(Date date) {
		this.dateEnchere = date;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public ArticleVendu getArticle() {
		return article;
	}

	public void setArticle(ArticleVendu article) {
		this.article = article;
	}

}
