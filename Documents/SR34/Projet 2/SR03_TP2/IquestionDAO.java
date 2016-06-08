package com.sr03.dao;

import java.util.List;

import com.sr03.beans.Question;

public interface QuestionDao {
    void creer( Question question ) throws DAOException;

    Question trouver( long id ) throws DAOException;

    List<Question> lister() throws DAOException;

    void supprimer( Question question ) throws DAOException;
}