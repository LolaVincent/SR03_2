<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des annonces</title>
</head>
<body>
<table>
	<tr>
		<td> Annonce </td>
		<td> Action </td>
	</tr>
	<c:forEach items="${annonces}" var="annonce">
		<tr>
			<td>${annonce.nom}</td>
		
			<td><a href="<c:url value="/VoirAnnonce"><c:param name="annonce_nom" value="${ annonce.nom}" /></c:url>">
		                Voir
		         </a><br>
			<a href="<c:url value="/SuppressionAnnonce"><c:param name="annonce_nom" value="${ annonce.nom }" /></c:url>">
		                Supprimer
		         </a><br>
		         <a href="<c:url value="/ModificationAnnonce"><c:param name="annonce_nom" value="${ annonce.nom }" /></c:url>">
		                Modifier
		         </a>
		     </td>
		</tr>
		         
	</c:forEach>
		
</table>
<a href="<c:url value="/admin"></c:url>">Retour à l'accueil</a>
</body>
</html>