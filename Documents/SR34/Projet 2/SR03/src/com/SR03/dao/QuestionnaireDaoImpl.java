package com.SR03.dao;

import static com.SR03.dao.DAOUtilitaire.fermeturesSilencieuses;
import static com.SR03.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.SR03.beans.Question;
import com.SR03.beans.Questionnaire;

public class QuestionnaireDaoImpl implements QuestionnaireDao {

    private static final String SQL_SELECT        = "SELECT * FROM Questionnaire ORDER BY id";
    private static final String SQL_SELECT_PAR_ID = "SELECT * FROM Questionnaire WHERE id = ?";
    private static final String SQL_SELECT_PAR_SUJET = "SELECT * FROM Questionnaire WHERE sujet = ?";
    private static final String SQL_INSERT        = "INSERT INTO Questionnaire(sujet, statut) VALUES (?, 'A')";
    private static final String SQL_DELETE_PAR_ID = "DELETE FROM Questionnaire WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE Questionnaire SET sujet=? where id=?";
    
    
    private DAOFactory daoFactory;

    QuestionnaireDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    public Questionnaire trouver( long id ) throws DAOException {
        return trouver( SQL_SELECT_PAR_ID, id );
    }
    
    public Questionnaire trouverSujet( String sujet) throws DAOException {
        return trouver( SQL_SELECT_PAR_SUJET, sujet );
    }
    
    public void creer( Questionnaire questionnaire ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT, true,
                    questionnaire.getSujet());
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "�chec de la cr�ation du questionnaire, aucune ligne ajout�e dans la table." );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                questionnaire.setId( valeursAutoGenerees.getLong( 1 ) );
            } else {
                throw new DAOException( "�chec de la cr�ation du questionnaire en base, aucun ID auto-g�n�r� retourn�." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }

    public List<Questionnaire> lister() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Questionnaire> questionnaires = new ArrayList<Questionnaire>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement( SQL_SELECT );
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                questionnaires.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return questionnaires;
    }

    public void supprimer( Questionnaire questionnaire ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE_PAR_ID, true, questionnaire.getId() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "�chec de la suppression du questionnaire, aucune ligne supprim�e de la table." );
            } else {
                questionnaire.setId( null );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }

    private Questionnaire trouver( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Questionnaire questionnaire = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            if ( resultSet.next() ) {
                questionnaire = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return questionnaire;
    }

    private static Questionnaire map( ResultSet resultSet ) throws SQLException {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setId( resultSet.getLong( "id" ) );
        questionnaire.setSujet( resultSet.getString( "sujet" ) );
        questionnaire.setStatut( resultSet.getString( "statut" ) );
        return questionnaire;
    }
    
    public void modifier(Questionnaire questionnaire ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_UPDATE, true,
            		questionnaire.getSujet(), questionnaire.getId());
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Echec de la modification du questionnaire, aucune ligne modifié de la table." );
            } else {
            	questionnaire.setId((long) 0);
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }

}