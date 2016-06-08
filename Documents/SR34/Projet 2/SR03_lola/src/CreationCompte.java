

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
 * Servlet implementation class CreationCompte
 */
@WebServlet("/CreationCompte")
public class CreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationCompte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Servlet Creation Compte");
		this.getServletContext().getRequestDispatcher("/WEB-INF/adminCreationCompte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String mail = request.getParameter("mail");
		 String mot_passe = request.getParameter("mot_passe"); 
		 String nom = request.getParameter("nom");
		 String societe = request.getParameter("societe");
		 String telephone = request.getParameter("telephone");
		 String type = request.getParameter("type");
		 
      
		 if (LoginControleur.isMailUsed(mail)){
			 this.getServletContext().getRequestDispatcher("/admin").forward(request, response);
			 throw new DAOException( "Mail déjà utilisé" );
		 }
		 
	     Utilisateur user = new Utilisateur();
	     user.setAdresse(mail);
	     user.setMdp(mot_passe);
	     user.setNom(nom);
	     user.setSociete(societe);
	     user.setTelephone(telephone);
	     user.setStatut("A");
	     user.setType(type);
	     user.setDate("13/05");
	          
	     
	     DAOFactory factory = DAOFactory.getInstance();
	     
	     UtilisateurDaoImpl DaoUser = (UtilisateurDaoImpl) factory.getUtilisateurDao();
	     DaoUser.creer(user);
	     	     
	}
}
