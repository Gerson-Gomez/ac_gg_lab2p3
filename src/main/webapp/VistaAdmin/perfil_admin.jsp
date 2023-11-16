<%@page import="java.util.List"%>
<%@page import ="modelos.ac_gg_Encuesta"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>
        <jsp:include page="../Plantilla/nav_admin.jsp"></jsp:include>
        </head>
        <body>
            <div class="container mt-5">
                <div class="card-body">
                    <h3 class="card-title mb-4">Información de todas las encuestas recolectadas.</h3>

                    <form method="post" action="ac_gg_AdminController">
                        <input type="hidden" name="action" value="search">
                        <div class="input-group mb-3">
                            <input type="text" class="form-control" placeholder="Buscar por nombre de usuario" name="searchUsuario">
                            <input type="date" class="form-control" name="fechaBusqueda">
                            <button type="submit" class="btn btn-warning">Buscar</button>
                            <a href="ac_gg_AdminController?action=showAll" class="btn btn-secondary">Mostrar Todos</a>
                        </div>
                    </form>


                    <div class="table-responsive">
                        <table class="table table-bordered table-striped">
                            <thead class="table-dark">
                                <tr>
                                    <th scope="col"># Encuesta</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Correo</th>
                                    <th scope="col">Sexo</th>
                                    <th scope="col">Deportes</th>
                                    <th scope="col">Nivel de inglés</th>
                                    <th scope="col">Temas de Interes</th>
                                    <th scope="col">Fecha </th>
                                    <th scope="col">Accion</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${consulta}" var="dato">
                                <tr>
                                    <td>${dato.id_encuesta}</td>
                                    <td>${dato.name}</td>
                                    <td>${dato.correo}</td>
                                    <td>${dato.sexo}</td>
                                    <td>${dato.deportes}</td>
                                    <td>${dato.nivel_ing}</td>
                                    <td>${dato.temas_fav}</td>
                                    <td>${dato.fecha}</td>    
                                    <td>
                                        <div class="btn-group" role="group">
                                            <button type="button" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#editarModal" data-correo="${correo}">
                                                Editar
                                            </button>
                                            <di>
                                                <form method="post" action="ControllerVentas">
                                                    <input type="hidden" name="action" value="delete">
                                                    <input type="hidden" name="id" value="${venta.id}">
                                                    <button type="submit" class="btn btn-danger">Eliminar</button>
                                                </form>
                                            </di>

                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- EL MODAL DEBE CONFIGURARSE SEGUN LOS VALORES SELECCIONADOS -->
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

                            <form method="post" action="../ac_gg_UserController">                                    
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
    </body>
</html>
