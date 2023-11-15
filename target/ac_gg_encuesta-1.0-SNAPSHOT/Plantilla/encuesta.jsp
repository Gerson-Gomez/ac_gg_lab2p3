<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    int id = (int) sesion.getAttribute("id");
    String nombre = (String) sesion.getAttribute("nombre");
    String correo = (String) sesion.getAttribute("correo");
    String pass = (String) sesion.getAttribute("pass");
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Formulario de encuesta</title>
        <!-- Agregar el CDN de Bootstrap 5.0 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <jsp:include page="../Plantilla/nav_user.jsp"></jsp:include>
        </head>
        <body>
            <div class="container mt-3">
                <div class="card bg-light">
                    <div class="card-body ">
                        <h5 class="card-title" style="text-align: center">Encuesta 2023</h5>

                        <!-- LA ACCION SERIA INSERT   ../VistaCliente/perfil_cliente.jsp-->
                        <form action="../ac_gg_EncuestaController" method="post"> 
                            <input type="hidden" name="action" value="add">
                            <input type="hidden" id="id" name="id" value="${id}">  
                        
                        <label style="font-weight: bold;">Nombre:</label>
                        <input type="text" id="nombree" name="nombree" value="${nombre}" class="form-control" disabled>                                

                        <br>                 
                        <label style="font-weight: bold;">Género:</label>
                        <div class="form-check">
                            <input type="radio" id="masculino" name="genero" value="M" class="form-check-input" required>
                            <label for="masculino" class="form-check-label">Masculino</label>
                        </div>     
                        <div class="form-check">
                            <input type="radio" id="femenino" name="genero" value="F" class="form-check-input" required>
                            <label for="femenino" class="form-check-label">Femenino</label>
                        </div>
                        <br>
                        <label style="font-weight: bold;">Deportes Favoritos:</label>
                        <div class="row">
                            <div class="col">
                                <div class="form-check ">
                                    <input type="radio" id="futbol" name="deporte" value="futbol" class="form-check-input" required>
                                    <label for="futbol" class="form-check-label">Fútbol</label>
                                </div>
                            </div>

                            <div class="col">
                                <div class="form-check form-check-inline">
                                    <input type="radio" id="baloncesto" name="deporte" value="baloncesto" class="form-check-input">
                                    <label for="baloncesto" class="form-check-label">Baloncesto</label>
                                </div>
                            </div>
                            <div class="col">
                                <div class="form-check form-check-inline">
                                    <input type="radio" id="tenis" name="deporte" value="tenis" class="form-check-input">
                                    <label for="tenis" class="form-check-label">Tenis</label>
                                </div>
                            </div>
                            <div class="col">
                                <div class="form-check form-check-inline">
                                    <input type="radio" id="atletismo" name="deporte" value="atletismo" class="form-check-input">
                                    <label for="atletismo" class="form-check-label">Atletismo</label>
                                </div>
                            </div>
                        </div>
                        <br>

                        <label style="font-weight: bold;">Nivel de Inglés:</label>                
                        <select id="nivel_ingles" name="nivel_ingles" class="form-select" required>
                            <option value="Ninguno">Ninguno</option>
                            <option value="Bajo">Bajo</option>
                            <option value="Medio">Medio</option>
                            <option value="Alto">Alto</option>
                        </select>
                        <br>

                        <label style="font-weight: bold;">Temas de Interés Favoritos:</label>
                        <div class="container">
                            <div class="row">
                                <div class="col">
                                    <div class="form-check form-check-inline">
                                        <input type="radio" id="television" name="interes" value="television" class="form-check-input"required>
                                        <label for="television" class="form-check-label">Televisión</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-check form-check-inline">
                                        <input type="radio" id="deportes" name="interes" value="deportes" class="form-check-input">
                                        <label for="deportes" class="form-check-label">Deportes</label>
                                    </div>
                                </div>

                                <div class="col">
                                    <div class="form-check form-check-inline">
                                        <input type="radio" id="musica" name="interes" value="musica" class="form-check-input">
                                        <label for="musica" class="form-check-label">Música</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-check form-check-inline">
                                        <input type="radio" id="cocina" name="interes" value="cocina" class="form-check-input">
                                        <label for="cocina" class="form-check-label">Cocina</label>
                                    </div>
                                </div>

                                <div class="col">
                                    <div class="form-check form-check-inline">
                                        <input type="radio" id="tecnologia" name="interes" value="tecnologia" class="form-check-input">
                                        <label for="tecnologia" class="form-check-label">Tecnología</label>
                                    </div>
                                </div>

                            </div>
                        </div>

                        <br>
                        <!-- ENVIA ESTO AL SERVLET -->
                        <div class="text-center">
                            <input type="submit" value="Enviar" class="btn btn-primary mt-3">
                        </div>

                    </form>
                </div>
            </div>
            <!-- Script de JavaScript para mostrar el alert con los datos -->
           
            <!-- Agregar el CDN de Bootstrap 5.0 (scripts) -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
            <!-- Scripts -->
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
        </div>
    </body>
</html>