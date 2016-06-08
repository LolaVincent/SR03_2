<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des questionnaires</title>
</head>
<body>
	<table>
	    <tr>
	        <th>Sujet</th>
	        <th>Action</th>                    
	    </tr>
	    <c:forEach items="${ mapQuestionnaires }" var="questionnaire">
		    <tr>
		        <td>
		        	<c:out value="${ questionnaire.value.sujet }"/>
		        </td>
		        <td>
		            <a href="<c:url value="/FaireQuestionnaire"><c:param name="idQuestionnaire" value="${ questionnaire.key }" /></c:url>">
		                Commencer
		            </a>
		        </td>
		    </tr>
	    </c:forEach>
	</table>
	<a href="<c:url value="/admin"></c:url>">Retour à l'accueil</a>
</body>
</html>