package com.SR03.beans;

//import org.joda.time.DateTime;

public class Utilisateur {

	private long id;
    private String type;
    private String adresse;
    private String mdp;
    private String nom;
    private String societe;
	private String telephone;
	private String statut;
	//private DateTime date;
	private String date;
	
	public void setId( long identifiant ) {
        this.id = identifiant;
    }

    public long getId() {
        return id;
    }
	
    public void setType( String type ) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setAdresse( String adresse ) {
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setMdp( String mdp ) {
        this.mdp = mdp;
    }

    public String getMdp() {
        return mdp;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }
    
	public String getNom() {
        return nom;
    }

    public void setSociete( String societe ) {
        this.societe = societe;
    }

    public String getSociete() {
        return societe;
    }
	
	public void setTelephone( String telephone ) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setStatut( String statut ) {
        this.statut = statut;
    }
    
	public String getStatut() {
        return statut;
    }

    public void setDate( String date ) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
    //public void setDate( DateTime date ) {
    //    this.date = date;
    //}

    //public Datetime getDate() {
    //    return date;
    //}
}