package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.ArticleVenduManager;
import bll.CategorieManager;

/**
 * Servlet implementation class GestionArticles
 */
@WebServlet("/gestionArticles")
public class GestionArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArticleVenduManager articleVenduManager = new ArticleVenduManager();
	private CategorieManager categorieManager = new CategorieManager();
       
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

			request.setAttribute("categories", categorieManager.listerCategories());
			
			
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
		
		if(request.getParameter("action").equalsIgnoreCase("filtrer")) {
			
			try {
				
				request.setAttribute("listeArticles", articleVenduManager.filtrerLesArticlesAVendre(request));
				
				request.setAttribute("categories", categorieManager.listerCategories());

				this.getServletContext().getRequestDispatcher("/encheres.jsp").forward(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			
			try {
				articleVenduManager.vendreUnArticle(request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			doGet(request, response);
			
		}
				
	}

}
