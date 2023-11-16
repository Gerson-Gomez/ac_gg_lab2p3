<%@page import="java.util.Map"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <title>Grafica ingles</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <jsp:include page="../Plantilla/nav_admin.jsp"></jsp:include>
</head>

<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-lg-8">
                <div class="card">
                    <div class="card-body">
                        <h5>Resumen de la encuesta</h5>
                        <h7>Preguntas:</h7>
                        <h8>Nivel de inglés</h8>
                        <h2 class="card-title mb-4" style="text-align: center">Distribucion por nivel de inglés</h2>
                        <canvas id="graficaNivelIngles" width="400" height="200"></canvas>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%
        Map<String, Double> datosGrafica = (Map<String, Double>) request.getAttribute("datosGrafica");
    %>

    <script>
        var datosGrafica = <%= new Gson().toJson(datosGrafica) %>;

        var ctx = document.getElementById('graficaNivelIngles').getContext('2d');
        var colores = ['rgba(255, 99, 132, 0.2)', 'rgba(54, 162, 235, 0.2)', 'rgba(255, 206, 86, 0.2)', 'rgba(75, 192, 192, 0.2)'];
        var bordes = ['rgba(255, 99, 132, 1)', 'rgba(54, 162, 235, 1)', 'rgba(255, 206, 86, 1)', 'rgba(75, 192, 192, 1)'];

        var grafica = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: Object.keys(datosGrafica),
                datasets: [{
                    label: 'Porcentaje por nivel de inglés',
                    data: Object.values(datosGrafica),
                    backgroundColor: colores,
                    borderColor: bordes,
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true,
                        max: 100
                    }
                }
            }
        });
    </script>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
            crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
            integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
            crossorigin="anonymous"></script>
</body>

</html>
