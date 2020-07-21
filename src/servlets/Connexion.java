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
 * Servlet implementation class Connexion
 */
@WebServlet("/connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UtilisateurManager utilisateurManager = new UtilisateurManager();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utilisateur utilisateur = utilisateurManager.connecterUtilisateur(request);
		
		HttpSession session = request.getSession();
		
		if(utilisateur == null) {
			
			request.setAttribute("messageErreur", "Login ou mot de passe incorrect");
			
			session.setAttribute("sessionUtilisateur", null);
			
			this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
			
			
		} else {
			
			session.setAttribute("sessionUtilisateur", utilisateur);
			
			this.getServletContext().getRequestDispatcher("/encheres").forward(request, response);
			
		}

	}

}