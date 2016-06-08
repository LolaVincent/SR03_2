

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SR03.beans.Parcours;
import com.SR03.beans.Utilisateur;
import com.SR03.dao.DAOFactory;
import com.SR03.dao.ParcoursDaoImpl;
import com.SR03.dao.UtilisateurDaoImpl;

/**
 * Servlet implementation class VoirParcours
 */
@WebServlet("/VoirParcours")
public class VoirParcours extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoirParcours() {
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
		UtilisateurDaoImpl DaoUtilisateur = (UtilisateurDaoImpl) factory.getUtilisateurDao();
	    ParcoursDaoImpl DaoParcours = (ParcoursDaoImpl) factory.getParcoursDao();
	    List<Parcours> parcours= DaoParcours.listerParcours(id);
	    Utilisateur utilisateur = DaoUtilisateur.trouver(id);
	    request.setAttribute("utilisateur", utilisateur.getAdresse());
	    request.setAttribute("parcours", parcours);
	    this.getServletContext().getRequestDispatcher("/WEB-INF/adminVoirParcours.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
