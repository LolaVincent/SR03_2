import java.util.Iterator;
import java.util.List;

import beans.Annonce;
import beans.Categorie;
import dao.AnnonceDaoImpl;
import dao.CategorieDaoImpl;
import dao.DAOFactory;

public class Annuaire {
	public void creationCategorie(String categorie) {
		Categorie cat = new Categorie();
	    cat.setSujet(categorie);
        DAOFactory factory = DAOFactory.getInstance();
	    CategorieDaoImpl DaoCat = (CategorieDaoImpl) factory.getCategorieDao();
	    DaoCat.creer(cat);
	}
	
	public void creationAnnonce(int categorie_id, String nom, String adresse, String numero) {
		Annonce annonce = new Annonce();
		DAOFactory factory = DAOFactory.getInstance();
		CategorieDaoImpl DaoCategorie = (CategorieDaoImpl) factory.getCategorieDao();
		Categorie categorie = DaoCategorie.trouver(categorie_id);
	    annonce.setCategorie(categorie);
	    annonce.setNom(nom);
	    annonce.setAdresse(adresse);
	    annonce.setNumero(numero);
	    AnnonceDaoImpl DaoAnnonce = (AnnonceDaoImpl) factory.getAnnonceDao();
	    DaoAnnonce.creer(annonce);
	}

	public void modificationCategorie(String sujet, int categorie_id ) {
		DAOFactory factory = DAOFactory.getInstance();
	    CategorieDaoImpl DaoCategorie = (CategorieDaoImpl) factory.getCategorieDao();
	    Categorie categorie = DaoCategorie.trouver(categorie_id);
	    categorie.setSujet(sujet);
	    DaoCategorie.modifier(categorie);
	}
	
	public void modificationAnnonce(int categorie_id, String nom, String adresse, String numero, int annonce_id)  {
		DAOFactory factory = DAOFactory.getInstance();
	    AnnonceDaoImpl DaoAnnonce = (AnnonceDaoImpl) factory.getAnnonceDao();
	    CategorieDaoImpl DaoCategorie = (CategorieDaoImpl) factory.getCategorieDao();
		Categorie categorie = DaoCategorie.trouver(categorie_id);
	    Annonce annonce = DaoAnnonce.trouver(annonce_id);
	    annonce.setNom(nom);
	    annonce.setCategorie(categorie);
	    annonce.setAdresse(adresse);
	    annonce.setNumero(numero);
	    DaoAnnonce.modifier(annonce);
	}
	
	public void suppressionCategorie(int categorie_id){
		DAOFactory factory = DAOFactory.getInstance();
	    CategorieDaoImpl DaoCategorie = (CategorieDaoImpl) factory.getCategorieDao();
	    Categorie categorie = DaoCategorie.trouver(categorie_id);
	    DaoCategorie.supprimer(categorie);
	}
	
	public void suppressionAnnonce(int annonce_id){
		DAOFactory factory = DAOFactory.getInstance();
	    AnnonceDaoImpl DaoAnnonce = (AnnonceDaoImpl) factory.getAnnonceDao();
	    Annonce annonce = DaoAnnonce.trouver(annonce_id);
	    DaoAnnonce.supprimer(annonce);
	}
	
	public Annonce[] affichageAnnonceCategorie(int categorie_id) {
		DAOFactory factory = DAOFactory.getInstance();
		CategorieDaoImpl DaoCategorie = (CategorieDaoImpl) factory.getCategorieDao();
		Categorie categorie = DaoCategorie.trouver(categorie_id);
	    AnnonceDaoImpl DaoAnnonce = (AnnonceDaoImpl) factory.getAnnonceDao();
	    List<Annonce> annonces = DaoAnnonce.listerCategorie(categorie.getId());
	    Annonce[] list_annonce = new Annonce[annonces.size()];
	    annonces.toArray(list_annonce);
	    return list_annonce;
	}
	
	public Annonce[] affichageAnnonceAdresse(String adresse) {
		DAOFactory factory = DAOFactory.getInstance();
	    AnnonceDaoImpl DaoAnnonce = (AnnonceDaoImpl) factory.getAnnonceDao();
	    List<Annonce> annonces = DaoAnnonce.listerAdresse(adresse);
	    Annonce[] list_annonce = new Annonce[annonces.size()];
	    annonces.toArray(list_annonce);
	    return list_annonce;
	}
	
	public Annonce affichageAnnonceNom(String nom) {
		DAOFactory factory = DAOFactory.getInstance();
	    AnnonceDaoImpl DaoAnnonce = (AnnonceDaoImpl) factory.getAnnonceDao();
	    Annonce annonce = DaoAnnonce.trouver_par_nom(nom);
		return annonce;
	}
}
