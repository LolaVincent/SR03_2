package com.SR03.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory{
	private String url;
	private String username;
	private String password;
	
	DAOFactory(String url, String username, String password){
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public static DAOFactory getInstance() throws DAOConfigurationException {
		String url = "jdbc:mysql://tuxa.sme.utc/sr03p034";
		String driver = "com.mysql.jdbc.Driver";
		String username = "sr03p034";
		String password = "20VKymsC";

		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try {
            Class.forName( driver );
        } catch ( ClassNotFoundException e ) {
            throw new DAOConfigurationException( "Le driver est introuvable dans le classpath.", e );
        }

        DAOFactory instance = new DAOFactory( url, username, password );
        return instance;
    }
	
	Connection getConnection() throws SQLException {
        return DriverManager.getConnection( url, username, password );
    }
	
	public UtilisateurDao getUtilisateurDao() {
        return new UtilisateurDaoImpl( this );
    }

    public QuestionnaireDao getQuestionnaireDao() {
        return new QuestionnaireDaoImpl( this );
    }
	
	public QuestionDao getQuestionDao() {
        return new QuestionDaoImpl( this );
    }

    public ReponseDao getReponseDao() {
        return new ReponseDaoImpl( this );
    }
	
	public ParcoursDao getParcoursDao() {
        return new ParcoursDaoImpl( this );
    }

	public PossibiliteDao getPossibiliteDao() {
        return new PossibiliteDaoImpl( this );
    }

}
