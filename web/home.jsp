<%-- 
    Document   : home
    Created on : 11/11/2018, 11:14:53 AM
    Author     : manue
--%>
<%@page import="Beans.Cliente"%>
<%@page import="Beans.Trabajador"%>
<%@page import="Beans.Usuario"%>
<%
    Usuario u = null;
    String tipo = null;
    Trabajador trabajador = null;
    Cliente cliente = null;
    if (request.getSession().getAttribute("user") != null) {
            u = (Usuario)request.getSession().getAttribute("usuario");
            tipo = request.getSession().getAttribute("tipo").toString();
            if (tipo.equals("trabajador")) {
                    trabajador = (Trabajador) request.getSession().getAttribute("t");
                }else if (tipo.equals("cliente")) {
                        cliente = (Cliente) request.getSession().getAttribute("c");
                    }
        }else{
        response.sendRedirect("index.jsp");
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

        <title>Home</title>
    </head>
    <body>
        <header>
        <!------------           nav    ------------------->
        <nav class="blue-grey lighten-2" role="navigation">
            <div class="nav-wrapper container">
                <a class="brand-logo" href="#"><i class="material-icons">local_library</i>Logo</a>  
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
                    <a href="#name"><span class="white-text name">John Doe</span></a>
                    <a href="#email"><span class="white-text email">jdandturk@gmail.com</span></a>
                </div></li>
            <li><a href="#!"><i class="material-icons">cloud</i>First Link With Icon</a></li>
            <li><a href="#!">Second Link</a></li>
            <li><div class="divider"></div></li>
            <li><a class="subheader">Subheader</a></li>
            <li><a class="waves-effect" href="#!">Third Link With Waves</a></li>
        </ul>
        <!----          SideNav de menus         ------>
        <ul class="sidenav" id="prueba-movil">
            <li><a href="#">Buscar</a></li>
            <li><a href="#">Desplegar</a></li>
        </ul>
        </header>
        <main>
            
        </main>
        
        <footer>
            
        </footer>
         <!--        Scripts             -->
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/init.js"></script> 
    </body>
</html>
