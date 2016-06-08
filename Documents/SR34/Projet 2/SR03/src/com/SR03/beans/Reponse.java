package com.SR03.beans;

public class Reponse {

	private Long id;
	private String possiblite;
	private Question question;
	private int score;
	
	public void setId( Long id ) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
	
	public void setPossiblite( String possiblite ) {
        this.possiblite = possiblite;
    }

    public String getPossiblite() {
        return possiblite;
    }
	
	public void setQuestion( Question question ) {
        this.question = question;
    }
	
	public Question getQuestion() {
        return question;
    }
	
	public void setScore( int score ) {
        this.score = score;
    }
	
	public int getScore() {
        return score;
    }
	
}