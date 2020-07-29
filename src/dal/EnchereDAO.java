package dal;

import java.util.List;

import bo.Enchere;

public interface EnchereDAO {
	
	public void insert(Enchere enchere)  throws Exception;
	
	public boolean verifierPresenceEnchere(int noUtilisateur, int noArticle) throws Exception;
	
	public List<Enchere> select() throws Exception;
	
}
