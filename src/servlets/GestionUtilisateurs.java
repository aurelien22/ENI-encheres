package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.UtilisateurManager;
import bo.Utilisateur;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/utilisateurs")
public class GestionUtilisateurs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UtilisateurManager utilisateurManager = new UtilisateurManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionUtilisateurs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("noUtilisateur") != null) {
			
			Utilisateur utilisateur = new Utilisateur();
			
			utilisateur = utilisateurManager.recupererUtilisateurParSonNo(Integer.parseInt(request.getParameter("noUtilisateur")));
			
			request.setAttribute("utilisateur" , utilisateur);
			
			this.getServletContext().getRequestDispatcher("/profil.jsp").forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		utilisateurManager.inscrireUtilisateur(request);
		
		this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
		
	}

}
