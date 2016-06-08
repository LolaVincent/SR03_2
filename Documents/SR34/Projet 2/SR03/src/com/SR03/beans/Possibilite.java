package com.SR03.beans;

import com.SR03.beans.*;

import java.util.List;
import java.util.ArrayList;

public class Possibilite {

	private long id;
	private Question question;
	private String possibilite;
	private String bonneReponse;
	private String statut;
	private int ordre;
	
	
	public void setId( long i ) {
        this.id = i;
    }

    public Long getId() {
        return id;
    }
	
	
	public void setQuestion( Question question ) {
        this.question= question;
    }
	
	public Question getQuestion() {
        return question;
    }
	
	public void setBonneReponse( String string ) {
        this.bonneReponse = string;
    }
	
	public String getBonneReponse() {
		return bonneReponse;
	}
	
	public void setStatut( String statut ) {
        this.statut = statut;
    }
	
	public String getStatut() {
        return statut;
    }

	public void setPossibilite ( String possibilite ) {
        this.possibilite = possibilite;
    }
	
	public String getPossibilite() {
        return possibilite;
    }
	public int getOrdre(){
		return ordre;
	}
	public void setOrdre(int i){
		this.ordre = i;
	}
}