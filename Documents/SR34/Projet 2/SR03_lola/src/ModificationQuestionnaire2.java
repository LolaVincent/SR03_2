

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

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
 * Servlet implementation class ModificationQuestionnaire2
 */
@WebServlet("/ModificationQuestionnaire2")
public class ModificationQuestionnaire2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificationQuestionnaire2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/adminModificationQuestionnaire2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String titre = request.getParameter("titre");

		DAOFactory factory = DAOFactory.getInstance();
	    QuestionnaireDaoImpl DaoQuestionnaire = (QuestionnaireDaoImpl) factory.getQuestionnaireDao();
	    Questionnaire questionnaire = DaoQuestionnaire.trouverSujet(titre);
	    Long questionnaire_id = questionnaire.getId();
		QuestionDaoImpl DaoQuestion = (QuestionDaoImpl) factory.getQuestionDao();
		PossibiliteDaoImpl DaoPossibilite = (PossibiliteDaoImpl) factory.getPossibiliteDao();
		List<Question> questions = (List<Question>) DaoQuestion.listerQuestion(questionnaire_id);
		int j = 0;

		for ( Iterator<Question> it = questions.iterator() ; it.hasNext();) {
			j += 1;
			Question q = it.next();
			Long question_id = q.getId();
			String varQuestion = "question"+Integer.toString(j);
			q.setQuestion(request.getParameter(varQuestion));
			DaoQuestion.modifier(q);
			
			List<Possibilite> possibilites = (List<Possibilite>) DaoPossibilite.listerPossibilite(question_id);	
			
			int i = 0;
			for (Iterator<Possibilite> it2 = possibilites.iterator() ; it2.hasNext();) {
				i+=1;
				Possibilite possibilite = it2.next();
				String varPossibilite = "reponse"+Integer.toString(j)+Integer.toString(i);
				String varBonneReponse = "bonneReponse"+Integer.toString(j);
				if (request.getParameter(varBonneReponse).substring(8).equals(Integer.toString(i))){
					possibilite.setBonneReponse("1");
				}else {possibilite.setBonneReponse("0");}
				possibilite.setPossibilite(request.getParameter(varPossibilite));
				DaoPossibilite.modifier(possibilite);
			}
		}
		
	    
	    
	}

}
