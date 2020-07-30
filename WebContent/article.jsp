<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page enchère</title>
</head>
<body>

	<h1>Détail vente</h1>
	
	${article.nomArticle } <br>
	
	Description : ${article.description } <br>
	
	Catégorie : ${article.categorie.libelle } <br>
	
	Meilleur offre : <br>
	
	Mise à prix : ${article.miseAPrix } <br>
	
	Début de l'enchère : ${article.dateDebutEncheres } <br>
	
	Fin de l'enchère : ${article.dateFinEncheres } <br>
	
	Retrait : ${article.utilisateur.rue } ${article.utilisateur.codePostal } ${article.utilisateur.ville } <br>
	
	Vendeur : ${article.utilisateur.pseudo } <br>
	
	<br>
	
	<c:set var="dateDuJour" value="<%=new java.util.Date()%>"/>
	
	<c:choose>
		
		<c:when test="${sessionScope.sessionUtilisateur.noUtilisateur == article.utilisateur.noUtilisateur }">
			
			<c:if test="${dateDuJour lt article.dateDebutEncheres}">
			
				<a><button>Modifier la vente</button></a>
			
			</c:if>
	
		</c:when>
		<c:otherwise>
		
			<c:choose>
				<c:when test="${dateDuJour lt article.dateDebutEncheres}">
					
					<h3>Les enchères pour cet article n'ont pas débutées</h3>
				
				</c:when>
				<c:otherwise>
				
					Ma proposition : <br>
				
					<br>
			
					<form action="<%=request.getContextPath()%>/encheres" method="post">
			
						<input id="noArticle" name="noArticle" type="hidden" value="${article.noArticle }">
			
						<input class="form-control" required="required" type="number" name="proposition" id="proposition" autocomplete="off" step="10" value="${article.miseAPrix + 10 }" min="${article.miseAPrix + 10 }" max = "1000"/>
	
						<button type="submit">Enchérir</button>
			
					</form>
				
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
	
	<p style="color: green;"> ${message } </p>


</body>
</html>