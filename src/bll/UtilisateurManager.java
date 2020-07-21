package bll;

import javax.servlet.http.HttpServletRequest;

import bo.Utilisateur;
import dal.DAOFactory;
import dal.UtilisateurDAO;

public class UtilisateurManager {
	
	private UtilisateurDAO utilisateurDAO;
	
	public UtilisateurManager() {
		
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
		
	}
	
	public Utilisateur recupererUtilisateurParSonNo(int no) {
		
		Utilisateur utilisateur = new Utilisateur();
		
		try {
			utilisateur = utilisateurDAO.selectByNo(no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return utilisateur;
		
	}
	
	public Utilisateur connecterUtilisateur(HttpServletRequest request) {
		
		
		/* Recuperation des champs du formulaire */
		
		String username = getFieldValue(request, "username");
		String password = getFieldValue(request, "password");
		
		Utilisateur utilisateur = new Utilisateur();
		
		/* Verification du username et du password */
		
		if(username.contains("@")) {
			
			try {
				
				utilisateur = utilisateurDAO.selectByEmail(username);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
		} else {
			
			try {
				
				utilisateur = utilisateurDAO.selectByPseudo(username);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
		}
					
		if(utilisateur != null) {
			
			if(utilisateur.getMotDePasse().equalsIgnoreCase(password)) {
				
				return utilisateur;
				
			}else {
				return null;
			}
			
		} else {			
			return null;
		}

	}
	
	public void inscrireUtilisateur(HttpServletRequest request) {
		
		Utilisateur utilisateur = new Utilisateur();
		
		utilisateur.setPseudo(getFieldValue(request, "pseudo"));
		utilisateur.setNom(getFieldValue(request, "nom"));
		utilisateur.setPrenom(getFieldValue(request, "prenom"));
		utilisateur.setEmail(getFieldValue(request, "email"));
		utilisateur.setTelephone(getFieldValue(request, "telephone"));
		utilisateur.setRue(getFieldValue(request, "rue"));
		utilisateur.setCodePostal(getFieldValue(request, "codepostal"));
		utilisateur.setVille(getFieldValue(request, "ville"));
		utilisateur.setMotDePasse(getFieldValue(request, "motdepasse"));
		utilisateur.setCredit(100);
		utilisateur.setAdministrateur(0);
		
		try {
			this.utilisateurDAO.insert(utilisateur);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}
	
	
	private static String getFieldValue(HttpServletRequest request, String fieldName) {
		
		String value = request.getParameter(fieldName);
		
		if(value == null || value.trim().length() == 0) {
			return null;
		} else {
			return value;
		}
	}

}





















