<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.SR03.beans.Questionnaire" %>
<%@ page import="com.SR03.dao.QuestionnaireDaoImpl" %>
<%@ page import="com.SR03.beans.Question" %>
<%@ page import="com.SR03.dao.QuestionDaoImpl" %>
<%@ page import="com.SR03.beans.Possibilite" %>
<%@ page import="com.SR03.dao.PossibiliteDaoImpl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des possibilites</title>
</head>
<body>
<table border=6 cellspacing=12 cellpadding=20>
	<tr><td> Possibilite </td></tr>
	<c:forEach items="${possibilites}" var="possibilite">
		<tr>
			<td>${possibilite.possibilite}</td>
		</tr>
	</c:forEach>
		
</table>
</body>
</html>