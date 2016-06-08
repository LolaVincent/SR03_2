<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modification d'un questionnaire</title>
</head>
<body>
	<form  method="post" action="ModificationQuestionnaire2">
			<input type="hidden" name ="id" value="${id}">
			<label for="questionnaire"> Questionnaire :</label>
			<input type="text" name="questionnaire" id="questionnaire" value="${titre }"></input><br>
		<c:forEach items="${mapReponses}" var="question">
			<label for="question">Question : </label>
			<input type="text" name="question${question.key.id}" id="question" value="${question.key.question}"></input><br>
			<label for="reponse1">Reponse 1 : </label>
			<input type="text" name="reponse${question.value.get(0).id}" value="${question.value.get(0).possibilite}"></input><br>
			Ordre: <input type="number" name="number${question.value.get(0).id}" value="${question.value.get(0).ordre}" min="1" max="4"><br>
			<label for="reponse2">Reponse 2 : </label>
			<input type="text" name="reponse${question.value.get(1).id}" value="${question.value.get(1).possibilite}"></input><br>
			Ordre: <input type="number" name="number${question.value.get(1).id}" value="${question.value.get(1).ordre}" min="1" max="4"><br>
			<label for="reponse3">Reponse 3 : </label>
			<input type="text" name="reponse${question.value.get(2).id}" value="${question.value.get(2).possibilite}"></input><br>
			Ordre: <input type="number" name="number${question.value.get(2).id}" value="${question.value.get(2).ordre}" min="1" max="4"><br>
			<label for="reponse4">Reponse 4 : </label>
			<input type="text" name="reponse${question.value.get(3).id}" value="${question.value.get(3).possibilite}"></input><br>
			Ordre: <input type="number" name="number${question.value.get(3).id}" value="${question.value.get(3).ordre}" min="1" max="4"><br>
			<label for="bonneReponse${question.key.id}">Bonne réponse :</label>
			<select name="bonneReponse${question.key.id}" id="bonneReponse">
				<c:choose>
					<c:when test="${ question.value.get(0).bonneReponse == 1 }"><option value="${ question.value.get(0).id}" selected>Réponse 1</option></c:when>
					<c:otherwise><option value="${ question.value.get(0).id}">Réponse 1</option></c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${ question.value.get(1).bonneReponse == 1 }"><option value="${ question.value.get(1).id}" selected>Réponse 2</option></c:when>
					<c:otherwise><option value="${ question.value.get(1).id}">Réponse 2</option></c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${ question.value.get(2).bonneReponse == 1 }"><option value="${ question.value.get(2).id}" selected>Réponse 3</option></c:when>
					<c:otherwise><option value="${ question.value.get(2).id}">Réponse 3</option></c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${ question.value.get(3).bonneReponse == 1 }"><option value="${ question.value.get(3).id}" selected>Réponse 4</option></c:when>
					<c:otherwise><option value="${question.value.get(3).id}">Réponse 4</option></c:otherwise>
				</c:choose>
			</select><br>
		</c:forEach>
        <input type="submit" value ="envoyer"/>
    </form>
</body>
</html>