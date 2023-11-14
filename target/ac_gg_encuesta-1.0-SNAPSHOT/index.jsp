<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelos.ac_gg_Usuario" %>
<%@page import="modelosDAO.ac_gg_UsuarioDAO" %>

<%
    ac_gg_UsuarioDAO userDAO = new ac_gg_UsuarioDAO();
    HttpSession sesion = request.getSession();

    if (request.getParameter("btn_ingresar") != null) {
        String correo = request.getParameter("correo");
        String pass = request.getParameter("pass");

        ac_gg_Usuario user = userDAO.ObtenerUsuarios(correo, pass);

        if (user != null) {
            sesion.setAttribute("user_logged", true);
            sesion.setAttribute("id_usuario", user.getId_usuario());
            sesion.setAttribute("nombre", user.getNombre());
            sesion.setAttribute("correo", user.getCorreo());
            sesion.setAttribute("pass", user.getPass());

            if (user.getRol().contains("u")) {
            //la u es de Usuario
                response.sendRedirect("perfil_cliente.jsp");
                
            } else {
                response.sendRedirect("perfil_admin.jsp");
            }
        }
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Encuesta 2023</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>

    <body>

        <div class="container mt-5">

            <div class="card text-center" style="max-width: 18rem; margin: 0 auto;">
               
                    <div class="card-header">
                        <h5 class="card-title">Encuesta2023!</h5>
                    </div>
                     <form method="post">
                    <div class="card-body">
                        <p class="card-text">Bienvenido, por favor ingresa tu correo y contraseña.</p>
                 
                            <div class="mb-3">
                                <label for="correo" class="form-label">Correo Electrónico:</label>
                                <input type="email" class="form-control" name="correo" placeholder="correo@example.com" required>
                            </div>
                            <div class="mb-3">
                                <label for="pass" class="form-label">Contraseña:</label>
                                <input type="password" class="form-control" name="pass" required>
                            </div>
                            <div class="mb-3">
                                <button type="submit" class="btn btn-primary"  name="btn_ingresar">Iniciar Sesión</button>
                            </div>
                     

                        <div class="mb-3">
                            <div class="text-center">
                                <a  href="registrarse.jsp">¿No tienes cuenta?</a>
                            </div>
                        </div>
                    </div>
                </form>  
            </div>

        </div>

        <!-- Agregar el CDN de Bootstrap 5.0 (scripts) -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>

