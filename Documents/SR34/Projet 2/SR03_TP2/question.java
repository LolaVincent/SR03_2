package com.sr03.beans;

import java.util.List;
import java.util.ArrayList;

public class Question {

	private Long id;
	private String question;
	private Questionnaire questionnaire;
	private String statut;

	public void setId( Long id ) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
	
	public void setQuestion( String question ) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }
	
	public void setQuestionnaire( Questionnaire ) {
        this.questionnaire = questionnaire;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }
	
	public void setSatut( String statut ) {
        this.statut = statut;
    }
	
	public String getStatut() {
        return statut;
    }
}