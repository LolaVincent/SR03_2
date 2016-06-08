

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.SR03.beans.Parcours;
import com.SR03.beans.Questionnaire;
import com.SR03.beans.Utilisateur;
import com.SR03.dao.DAOFactory;
import com.SR03.dao.ParcoursDaoImpl;
import com.SR03.dao.QuestionnaireDaoImpl;

/**
 * Servlet implementation class ListeResultat
 */
@WebServlet("/ListeResultat")
public class ListeResultat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeResultat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("sessionUser");
		DAOFactory factory = DAOFactory.getInstance();
		ParcoursDaoImpl DaoParcours = (ParcoursDaoImpl) factory.getParcoursDao();
		List<Parcours> parcours = DaoParcours.listerParcours(user.getId());
		Map<Long, Parcours> mapParcours = new HashMap<Long, Parcours>();
        for ( Parcours parcour : parcours ) {
            mapParcours.put( parcour.getId(), parcour );
        }
		request.setAttribute( "mapParcours", mapParcours );	
		this.getServletContext().getRequestDispatcher("/WEB-INF/ListeResultat.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
