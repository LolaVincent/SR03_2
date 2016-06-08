<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<a href="<c:url value="/CreationCompte"/>">Creation compte</a>
		<br>
		<a href="<c:url value="/ModificationCompte"/>">Modification compte</a>
		<br>
		<a href="<c:url value="/ListeCompte"/>">Liste des comptes</a>
		<br>
		<a href="<c:url value="/SuppressionCompte"/>">Suppression compte</a>
		<br>
		<a href="<c:url value="/CreationQuestionnaire"/>">Création d'un questionnaire</a>
		<br>
		<a href="<c:url value="/ModificationQuestionnaire"/>">Modification d'un questionnaire</a>
		<br>
		<a href="<c:url value="/SuppressionQuestionnaire"/>">Suppression d'un questionnaire</a>
		<br>
		<a href="<c:url value="/ListeQuestionnaire"/>">Liste des questionnaires</a>
		<br>
</body>
</html>