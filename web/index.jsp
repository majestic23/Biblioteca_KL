<%-- 
    Document   : index
    Created on : 06/11/2018, 11:53:34 PM
    Author     : retr0
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
        <link type="text/css" rel="stylesheet" href="css/style.css">
        <title>Biblioteca_KL</title>
    </head>
    <body>
        <header>
        <!------------           nav    ------------------->
        <nav class="blue-grey lighten-1" role="navigation">
            <div class="nav-wrapper container">
                <a class="brand-logo center-on-small-only" href="#"><i class="material-icons">local_library</i>Biblioteca KL</a>  
                <a href="#" data-target="prueba-movil" class="sidenav-trigger"><i class="material-icons">menu</i></a>
                <ul class="right hide-on-small-only">
                    <li><a href="login.jsp">Sign-in</a></li>
                </ul>
            </div>
        </nav>
        <!----          SideNav de menus         ------>
        <ul class="sidenav" id="prueba-movil">
            <li><a href="login.jsp">Login</a></li>
            <li><a href="#">About</a></li>
        </ul>
        </header>
        <main>
        <!------------           parallax    ------------------->
        <div class="parallax-container">
            <div class="parallax"><img src="images/1.jpg"></div>
        </div>
        <div class="section white">
            <div class="row container">
                <h2 class="header">Biblioteca KL v.0.0.1</h2>
                <p class="grey-text text-darken-3 lighten-3">
                    Biblioteca KL es un software de bajo a mediano rendimiento, optimizado para la gestion de libros virtuales y la rapidez en procesos de alquiler y/o venta 
                    que se produzcan en el proceso de negocio de la biblioteca en si.
                </p>
            </div>
        </div>
        <div class="parallax-container">
            <div class="parallax"><img src="images/libro_abierto.jpg"></div>
        </div>
        </main>
        <footer class="page-footer orange darken-3">
            <div class="container">
                <div class="row">
                    <div class="col l6 s12">
                        <h5 class="white-text">Desarrollo</h5>
                        <p class="grey-text text-lighten-4">Manuel Alejandro Quevedo Cumpa, estudiante de la carrera de Ing. de Sistemas en la Universidad Nacional Pedro Ruiz Gallo de la ciudad de Lambayeque, Lambayeque - Perú.</p>
                        <strong>Correo: manuel.alejandro.qc@gmail.com</strong>

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
