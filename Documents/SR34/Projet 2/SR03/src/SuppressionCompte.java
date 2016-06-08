import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SR03.beans.Utilisateur;
import com.SR03.dao.DAOFactory;
import com.SR03.dao.UtilisateurDaoImpl;



/**
 * Servlet implementation class CreationCompte
 */
@WebServlet("/SuppresionCompte")
public class SuppressionCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionCompte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idUser = request.getParameter("idUser");
		Long id = Long.parseLong(idUser);
		DAOFactory factory = DAOFactory.getInstance();  
	    UtilisateurDaoImpl DaoUser = (UtilisateurDaoImpl) factory.getUtilisateurDao();
	    Utilisateur user = DaoUser.trouver(id);
	    DaoUser.supprimer(user);
		this.getServletContext().getRequestDispatcher("/ListeCompte").forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String mail = request.getParameter("mail");    
	    DAOFactory factory = DAOFactory.getInstance();  
	    UtilisateurDaoImpl DaoUser = (UtilisateurDaoImpl) factory.getUtilisateurDao();
	    Utilisateur user = DaoUser.trouverAdresse(mail);
	    DaoUser.supprimer(user);
	    System.out.println("Compte "+mail+"supprimé");
	     
	}
}
