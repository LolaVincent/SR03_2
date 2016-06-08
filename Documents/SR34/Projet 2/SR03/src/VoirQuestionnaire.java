

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SR03.beans.Possibilite;
import com.SR03.beans.Question;
import com.SR03.beans.Questionnaire;
import com.SR03.dao.DAOFactory;
import com.SR03.dao.PossibiliteDaoImpl;
import com.SR03.dao.QuestionDaoImpl;
import com.SR03.dao.QuestionnaireDaoImpl;

/**
 * Servlet implementation class VoirQuestionnaire
 */
@WebServlet("/VoirQuestionnaire")
public class VoirQuestionnaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoirQuestionnaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idQuestionnaire = request.getParameter("idQuestionnaire");
		Long id = Long.parseLong(idQuestionnaire);
		
		DAOFactory factory = DAOFactory.getInstance();  
	    QuestionnaireDaoImpl DaoQuestionnaire = (QuestionnaireDaoImpl) factory.getQuestionnaireDao();
	    QuestionDaoImpl DaoQuestion = (QuestionDaoImpl) factory.getQuestionDao();
	    PossibiliteDaoImpl DaoPossibilite = (PossibiliteDaoImpl) factory.getPossibiliteDao();
	    
	    Questionnaire questionnaire = DaoQuestionnaire.trouver(id);
	    List<Question> questions = DaoQuestion.listerQuestion(id);
	    Map<Question, List<Possibilite>> mapQuestions = new HashMap<Question, List<Possibilite>>();
		for ( Question question : questions ) {
			List<Possibilite> reponses = DaoPossibilite.listerPossibilite(question.getId());
				mapQuestions.put( question , reponses );
			}
	    request.setAttribute("mapQuestions", mapQuestions);
	    request.setAttribute("titre", questionnaire.getSujet());
		this.getServletContext().getRequestDispatcher("/WEB-INF/adminVoirQuestionnaire.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
