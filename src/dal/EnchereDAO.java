package dal;

import java.util.List;

import bo.Enchere;

public interface EnchereDAO {
	
	public void insert(Enchere enchere)  throws Exception;
	
	public List<Enchere> select() throws Exception;
	
}
