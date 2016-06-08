

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
 * Servlet implementation class ModificationCompte2
 */
@WebServlet("/ModificationCompte2")
public class ModificationCompte2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificationCompte2() {
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
	    request.setAttribute("user", user);
		this.getServletContext().getRequestDispatcher("/WEB-INF/adminModificationCompte2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String mail = (String) request.getParameter("mail");
		 String mot_passe = (String) request.getParameter("mot_passe");
		 String nom = request.getParameter("nom");
		 String societe = request.getParameter("societe");
		 String telephone = request.getParameter("telephone");
		 String type = request.getParameter("type");
		 String statut = request.getParameter("statut");
		 String idUser =request.getParameter("id");
		 Long id = Long.parseLong(idUser);
	
		 DAOFactory factory = DAOFactory.getInstance();  
		 UtilisateurDaoImpl DaoUser = (UtilisateurDaoImpl) factory.getUtilisateurDao();
		 Utilisateur user = DaoUser.trouver(id);
		 user.setAdresse(mail);
		 user.setMdp(mot_passe);
	     user.setNom(nom);
	     user.setSociete(societe);
	     user.setTelephone(telephone);
	     user.setType(type);
	     user.setStatut(statut);
	     
	     DaoUser.modifier(user);

	     this.getServletContext().getRequestDispatcher("/ListeCompte").forward(request, response);
	}

}
