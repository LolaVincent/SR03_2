

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DefaultNamespace.AnnuaireProxy;
import beans.Categorie;

/**
 * Servlet implementation class ModificationAnnonce2
 */
@WebServlet("/ModificationAnnonce2")
public class ModificationAnnonce2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificationAnnonce2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/ModificationAnnonce2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String adresse = request.getParameter("adresse"); 
		String numero = request.getParameter("numero");
		String sujet = request.getParameter("categorie");
		 		 
		AnnuaireProxy annuaire = new AnnuaireProxy();
		int annonce_id = annuaire.affichageAnnonceNom(nom).getId();
		Categorie categorie = annuaire.affichageCategorieNom(sujet);
		annuaire.modificationAnnonce(categorie.getId(), nom, adresse, numero,  annonce_id);
		 
		this.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
	}

}
