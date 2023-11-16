<%@page import="modelosDAO.ac_gg_UsuarioDAO"%>
<%@page import ="modelos.ac_gg_Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%
    if (request.getParameter("registro") != null) {

        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String pass = request.getParameter("pass");
        String rol = request.getParameter("rol");

        // Verificar si los parámetros no son null antes de llamar a isEmpty()
        if (nombre != null && correo != null && pass != null
                && !nombre.isEmpty() && !correo.isEmpty() && !pass.isEmpty()) {

            // Verificar si el correo ya existe
            ac_gg_UsuarioDAO userDAO = new ac_gg_UsuarioDAO();
            if (userDAO.existeCorreo(correo)) {
                // El correo ya existe, puedes manejarlo como desees (mostrar un mensaje, redirigir, etc.)
                out.println("<script>alert('El correo electrónico ya está registrado');</script>");
            } else {
                // El correo no existe, puedes proceder a insertar el usuario
                ac_gg_Usuario usuario = new ac_gg_Usuario();
                usuario.setNombre(nombre);
                usuario.setCorreo(correo);
                usuario.setPass(pass);
                usuario.setRol(rol);

                userDAO.insertUsuario(usuario);
                response.sendRedirect("index.jsp");
            }
        }
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>

        <div class="container mt-5">
            <form>
                <div class="card" style="max-width: 30rem; margin: 0 auto;">
                    <div class="card-header">
                        <h5 class="card-title">Registrarse</h5>
                    </div>

                    <div class="card-body">
                        <p class="card-text">Por favor, completa el formulario para registrarte.</p>
                        <div class="form-group row">
                            <div class="col">
                                <label for="nombre">Nombre:</label>
                                <input type="text" class="form-control" name="nombre" required>
                            </div>
                        </div>                        
                        <div class="form-group row ">
                            <div class="col">
                                <label for="correo">Correo Electrónico:</label>
                                <input type="email" class="form-control" name="correo" required>
                            </div>
                        </div>                        
                        <div class="form-group row">
                            <div class="col">
                                <label for="pass">Contraseña:</label>
                                <input type="password" class="form-control" name="pass" required>
                            </div>
                        </div>
                        <!-- Agregar el combo box para roles -->
                        <div class="form-group row">
                            <div class="col">
                                <label for="rol">Rol:</label>
                                <select class="form-control" name="rol">
                                    <option value="u" selected>Usuario</option>
                                    <option value="a">Administrador</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group  text-center mt-4">
                            <button type="submit" class="btn btn-primary" name ="registro">Registrarse</button>
                            <a  class="btn btn-secondary"href="./index.jsp" >Volver</a>
                        </div>
                    </div>
                    
                </div>
            </form>   
        </div>
    </body>
</html>
