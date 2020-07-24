<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>S'inscrire à ENI-enchères</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
	<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<div class="container">
  		<div class="col-sm-offset-2 col-sm-8 col-md-offset-3 col-md-6">
    <div class="header">

      <div class="header__text-group text-center">
      	<c:choose>
			<c:when test="${!empty sessionScope.sessionUtilisateur}">
				<h1 class="header__heading">Modifier son profil</h1>
			</c:when>
			<c:otherwise>
				<h1 class="header__heading">Inscription</h1>
			</c:otherwise>
		</c:choose>
      </div> <!-- close .text-group -->
    </div> <!-- close .header -->
    
    <hr />
    
    <div class="form-register">
		<form name="ajoutVente" method="post" action="<%=request.getContextPath()%>/gestionArticles">

		<div class="form-group">
        	<label for="user_username">
        		Nom de l'article
        	</label>
        	<input class="form-control" required="required" type="text" name="nom" id="user_username" data-cip-id="user_username" />
        </div> <!-- close .form-group -->

        <div class="form-group">
          <label for="user_username">
            Description
          </label>
          <textarea class="form-control" required="required" name="denomination" id="user_username" data-cip-id="user_username" autocomplete="off">
          	
          </textarea>
        </div> <!-- close .form-group -->
	
		<div class="form-group">
          <label for="user_username">
            Catégorie
          </label>
          <select class="form-control" required="required" name="categorie" id="user_username" data-cip-id="user_username">
          	<option value="1">Informatique</option>
          	<option value="2">Ameublement</option>
          	<option value="3">Vetements</option>
          	<option value="4">Sports et loisirs</option>
          </select>
        </div> <!-- close .form-group -->
		
		<div class="form-group">
          <label for="user_username">
            Mise à prix
          </label>
          <input class="form-control" required="required" type="number" name="miseAPrix" id="user_username" data-cip-id="user_username" autocomplete="off" step="10" value="150" min="10" max = "1000"/>
        </div> <!-- close .form-group -->
        
		<div class="form-group">
          <label for="user_username">
            Debut de l'enchere
          </label>
          <input class="form-control" required="required" type="date" name="dateDebut" id="user_username" data-cip-id="user_username" autocomplete="off" />
        </div> <!-- close .form-group -->
        
        <div class="form-group">
          <label for="user_username">
            Fin de l'enchere
          </label>
          <input class="form-control" required="required" type="date" name="dateFin" id="user_username" data-cip-id="user_username" autocomplete="off" />
        </div> <!-- close .form-group -->
        
        </br></br></br>
        
        <div class="form-group">
          <label for="user_username">
            Adresse de retrait
          </label>
        </div> <!-- close .form-group -->
        
        <div class="form-group">
          <label for="user_username">
            Rue
          </label>
          <input class="form-control" required="required" type="text" name="rueRetrait" id="user_username" data-cip-id="user_username" value="${sessionUtilisateur.rue }" />
        </div> <!-- close .form-group -->
        
                <div class="form-group">
        <label for="user_username">
            Code postal
          </label>
          <input class="form-control" required="required" type="text" name="cpRetrait" id="user_username" data-cip-id="user_username" value="${sessionUtilisateur.codePostal }" />
        </div> <!-- close .form-group -->
        
        <div class="form-group">
          <label for="user_username">
            Ville
          </label>
          <input class="form-control" required="required" type="text" name="villeRetrait" id="user_username" data-cip-id="user_username" value="${sessionUtilisateur.ville }" />
        </div> <!-- close .form-group -->
        
        <div class="form-group">
          	<input type="submit" value="Enregistrer" class="btn btn-success login-btn">
          	<a href="<%=request.getContextPath()%>"><input type="button" value="Annuler" class="btn btn-danger login-btn"></a>
        </div> <!-- close .form-group -->

      </form>
    </div> <!-- close .form -->

  </div>
</div>
</body>
</html>































