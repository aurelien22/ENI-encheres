package bll;

import java.util.List;

import bo.Categorie;
import dal.CategorieDAO;
import dal.DAOFactory;

public class CategorieManager {
	
	private CategorieDAO categorieDAO;
	
	public CategorieManager() {
		
		this.categorieDAO = DAOFactory.getCategorieDAO();
		
	}
	
	public List<Categorie> listerCategories() throws Exception {
		
		return this.categorieDAO.select();
		
	}

}
