package com.SR03.beans;

import java.util.List;

import com.SR03.beans.*;

import java.util.ArrayList;

public class Question {

	private long id;
	private String question;
	private Questionnaire questionnaire;
	private String statut;
	private int ordre;

	public void setId( long i ) {
        this.id = i;
    }

    public long getId() {
        return id;
    }
	
	public void setQuestion( String question ) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }
	
	public void setQuestionnaire(Questionnaire questionnaire ) {
        this.questionnaire = questionnaire;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }
	
	public void setStatut( String statut ) {
        this.statut = statut;
    }
	
	public String getStatut() {
        return statut;
    }
	
	public int getOrdre() {
		return ordre;
	}
	
	public void setOrdre( int i ) {
		this.ordre = i;
	}

}