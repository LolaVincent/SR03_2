

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SR03.beans.Questionnaire;
import com.SR03.dao.DAOFactory;
import com.SR03.dao.QuestionDaoImpl;
import com.SR03.dao.QuestionnaireDaoImpl;
import com.SR03.dao.UtilisateurDaoImpl;

/**
 * Servlet implementation class ListeQuestionnaires
 */
@WebServlet("/ListeQuestionnaires")
public class ListeQuestionnaires extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeQuestionnaires() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Servlet ListeQuestionnaires");
		
		DAOFactory factory = DAOFactory.getInstance();
		QuestionnaireDaoImpl DaoQuestionnaire = (QuestionnaireDaoImpl) factory.getQuestionnaireDao();
		List<Questionnaire> questionnaires = DaoQuestionnaire.lister();
		Map<Long, Questionnaire> mapQuestionnaires = new HashMap<Long, Questionnaire>();
        for ( Questionnaire questionnaire : questionnaires ) {
            mapQuestionnaires.put( questionnaire.getId(), questionnaire );
        }
		request.setAttribute( "mapQuestionnaires", mapQuestionnaires );	
		 
		this.getServletContext().getRequestDispatcher("/WEB-INF/ListeQuestionnaires.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
