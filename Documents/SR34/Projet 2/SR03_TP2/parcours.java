package com.sr03.beans;

import java.util.List;
import java.util.ArrayList;

public class Parcours {

	private Long id;
	private Utilisateur utilisateur;
	private Questionnaire questionnaire;
	private int score;
	private int duree;
	
	Parcours(){
		this.reponses = new ArrayList<Reponse>();
	}
	
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
        this.score = score;
    }
	
	public int getScore() {
        return score;
    }
	
	public void setDuree( int duree ) {
        this.duree = duree;
    }
	
	public int getDuree() {
        return duree;
    }
	
	public void setReponses( List<Reponse> reponses ) {
        this.reponses = reponses;
    }
	
	public List<Reponse> getReponses() {
        return reponses;
    }
}