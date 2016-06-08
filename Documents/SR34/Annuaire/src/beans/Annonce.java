package beans;

import beans.*;

import java.util.List;
import java.util.ArrayList;

public class Annonce {

	private int id;
	private Categorie categorie;
	private String nom;
	private String adresse;
	private String numero;
	
	public void setId( int id ) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
	
    public void setCategorie( Categorie categorie ) {
        this.categorie = categorie;
    }
	
	public Categorie getCategorie() {
        return categorie;
    }
	
	public void setNom( String nom ) {
        this.nom = nom;
    }
	
	public String getNom() {
        return nom;
    }
	
	public void setAdresse( String adresse ) {
        this.adresse = adresse;
    }
	
	public String getAdresse() {
        return adresse;
    }
	
	public void setNumero(String numero ) {
        this.numero = numero;
    }
	
	public String getNumero() {
        return numero;
    }
}