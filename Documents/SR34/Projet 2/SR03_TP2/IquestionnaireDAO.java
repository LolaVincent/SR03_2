package com.sr03.dao;

import java.util.List;

import com.sr03.beans.Questionnaire;

public interface QuestionnaireDao {
    void creer( Questionnaire questionnaire ) throws DAOException;

    Questionnaire trouver( long id ) throws DAOException;

    List<Questionnaire> lister() throws DAOException;

    void supprimer( Questionnaire questionnaire ) throws DAOException;
}