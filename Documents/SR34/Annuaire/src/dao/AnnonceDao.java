
package dao;

import java.util.List;

import beans.Annonce;

public interface AnnonceDao {
    void creer( Annonce annonce ) throws DAOException;

    Annonce trouver( long id ) throws DAOException;

    List<Annonce> lister() throws DAOException;

    void supprimer( Annonce annonce ) throws DAOException;
}