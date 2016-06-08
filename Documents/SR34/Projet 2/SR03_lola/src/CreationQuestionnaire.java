

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SR03.beans.Possibilite;
import com.SR03.beans.Question;
import com.SR03.beans.Questionnaire;
import com.SR03.beans.Reponse;
import com.SR03.controleur.QuestionnaireControleur;
import com.SR03.dao.DAOFactory;
import com.SR03.dao.PossibiliteDaoImpl;
import com.SR03.dao.QuestionDaoImpl;
import com.SR03.dao.QuestionnaireDaoImpl;
import com.SR03.dao.ReponseDaoImpl;
import com.SR03.dao.UtilisateurDaoImpl;

/**
 * Servlet implementation class CreationQuestionnaire
 */
@WebServlet("/CreationQuestionnaire")
public class CreationQuestionnaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationQuestionnaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/adminCreationQuestionnaire.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String titre = request.getParameter("titre");
		String question1 = request.getParameter("question1");
		String question2 = request.getParameter("question2"); 
		String question3 = request.getParameter("question3"); 
		String question4 = request.getParameter("question4");
		
		String reponse11 = request.getParameter("reponse11");
		String reponse12 = request.getParameter("reponse12");
		String reponse13 = request.getParameter("reponse13");
		String reponse14 = request.getParameter("reponse14");
		String reponse21 = request.getParameter("reponse21");
		String reponse22 = request.getParameter("reponse22");
		String reponse23 = request.getParameter("reponse23");
		String reponse24 = request.getParameter("reponse24");
		String reponse31 = request.getParameter("reponse31");
		String reponse32 = request.getParameter("reponse32");
		String reponse33 = request.getParameter("reponse33");
		String reponse34 = request.getParameter("reponse34");
		String reponse41 = request.getParameter("reponse41");
		String reponse42 = request.getParameter("reponse42");
		String reponse43 = request.getParameter("reponse43");
		String reponse44 = request.getParameter("reponse44");
		
		String bonneReponse1 = request.getParameter("bonneReponse1");
		String bonneReponse2 = request.getParameter("bonneReponse2");
		String bonneReponse3 = request.getParameter("bonneReponse3");
		String bonneReponse4 = request.getParameter("bonneReponse4");	   



		DAOFactory factory = DAOFactory.getInstance();
	    QuestionnaireDaoImpl DaoQuestionnaire = (QuestionnaireDaoImpl) factory.getQuestionnaireDao();
	    Questionnaire questionnaire = new Questionnaire();
	    questionnaire.setSujet(titre);
	    DaoQuestionnaire.creer(questionnaire);

		QuestionnaireControleur.creerQuestionnaire(titre, question1, reponse11, reponse12, reponse13, reponse14, bonneReponse1);
		QuestionnaireControleur.creerQuestionnaire(titre, question2, reponse21, reponse22, reponse23, reponse24, bonneReponse2);
		QuestionnaireControleur.creerQuestionnaire(titre, question3, reponse31, reponse32, reponse33, reponse34, bonneReponse3);
		QuestionnaireControleur.creerQuestionnaire(titre, question4, reponse41, reponse42, reponse43, reponse44, bonneReponse4);


	    

	}

}
