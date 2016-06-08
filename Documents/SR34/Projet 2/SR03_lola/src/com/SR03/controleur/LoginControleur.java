package com.SR03.controleur;

import java.sql.DriverManager;

import com.SR03.beans.Utilisateur;
import com.SR03.dao.DAOFactory;
import com.SR03.dao.UtilisateurDaoImpl;

public class LoginControleur {
	public static Boolean isAdmin(Utilisateur user) {
		if (user.getType().equals("admin"))
			return true;
		return false;
	}
	
	public static Boolean isUserValid(String mail, String mdp) {
	     DAOFactory factory = DAOFactory.getInstance();
	     UtilisateurDaoImpl DaoUser = (UtilisateurDaoImpl) factory.getUtilisateurDao();
	     Utilisateur user = DaoUser.trouverIdentifiants(mail, mdp);
	     if (user != null)
	    	 return true;
	     return false;  	
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
