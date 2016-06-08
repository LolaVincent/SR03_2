

import java.io.IOException;
import java.util.Enumeration;
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
import com.SR03.beans.Possibilite;
import com.SR03.beans.Question;
import com.SR03.beans.Questionnaire;
import com.SR03.beans.Utilisateur;
import com.SR03.dao.DAOFactory;
import com.SR03.dao.ParcoursDaoImpl;
import com.SR03.dao.PossibiliteDaoImpl;
import com.SR03.dao.QuestionDaoImpl;
import com.SR03.dao.QuestionnaireDaoImpl;

/**
 * Servlet implementation class FaireQuestionnaire
 */
@WebServlet("/FaireQuestionnaire")
public class FaireQuestionnaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaireQuestionnaire() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idQuestionnaire = request.getParameter("idQuestionnaire");
        Long id = Long.parseLong( idQuestionnaire );
        
        java.util.Date dateDebut = new java.util.Date();
        Long debut = dateDebut.getTime();
        
        HttpSession session = request.getSession();
        session.setAttribute("debut", debut);
        
		DAOFactory factory = DAOFactory.getInstance();
		QuestionDaoImpl DaoQuestion = (QuestionDaoImpl) factory.getQuestionDao();
		PossibiliteDaoImpl DaoReponse = (PossibiliteDaoImpl) factory.getPossibiliteDao();
		QuestionnaireDaoImpl DaoQuestionnaire = (QuestionnaireDaoImpl) factory.getQuestionnaireDao();
		Questionnaire questionnaire = DaoQuestionnaire.trouver(id);

		session.setAttribute("sessionQuestionnaire", questionnaire);
		List<Question> questions = DaoQuestion.listerQuestion(id);
		Map<Question, List<Possibilite>> mapReponses = new HashMap<Question, List<Possibilite>>();
		for ( Question question : questions ) {
			List<Possibilite> reponses = DaoReponse.listerPossibilite(question.getId());
				mapReponses.put( question, reponses );
        }
		request.setAttribute( "questions", questions );
		request.setAttribute( "mapReponses", mapReponses );
		request.setAttribute("sujet", questionnaire.getSujet());
		this.getServletContext().getRequestDispatcher("/WEB-INF/FaireQuestionnaire.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("sessionUser");
		Questionnaire questionnaire = (Questionnaire) session.getAttribute("sessionQuestionnaire");
		DAOFactory factory = DAOFactory.getInstance();
	    ParcoursDaoImpl DaoParcours = (ParcoursDaoImpl) factory.getParcoursDao();
	    Parcours parcours = new Parcours();
	    parcours.setUtilisateur(user);
	    parcours.setQuestionnaire(questionnaire);
	    int score = 0;
		Enumeration<String> params = request.getParameterNames();
		while(params.hasMoreElements()){
			String param = (String) params.nextElement();
			score += Integer.parseInt(request.getParameter(param));
		}
		parcours.setScore(score);
		
        Long debut = (Long)session.getAttribute("debut");
        java.util.Date dateFin = new java.util.Date();
        Long fin = dateFin.getTime();
        double duree = fin - debut;
        
		parcours.setDuree(duree/1000);
		DaoParcours.creer(parcours);		
		request.setAttribute("score", score);
		request.setAttribute("sujet", questionnaire.getSujet());
		session.removeAttribute("sessionQuestionnaire");
		this.getServletContext().getRequestDispatcher( "/WEB-INF/afficherScore.jsp" ).forward( request, response );	}

}
