package com.SR03.dao;

import static com.SR03.dao.DAOUtilitaire.fermeturesSilencieuses;
import static com.SR03.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.SR03.beans.Reponse;
import com.SR03.beans.Question;
import com.SR03.beans.Parcours;

public class ReponseDaoImpl implements ReponseDao {

    private static final String SQL_SELECT        = "SELECT * FROM Reponse ORDER BY id";
    private static final String SQL_SELECT_PAR_ID = "SELECT * FROM Reponse WHERE id = ?";
    private static final String SQL_SELECT_QUESTION = "SELECT * FROM Reponse WHERE question_id = ?";
    private static final String SQL_INSERT        = "INSERT INTO Reponse VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_PAR_ID = "DELETE FROM Reponse WHERE id = ?";

    private static DAOFactory daoFactory;

    ReponseDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    public Reponse trouver( long id ) throws DAOException {
        return trouver( SQL_SELECT_PAR_ID, id );
    }

    public void creer( Reponse reponse ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true,
                    reponse.getId(), reponse.getPossiblite(),
                    reponse.getQuestion().getId(), reponse.getScore() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "�chec de la cr�ation du reponse, aucune ligne ajout�e dans la table." );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                reponse.setId( valeursAutoGenerees.getLong( 1 ) );
            } else {
                throw new DAOException( "�chec de la cr�ation du reponse en base, aucun ID auto-g�n�r� retourn�." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }

    public List<Reponse> lister() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Reponse> reponses = new ArrayList<Reponse>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement( SQL_SELECT );
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                reponses.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return reponses;
    }
    
    public List<Reponse> listerReponses(Long question_id) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Reponse> reponses = new ArrayList<Reponse>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_QUESTION , true,
            		question_id
			);
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                reponses.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return reponses;
    }

    public void supprimer( Reponse reponse ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE_PAR_ID, true, reponse.getId() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "�chec de la suppression du reponse, aucune ligne supprim�e de la table." );
            } else {
                reponse.setId( null );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }

    private Reponse trouver( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Reponse reponse = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            if ( resultSet.next() ) {
                reponse = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return reponse;
    }

    private static Reponse map( ResultSet resultSet ) throws SQLException {
        Reponse reponse = new Reponse();
		QuestionDao questionDao = daoFactory.getQuestionDao();
		ParcoursDao parcoursDao = daoFactory.getParcoursDao();
        reponse.setId( resultSet.getLong( "id" ) );
        reponse.setPossiblite( resultSet.getString( "possiblite" ) );
		reponse.setQuestion( questionDao.trouver( resultSet.getLong( "question_id" ) ) );
        reponse.setScore( resultSet.getInt( "score" ) );
        return reponse;
    }

}