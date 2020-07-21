package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	
	
	Utilisateur utilisateur = new Utilisateur();
	List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();
	

	@Override
	public void insert(Utilisateur utilisateur) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur selectByNo(int no) throws Exception {
		
		ResultSet rs = null;
		
		try {
			
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM utilisateurs WHERE no_utilisateur = ?;");
			
			ps.setInt(1, no);

			rs = ps.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		while(rs.next()) {
			utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
			utilisateur.setPseudo(rs.getString("pseudo"));
			utilisateur.setNom(rs.getString("nom"));
			utilisateur.setPrenom(rs.getString("prenom"));
			utilisateur.setEmail(rs.getString("email"));
			utilisateur.setTelephone(rs.getString("telephone"));
			utilisateur.setRue(rs.getString("rue"));
			utilisateur.setCodePostal(rs.getString("code_postal"));
			utilisateur.setVille(rs.getString("ville"));
			utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
			utilisateur.setCredit(rs.getInt("credit"));
			utilisateur.setAdministrateur(rs.getInt("administrateur"));
		}
			
		return utilisateur;
		
	}

	@Override
	public Utilisateur selectByPseudo(String pseudo) throws Exception {
		
		ResultSet rs = null;
		
		try {
			
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM utilisateurs WHERE pseudo = ?;");
			
			ps.setString(1, pseudo);

			rs = ps.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		while(rs.next()) {
			utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
			utilisateur.setPseudo(rs.getString("pseudo"));
			utilisateur.setNom(rs.getString("nom"));
			utilisateur.setPrenom(rs.getString("prenom"));
			utilisateur.setEmail(rs.getString("email"));
			utilisateur.setTelephone(rs.getString("telephone"));
			utilisateur.setRue(rs.getString("rue"));
			utilisateur.setCodePostal(rs.getString("code_postal"));
			utilisateur.setVille(rs.getString("ville"));
			utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
			utilisateur.setCredit(rs.getInt("credit"));
			utilisateur.setAdministrateur(rs.getInt("administrateur"));
		}
		return utilisateur;
		
	}
		
	@Override
	public Utilisateur selectByEmail(String email) throws Exception {
		
		ResultSet rs = null;
		
		try {
			
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM utilisateurs WHERE email = ?;");
			
			ps.setString(1, email);

			rs = ps.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		while(rs.next()) {
			utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
			utilisateur.setPseudo(rs.getString("pseudo"));
			utilisateur.setNom(rs.getString("nom"));
			utilisateur.setPrenom(rs.getString("prenom"));
			utilisateur.setEmail(rs.getString("email"));
			utilisateur.setTelephone(rs.getString("telephone"));
			utilisateur.setRue(rs.getString("rue"));
			utilisateur.setCodePostal(rs.getString("code_postal"));
			utilisateur.setVille(rs.getString("ville"));
			utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
			utilisateur.setCredit(rs.getInt("credit"));
			utilisateur.setAdministrateur(rs.getInt("administrateur"));
		}
			
		return utilisateur;
	}

	@Override
	public List<Utilisateur> select() throws Exception {
		
		ResultSet rs = null;
		
		try {
			
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM utilisateurs;");

			rs = ps.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		while(rs.next()) {
			
			Utilisateur utilisateurCourant = new Utilisateur();
			
			utilisateurCourant.setNoUtilisateur(rs.getInt("no_utilisateur"));
			utilisateurCourant.setPseudo(rs.getString("pseudo"));
			utilisateurCourant.setNom(rs.getString("nom"));
			utilisateurCourant.setPrenom(rs.getString("prenom"));
			utilisateurCourant.setEmail(rs.getString("email"));
			utilisateurCourant.setTelephone(rs.getString("telephone"));
			utilisateurCourant.setRue(rs.getString("rue"));
			utilisateurCourant.setCodePostal(rs.getString("code_postal"));
			utilisateurCourant.setVille(rs.getString("ville"));
			utilisateurCourant.setMotDePasse(rs.getString("mot_de_passe"));
			utilisateurCourant.setCredit(rs.getInt("credit"));
			utilisateurCourant.setAdministrateur(rs.getInt("administrateur"));
			
			listeUtilisateurs.add(utilisateurCourant);
			
		}
			
		return listeUtilisateurs;
		
	}
	
}



















