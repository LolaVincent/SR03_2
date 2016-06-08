<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Suppression d'un compte</title>
</head>
<body>
	<form  method="post" action="SuppressionCompte">
		<label for="mail">Entrer le mail du compte que vous voulez supprimer : </label>
		<input type="text" name="mail" id="mail" ></input>
        <input type="submit" value ="envoyer"/>
    </form>
</body>
</html>