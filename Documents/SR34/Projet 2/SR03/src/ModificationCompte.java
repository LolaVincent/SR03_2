

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SR03.beans.Utilisateur;
import com.SR03.controleur.LoginControleur;
import com.SR03.dao.DAOException;
import com.SR03.dao.DAOFactory;
import com.SR03.dao.UtilisateurDaoImpl;

/**
 * Servlet implementation class ModificationCompte
 */
@WebServlet("/ModificationCompte")
public class ModificationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificationCompte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/adminModificationCompte.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String mail = request.getParameter("mail");
		 String mot_passe = request.getParameter("mot_passe");
		 	 
		 DAOFactory factory = DAOFactory.getInstance();  
		 UtilisateurDaoImpl DaoUser = (UtilisateurDaoImpl) factory.getUtilisateurDao();
		 Utilisateur user = DaoUser.trouverIdentifiants(mail, mot_passe);
		 
		 String nom = user.getNom();
		 String societe = user.getSociete();
		 String telephone = user.getTelephone();
		 		 
		 request.setAttribute("mail", mail);
		 request.setAttribute("mot_passe", mot_passe);
		 request.setAttribute("societe", societe);
		 request.setAttribute("telephone", telephone);
		 request.setAttribute("nom", nom);

		 
		 this.getServletContext().getRequestDispatcher("/WEB-INF/adminModificationCompte2.jsp").forward(request, response);

	     
	     
	}

}
