package com.SR03.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SR03.beans.Possibilite;
import com.SR03.beans.Question;
import com.SR03.beans.Questionnaire;
import com.SR03.beans.Utilisateur;
import com.SR03.dao.DAOFactory;
import com.SR03.dao.PossibiliteDaoImpl;
import com.SR03.dao.QuestionDaoImpl;
import com.SR03.dao.QuestionnaireDaoImpl;
import com.SR03.dao.UtilisateurDaoImpl;
import com.sun.mail.smtp.SMTPMessage;

public class CreationControleur {
	public static Boolean isUserValid(String mail, String mdp, String activite) {
		try {
			validationEmail(mail);
			validationMotsDePasse(mdp);
		} catch (Exception e) {
			return false;
		}
	    if(!isMailUsed(mail)) {
	    	return true;
	    }
	    return false;
	}
	
	public static HttpServletResponse creerCompte(String mail,String mot_passe,String nom,String societe,String telephone,String type,String activite,HttpServletResponse response) throws IOException {
		Utilisateur user = new Utilisateur();
		user.setAdresse(mail);
		user.setMdp(mot_passe);
		user.setNom(nom);
		user.setSociete(societe);
		user.setTelephone(telephone);
		user.setStatut(activite);
		user.setType(type);
		          
	       String host = "localhost";
           Properties properties = System.getProperties();
           properties.put("mail.smtp.host", "smtp.gmail.com");
           properties.put("mail.smtp.auth", "true");
           properties.put("mail.smtp.socketFactory.port", "465");
           properties.put("mail.smtp.port", "805");
           properties. put("mail.smtp.socketFactory.class",
                   "javax.net.ssl.SSLSocketFactory");
           Session session2 = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
               @Override protected PasswordAuthentication getPasswordAuthentication() {
                   return new PasswordAuthentication("projetsr03@gmail.com","marwencharlottejordan");
              }});
           response.setContentType("text/html");
           PrintWriter out = response.getWriter();
           try{
                // Create a default MimeMessage object.
                SMTPMessage message = new SMTPMessage(session2);
                // Set From: header field of the header.
                message.setFrom(new InternetAddress("projetsr03@gmail.com"));
                // Set To: header field of the header.
                message.addRecipient(Message.RecipientType.TO,
                                         new InternetAddress(mail));
                // Set Subject: header field
                message.setSubject("Creation de compte SR03");
                // Now set the actual message
                message.setText("Voici vos identifiant: mail: "+mail+"\n mdp: "+mot_passe);
                // Send message
                Transport.send(message);

               /* Transport tr = session2.getTransport("smtp");
                tr.connect(host, "", "");
                message.saveChanges();
                 
                tr.sendMessage(message,message.getAllRecipients());
                tr.close();*/


             }catch (Exception mex) {
                mex.printStackTrace();
             }
		     DAOFactory factory = DAOFactory.getInstance();
		     
		     UtilisateurDaoImpl DaoUser = (UtilisateurDaoImpl) factory.getUtilisateurDao();
		     DaoUser.creer(user);
		     return response;
	}
	
	public static void validationEmail( String email ) throws Exception {
	    if ( email != null ) {
	        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new Exception( "Merci de saisir une adresse mail valide." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir une adresse mail." );
	    }
	}

	public static void validationMotsDePasse( String motDePasse) throws Exception {
	    if ( motDePasse != null) {
	        if ( motDePasse.length() < 6 ) {
	            throw new Exception( "Les mots de passe doivent contenir au moins 6 caractères." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
	    }
	}
	
	public static Boolean isMailUsed(String mail) {
	     try {
	    	 DAOFactory factory = DAOFactory.getInstance();
	    	 UtilisateurDaoImpl DaoUser = (UtilisateurDaoImpl) factory.getUtilisateurDao();
		     Utilisateur utilisateur = DaoUser.trouverAdresse(mail);
		     System.out.println(utilisateur.getAdresse());
	     }  catch (Exception e) {
	    	 return false;
	     }
	     return true;		
	}
	
	public static void creerQuestion(String titre,String question,String reponse1,String reponse2,String reponse3,String reponse4,String bonneReponse,HttpServletRequest request){
		DAOFactory factory = DAOFactory.getInstance();
		QuestionnaireDaoImpl DaoQuestionnaire = (QuestionnaireDaoImpl) factory.getQuestionnaireDao();
		QuestionDaoImpl DaoQuestion = (QuestionDaoImpl) factory.getQuestionDao();
		PossibiliteDaoImpl DaoPossibilite = (PossibiliteDaoImpl) factory.getPossibiliteDao();
		
		Questionnaire questionnaire = DaoQuestionnaire.trouverSujet(titre);
		
		Question newQuestion = new Question();
	    newQuestion.setQuestion(question);
	    newQuestion.setQuestionnaire(questionnaire);
	    List<Question> questions = DaoQuestion.listerQuestion(questionnaire.getId());
	    newQuestion.setOrdre(questions.size()+1);
	    System.out.println(newQuestion.getOrdre());
	    DaoQuestion.creer(newQuestion);
	    
	    Question questionBD = DaoQuestion.trouverQuestion(question);
	    
	    Possibilite possibilite1 = new Possibilite();
	    possibilite1.setPossibilite(reponse1);
	    possibilite1.setQuestion(questionBD);
	    possibilite1.setOrdre(Integer.parseInt(request.getParameter("reponse1number"))); 
	    if (bonneReponse.equals("reponse1")){
	    	possibilite1.setBonneReponse("1");
	    } else {
	    	possibilite1.setBonneReponse("0");
	    }
	    DaoPossibilite.creer(possibilite1);
	    
	    Possibilite possibilite2 = new Possibilite();
	    possibilite2.setPossibilite(reponse2);
	    possibilite2.setQuestion(questionBD);
	    possibilite2.setOrdre(Integer.parseInt(request.getParameter("reponse2number"))); 
	    if (bonneReponse.equals("reponse2")){
	    	possibilite2.setBonneReponse("1");
	    	System.out.print("çamarche");
	    } else {
	    	possibilite2.setBonneReponse("0");
	    }
	    DaoPossibilite.creer(possibilite2);
	    
	    Possibilite possibilite3 = new Possibilite();
	    possibilite3.setPossibilite(reponse3);
	    possibilite3.setQuestion(questionBD);
	    possibilite3.setOrdre(Integer.parseInt(request.getParameter("reponse3number"))); 
	    if (bonneReponse.equals("reponse3")){
	    	possibilite3.setBonneReponse("1");
	    } else {
	    	possibilite3.setBonneReponse("0");
	    }
	    DaoPossibilite.creer(possibilite3);
	    
	    Possibilite possibilite4 = new Possibilite();
	    possibilite4.setPossibilite(reponse4);
	    possibilite4.setQuestion(questionBD);
	    possibilite4.setOrdre(Integer.parseInt(request.getParameter("reponse4number"))); 
	    if (bonneReponse.equals("reponse4")){
	    	possibilite4.setBonneReponse("1");
	    } else {
	    	possibilite4.setBonneReponse("0");
	    }
	    DaoPossibilite.creer(possibilite4);
	}
	
	public static void creerQuestionnaire(String titre){
		DAOFactory factory = DAOFactory.getInstance();
	    QuestionnaireDaoImpl DaoQuestionnaire = (QuestionnaireDaoImpl) factory.getQuestionnaireDao();
	    Questionnaire questionnaire = new Questionnaire();
	    questionnaire.setSujet(titre);
	    DaoQuestionnaire.creer(questionnaire);
	}
}
