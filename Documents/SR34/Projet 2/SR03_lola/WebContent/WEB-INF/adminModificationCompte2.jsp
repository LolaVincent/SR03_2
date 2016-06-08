<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modification Compte</title>
</head>
<body>
	<form  method="post" action="ModificationCompte2">
		<label for="mail">Mail : </label>
		<input type="text" name="mail" id="mail" value="${mail}"></input>
		<label for="mot_passe"><br>Mot de passe : </label>
		<input type="text" name="mot_passe" id="mot_passe" value="${mot_passe}"></input>
		<label for="nom"><br>Nom :</label>
		<input type="text" name="nom" id="nom" value="${nom}"></input>
		<label for="societe"><br>Société :</label>
		<input type="text" name="societe" id="societe" value="${societe}"></input>
		<label for="telephone"><br>Téléphone :</label>
		<input type="text" name="telephone" id="telephone" value="${telephone}"></input>
		<label for="type"><br>Type :</label>
		<select name="type" id="type">
			<option value="admin">Administrateur</option>
			<option value="stagiaire">Stagiaire</option>
		</select>
		<label for="statut"><br>Statut :</label>
		<select name="statut" id="statut">
			<option value="A">Actif</option>
			<option value="I">Inactif</option>
		</select>
		<br>
        <input type="submit" value ="envoyer"/>
	</form>
</body>
</html>