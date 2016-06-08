<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.SR03.beans.Questionnaire" %>
<%@ page import="com.SR03.dao.QuestionnaireDaoImpl" %>
<%@ page import="com.SR03.beans.Question" %>
<%@ page import="com.SR03.dao.QuestionDaoImpl" %>
<%@ page import="com.SR03.beans.Possibilite" %>
<%@ page import="com.SR03.dao.PossibiliteDaoImpl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des questionnaires</title>
</head>
<body>
<table>
	<tr>
		<td> Questionnaire </td>
		<td> Action </td>
	</tr>
	<c:forEach items="${questionnaires}" var="questionnaire">
		<tr>
			<td>${questionnaire.sujet}</td>
		
			<td><a href="<c:url value="/VoirQuestionnaire"><c:param name="idQuestionnaire" value="${ questionnaire.id }" /></c:url>">
		                Voir
		         </a><br>
			<a href="<c:url value="/SuppressionQuestionnaire"><c:param name="idQuestionnaire" value="${ questionnaire.id }" /></c:url>">
		                Supprimer
		         </a><br>
		         <a href="<c:url value="/ModificationQuestionnaire2"><c:param name="idQuestionnaire" value="${ questionnaire.id }" /></c:url>">
		                Modifier
		         </a>
		     </td>
		</tr>
		         
	</c:forEach>
		
</table>
<a href="<c:url value="/admin"></c:url>">Retour à l'accueil</a>
</body>
</html>