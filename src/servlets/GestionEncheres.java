package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.ArticleVenduManager;
import bll.EnchereManager;
import bo.ArticleVendu;

/**
 * Servlet implementation class GestionEncheres
 */
@WebServlet("/encheres")
public class GestionEncheres extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnchereManager enchereManager = new EnchereManager();
	private ArticleVenduManager articleManager = new ArticleVenduManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionEncheres() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		this.getServletContext().getRequestDispatcher("/gestionArticles").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArticleVendu article = new ArticleVendu();
		String message = "";
		
		try {
			
			article = articleManager.afficherArticle(request);
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		try {
			
			message = enchereManager.ajouterUneEnchere(request);			
			
		} catch (Exception e) {
			e.printStackTrace();
						
		}
		
		request.setAttribute("message", message);
		request.setAttribute("article", article);
		
		this.getServletContext().getRequestDispatcher("/article.jsp").forward(request, response);
		
	}

}
