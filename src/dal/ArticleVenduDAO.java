package dal;

import java.util.List;

import bo.ArticleVendu;

public interface ArticleVenduDAO {

	public void insert(ArticleVendu article) throws Exception;
	
	public List<ArticleVendu> select() throws Exception;
	
}
