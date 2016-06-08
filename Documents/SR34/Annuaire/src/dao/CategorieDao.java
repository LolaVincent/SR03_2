package dao;

import java.util.List;
import beans.Categorie;


public interface CategorieDao {
    void creer( Categorie categorie ) throws DAOException;

    Categorie trouver( long id ) throws DAOException;

    List<Categorie> lister() throws DAOException;

    void supprimer( Categorie categorie ) throws DAOException;
}