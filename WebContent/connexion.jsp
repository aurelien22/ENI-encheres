<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Bootstrap Sign in Form with Social Login Buttons</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
	<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<div class="login-form">
	    <form action="<%=request.getContextPath()%>/connexion" method="post">
	        <h2 class="text-center">Se connecter</h2>		
			<div class="or-seperator"></div>
	        <div class="form-group">
	        	<div class="input-group">
	                <span class="input-group-addon"><i class="fa fa-user"></i></span>
	                <input type="text" class="form-control" name="username" placeholder="Pseudo ou email" required="required">
	            </div>
	        </div>
			<div class="form-group">
	            <div class="input-group">
	                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
	                <input type="password" class="form-control" name="password" placeholder="Mot de passe" required="required">
	            </div>
	        </div>        
	        <div class="form-group">
	            <button type="submit" class="btn btn-success btn-block login-btn">Se connecter</button>
	        </div>
	        <div class="clearfix">
	            <label class="pull-left checkbox-inline"><input type="checkbox"> Se souvenir de moi</label>
	            <a href="#" class="pull-right text-success">Mot de passe oublié</a>
	        </div> 
	        <h4>
	        	<c:if test="${!empty requestScope['messageErreur']}">
	        		${requestScope['messageErreur']}
	        	</c:if>
	        </h4> 
	        
	    </form>
    	<div class="hint-text small">Pas encore inscrit ? <a href="<%=request.getContextPath()%>/inscription.jsp" class="text-success">S'inscrire !</a></div>
	</div>
</body>
</html>
























