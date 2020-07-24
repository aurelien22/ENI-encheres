package dal;

public abstract class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO() {
		
		return new UtilisateurDAOJdbcImpl();
		
	}
	
	public static EnchereDAO getEnchereDAO() {
		
		return new EnchereDAOJdbcImpl();
		
	}
	
	public static ArticleVenduDAO getArticleVenduDAO() {
		
		return new ArticleVenduDAOJdbcImpl();
		
	}
	
	public static CategorieDAO getCategorieDAO() {
		
		return new CategorieDAOJdbcImpl();
		
	}

}
