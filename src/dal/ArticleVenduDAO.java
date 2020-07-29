package dal;

import java.util.List;

import bo.ArticleVendu;

public interface ArticleVenduDAO {

	public void insert(ArticleVendu article) throws Exception;
	
	public ArticleVendu selectParId(int id) throws Exception;
	
	public List<ArticleVendu> select() throws Exception;
	
	public List<ArticleVendu> selectParCategorie(int no_categorie) throws Exception;
	
	public List<ArticleVendu> selectParFiltreNom(String filtreNom) throws Exception;
	
	public List<ArticleVendu> selectParCategorieEtFiltreNom(int no_categorie, String filtreNom) throws Exception;
	
}
