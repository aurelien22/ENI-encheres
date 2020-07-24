package bll;

import javax.servlet.http.HttpServletRequest;

import bo.Enchere;
import dal.DAOFactory;
import dal.EnchereDAO;

public class EnchereManager {

	private EnchereDAO enchereDAO;
	
	public EnchereManager() {
		
		this.enchereDAO = DAOFactory.getEnchereDAO();
		
	}
	
}
