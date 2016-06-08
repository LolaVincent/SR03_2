<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil Client Administrateur</title>
</head>
<body>
		<a href="<c:url value="/CreationAnnonce"/>">Créer une annonce</a>
		<br>
		<a href="<c:url value="/ListeAnnonce"/>">Liste des annonces</a>
		<br>
		<a href="<c:url value="/CreationCategorie"/>">Créer une catégorie</a>
		<br>
		<a href="<c:url value="/ListeCategorie"/>">Liste des categories</a>
		<br>
</body>
</html>