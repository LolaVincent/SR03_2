package com.sr03.beans;

public class Reponse {

	private Long id;
	private String reponse;
	private boolean bonneReponse;
	private Question question;
	private Parcours parcours;
	private String statut;
	
	public void setId( Long id ) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
	
	public void setReponse( String reponse ) {
        this.reponse = reponse;
    }

    public String getReponse() {
        return reponse;
    }
	
	public void setBonneReponse( boolean bonneReponse ) {
        this.bonneReponse = bonneReponse;
    }
	
	public boolean getBonneReponse() {
        return bonneReponse;
    }
	
	public void setQuestion( Question question ) {
        this.question = question;
    }
	
	public Question getQuestion() {
        return question;
    }
	
	public void setParcours( Parcours parcours ) {
        this.parcours = parcours;
    }
	
	public Parcours getParcours() {
        return parcours;
    }
	
	public void setSatut( String statut ) {
        this.statut = statut;
    }
	
	public String getStatut() {
        return statut;
    }
}