package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
	
		Utilisateur utilisateur = new Utilisateur();
		
		if(request.getParameter("action").equalsIgnoreCase("afficher") && request.getParameter("noUtilisateur") != null) {
			
			utilisateur = utilisateurManager.recupererUtilisateurParSonNo(Integer.parseInt(request.getParameter("noUtilisateur")));
			
			request.setAttribute("utilisateur" , utilisateur);
			
			this.getServletContext().getRequestDispatcher("/profil.jsp").forward(request, response);
			
		}
		
		if(request.getParameter("action").equalsIgnoreCase("modifier")){
			
			this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
			
		}
		
		if(request.getParameter("action").equalsIgnoreCase("supprimer")){
			
			
			HttpSession session = request.getSession();
			
			utilisateurManager.desinscrireUtilisateur(Integer.parseInt(request.getParameter("noUtilisateur")));
			
			session.invalidate();
			
			this.getServletContext().getRequestDispatcher("/").forward(request, response);
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("action") != null && request.getParameter("action").equalsIgnoreCase("modifier")){
			
			utilisateurManager.modifierUtilisateur(request);
			
			HttpSession session = request.getSession();
			
			Utilisateur utilisateur = (Utilisateur)session.getAttribute("sessionUtilisateur");
			
			int numeroUtilisateur = utilisateur.getNoUtilisateur();
			
			session.setAttribute("sessionUtilisateur", utilisateurManager.recupererUtilisateurParSonNo(numeroUtilisateur));
			
			this.getServletContext().getRequestDispatcher("/").forward(request, response);
			
			
		} else {
			
			utilisateurManager.inscrireUtilisateur(request);
		
			this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
			
		}
		
	}

}
