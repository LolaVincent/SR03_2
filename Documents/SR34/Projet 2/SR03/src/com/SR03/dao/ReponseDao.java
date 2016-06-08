package com.SR03.dao;

import java.util.List;

import com.SR03.beans.Reponse;

public interface ReponseDao {
    void creer( Reponse reponse ) throws DAOException;

    Reponse trouver( long id ) throws DAOException;

    List<Reponse> lister() throws DAOException;

    void supprimer( Reponse reponse ) throws DAOException;
}