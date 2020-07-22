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
    	<c:choose>
			<c:when test="${!empty sessionScope.sessionUtilisateur}">
				<form name="register" method="post" action="<%=request.getContextPath()%>/utilisateurs?action=modifier">
			</c:when>
			<c:otherwise>
				<form name="register" method="post" action="<%=request.getContextPath()%>/utilisateurs">
			</c:otherwise>
		</c:choose>
        <div class="row">
          <div class="col-xs-6">
            <div class="form-group">
              <label for="user_first_name">Prenom</label>
              <input autofocus="autofocus" class="form-control" required="required" type="text" name="prenom" id="user_first_name" value="${sessionUtilisateur.prenom }">
            </div> <!-- close .form-group -->
          </div> <!-- close .col -->

          <div class="col-xs-6">
            <div class="form-group">
              <label for="user_last_name">Nom</label>
              <input class="form-control" type="text" name="nom" id="user_last_name" value="${sessionUtilisateur.nom }">
            </div> <!-- close .form-group -->
          </div> <!-- close .col -->
        </div> <!-- close .row -->

        <div class="form-group">
          <label for="user_email">
            Adresse email
          </label>
          <input class="form-control" type="email" name="email" id="user_email" data-cip-id="cIPJQ342845639" value="${sessionUtilisateur.email }">

        </div> <!-- close .form-group -->

        <div class="form-group">
          <label for="user_username">
            Pseudo
          </label>
          <input class="form-control" required="required" type="text" name="pseudo" id="user_username" data-cip-id="user_username" autocomplete="off"  value="${sessionUtilisateur.pseudo }">
        </div> <!-- close .form-group -->
	
		<div class="form-group">
          <label for="user_username">
            Adresse
          </label>
          <input class="form-control" required="required" type="text" name="rue" id="user_username" data-cip-id="user_username" autocomplete="off" value="${sessionUtilisateur.rue }">
        </div> <!-- close .form-group -->
		
		<div class="row">
          <div class="col-xs-6">
            <div class="form-group">
              <label for="user_first_name">Code postal</label>
              <input autofocus="autofocus" class="form-control" required="required" type="text" name="codepostal" id="user_first_name" value="${sessionUtilisateur.codePostal }">
            </div> <!-- close .form-group -->
          </div> <!-- close .col -->

          <div class="col-xs-6">
            <div class="form-group">
              <label for="user_last_name">Ville</label>
              <input class="form-control" type="text" name="ville" id="user_last_name" value="${sessionUtilisateur.ville }">
            </div> <!-- close .form-group -->
          </div> <!-- close .col -->
        </div> <!-- close .row -->
		
		<div class="form-group">
          <label for="user_username">
            Numero de telephone
          </label>
          <input class="form-control" required="required" type="text" name="telephone" id="user_username" data-cip-id="user_username" autocomplete="off" value="${sessionUtilisateur.telephone }">
        </div> <!-- close .form-group -->
        
		<c:choose>
			<c:when test="${!empty sessionScope.sessionUtilisateur}">
				
				<div class="form-group">
				
		          <label for="user_password">
		            Mot de passe actuel<span class="text-secondary"></span>
		          </label>
		          <input autocomplete="off" class="form-control" required="required" type="password" name="motdepasseActuel" id="user_password" data-cip-id="cIPJQ342845640">
		
		        </div> <!-- close .form-group -->
		        
		        <div class="form-group">
		          	<label for="user_password">
		            Nouveau mot de passe <span class="text-secondary">(6 characteres minimum)</span>
		          	</label>
		          	<input autocomplete="off" class="form-control" required="required" type="password" name="nouveauMotdepasse" id="user_password" data-cip-id="cIPJQ342845640">
		
		        </div> <!-- close .form-group -->
		        
		        <div class="form-group">
		        	<p>
		        		Credit ${sessionUtilisateur.credit}
		        	</p>
		        </div>
				
				<div class="form-group">
          			<input type="submit" value="Modifier" class="btn btn-success login-btn">
          			<a href="<%=request.getContextPath()%>/utilisateurs?action=supprimer&noUtilisateur=${sessionUtilisateur.noUtilisateur}"><input type="button" value="Se desinscrire" class="btn btn-danger login-btn"></a>
        		</div> <!-- close .form-group -->
				
			</c:when>
			<c:otherwise>
			
				<div class="form-group">
          			<label for="user_password">
            			Mot de passe <span class="text-secondary">(6 characteres minimum)</span>
          			</label>
          			<input autocomplete="off" class="form-control" required="required" type="password" name="motdepasse" id="user_password" data-cip-id="cIPJQ342845640">
	
        		</div> <!-- close .form-group -->
			
				<div class="form-group">
          			<input type="submit" value="S'inscrire" class="btn btn-success login-btn">
          			<a href="<%=request.getContextPath()%>"><input type="button" value="Annuler" class="btn btn-success login-btn"></a>
        		</div> <!-- close .form-group -->

        		<div class="form-group text-center">
          			<p class="text-secondary zeta">
            			En vous inscrivant, vous acceptez les <a href="/terms">les regles d'usage de l'application</a>.
          			</p>
        		</div>	
			
			</c:otherwise>
		</c:choose>

      </form>
    </div> <!-- close .form -->

	<c:if test="${empty sessionScope.sessionUtilisateur}">
				
		<div class="sheet sheet--padding-small text-center">
      		<p class="epsilon">Deja inscrit ? <a href="<%=request.getContextPath()%>/connexion.jsp">Se connecter</a></p>
   		</div>

	</c:if>

  </div>
</div>
</body>
</html>




















