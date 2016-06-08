<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modification d'un questionnaire</title>
</head>
<body>
	<form  method="post" action="ModificationQuestionnaire2">
		<label for="titre">Titre : </label>
		<input type="text" name="titre" id="titre" value="${sujet}" ></input>
		<br>
		<br>
		<label for="question 1"><br>Question 1 : </label>
		<input type="text" name="question1" id="question1" value="${question1}"></input>
			<label for="reponse11"><br> &nbsp; Réponse 1 :</label>
			<input type="text" name="reponse11" id="reponse11" value="${possibilite11}"></input>
			<label for="reponse12"><br> &nbsp; Réponse 2 :</label>
			<input type="text" name="reponse12" id="reponse12" value="${possibilite12}"></input>
			<label for="reponse13"><br> &nbsp; Réponse 3 :</label>
			<input type="text" name="reponse13" id="reponse13" value="${possibilite13}"></input>
			<label for="reponse14"><br> &nbsp; Réponse 4 :</label>
			<input type="text" name="reponse14" id="reponse14" value="${possibilite14}"></input>
			<label for="bonneReponse1"><br> &nbsp; Veuillez sélectionner la bonne réponse :</label>
			<select name="bonneReponse1" id="bonneReponse1">
				<option value="reponse11">Réponse 1</option>
				<option value="reponse12">Réponse 2</option>
				<option value="reponse13">Réponse 3</option>
				<option value="reponse14">Réponse 4</option>
			</select>
		<br>
		<label for="question 2"><br>Question 2 : </label>
		<input type="text" name="question2" id="question2" value="${question2}"></input>
			<label for="reponse21"><br> &nbsp; Réponse 1 :</label>
			<input type="text" name="reponse21" id="reponse21" value="${possibilite21 }"></input>
			<label for="reponse22"><br> &nbsp; Réponse 2 :</label>
			<input type="text" name="reponse22" id="reponse22" value="${possibilite22 }"></input>
			<label for="reponse23"><br> &nbsp; Réponse 3 :</label>
			<input type="text" name="reponse23" id="reponse23" value="${possibilite23 }"></input>
			<label for="reponse24"><br> &nbsp; Réponse 4 :</label>
			<input type="text" name="reponse24" id="reponse24" value="${possibilite24 }"></input>
			<label for="bonneReponse2"><br> &nbsp; Veuillez sélectionner la bonne réponse :</label>
			<select name="bonneReponse2" id="bonneReponse2">
				<option value="reponse21">Réponse 1</option>
				<option value="reponse22">Réponse 2</option>
				<option value="reponse23">Réponse 3</option>
				<option value="reponse24">Réponse 4</option>
			</select>
		<br>
		<label for="question 3"><br>Question 3 : </label>
		<input type="text" name="question3" id="question3" value="${question3}"></input>
			<label for="reponse31"><br> &nbsp; Réponse 1 :</label>
			<input type="text" name="reponse31" id="reponse31" value="${possibilite31 }"></input>
			<label for="reponse32"><br> &nbsp; Réponse 2 :</label>
			<input type="text" name="reponse32" id="reponse32" value="${possibilite32 }"></input>
			<label for="reponse33"><br> &nbsp; Réponse 3 :</label>
			<input type="text" name="reponse33" id="reponse33" value="${possibilite33 }"></input>
			<label for="reponse34"><br> &nbsp; Réponse 4 :</label>
			<input type="text" name="reponse34" id="reponse34" value="${possibilite34 }"></input>
			<label for="bonneReponse3"><br> &nbsp; Veuillez sélectionner la bonne réponse :</label>
			<select name="bonneReponse3" id="bonneReponse3">
				<option value="reponse31">Réponse 1</option>
				<option value="reponse32">Réponse 2</option>
				<option value="reponse33">Réponse 3</option>
				<option value="reponse34">Réponse 4</option>
			</select>
		<br>
		<label for="question 4"><br>Question 4 : </label>
		<input type="text" name="question4" id="question4" value="${question4}"></input>
			<label for="reponse41"><br> &nbsp; Réponse 1 :</label>
			<input type="text" name="reponse41" id="reponse41" value="${possibilite41}"></input>
			<label for="reponse42"><br> &nbsp; Réponse 2 :</label>
			<input type="text" name="reponse42" id="reponse42" value="${possibilite42}"></input>
			<label for="reponse43"><br> &nbsp; Réponse 3 :</label>
			<input type="text" name="reponse43" id="reponse43" value="${possibilite43}"></input>
			<label for="reponse44"><br> &nbsp; Réponse 4 :</label>
			<input type="text" name="reponse44" id="reponse44" value="${possibilite44}"></input>
			<label for="bonneReponse4"><br> &nbsp; Veuillez sélectionner la bonne réponse :</label>
			<select name="bonneReponse4" id="bonneReponse4">
				<option value="reponse41">Réponse 1</option>
				<option value="reponse42">Réponse 2</option>
				<option value="reponse43">Réponse 3</option>
				<option value="reponse44">Réponse 4</option>
			</select>
		<br>
		<br>
        <input type="submit" value ="envoyer"/>
    </form>
</body>
</html>