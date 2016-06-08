package com.SR03.beans;

import java.util.List;
import java.util.ArrayList;

public class Questionnaire {

	private Long id;
	private String sujet;
	private String statut;
	
	public void setId( Long id ) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
	
    public void setSujet( String sujet ) {
        this.sujet = sujet;
    }
	
	public String getSujet() {
        return sujet;
    }
	
	public void setStatut( String statut ) {
        this.statut = statut;
    }
	
	public String getStatut() {
        return statut;
    }
}