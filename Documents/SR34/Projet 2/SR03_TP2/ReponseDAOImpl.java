package com.sr03.dao;

import static com.sr03.dao.DAOUtilitaire.fermeturesSilencieuses;
import static com.sr03.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sr03.beans.Reponse;
import com.sr03.beans.Question;
import com.sr03.beans.Parcours;

public class ReponseDaoImpl implements ReponseDao {

    private static final String SQL_SELECT        = "SELECT * FROM Reponse ORDER BY id";
    private static final String SQL_SELECT_PAR_ID = "SELECT * FROM Reponse WHERE id = ?";
    private static final String SQL_INSERT        = "INSERT INTO Reponse VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_PAR_ID = "DELETE FROM Reponse WHERE id = ?";

    private DAOFactory daoFactory;

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
                    reponse.getReponse(), reponse.getBonneReponse(),
                    reponse.getQuestion().getId(), reponse.getParcours().getId(),
					reponse.getStatut() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création du reponse, aucune ligne ajoutée dans la table." );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                reponse.setId( valeursAutoGenerees.getLong( 1 ) );
            } else {
                throw new DAOException( "Échec de la création du reponse en base, aucun ID auto-généré retourné." );
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

    public void supprimer( Reponse reponse ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE_PAR_ID, true, reponse.getId() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la suppression du reponse, aucune ligne supprimée de la table." );
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
        reponse.setReponse( resultSet.getString( "reponse" ) );
        reponse.setBonneReponse( resultSet.getString( "bonneReponse" ) );
		reponse.setQuestion( questionDao.trouver( resultSet.getLong( "question_id" ) ) );
        reponse.setParcours( parcoursDao.trouver( resultSet.getLong( "parcours_id" ) ) );
        reponse.setStatut( resultSet.getString( "statut" ) );
        return reponse;
    }

}