<%-- 
    Document   : home
    Created on : 11/11/2018, 11:14:53 AM
    Author     : manue
--%>
<%@page import="Beans.Cliente"%>
<%@page import="Beans.Trabajador"%>
<%@page import="Beans.Usuario"%>
<%
    Trabajador t = new Trabajador();
    Cliente c = new Cliente();
    Usuario u = (session.getAttribute("usuario") != null)
            ? (Usuario) session.getAttribute("usuario") : null;
    String tipo = (session.getAttribute("tipo") != null)
            ? (String) session.getAttribute("tipo") : null;
    if (u.equals(null)) {
        response.sendRedirect("Controlador?opc=99");
    } else if (tipo.equals("Trabajador")) {
        t = (session.getAttribute("trabajador") != null)
                ? (Trabajador) session.getAttribute("trabajador") : null;
    } else if (tipo.equals("Cliente")) {
        c = (session.getAttribute("cliente") != null)
                ? (Cliente) session.getAttribute("cliente") : null;
    }

%>
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
        <title>Home</title>
    </head>
    <body>
        <header>
            <!------------           nav    ------------------->
            <nav class="blue-grey lighten-2" role="navigation">
                <div class="nav-wrapper container">
                    <a class="brand-logo" href="#"><i class="material-icons">local_library</i>Biblioteca KL</a>  
                    <a href="#" data-target="prueba-movil" class="sidenav-trigger"><i class="material-icons">menu</i></a>
                    <ul class="right hide-on-small-only">
                        <li><a href="Controlador?opc=9">Logout</a></li>
                        <li class="sidenav-trigger left" data-target="slide-out-usuario"><a href="#"><i class="material-icons">view_module</i></a></li>
                    </ul>
                </div>
            </nav>
            <!----          SideNav de usuario         ------>
            <ul class="sidenav" id="slide-out-usuario">
                <li><div class="user-view">
                        <div class="background">
                            <img src="images/user_wallpaper.jpg">
                        </div>
                        <a href="#user"><img class="circle" src="images/user_default.png"></a>
                        <a href="#name"><span class="white-text name"><%=u.getUsername()%></span></a>
                        <a href="#email"><span class="white-text email"><%=u.getEmail()%></span></a>
                    </div></li>
                    <%if (t.equals(null)) {%>
                <li><a href="#!"><i class="material-icons">cloud</i>Almacen</a></li>
                <%    } else {%>
                <li><a href="#!"><i class="material-icons">cloud</i>Reservaciones</a></li>
                <%}%>
                <li><a href="#!"><i class="material-icons">settings</i>Configuracion</a></li>
                <li><div class="divider"></div></li>
                <li><a class="subheader">Accesorios</a></li>
                <li><a class="waves-effect" href="#!"><i class="material-icons">insert_invitation</i>Calendario</a></li>
            </ul>
            <!----          SideNav de menus         ------>
            <ul class="sidenav" id="prueba-movil">
                <li><a href="#">Buscar</a></li>
                <li><a href="#">Desplegar</a></li>
            </ul>
        </header>
        <main>
            <%if (t.equals(null)) {%>
            <div class="container">
                <div row>
                    <h5 class="teal-text center-align">Welcome <%=t.getNombre_trabajador()%></h5>
                </div>
                <div class="divider"></div>
                <div class="row">
                    <div class="col s4">
                        <div class="card small">
                            <div class="card-image">
                                <img  src="images/background1.jpg">
                            </div>
                            <div class="card-content">
                                <span class="card-title">Usuarios<i class="material-icons right">add</i></span>
                                <p class="waves-effect waves-green"><a href="Controlador?opc=2">Ver más<i class="material-icons right">account_circle</i></a></p>
                            </div>
                        </div>
                    </div>
                    <div class="col s4">
                        <div class="card small">
                            <div class="card-image waves-effect waves-block waves-light">
                                <img class="activator" src="images/background1.jpg">
                            </div>
                            <div class="card-content">
                                <span class="card-title">Reservaciones</span>
                                <p class="waves-effect waves-green"><a href="Controlador?opc=2">Agregar Reservacion<i class="material-icons right">add</i></a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%    } else {%>
        <div class="container">
            <div row>
                <h3 class="teal-text center-align">Welcome <%=c.getNombre_cliente()%></h3>
            </div>
            <div class="divider"></div>
            <div class="row">
                <div class="col s4">
                    <div class="card small">
                        <div class="card-image">
                            <img  src="images/pasillo.jpg">
                        </div>
                        <div class="card-content">
                            <span class="card-title">Libros<i class="material-icons right"></i></span>
                            <p class="waves-effect waves-green">
                                <a href="Controlador?opc=2">Buscar<i class="material-icons right">book</i></a><br>
                            </p>
                            
                        </div>
                    </div>
                </div>
                <div class="col s4">
                    <div class="card small">
                        <div class="card-image waves-effect waves-block waves-light">
                            <img class="activator" src="images/background1.jpg">
                        </div>
                        <div class="card-content">
                            <span class="card-title">Reservaciones</span>
                            <p class="waves-effect waves-green"><a href="Controlador?opc=2">Agregar Reservacion<i class="material-icons right">add</i></a></p>
                        </div>
                    </div>
                </div>
                <div class="col s4">
                    <div class="card small">
                        <div class="card-image waves-effect waves-block waves-light">
                            <img class="activator" src="images/1.jpg">
                        </div>
                        <div class="card-content">
                            <span class="card-title">Algo más</span>
                            <p class="waves-effect waves-green"><a href="#!">Otra Opcion<i class="material-icons right">filter_tilt_shift</i></a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%}%>
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
                <h5 class="white-text">Contacto</h5>
                <ul>
                    <li><a class="white-text" href="#!">Ubicacion</a></li>
                    <li><a class="white-text" href="#!">Telefonos</a></li>
                    <li><a class="white-text" href="#!">Correo Institucional</a></li>
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
