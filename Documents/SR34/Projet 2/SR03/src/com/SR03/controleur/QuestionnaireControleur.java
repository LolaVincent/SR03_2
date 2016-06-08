package com.SR03.controleur;

import com.SR03.beans.Possibilite;
import com.SR03.beans.Question;
import com.SR03.beans.Questionnaire;
import com.SR03.dao.DAOFactory;
import com.SR03.dao.PossibiliteDaoImpl;
import com.SR03.dao.QuestionDaoImpl;
import com.SR03.dao.QuestionnaireDaoImpl;

public class QuestionnaireControleur {

	public static void creerQuestionnaire(String titre,String question, String reponse1, String reponse2, 
		String reponse3, String reponse4, String bonneReponse) {
		bonneReponse = bonneReponse.substring(8);
		System.out.println(bonneReponse);
		DAOFactory factory = DAOFactory.getInstance();
	    QuestionnaireDaoImpl DaoQuestionnaire = (QuestionnaireDaoImpl) factory.getQuestionnaireDao();
	    
	    Questionnaire questionnaireFK = DaoQuestionnaire.trouverSujet(titre);
	    
	    QuestionDaoImpl DaoQuestion = (QuestionDaoImpl) factory.getQuestionDao();
	    Question premiereQuestion = new Question();
	    premiereQuestion.setQuestion(question);
	    premiereQuestion.setQuestionnaire(questionnaireFK);
	    DaoQuestion.creer(premiereQuestion);
	    
	    Question questionFK = DaoQuestion.trouverQuestion(question);
	    
	    PossibiliteDaoImpl DaoPossibilite = (PossibiliteDaoImpl) factory.getPossibiliteDao();
	    
	    Possibilite possibilitea = new Possibilite();
	    possibilitea.setPossibilite(reponse1);
	    possibilitea.setQuestion(questionFK);
	    if (bonneReponse.equals("1")) {
	    	possibilitea.setBonneReponse("1");
	    } else {possibilitea.setBonneReponse("0");}
	    DaoPossibilite.creer(possibilitea);
	    
	    Possibilite possibiliteb = new Possibilite();
	    possibiliteb.setPossibilite(reponse2);
	    possibiliteb.setQuestion(questionFK);
	    if (bonneReponse.equals("2")) {
	    	possibiliteb.setBonneReponse("1");
	    } else {possibiliteb.setBonneReponse("0");}
	    DaoPossibilite.creer(possibiliteb);
	    
	    Possibilite possibilitec = new Possibilite();
	    possibilitec.setPossibilite(reponse3);
	    possibilitec.setQuestion(questionFK);
	    if (bonneReponse.equals("3")) {
	    	possibilitec.setBonneReponse("1");
	    } else {possibilitec.setBonneReponse("0");}
	    DaoPossibilite.creer(possibilitec);
	    
	    Possibilite possibilited = new Possibilite();
	    possibilited.setPossibilite(reponse4);
	    possibilited.setQuestion(questionFK);
	    if (bonneReponse.equals("4")) {
	    	possibilited.setBonneReponse("1");
	    } else {possibilited.setBonneReponse("0");}
	    DaoPossibilite.creer(possibilited);
	}

}
