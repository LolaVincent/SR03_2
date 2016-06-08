package com.SR03.dao;

import static com.SR03.dao.DAOUtilitaire.fermeturesSilencieuses;
import static com.SR03.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.SR03.beans.Parcours;
import com.SR03.beans.Utilisateur;
import com.SR03.beans.Questionnaire;
import com.SR03.beans.Reponse;

public class ParcoursDaoImpl implements ParcoursDao {

    private static final String SQL_SELECT        = "SELECT * FROM Parcours ORDER BY id";
    private static final String SQL_SELECT_PAR_ID = "SELECT * FROM Parcours WHERE id = ?";
    private static final String SQL_SELECT_PAR_UTILISATEUR = "SELECT * FROM Parcours WHERE utilisateur_id = ?";
    private static final String SQL_INSERT        = "INSERT INTO Parcours (utilisateur_id,questionnaire_id,scoreTotal,duree) VALUES (?, ?, ?, ?)";
    private static final String SQL_DELETE_PAR_ID = "DELETE FROM Parcours WHERE id = ?";

    private static DAOFactory daoFactory;

    ParcoursDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    public Parcours trouver( long id ) throws DAOException {
        return trouver( SQL_SELECT_PAR_ID, id );
    }

    public void creer( Parcours parcours ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true,
                    parcours.getUtilisateur().getId(), 
                    parcours.getQuestionnaire().getId(),
                    parcours.getScore(), 
                    parcours.getDuree() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "�chec de la cr�ation du parcours, aucune ligne ajout�e dans la table." );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                parcours.setId( valeursAutoGenerees.getLong( 1 ) );
            } else {
                throw new DAOException( "�chec de la cr�ation du parcours en base, aucun ID auto-g�n�r� retourn�." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }

    public List<Parcours> lister() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Parcours> parcourss = new ArrayList<Parcours>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement( SQL_SELECT );
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                parcourss.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return parcourss;
    }
    
    public List<Parcours> listerParcours(Long utilisateur_id) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Parcours> parcours = new ArrayList<Parcours>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_PAR_UTILISATEUR , true,
            		utilisateur_id
			);
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                parcours.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return parcours;
    }

    public void supprimer( Parcours parcours ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE_PAR_ID, true, parcours.getId() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "�chec de la suppression du parcours, aucune ligne supprim�e de la table." );
            } else {
                parcours.setId( null );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }

    private Parcours trouver( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Parcours parcours = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            if ( resultSet.next() ) {
                parcours = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return parcours;
    }

    private static Parcours map( ResultSet resultSet ) throws SQLException {
        Parcours parcours = new Parcours();
		UtilisateurDao utilisateurDao = daoFactory.getUtilisateurDao();
		QuestionnaireDao questionnaireDao = daoFactory.getQuestionnaireDao();
        parcours.setId( resultSet.getLong( "id" ) );
        parcours.setUtilisateur( utilisateurDao.trouver( resultSet.getLong( "utilisateur_id" ) ) );
        parcours.setQuestionnaire( questionnaireDao.trouver ( resultSet.getLong( "questionnaire_id" ) ) );
        parcours.setScore( resultSet.getInt( "scoreTotal" ) );
        parcours.setDuree( resultSet.getInt( "duree" ) );
        return parcours;
    }

}