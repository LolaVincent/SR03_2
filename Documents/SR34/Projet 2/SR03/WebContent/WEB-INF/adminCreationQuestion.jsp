<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Creation Question</title>
</head>
<body>
	<form  method="post" action="CreationQuestion">
		<input type="hidden" name ="titre" value="${titre}"></input>
		<label for="question"><br>Question: </label>
		<input type="text" name="question" id="question"></input>
			<label for="reponse1"><br> &nbsp; Réponse 1 :</label>
			<input type="text" name="reponse1" id="reponse1"></input>
			<input type="number" name="reponse1number"></input>
			<label for="reponse2"><br> &nbsp; Réponse 2 :</label>
			<input type="text" name="reponse2" id="reponse2"></input>
			<input type="number" name="reponse2number"></input>
			<label for="reponse3"><br> &nbsp; Réponse 3 :</label>
			<input type="text" name="reponse3" id="reponse3"></input>
			<input type="number" name="reponse3number"></input>
			<label for="reponse4"><br> &nbsp; Réponse 4 :</label>
			<input type="text" name="reponse4" id="reponse4"></input>
			<input type="number" name="reponse4number"></input>
			<label for="bonneReponse"><br> &nbsp; Veuillez sélectionner la bonne réponse :</label>
			<select name="bonneReponse" id="bonneReponse">
				<option value="reponse1">Réponse 1</option>
				<option value="reponse2">Réponse 2</option>
				<option value="reponse3">Réponse 3</option>
				<option value="reponse4">Réponse 4</option>
			</select>
			<input type="submit" value="Question Suivante"></input>
	</form>
	<form action="admin" method="get">
    	<input type="submit" value="Fin"/>
	</form>
</body>
</html>