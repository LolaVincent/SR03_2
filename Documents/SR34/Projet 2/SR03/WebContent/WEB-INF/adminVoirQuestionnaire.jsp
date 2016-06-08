<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Voir Questionnaires</title>
</head>
<body>
	<h1>Questionnaire : <c:out value="${titre}"/></h1>
	<table>
		<tr>
			<td>Question</td>
			<td>Reponses</td>
			<td>Bonne réponse</td>
		</tr>
			<c:forEach items="${mapQuestions}" var="question"><br>
			<tr>
				<td><c:out value="${question.key.question}"/><br>
				<a href="<c:url value="/SuppressionQuestion"><c:param name="idQuestion" value="${ question.key.id }" /></c:url>">
		                Supprimer
		         </a><br>
				</td>
				<td>
					<c:out value="${question.value.get(0).possibilite}"/><br>
					<c:out value="${question.value.get(1).possibilite}"/><br>
					<c:out value="${question.value.get(2).possibilite}"/><br>
					<c:out value="${question.value.get(3).possibilite}"/><br>
				</td>
				<td>
					<c:out value="${question.value.get(0).bonneReponse}"/><br>
					<c:out value="${question.value.get(1).bonneReponse}"/><br>
					<c:out value="${question.value.get(2).bonneReponse}"/><br>
					<c:out value="${question.value.get(3).bonneReponse}"/><br>
				</td>
			</tr>
			</c:forEach>
	</table>
	<br>
    <a href="<c:url value="/AjoutQuestion"><c:param name="questionnaire" value="${ titre }" /></c:url>">
           Ajouter une question
    </a><br>
	<a href="<c:url value="/admin"></c:url>">Retour à l'accueil</a>
</body>
</html>