package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.ArticleVenduManager;

/**
 * Servlet implementation class GestionArticles
 */
@WebServlet("/gestionArticles")
public class GestionArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArticleVenduManager articleVenduManager = new ArticleVenduManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionArticles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		try {
			request.setAttribute("listeArticles", articleVenduManager.recupererToutLesArticlesAVendre());
			
			System.out.println("essai");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/encheres.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			articleVenduManager.vendreUnArticle(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
		
		
	}

}
