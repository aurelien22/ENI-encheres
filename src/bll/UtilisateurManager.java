package bll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
				
				System.out.println("Je recherhce l'utilisateur en bdd");
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
		}
					
		if(utilisateur == null) {
			
			return null;
			
		} else {	
						
			if(utilisateur.getMotDePasse().equalsIgnoreCase(password)) {
				
				return utilisateur;
				
			}else {
				return null;
			}
			
		}

	}
	
	public void modifierUtilisateur(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		Utilisateur utilisateurBase = new Utilisateur();
		
		utilisateurBase = (Utilisateur)session.getAttribute("sessionUtilisateur");
		
		if (utilisateurBase.getMotDePasse().equalsIgnoreCase(getFieldValue(request, "motdepasseActuel"))){
			
			Utilisateur utilisateur = new Utilisateur();
			
			utilisateur.setNoUtilisateur(utilisateurBase.getNoUtilisateur());
			utilisateur.setPseudo(getFieldValue(request, "pseudo"));
			utilisateur.setNom(getFieldValue(request, "nom"));
			utilisateur.setPrenom(getFieldValue(request, "prenom"));
			utilisateur.setEmail(getFieldValue(request, "email"));
			utilisateur.setTelephone(getFieldValue(request, "telephone"));
			utilisateur.setRue(getFieldValue(request, "rue"));
			utilisateur.setCodePostal(getFieldValue(request, "codepostal"));
			utilisateur.setVille(getFieldValue(request, "ville"));
			utilisateur.setMotDePasse(getFieldValue(request, "nouveauMotdepasse"));
			
			try {
				this.utilisateurDAO.update(utilisateur);
				
			} catch (Exception e) {
				
				e.printStackTrace();

			}	
			
		} else {
			
			System.out.println("Mauvais mot de passe");
			
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
	
	public void desinscrireUtilisateur(int noUtilisateur) {
		
		
		try {
			this.utilisateurDAO.delete(noUtilisateur);
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





















