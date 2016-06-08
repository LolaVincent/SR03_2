<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Parcours</title>
</head>
<body>
	<h1>Utilisateur ${ utilisateur }</h1>
	<table>
	<tr>
		<td> Questionnaire </td>
		<td> Score </td>
		<td> Duree </td>
	</tr>
	<c:forEach items="${parcours}" var="parcour">
		<tr>
			<td>${parcour.questionnaire.getSujet()}</td>
			<td>${parcour.score}</td>
			<td>${parcour.duree}</td>
		</tr>
	</c:forEach>
</table>
<a href="<c:url value="/admin"></c:url>">Retour à l'accueil</a>

</body>
</html>