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
import com.SR03.beans.Utilisateur;
import com.SR03.beans.Question;
import com.SR03.beans.Parcours;
import com.SR03.beans.Possibilite;

public class PossibiliteDaoImpl implements PossibiliteDao {

    private static final String SQL_SELECT        = "SELECT * FROM Possibilite ORDER BY id";
    private static final String SQL_QUESTION = "SELECT * FROM Possibilite WHERE question_id =?";
    private static final String SQL_SELECT_PAR_ID = "SELECT * FROM Possibilite WHERE id = ?";
    private static final String SQL_INSERT        = "INSERT INTO Possibilite(question_id, possibilite, bonneReponse, statut) VALUES (?, ?, ?, 'A')";
    private static final String SQL_DELETE_PAR_ID = "DELETE FROM Possibilite WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE Possibilite SET possibilite=?, bonneReponse=? where id=?";
    private static DAOFactory daoFactory;

    PossibiliteDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    public Possibilite trouver ( long id ) throws DAOException {
        return trouver( SQL_SELECT_PAR_ID, id );
    }

    public void creer( Possibilite possibilite ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true,
                    possibilite.getQuestion().getId(), possibilite.getPossibilite(),
                    possibilite.getBonneReponse());
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "�chec de la cr�ation du reponse, aucune ligne ajout�e dans la table." );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
            	possibilite.setId( valeursAutoGenerees.getLong( 1 ) );
            } else {
                throw new DAOException( "�chec de la cr�ation du reponse en base, aucun ID auto-g�n�r� retourn�." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }

    public List<Possibilite> lister() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Possibilite> possibilites = new ArrayList<Possibilite>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement( SQL_SELECT );
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
            	possibilites.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return possibilites;
    }

    public List<Possibilite> listerPossibilite (Long question_id) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Possibilite> possibilites = new ArrayList<Possibilite>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_QUESTION , true,
            		question_id
			);
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
            	possibilites.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return possibilites;
    }
    public void supprimer(Possibilite possibilite ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE_PAR_ID, true, possibilite.getId() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "�chec de la suppression du reponse, aucune ligne supprim�e de la table." );
            } else {
            	possibilite.setId( 0 );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }

    private Possibilite trouver( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Possibilite possibilite = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            if ( resultSet.next() ) {
            	possibilite = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return possibilite;
    }

    private static Possibilite map( ResultSet resultSet ) throws SQLException {
    	Possibilite possibilite = new Possibilite();
		QuestionDao questionDao = daoFactory.getQuestionDao();
		possibilite.setId( resultSet.getLong( "id" ) );
		possibilite.setPossibilite( resultSet.getString( "possibilite" ) );
		possibilite.setQuestion( questionDao.trouver( resultSet.getLong( "question_id" ) ) );
		possibilite.setBonneReponse( resultSet.getString("bonneReponse"));
		possibilite.setStatut( resultSet.getString( "statut" ) );
        return possibilite;
    }
    
    public void modifier( Possibilite possibilite ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_UPDATE, true,
            		possibilite.getPossibilite(), possibilite.getBonneReponse(),
            		possibilite.getId());
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Echec de la modification de la possibilite, aucune ligne modifié de la table." );
            } else {
            	possibilite.setId(0);
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }

}