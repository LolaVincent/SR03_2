<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.SR03.beans.Utilisateur" %>
<%@ page import="com.SR03.dao.UtilisateurDaoImpl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des comptes</title>
</head>
<body>
<table border=6 cellspacing=12 cellpadding=20>
	<tr><td> Mail </td><td> Nom </td><td> Societe </td><td> Téléphone </td><td> Type </td> <td> Statut </td></tr>
	<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.adresse}</td>
			<td>${user.nom}</td>
			<td>${user.societe}</td>
			<td>${user.telephone}</td>
			<td>${user.type}</td>
			<td>${user.statut}</td>
		</tr>
	</c:forEach>
		
</table>
</body>
</html>
