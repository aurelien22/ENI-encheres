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
		
		try {
			
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement ps = cnx.prepareStatement("INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			
			ps.setString(1, utilisateur.getPseudo());
			ps.setString(2, utilisateur.getNom());
			ps.setString(3, utilisateur.getPrenom());
			ps.setString(4, utilisateur.getEmail());
			ps.setString(5, utilisateur.getTelephone());
			ps.setString(6, utilisateur.getRue());
			ps.setString(7, utilisateur.getCodePostal());
			ps.setString(8, utilisateur.getVille());
			ps.setString(9, utilisateur.getMotDePasse());
			ps.setInt(10, utilisateur.getCredit());
			ps.setInt(11, utilisateur.getAdministrateur());
			
			ps.executeUpdate();
			
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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



















