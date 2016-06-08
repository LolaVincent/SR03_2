<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Résultats</title>
</head>
<body>
	<table>
	    <tr>
	        <th>Questionnaire</th>
	        <th>Score</th>    
	        <th>Durée</th>                
	    </tr>
	    <c:forEach items="${ mapParcours }" var="parcours">
		    <tr>
		        <td>
		        	<c:out value="${ parcours.value.questionnaire.getSujet() }"/>
		        </td>
		        <td>
		            <c:out value="${ parcours.value.score }"/>
		        </td>
		        <td>
		            <c:out value="${ parcours.value.duree }"/>
		        </td>
		    </tr>
	    </c:forEach>
	</table>
	<a href="<c:url value="/admin"></c:url>">Retour à l'accueil</a>
</body>
</html>