<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>

	<h1> ${message } </h1>

	<h2>Liste des encheres</h2>

	<c:choose>
		<c:when test="${!empty sessionScope.sessionUtilisateur}">
			<nav>
				<ul>
					<li><a href="<%=request.getContextPath()%>/gestionArticles">Encheres</a></li>
					<li><a href="<%=request.getContextPath()%>/creationVente.jsp">Vendre un article</a></li>
					<li><a href="<%=request.getContextPath()%>/utilisateurs?action=afficher&noUtilisateur=${sessionScope.sessionUtilisateur.noUtilisateur}">Mon profil</a></li>
					<li><a href="<%=request.getContextPath()%>/deconnexion">Deconnexion</a></li>
				</ul>
			</nav>
		</c:when>
		<c:when test="${empty sessionScope.sessionUtilisateur}">
			<nav>
				<ul>
					<li><a href="<%=request.getContextPath()%>/inscription.jsp">S'inscrire</a></li>
					<li><a href="<%=request.getContextPath()%>/connexion.jsp">Se connecter</a></li>
				</ul>
			</nav>
		</c:when>
	</c:choose>
	
	<h3>Filtres</h3>
	
	<form action="<%=request.getContextPath()%>/gestionArticles?action=filtrer" method="post">
		<input type="text" name="filtreNom"/>
		<label>Catégorie</label>
		<select name="categorie" id="categorie-select" size="1">
			<option value="tout">Tout
			<c:forEach var="categorie" items="${categories }">
				<option value="${categorie.no_categorie }">${categorie.libelle }
			</c:forEach>
		</select>
		
		<fieldset>
		  <legend><input type="radio" name="achatsVentes" id="achats" value="achats"><label for="lblAchats">Achats</label></legend>
		  <p>
		    <input type="checkbox" name="ckAchats" id="encheresCourantes" value="encheresCourantes">
		    <label for="encheresCourantes">Enchères ouvertes</label>
		  </p>
		  <p>
		    <input type="checkbox" name="ckAchats" id="mesEncheresCourantes" value="mesEncheresCourantes">
		    <label for="mesEncheresCourantes">Mes enchères en cours</label>
		  </p>
		  <p>
		    <input type="checkbox" name="ckAchats" id="mesEncheresRemportees" value="mesEncheresRemportees">
		    <label for="mesEncheresRemportees">Mes enchères remportées</label>
		  </p>
		</fieldset>
		<fieldset>
		  <legend><input type="radio" name="achatsVentes" id="ventes" value="ventes"><label for="lblVentes">Mes ventes</label></legend>
		  <p>
		    <input type="checkbox" name="ckVentes" id="red" value="#F00">
		    <label for="red">Mes ventes en cours</label>
		  </p>
		  <p>
		    <input type="checkbox" name="ckVentes" id="green" value="#0F0">
		    <label for="green">Ventes non débutées</label>
		  </p>
		  <p>
		    <input type="checkbox" name="ckVentes" id="blue" value="#00F">
		    <label for="blue">Ventes terminées</label>
		  </p>
		</fieldset>
		
		<br>
		
		<input type="submit" value="Rechercher" class="btn btn-primary">
	</form>
	
	<c:forEach var="article" items="${listeArticles}">
	
		<div class="article">
			
			<c:choose>
				<c:when test="${!empty sessionScope.sessionUtilisateur}">
					<h2><a href="<%=request.getContextPath()%>/gestionArticles?action=afficher&noArticle=${article.noArticle }">${article.nomArticle}</a></h2>
				</c:when>
				<c:when test="${empty sessionScope.sessionUtilisateur}">
					<h2>${article.nomArticle}</h2>
				</c:when>
			</c:choose>	
			Prix : ${article.miseAPrix} points
			</br>
			Fin de l'enchère : ${article.dateFinEncheres }
			</br>
			Vendeur : <a href="<%=request.getContextPath()%>/utilisateurs?action=afficher&noUtilisateur=${article.utilisateur.noUtilisateur }">${article.utilisateur.pseudo }</a>		
		</div>
	
	</c:forEach>

</body>
</html>