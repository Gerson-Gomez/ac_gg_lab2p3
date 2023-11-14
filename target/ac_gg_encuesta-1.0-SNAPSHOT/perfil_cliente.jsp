<%@page import="java.util.List"%>
<%@page import="modelos.ac_gg_Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    Integer ids = (int) sesion.getAttribute("id_usuario");
    String nombre =  (String) sesion.getAttribute("nombre");
     String correo = (String) sesion.getAttribute("correo");
     String pass = (String) sesion.getAttribute("pass");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion usuario</title>
         <jsp:include page="Plantilla.jsp"></jsp:include>
    </head>
    <body>
        <div class="container mt-5">
            <div class="card" style="max-width: 50rem; margin: 0 auto;">
                
                <div class="card-header">
                    <h5 class="card-title">Información personal.</h5>
                </div>

                <div class="table-responsive">
                    <table class="table table-bordered table-striped">
                         <thead class="table-dark">
                                        <tr>
                                            <th scope="col">ID</th>
                                            <th scope="col">Nombre</th>
                                            <th scope="col">Correo</th>
                                             <th scope="col">Contraseña</th>
                                             <th scope="col">Acción</th>
                                        </tr>
                                    </thead>
                                    
                                    <tbody>
                                        
                                    <tbody>
                                        <tr>                                                
                                            <td>${ids}</td>
                                            <td>${nombre}</td>
                                            <td>${correo}</td>
                                            <td>${pass}</td>
                                            <td>
                                                <div class="btn-group" role="group">
                                                    <button type="button" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#editarModal" data-correo="${correo}">
                                                        Editar
                                                    </button>

                                                </div>
                                            </td>
                                    </tr>
                    </tbody>
                    </table>
                </div>
            </div>

            <div class="modal fade" id="editarModal" tabindex="-1" role="dialog" aria-labelledby="editarModalLabel" aria-hidden="true">
              <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="editarModalLabel${correo}">Editar Información</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                
                                <form method="post" action="ac_gg_UserController">                                    
                                    <input type="hidden" name="action" value="update">
                                    
                                    <input type="hidden" name="correo" value="${correo}">
                                    
                                    <div class="mb-3">
                                        <label for="nombre" class="form-label">Nombre</label>
                                        <input type="text" class="form-control" id="nombre" name="nombre" value="${nombre}" required>
                                    </div>
                                    
                                    <div class="mb-3">
                                        <label for="pass" class="form-label">Contraseña</label>
                                        <input type="text" class="form-control" id="pass" name="pass" value="${pass}" required>
                                    </div>
                                    <button type="submit" class="btn btn-success">Actualizar</button>
                                </form>
                                    
                            </div>
                        </div>
                    </div>
                                    </div>
                </div>
            <!-- comment 
        <h1>Perfil Cliente! </h1>
        <p>La idea es que en esta pag el user pueda cambiar info de su perfil o contraseña, el correo nel</p>
        <p>es decir aca debe haber una especie de crud para editar</p>
        <button type="submit" class="btn btn-primary" name="btn_ingresar">Ver mi encuesta</button>  
            -->
        </div>        
    </body>
    <!-- Scripts -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</html>