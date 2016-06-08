import java.io.IOException;

import java.io.PrintWriter;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String identifiant = request.getParameter("identifiant");
		 String mot_passe = request.getParameter("mot_passe"); 
		 
		 
		 // a terminer problème quand le login est faux, erreur 500 et passe pas dans le if
		 if (!LoginControleur.isUserValid(identifiant, mot_passe)){
			 //System.out.println("test id");
			 //this.getServletContext().getRequestDispatcher("/login_form").forward(request, response);
			 throw new DAOException( "Identifiants non valides" );
		 }
		 
		 HttpSession session = request.getSession();
         DAOFactory factory = DAOFactory.getInstance();
	     
	     UtilisateurDaoImpl DaoUser = (UtilisateurDaoImpl) factory.getUtilisateurDao();

	     Utilisateur user = DaoUser.trouverAdresse(identifiant);
	     if (LoginControleur.isAdmin(user)) {	    	 
	    	 this.getServletContext().getRequestDispatcher("/admin").forward(request, response);
	     }
	}

}
