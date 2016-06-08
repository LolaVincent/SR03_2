package com.SR03.dao;

import java.util.List;

import com.SR03.beans.Possibilite;

public interface PossibiliteDao {
    void creer( Possibilite possibilite ) throws DAOException;

    Possibilite trouver( long id ) throws DAOException;

    List<Possibilite> lister() throws DAOException;

    void supprimer( Possibilite possibilite ) throws DAOException;
}