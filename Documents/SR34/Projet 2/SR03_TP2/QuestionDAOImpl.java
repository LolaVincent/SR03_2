package com.sr03.dao;

import static com.sr03.dao.DAOUtilitaire.fermeturesSilencieuses;
import static com.sr03.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sr03.beans.Question;
import com.sr03.beans.Questionnaire;

public class QuestionDaoImpl implements QuestionDao {

    private static final String SQL_SELECT        = "SELECT * FROM Question ORDER BY id";
    private static final String SQL_SELECT_PAR_ID = "SELECT * FROM Question WHERE id = ?";
    private static final String SQL_INSERT        = "INSERT INTO Question VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_PAR_ID = "DELETE FROM Question WHERE id = ?";

    private DAOFactory daoFactory;

    QuestionDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    public Question trouver( long id ) throws DAOException {
        return trouver( SQL_SELECT_PAR_ID, id );
    }

    public void creer( Question question ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true,
                    question.getQuestion(), question.getQuestionnaire().getId()
					question.getStatut() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création du question, aucune ligne ajoutée dans la table." );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                question.setId( valeursAutoGenerees.getLong( 1 ) );
            } else {
                throw new DAOException( "Échec de la création du question en base, aucun ID auto-généré retourné." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }

    public List<Question> lister() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Question> questions = new ArrayList<Question>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement( SQL_SELECT );
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                questions.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return questions;
    }

    public void supprimer( Question question ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE_PAR_ID, true, question.getId() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la suppression du question, aucune ligne supprimée de la table." );
            } else {
                question.setId( null );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }

    private Question trouver( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Question question = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            if ( resultSet.next() ) {
                question = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return question;
    }

    private static Question map( ResultSet resultSet ) throws SQLException {
        Question question = new Question();
		QuestionnaireDao questionnaireDao = daoFactory.getQuestionnaireDao();
        question.setId( resultSet.getLong( "id" ) );
        question.setQuestion( resultSet.getString( "question" ) );
		question.setQuestionnaire( questionnaireDao.trouver( resultSet.getLong( "id_questionnaire" ) ) );
        question.setStatut( resultSet.getString( "statut" ) );
        return question;
    }

}