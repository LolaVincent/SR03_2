package com.SR03.controleur;

import com.SR03.beans.Utilisateur;
import com.SR03.dao.DAOFactory;
import com.SR03.dao.UtilisateurDaoImpl;

public class LoginControleur {
	public static Boolean isAdmin(Utilisateur user) {
		if (user.getType().equals("admin"))
			return true;
		return false;
	}
	
	public static Boolean isStagiaire(Utilisateur user) {
		if (user.getType().equals("stagiaire"))
			return true;
		return false;
	}
	
	public static Boolean isUserValid(String mail, String mdp) {
		try {
			validationEmail(mail);
			validationMotsDePasse(mdp);
		} catch (Exception e) {
			return false;
		}
	     DAOFactory factory = DAOFactory.getInstance();
	     try {
	    	 UtilisateurDaoImpl DaoUser = (UtilisateurDaoImpl) factory.getUtilisateurDao();
	    	 Utilisateur user = DaoUser.trouverIdentifiants(mail, mdp);
	    	 if (user.getStatut().equals("I")){
		    	 return false;
		     }
	     } catch ( Exception e) {
	    	return false; 
	     }
	     return true;
	}
	
	public static void validationEmail( String email ) throws Exception {
	    if ( email != null ) {
	        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new Exception( "Merci de saisir une adresse mail valide." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir une adresse mail." );
	    }
	}

	public static void validationMotsDePasse( String motDePasse) throws Exception {
	    if ( motDePasse != null) {
	        if ( motDePasse.length() < 6 ) {
	            throw new Exception( "Les mots de passe doivent contenir au moins 6 caractères." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
	    }
	}
	
	public static Boolean isMailUsed(String mail) {
	     DAOFactory factory = DAOFactory.getInstance();
	     UtilisateurDaoImpl DaoUser = (UtilisateurDaoImpl) factory.getUtilisateurDao();
	     Utilisateur user = DaoUser.trouverAdresse(mail);
	     if (user != null)
	    	 return true;
	     return false;  		
	}
	
}
