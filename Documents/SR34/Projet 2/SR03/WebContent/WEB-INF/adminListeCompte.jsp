<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.SR03.beans.Utilisateur" %>
<%@ page import="com.SR03.dao.UtilisateurDaoImpl" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des comptes</title>
</head>
<body>

<display:table id="user" name="users" pagesize="2" requestURI="ListeCompte">
				<display:column property="adresse" title="Email"	/>
				<display:column property="nom" title="Nom"  />
				<display:column property="societe" title="Societe"  />
				<display:column property="telephone" title="Telephone"	/>
				<display:column property="type" title="Type"  />
				<display:column property="statut" title="Statut"  />
				 <display:column title="Supprimer">
	        		<a href="<c:url value="/SuppressionCompte"><c:param name="idUser" value="${ user.getId() }" /></c:url>">
		                Supprimer
		         </a>       				
				 </display:column>	
				 <display:column title="Modifier">
		         <a href="<c:url value="/ModificationCompte2"><c:param name="idUser" value="${ user.id }" /></c:url>">
		                Modifier
		         </a>
		         </display:column>	
		         <display:column title="Resultats">
		         <a href="<c:url value="/VoirParcours"><c:param name="idUser" value="${ user.id }" /></c:url>">
		                Résultats
		         </a> 
		         </display:column>	
</display:table>
<a href="<c:url value="/admin"></c:url>">Retour à l'accueil</a>
</body>
</html>
