package beans;

import beans.*;

import java.util.List;
import java.util.ArrayList;

public class Categorie {

	private int id;
	private String sujet;	
	
	public void setId( int i ) {
        this.id = i;
    }

    public int getId() {
        return id;
    }
		
	public void setSujet( String sujet ) {
        this.sujet= sujet;
    }
	
	public String getSujet() {
        return sujet;
    }
	
}