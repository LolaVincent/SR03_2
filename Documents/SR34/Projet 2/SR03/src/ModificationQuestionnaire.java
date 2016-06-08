

import java.io.IOException;
import java.util.*;


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
 * Servlet implementation class ModificationQuestionnaire
 */
@WebServlet("/ModificationQuestionnaire")
public class ModificationQuestionnaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificationQuestionnaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/adminModificationQuestionnaire.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sujet = request.getParameter("sujet");
		
		DAOFactory factory = DAOFactory.getInstance();  
		QuestionnaireDaoImpl DaoQuestionnaire = (QuestionnaireDaoImpl) factory.getQuestionnaireDao();
		QuestionDaoImpl DaoQuestion = (QuestionDaoImpl) factory.getQuestionDao();
		PossibiliteDaoImpl DaoPossibilite = (PossibiliteDaoImpl) factory.getPossibiliteDao();
		Questionnaire questionnaire = DaoQuestionnaire.trouverSujet(sujet);
		
		request.setAttribute("sujet", questionnaire.getSujet());
		Long questionnaire_id = questionnaire.getId();
		List<Question> questions = (List<Question>) DaoQuestion.listerQuestion(questionnaire_id);
		//System.out.print(questions.size());
		int j = 0;
		
		for ( Iterator<Question> it = questions.iterator() ; it.hasNext();) {
			j += 1;
			Question q = it.next();
			Long question_id = q.getId();
			String question = q.getQuestion();
			String var_question = "question"+Integer.toString(j);
			request.setAttribute(var_question, question);
			List<Possibilite> possibilites = (List<Possibilite>) DaoPossibilite.listerPossibilite(question_id);	
			int i = 0;
			for (Iterator<Possibilite> it2 = possibilites.iterator() ; it2.hasNext();) {
				i+=1;
				String possibilite = it2.next().getPossibilite();
				String var_possibilite = "possibilite"+Integer.toString(j)+Integer.toString(i);
				request.setAttribute(var_possibilite, possibilite);
			}
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/adminModificationQuestionnaire2.jsp").forward(request, response);
	}

}
