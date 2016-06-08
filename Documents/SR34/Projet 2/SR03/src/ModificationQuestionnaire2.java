

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
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
import com.SR03.beans.Utilisateur;
import com.SR03.dao.DAOFactory;
import com.SR03.dao.PossibiliteDaoImpl;
import com.SR03.dao.QuestionDaoImpl;
import com.SR03.dao.QuestionnaireDaoImpl;
import com.SR03.dao.UtilisateurDaoImpl;

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
		String idQuestionnaire = request.getParameter("idQuestionnaire");
		Long id = Long.parseLong(idQuestionnaire);
		DAOFactory factory = DAOFactory.getInstance();  
	    QuestionnaireDaoImpl DaoQuestionnaire = (QuestionnaireDaoImpl) factory.getQuestionnaireDao();
	    QuestionDaoImpl DaoQuestion = (QuestionDaoImpl) factory.getQuestionDao();
	    PossibiliteDaoImpl DaoPossibilite = (PossibiliteDaoImpl) factory.getPossibiliteDao();
	    Questionnaire questionnaire = DaoQuestionnaire.trouver(id);
	    List<Question> questions = DaoQuestion.listerQuestion(id);
	    Map<Question, List<Possibilite>> mapReponses = new HashMap<Question, List<Possibilite>>();
		for ( Question question : questions ) {
			List<Possibilite> reponses = DaoPossibilite.listerPossibilite(question.getId());
				mapReponses.put( question , reponses );
			}
	    request.setAttribute("mapReponses", mapReponses);
	    request.setAttribute("titre", questionnaire.getSujet());
	    request.setAttribute("id", questionnaire.getId());
	    request.setAttribute("idQuestionnaire", idQuestionnaire);
		this.getServletContext().getRequestDispatcher("/WEB-INF/adminModificationQuestionnaire2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		 
		 String idQuestionnaire = request.getParameter("id");
		 Long id = Long.parseLong(idQuestionnaire);
		 
		 DAOFactory factory = DAOFactory.getInstance();  
	     QuestionDaoImpl DaoQuestion = (QuestionDaoImpl) factory.getQuestionDao();
	     PossibiliteDaoImpl DaoPossibilite = (PossibiliteDaoImpl) factory.getPossibiliteDao();
	     QuestionnaireDaoImpl DaoQuestionnaire = (QuestionnaireDaoImpl) factory.getQuestionnaireDao();
	     Questionnaire questionnaire = DaoQuestionnaire.trouver(id);
	     questionnaire.setSujet(request.getParameter("questionnaire"));
	     DaoQuestionnaire.modifier(questionnaire);
	     List<Question> questions = DaoQuestion.listerQuestion(id);
		 for ( Question question : questions ) {
			 String param = "question"+question.getId();
			 String param3 = "bonneReponse"+question.getId();
			 question.setQuestion(request.getParameter(param));
			 List<Possibilite> reponses = DaoPossibilite.listerPossibilite(question.getId());
			 for (Possibilite reponse: reponses) {
				 String param2 = "reponse"+reponse.getId();
				 String reponseId = Long.toString(reponse.getId());
				 String paramId = (String) request.getParameter(param3);
				 reponse.setPossibilite(request.getParameter(param2));
				 if (reponseId.equals(paramId)){
					 reponse.setBonneReponse("1");
				 } else {
					 reponse.setBonneReponse("0");
				 }
				 reponse.setOrdre(Integer.parseInt(request.getParameter("number"+reponse.getId())));
				 DaoPossibilite.modifier(reponse);
			 }
			 DaoQuestion.modifier(question);
		 }
	     this.getServletContext().getRequestDispatcher("/ListeQuestionnaire").forward(request, response);
	}

}
