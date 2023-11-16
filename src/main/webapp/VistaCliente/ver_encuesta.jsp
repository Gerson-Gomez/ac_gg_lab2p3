<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import ="java.util.List"%>
<%@page import ="modelos.ac_gg_Encuesta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tus datos</title>
         <!-- Enlaces a Bootstrap y otros recursos -->
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        <div class="container mt-5">
            
                        <div class="card-body">
                            <h1 class="card-title mb-4">Información Recolectada</h1>
                            
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
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                        <div class="text-center mt-3">
                            <h5>Gracias por participar en nuestra encuesta!</h5>
                            <a class="btn btn-secondary" aria-current="page" href="./VistaCliente/perfil_cliente.jsp">Volver</a>          
                        </div>

        </div>                   
    </body>
</html>
