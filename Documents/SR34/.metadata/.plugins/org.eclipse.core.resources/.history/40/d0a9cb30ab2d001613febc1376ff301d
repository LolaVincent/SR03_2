package dao;

import static dao.DAOUtilitaire.fermeturesSilencieuses;
import static dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Annonce;
import beans.Categorie;

public class AnnonceDaoImpl implements AnnonceDao {

    private static final String SQL_SELECT        			= "SELECT * FROM Annonce ORDER BY id";
    private static final String SQL_SELECT_PAR_ID 			= "SELECT * FROM Annonce WHERE id = ?";
    private static final String SQL_SELECT_PAR_CATEGORIE 	= "SELECT * FROM Annonce WHERE categorie_id = ?";
    private static final String SQL_SELECT_PAR_NOM 			= "SELECT * FROM Annonce WHERE nom = ?";
    private static final String SQL_SELECT_PAR_ADRESSE 		= "SELECT * FROM Annonce WHERE adresse = ?";
    private static final String SQL_SELECT_PAR_NUM 			= "SELECT * FROM Annonce WHERE num = ?";
    private static final String SQL_INSERT        			= "INSERT INTO Annonce (categorie_id,nom,adresse,num) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE                  = "UPDATE Annonce SET categorie_id=?, nom=?, adresse=?, num=? where id=?";
    private static final String SQL_DELETE_PAR_ID 			= "DELETE FROM Annonce WHERE id = ?";

    private static DAOFactory daoFactory;

    AnnonceDaoImpl( DAOFactory daoFactory ) {
        AnnonceDaoImpl.daoFactory = daoFactory;
    }

    public Annonce trouver( long id ) throws DAOException {
        return trouver( SQL_SELECT_PAR_ID, id );
    }
    
    public Annonce trouver_par_nom( String nom) throws DAOException {
        return trouver( SQL_SELECT_PAR_NOM, nom);
    }
    
    public Annonce trouver_par_adresse( String adresse) throws DAOException {
        return trouver( SQL_SELECT_PAR_ADRESSE, adresse );
    }
    
    public void creer( Annonce annonce ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true,
                    annonce.getCategorie().getId(), 
                    annonce.getNom(),
                    annonce.getAdresse(), 
                    annonce.getNumero() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "échec de la création du parcours, aucune ligne ajoutée dans la table." );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                annonce.setId( valeursAutoGenerees.getLong( 1 ) );
            } else {
                throw new DAOException( "échec de la création du parcours en base, aucun ID auto-généré retourné." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }

    public List<Annonce> lister() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Annonce> annonces = new ArrayList<Annonce>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement( SQL_SELECT );
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                annonces.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return annonces;
    }
    
    public List<Annonce> listerCategorie(Long categorie_id) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Annonce> annonces = new ArrayList<Annonce>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_PAR_CATEGORIE , true,
            		categorie_id
			);
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                annonces.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return annonces;
    }
     
    public List<Annonce> listerAdresse(String adresse) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Annonce> annonces = new ArrayList<Annonce>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_PAR_ADRESSE , true,
            		adresse
			);
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                annonces.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return annonces;
    }
    
    public void supprimer( Annonce annonce ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE_PAR_ID, true, annonce.getId() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "échec de la suppression du parcours, aucune ligne supprimée de la table." );
            } else {
                annonce.setId( (Long) null );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }

    private Annonce trouver( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Annonce annonce = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            if ( resultSet.next() ) {
                annonce = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return annonce;
    }
    
    public void modifier( Annonce annonce ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_UPDATE, true,
            		annonce.getCategorie().getId(), annonce.getNom(),
            		annonce.getAdresse(), annonce.getNumero(),
            		annonce.getId());
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Echec de la modification de l'utilisateur, aucune ligne modifié de la table." );
            } else {
                annonce.setId((long) 0);
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }

    private static Annonce map( ResultSet resultSet ) throws SQLException {
        Annonce annonce = new Annonce();
		CategorieDao categorieDao = daoFactory.getCategorieDao();
        annonce.setId( resultSet.getLong( "id" ) );
        Categorie categorie = categorieDao.trouver(resultSet.getLong("categorie_id"));
        annonce.setCategorie(categorie);
        annonce.setNom( resultSet.getString( "nom" ) );
        annonce.setAdresse( resultSet.getString( "adresse" ) );
        annonce.setNumero( resultSet.getString( "num" ) );
        return annonce;
    }

}