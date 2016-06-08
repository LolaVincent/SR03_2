
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.SR03.beans.Utilisateur;
import com.SR03.controleur.LoginControleur;
import com.SR03.dao.DAOException;
import com.SR03.dao.DAOFactory;
import com.SR03.dao.UtilisateurDaoImpl;

/**
 * Servlet implementation class login_form
 */
@WebServlet("/login_form")
public class login_form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_form() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String identifiant = request.getParameter("identifiant");
		 String mot_passe = request.getParameter("mot_passe"); 
		 
		 if (!LoginControleur.isUserValid(identifiant, mot_passe)){
			 this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		 }
		 
		 HttpSession session = request.getSession();
		 
         DAOFactory factory = DAOFactory.getInstance();
	     UtilisateurDaoImpl DaoUser = (UtilisateurDaoImpl) factory.getUtilisateurDao();
	     Utilisateur user = DaoUser.trouverAdresse(identifiant);
	     
	     session.setAttribute("sessionUser", user);
	     
	     if (LoginControleur.isAdmin(user)) {	    	 
	    	 this.getServletContext().getRequestDispatcher("/admin").forward(request, response);
	     } else if (LoginControleur.isStagiaire(user)) {
	    	 this.getServletContext().getRequestDispatcher("/stagiaire").forward(request, response);
	     }
	}

}
