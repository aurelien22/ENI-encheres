package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bo.Categorie;

public class CategorieDAOJdbcImpl implements CategorieDAO {

	@Override
	public void insert(Categorie categorie) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Categorie> select() {
		
		
		List<Categorie> categories = new ArrayList<Categorie>();
		
		try {
			
			Connection cnx = ConnectionProvider.getConnection();
			
			
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM CATEGORIES;");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Categorie categorie = new Categorie();
				
				categorie.setNo_categorie(rs.getInt("no_categorie"));
				
				categorie.setLibelle(rs.getString("libelle"));
				
				categories.add(categorie);
				
			}
			
			cnx.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}
		
		return categories;
	}
	

	@Override
	public Categorie select(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie select(String libelle) {
		// TODO Auto-generated method stub
		return null;
	}

}
