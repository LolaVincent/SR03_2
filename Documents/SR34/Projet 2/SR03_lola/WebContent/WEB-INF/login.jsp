<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Identification</title>
</head>
<body>
	<c:if test="${ !empty sessionScope.identifiant && !empty sessionScope.mot_passe }">
        <p>Vous êtes ${ sessionScope.identifiant }!</p>
    </c:if>
	<form  method="post" action="login_form">
		<label for="identifiant">Identifiant : </label>
		<input type="text" name="identifiant" id="identifiant" ></input>
		<label for="mot_passe">Mot de passe : </label>
		<input type="text" name="mot_passe" id="mot_passe"></input>
        <input type="submit" value ="envoyer"/>
    </form>
</body>
</html>