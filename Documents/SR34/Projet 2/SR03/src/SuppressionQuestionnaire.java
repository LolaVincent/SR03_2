

import java.io.IOException;import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SR03.beans.Questionnaire;
import com.SR03.beans.Utilisateur;
import com.SR03.dao.DAOFactory;
import com.SR03.dao.QuestionDaoImpl;
import com.SR03.dao.QuestionnaireDaoImpl;
import com.SR03.dao.UtilisateurDaoImpl;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.util.ArrayList;

/**
 * Servlet implementation class SuppressionQuestionnaire
 */
@WebServlet("/SuppressionQuestionnaire")
public class SuppressionQuestionnaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionQuestionnaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idQuestionnaire = request.getParameter("idQuestionnaire");
		Long id = Long.parseLong(idQuestionnaire);
		DAOFactory factory = DAOFactory.getInstance();  
		QuestionnaireDaoImpl DaoQuestionnaire = (QuestionnaireDaoImpl) factory.getQuestionnaireDao();
		Questionnaire questionnaire = DaoQuestionnaire.trouver(id);
		DaoQuestionnaire.supprimer(questionnaire);
		this.getServletContext().getRequestDispatcher("/ListeQuestionnaire").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sujet = request.getParameter("sujet");
		
		DAOFactory factory = DAOFactory.getInstance();  
		QuestionnaireDaoImpl DaoQuestionnaire = (QuestionnaireDaoImpl) factory.getQuestionnaireDao();
		Questionnaire questionnaire = DaoQuestionnaire.trouverSujet(sujet);
		DaoQuestionnaire.supprimer(questionnaire);
		System.out.println("Questionnaire "+sujet+"supprimé");
		
	}

}
