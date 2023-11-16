<%@ page import="java.util.List" %>
<%@ page import="modelos.ac_gg_Encuesta" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Administrador</title>
    <jsp:include page="../Plantilla/nav_admin.jsp"></jsp:include>
    <script>
        function confirmarEliminar() {
            return confirm('¿Estás seguro de que deseas eliminar las encuestas seleccionadas?');
        }
    </script>
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

            <form method="post" action="ac_gg_AdminController" onsubmit="return confirmarEliminar();">
                <input type="hidden" name="action" value="deleteSelected">
                <div class="table-responsive">
                    <table class="table table-bordered table-striped">
                        <thead class="table-dark">
                            <tr>
                                <th scope="col">Seleccionar</th>
                                <th scope="col"># Encuesta</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Correo</th>
                                <th scope="col">Sexo</th>
                                <th scope="col">Deportes</th>
                                <th scope="col">Nivel de inglés</th>
                                <th scope="col">Temas de Interes</th>
                                <th scope="col">Fecha</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${consulta}" var="dato">
                                <tr>
                                    <td><input type="checkbox" name="selectedItems" value="${dato.id_encuesta}"></td>
                                    <td>${dato.id_encuesta}</td>
                                    <td>${dato.name}</td>
                                    <td>${dato.correo}</td>
                                    <td>${dato.sexo}</td>
                                    <td>${dato.deportes}</td>
                                    <td>${dato.nivel_ing}</td>
                                    <td>${dato.temas_fav}</td>
                                    <td>${dato.fecha}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- Botón de eliminar -->
                <button type="submit" class="btn btn-danger">Eliminar seleccionados</button>
            </form>
        </div>
    </div>
</body>
</html>
