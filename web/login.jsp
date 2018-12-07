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
        <!--Importacion de Css Personalizado para el Login-Registro--->
        <link type="text/css" rel="stylesheet" href="css/log-style.css">
        <title>Biblioteca_KL</title>
    </head>
    <body>
        <header>
        <!------------           nav    ------------------->
        <nav class="blue-grey lighten-2" role="navigation">
            <div class="nav-wrapper container">
                <a class="brand-logo" href="index.jsp"><i class="material-icons">local_library</i>Biblioteca KL</a>  
                <a href="#" data-target="prueba-movil" class="sidenav-trigger"><i class="material-icons">menu</i></a>
                <ul class="right hide-on-small-only">
                    <li><a href="#">Sign-in</a></li>
                    <li><a href="registrar.jsp">Register</a></li>
                </ul>
            </div>
        </nav>
        </header>
        <main>
        <!-------   Login form ------->
        <div class="row login" id="central">
            <div class="col s12 l4 offset-l4">
                <div class="card">
                    <div class="card-action grey darken-3 white-text">
                        <h4>Login</h4>
                    </div>
                    <div class="card-content">
                        <form action="Controlador" method="">
                            <div class="row">
                                <div class="input-field">
                                    <input id="user" name="txtuser" type="text">
                                    <label for="user">Usuario</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field ">
                                    <input id="password" name="txtpassword" type="password">
                                    <label for="password">Contraseña</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="center-align">
                                    <button class="btn waves-effect waves-light" type="submit">Login
                                        <input type="hidden" name="opc" value="11">
                                        <i class="material-icons right">send</i>
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
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
