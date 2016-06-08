
import java.io.IOException;import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SR03.beans.Question;
import com.SR03.dao.DAOFactory;
import com.SR03.dao.QuestionDaoImpl;

/**
 * Servlet implementation class ListeQuestion
 */
@WebServlet("/ListeQuestion")
public class ListeQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		DAOFactory factory = DAOFactory.getInstance();
		QuestionDaoImpl DaoQuestion = (QuestionDaoImpl) factory.getQuestionDao();
	    List<Question> questions = (List<Question>) DaoQuestion.listerQuestion(Long.valueOf(id).longValue());
	    request.setAttribute("questions", questions);
	    this.getServletContext().getRequestDispatcher("/WEB-INF/adminListeQuestion.jsp").forward(request, response);
	}

}
