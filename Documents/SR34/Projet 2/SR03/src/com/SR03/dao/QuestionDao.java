package com.SR03.dao;

import java.util.List;

import com.SR03.beans.Question;

public interface QuestionDao {
    void creer( Question question ) throws DAOException;

    Question trouver( long id ) throws DAOException;

    List<Question> lister() throws DAOException;

    void supprimer( Question question ) throws DAOException;
}