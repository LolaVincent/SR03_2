<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Score</title>
</head>
<body>
	<h1>Questionnaire <c:out value="${ sujet }"/></h1>
	<p>Votre score est de <c:out value="${ score }"/></p>
	<a href="<c:url value="/stagiaire"/>">Retour à l'accueil</a>
</body>
</html>