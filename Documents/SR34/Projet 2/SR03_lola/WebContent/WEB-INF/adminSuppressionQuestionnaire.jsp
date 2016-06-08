<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Suppression Questionnaire</title>
</head>
<body>
	<form  method="post" action="SuppressionQuestionnaire">
		<label for="sujet">Entrer le sujet du questionnaire que vous voulez supprimer : </label>
		<input type="text" name="sujet" id="sujet" ></input>
        <input type="submit" value ="envoyer"/>
    </form>
</body>
</html>