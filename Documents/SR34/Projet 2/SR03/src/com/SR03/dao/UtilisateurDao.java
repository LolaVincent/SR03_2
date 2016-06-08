package com.SR03.dao;

import java.util.List;

import com.SR03.beans.Utilisateur;

public interface UtilisateurDao {
    void creer( Utilisateur utilisateur ) throws DAOException;

    Utilisateur trouver( long id ) throws DAOException;

    List<Utilisateur> lister() throws DAOException;

    void supprimer( Utilisateur utilisateur ) throws DAOException;
}