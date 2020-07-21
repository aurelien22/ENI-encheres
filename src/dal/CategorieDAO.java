package dal;

import java.util.List;

import bo.Categorie;

public interface CategorieDAO {
	
	public void insert(Categorie categorie);
	
	public List<Categorie> select();
	
	public Categorie select(int no);
	
	public Categorie select(String libelle);
	
}
