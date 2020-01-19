<!DOCTYPE html>
<html>
<head>
    <title>Suffie | Suffice Responsive Admin Dashboard Template</title>    <meta charset="utf-8" />  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- Bootstrap -->
    <link href="adminResources/css/bootstrap.min.css" rel="stylesheet" />
    <!-- Custom styling plus plugins -->
    <link rel="stylesheet" href="adminResources/css/main.css">

     <link href="adminResources/css/ionicons.min.css" rel="stylesheet" />
    <link href="adminResources/css/extra_colors.css" rel="stylesheet" />
    <link href="adminResources/css/bootstrap-extra.css" rel="stylesheet" />

    <!-- Custom styling login-->
    <link href="adminResources/css/custom-login.css" rel="stylesheet">
</head>
<body>

    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-md-4 col-md-offset-4">
                <h1 class="text-center login-title">Sign in to continue</h1>
                <div class="account-wall">
                    <img class="profile-img" src="adminResources/images/photo.png" alt="Hello">
                    
                    <form class="form-signin" action="spring_verify" method="post">
                    	   <input type="text" name="username" class="form-control" placeholder="Email" required autofocus>
 				
                       
                        <input type="password" name="password" class="form-control" placeholder="Password" required>
                        <p> 
                              <input type="submit" class="btn btn-lg btn-dark btn-block" value="Sign in">
                            
                         </p>
                         
                        <label class="checkbox pull-left">
                    <input type="checkbox" value="remember-me">
                    Remember me
                </label>
                          <a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span>
                    </form>
                </div>
             
            </div>
        </div>
    </div>
</body>

</html>