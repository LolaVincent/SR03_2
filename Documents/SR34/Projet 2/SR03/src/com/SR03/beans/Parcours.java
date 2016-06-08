package com.SR03.beans;

import com.SR03.beans.*;

import java.util.List;
import java.util.ArrayList;

public class Parcours {

	private Long id;
	private Utilisateur utilisateur;
	private Questionnaire questionnaire;
	private int scoreTotal;
	private double duree;
	
	
	public void setId( Long id ) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
	
    public void setUtilisateur( Utilisateur utilisateur ) {
        this.utilisateur = utilisateur;
    }
	
	public Utilisateur getUtilisateur() {
        return utilisateur;
    }
	
	public void setQuestionnaire( Questionnaire questionnaire ) {
        this.questionnaire = questionnaire;
    }
	
	public Questionnaire getQuestionnaire() {
        return questionnaire;
    }
	
	public void setScore( int score ) {
        this.scoreTotal = score;
    }
	
	public int getScore() {
        return scoreTotal;
    }
	
	public void setDuree( double duree2 ) {
        this.duree = duree2;
    }
	
	public double getDuree() {
        return duree;
    }

}