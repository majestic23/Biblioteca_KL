<%-- 
    Document   : login
    Created on : 10/11/2018, 12:59:50 PM
    Author     : manue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>


        <title>Biblioteca_KL</title>
    </head>
    <body>
        <!------------           nav    ------------------->
        <nav class="blue-grey lighten-2" role="navigation">
            <div class="nav-wrapper container">
                <a class="brand-logo" href="#"><i class="material-icons">local_library</i>Logo</a>  
                <a href="#" data-target="prueba-movil" class="sidenav-trigger"><i class="material-icons">menu</i></a>
                <ul class="right hide-on-small-only">
                    <li><a href="#">Sign-in</a></li>
                    <li class="sidenav-trigger left" data-target="slide-out-usuario"><a href="#"><i class="material-icons">view_module</i></a></li>
                </ul>
            </div>
        </nav>
        
        
        
        
        
        
         <footer class="page-footer orange darken-3">
            <div class="container">
                <div class="row">
                    <div class="col l6 s12">
                        <h5 class="white-text">Company Bio</h5>
                        <p class="grey-text text-lighten-4">We are a team of college students working on this project like it's our full time job. Any amount would help support and continue development on this project and is greatly appreciated.</p>


                    </div>
                    <div class="col l3 s12">
                        <h5 class="white-text">Settings</h5>
                        <ul>
                            <li><a class="white-text" href="#!">Link 1</a></li>
                            <li><a class="white-text" href="#!">Link 2</a></li>
                            <li><a class="white-text" href="#!">Link 3</a></li>
                            <li><a class="white-text" href="#!">Link 4</a></li>
                        </ul>
                    </div>
                    <div class="col l3 s12">
                        <h5 class="white-text">Connect</h5>
                        <ul>
                            <li><a class="white-text" href="#!">Link 1</a></li>
                            <li><a class="white-text" href="#!">Link 2</a></li>
                            <li><a class="white-text" href="#!">Link 3</a></li>
                            <li><a class="white-text" href="#!">Link 4</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="footer-copyright">
                <div class="container">
                    Powered by <a class="orange-text text-lighten-3" href="http://materializecss.com">Materialize</a>
                </div>
            </div>
        </footer>

        <!--        Scripts             -->
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/init.js"></script> 

    </body>
</html>