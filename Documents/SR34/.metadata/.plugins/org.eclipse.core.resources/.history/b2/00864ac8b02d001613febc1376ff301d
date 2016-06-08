package dao;

import static dao.DAOUtilitaire.fermeturesSilencieuses;
import static dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Categorie;

public class CategorieDaoImpl implements CategorieDao {

    private static final String SQL_SELECT        = "SELECT * FROM Categorie ORDER BY id";
    private static final String SQL_SELECT_PAR_ID = "SELECT * FROM Categorie WHERE id = ?";
    private static final String SQL_SELECT_PAR_SUJET = "SELECT * FROM Categorie WHERE sujet = ?";
    private static final String SQL_INSERT        = "INSERT INTO Categorie (sujet) VALUES (?)";
    private static final String SQL_UPDATE        = "UPDATE Categorie SET sujet=? where id=?";
    private static final String SQL_DELETE_PAR_ID = "DELETE FROM Categorie WHERE id = ?";

    private static DAOFactory daoFactory;

    CategorieDaoImpl( DAOFactory daoFactory ) {
        CategorieDaoImpl.daoFactory = daoFactory;
    }

    public Categorie trouver( long id ) throws DAOException {
        return trouver( SQL_SELECT_PAR_ID, id );
    }
    
    public Categorie trouverSujet( String sujet ) throws DAOException {
        return trouver( SQL_SELECT_PAR_SUJET, sujet   );
    }
    
    public void creer( Categorie categorie ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true,
            		categorie.getSujet()); 
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Echec de la création du Categorie, aucune ligne ajoutée dans la table." );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
            	categorie.setId( valeursAutoGenerees.getLong(1));
            } else {
                throw new DAOException( "Echec de la création du Categorie en base, aucun ID auto-généré retourné." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }

    public List<Categorie> lister() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Categorie> categories = new ArrayList<Categorie>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement( SQL_SELECT );
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
            	categories.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return categories;
    }
    
    public void supprimer( Categorie categorie ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE_PAR_ID, true, categorie.getId() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Echec de la suppression du Categorie, aucune ligne supprimée de la table." );
            } else {
            	categorie.setId( 0 );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }
    
    private Categorie trouver( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Categorie Categorie = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            if ( resultSet.next() ) {
                Categorie = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return Categorie;
    }

    public void modifier(Categorie categorie) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_UPDATE, true,
            		categorie.getSujet(), categorie.getId());
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException("Echec de la modification de l'utilisateur, aucune ligne modifié de la table.");
            } else {
            	categorie.setId(0);
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }
    
    private static Categorie map( ResultSet resultSet ) throws SQLException {
    	Categorie categorie = new Categorie();
        categorie.setId( resultSet.getLong( "id" ) );
        categorie.setSujet( resultSet.getString( "Sujet" ) );
        return categorie;
    }

}