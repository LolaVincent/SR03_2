

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SR03.beans.Possibilite;
import com.SR03.beans.Question;
import com.SR03.beans.Questionnaire;
import com.SR03.controleur.CreationControleur;
import com.SR03.controleur.QuestionnaireControleur;
import com.SR03.dao.DAOFactory;
import com.SR03.dao.PossibiliteDaoImpl;
import com.SR03.dao.QuestionDaoImpl;
import com.SR03.dao.QuestionnaireDaoImpl;

/**
 * Servlet implementation class CreationQuestion
 */
@WebServlet("/CreationQuestion")
public class CreationQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationQuestion() {
        super();
        // TODO Auto-generated constructor stub

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String titre = (String) request.getAttribute("titre");
		request.setAttribute("titre", titre);
		this.getServletContext().getRequestDispatcher("/WEB-INF/adminCreationQuestion.jsp").forward(request, response);

		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String titre = request.getParameter("titre");
			String question = request.getParameter("question");
			String reponse1 = request.getParameter("reponse1");
			String reponse2 = request.getParameter("reponse2");
			String reponse3 = request.getParameter("reponse3");
			String reponse4 = request.getParameter("reponse4");
			String bonneReponse = request.getParameter("bonneReponse");   
			
			CreationControleur.creerQuestion(titre,question,reponse1,reponse2,reponse3,reponse4,bonneReponse,request);
		    			
		} catch (Exception e) {
			doGet(request, response);
		}
		String titre = request.getParameter("titre");
		request.setAttribute("titre", titre);
		doGet(request, response);
	}

}
