import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.SR03.beans.Utilisateur;
import com.SR03.controleur.CreationControleur;
import com.SR03.controleur.LoginControleur;
import com.SR03.dao.DAOException;
import com.SR03.dao.DAOFactory;
import com.SR03.dao.DAOUtilitaire;
import com.SR03.dao.UtilisateurDaoImpl;
import com.mysql.jdbc.ResultSet;
import com.sun.mail.smtp.SMTPMessage;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

/**
 * Servlet implementation class CreationCompte
 */
@WebServlet("/CreationCompte")
public class CreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationCompte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/adminCreationCompte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String mail = request.getParameter("mail");
		 String mot_passe = request.getParameter("mot_passe"); 
		 String nom = request.getParameter("nom");
		 String societe = request.getParameter("societe");
		 String telephone = request.getParameter("telephone");
		 String type = request.getParameter("type");
		 String activite = request.getParameter("activite");
		 
		 if (!CreationControleur.isUserValid(mail,mot_passe,activite)){
			 this.getServletContext().getRequestDispatcher("/WEB-INF/adminCreationCompte.jsp").forward(request, response);
		 } else {
			 response = CreationControleur.creerCompte(mail,mot_passe,nom,societe,telephone,type,activite, response);
		 }
		     
		     this.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
		 }
	}

