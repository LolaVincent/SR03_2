<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modification d'un compte</title>
</head>
<body>
	<form  method="post" action="ModificationCompte">
		<label for="mail">Mail : </label>
		<input type="text" name="mail" id="mail" ></input>
		<label for="mot_passe"><br>Mot de passe : </label>
		<input type="text" name="mot_passe" id="mot_passe"></input>
		<br>
        <input type="submit" value ="envoyer"/>
	</form>
</body>
</html>