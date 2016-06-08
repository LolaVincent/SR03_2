

import java.io.IOException;
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
 * Servlet implementation class SuppressionQuestion
 */
@WebServlet("/SuppressionQuestion")
public class SuppressionQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idQuestion = request.getParameter("idQuestion");
		Long id = Long.parseLong(idQuestion);
		DAOFactory factory = DAOFactory.getInstance();  
		QuestionDaoImpl DaoQuestion = (QuestionDaoImpl) factory.getQuestionDao();
		Question question = DaoQuestion.trouver(id);
		DaoQuestion.supprimer(question);
		this.getServletContext().getRequestDispatcher("/ListeQuestionnaire").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
