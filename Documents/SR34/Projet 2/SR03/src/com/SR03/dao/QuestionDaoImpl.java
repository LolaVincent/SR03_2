package com.SR03.dao;

import static com.SR03.dao.DAOUtilitaire.fermeturesSilencieuses;
import static com.SR03.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.SR03.beans.Possibilite;
import com.SR03.beans.Question;
import com.SR03.beans.Questionnaire;

public class QuestionDaoImpl implements QuestionDao {

    private static final String SQL_SELECT        = "SELECT * FROM Question ORDER BY ordre DESC";
    private static final String SQL_QUESTIONNAIRE = "SELECT * FROM Question WHERE questionnaire_id =? ORDER by ordre DESC";
    private static final String SQL_SELECT_PAR_ID = "SELECT * FROM Question WHERE id = ? ORDER by ordre DESC";
    private static final String SQL_SELECT_PAR_QUESTION = "SELECT * FROM Question WHERE question = ? ORDER by ordre DESC";
    private static final String SQL_INSERT        = "INSERT INTO Question(questionnaire_id, question, statut,ordre) VALUES (?, ?, 'A',?)";
    private static final String SQL_DELETE_PAR_ID = "DELETE FROM Question WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE Question SET question=?, statut=?, ordre=? where id=?";
    
    private static DAOFactory daoFactory;

    QuestionDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    public Question trouver( long id ) throws DAOException {
        return trouver( SQL_SELECT_PAR_ID, id );
    }
    
    public Question trouverQuestion( String question) throws DAOException {
        return trouver( SQL_SELECT_PAR_QUESTION, question );
    }

    public void creer( Question question ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true,
                    question.getQuestionnaire().getId(), question.getQuestion() , question.getOrdre()
			);
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "�chec de la cr�ation du question, aucune ligne ajout�e dans la table." );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                question.setId( valeursAutoGenerees.getLong( 1 ) );
            } else {
                throw new DAOException( "�chec de la cr�ation du question en base, aucun ID auto-g�n�r� retourn�." );
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
            preparedStatement = connection.prepareStatement( SQL_QUESTIONNAIRE );
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

    public List<Question> listerQuestion(Long questionnaire_id) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Question> questions = new ArrayList<Question>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_QUESTIONNAIRE , true,
            		questionnaire_id
			);
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
                throw new DAOException( "�chec de la suppression du question, aucune ligne supprim�e de la table." );
            } else {
                question.setId( 0 );
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
		question.setQuestionnaire( questionnaireDao.trouver( resultSet.getLong( "questionnaire_id" ) ) );
        question.setStatut( resultSet.getString( "statut" ) );
        return question;
    }
    
    public void modifier(Question question ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_UPDATE, true,
            		question.getQuestion(), question.getStatut(), question.getOrdre(), question.getId());
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Echec de la modification de la question, aucune ligne modifié de la table." );
            } else {
            	question.setId(0);
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }
}