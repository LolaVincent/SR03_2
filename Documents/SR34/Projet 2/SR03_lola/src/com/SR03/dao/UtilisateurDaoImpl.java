package com.SR03.dao;

import static com.SR03.dao.DAOUtilitaire.fermeturesSilencieuses;
import static com.SR03.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.SR03.beans.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {

    private static final String SQL_SELECT        = "SELECT * FROM Utilisateur ORDER BY id";
    private static final String SQL_SELECT_PAR_ID = "SELECT * FROM Utilisateur WHERE id = ?";
    private static final String SQL_SELECT_PAR_ADRESSE = "SELECT * FROM Utilisateur WHERE mail = ?";
    private static final String SQL_SELECT_PAR_MDP = "SELECT * FROM Utilisateur WHERE mail = ? AND mdp =?";
    private static final String SQL_INSERT        = "INSERT INTO Utilisateur (mail, mdp, nom, telephone, societe, type, statut, date) VALUES (?, ?, ?, ?, ?, ?, ?, now())";
    private static final String SQL_UPDATE = "UPDATE Utilisateur SET nom=?, telephone=?, societe=?, type=?, statut=?, date=now() where mail=? and mdp=?";
    private static final String SQL_DELETE_PAR_ID = "DELETE FROM Utilisateur WHERE id = ?";

    private DAOFactory daoFactory;

    UtilisateurDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    public Utilisateur trouver( long id ) throws DAOException {
        return trouver( SQL_SELECT_PAR_ID, id );
    }
    
    public Utilisateur trouverAdresse( String adresse ) throws DAOException {
        return trouver( SQL_SELECT_PAR_ADRESSE, adresse );
    }
    
    public Utilisateur trouverIdentifiants( String adresse, String mdp ) throws DAOException {
        return trouver( SQL_SELECT_PAR_MDP, adresse, mdp);
    }


    public void creer( Utilisateur utilisateur ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true,
            		utilisateur.getAdresse(), utilisateur.getMdp(), 
                    utilisateur.getNom(), utilisateur.getTelephone(),
                    utilisateur.getSociete(), utilisateur.getType(),
                    utilisateur.getStatut());
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "�chec de la cr�ation de l'utilisateur, aucune ligne ajout�e dans la table." );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
            	utilisateur.setId( valeursAutoGenerees.getLong( 1 ) );
            } else {
                throw new DAOException( "�chec de la cr�ation de l'utilisateur en base, aucun ID auto-g�n�r� retourn�." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }

    public List<Utilisateur> lister() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement( SQL_SELECT );
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                utilisateurs.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return utilisateurs;
    }

    public void modifier( Utilisateur utilisateur ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_UPDATE, true,
            		utilisateur.getNom(), utilisateur.getTelephone(),
                    utilisateur.getSociete(), utilisateur.getType(),
                    utilisateur.getStatut(), utilisateur.getAdresse(), utilisateur.getMdp());
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Echec de la modification de l'utilisateur, aucune ligne modifié de la table." );
            } else {
                utilisateur.setId(0);
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }
    
    
    public void supprimer( Utilisateur utilisateur ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE_PAR_ID, true, utilisateur.getId() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "�chec de la suppression de l'utilisateur, aucune ligne supprim�e de la table." );
            } else {
                utilisateur.setId(0);
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }

    private Utilisateur trouver( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Utilisateur utilisateur = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            if ( resultSet.next() ) {
                utilisateur = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return utilisateur;
    }

    
    
    private static Utilisateur map( ResultSet resultSet ) throws SQLException {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId( resultSet.getLong( "id" ) );
        utilisateur.setType( resultSet.getString( "type" ) );
        utilisateur.setAdresse( resultSet.getString( "mail" ) );
        utilisateur.setMdp( resultSet.getString( "mdp" ) );
        utilisateur.setNom( resultSet.getString( "nom" ) );
        utilisateur.setSociete( resultSet.getString( "societe" ) );
        utilisateur.setTelephone( resultSet.getString( "telephone" ) );
		utilisateur.setStatut( resultSet.getString( "statut" ) );
        utilisateur.setDate( resultSet.getString( "date" ) );
        return utilisateur;
    }

}