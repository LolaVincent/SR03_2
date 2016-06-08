<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modification d'une annonce</title>
</head>
<body>
<form  method="post" action="ModificationAnnonce2">
		<label for="nom">Nom : </label>
		<input type="text" name="nom" id="nom" value="${ annonce.nom }"></input>
		<label for="adresse"><br>Adresse : </label>
		<input type="text" name="adresse" id="adresse" value="${ annonce.adresse }"></input>
		<label for="numero"><br>Téléphone :</label>
		<input type="text" name="numero" id="numero" value="${ annonce.numero }"></input>
		<br>
		<select name="categorie" id="categorie">
			<c:forEach items="${ categories }" var="categorie">
				<option value="${ categorie.getSujet() }">${categorie.getSujet() }</option>
			</c:forEach>
		</select>
		<br>
        <input type="submit" value ="envoyer"/>
    </form>
    <a href="<c:url value="/admin"/>">Retour à l'accueil</a>
</body>
</html>