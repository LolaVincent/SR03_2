package com.sr03.dao;

import java.util.List;

import com.sr03.beans.Parcours;

public interface ParcoursDao {
    void creer( Parcours parcours ) throws DAOException;

    Parcours trouver( long id ) throws DAOException;

    List<Parcours> lister() throws DAOException;

    void supprimer( Parcours parcours ) throws DAOException;
}