package dal;

import java.util.List;

import bo.Utilisateur;

public interface UtilisateurDAO {

	public void insert(Utilisateur utilisateur) throws Exception;
	
	public void debiterEnchere(Utilisateur utilisateur, int montantEnchere) throws Exception;
	
	public Utilisateur selectByNo(int no) throws Exception;
	
	public Utilisateur selectByPseudo(String pseudo) throws Exception;
	
	public Utilisateur selectByEmail(String email) throws Exception;
	
	public List<Utilisateur> select() throws Exception;
	
	public void update(Utilisateur utilisateur) throws Exception;
	
	public void delete(int noUtilisateur) throws Exception;
	
}
