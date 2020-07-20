package dal;

import java.util.List;

import bo.Categorie;

public interface CategorieDAO {
	
	public void insert(Categorie categorie);
	
	public List<Categorie> selectAll();

}
