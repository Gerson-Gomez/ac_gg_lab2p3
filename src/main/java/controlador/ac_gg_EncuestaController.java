package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.ac_gg_Encuesta;
import modelosDAO.ac_gg_EncuestaDAO;

@WebServlet(name = "ac_gg_EncuestaController", urlPatterns = {"/ac_gg_EncuestaController"})
public class ac_gg_EncuestaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            try {
                ac_gg_EncuestaDAO encuestaDAO = new ac_gg_EncuestaDAO();

                // Obtener los valores del formulario
                   int id = Integer.parseInt(request.getParameter("id"));                   
                String nombre = request.getParameter("nombree");
                String genero = request.getParameter("genero");
                String deporte = request.getParameter("deporte");
                String nivel_Ingles = request.getParameter("nivel_ingles");
                String interes = request.getParameter("interes");

                // Crear un objeto de la clase Encuesta con los valores obtenidos
                ac_gg_Encuesta encuesta;
                encuesta = new ac_gg_Encuesta(id, nombre , genero, deporte, nivel_Ingles, interes);
                   System.out.println(" "+id);
                // Llamar al método de DAO para insertar la encuesta
                boolean agregado = encuestaDAO.insertEncuesta(encuesta);
                if (agregado) {
                    response.sendRedirect("../index.jsp");
                    System.out.println("SI ENTRO AL IF");
                } else {
                    request.setAttribute("mensajeError", "No se pudo agregar la venta.");
                    System.out.println("error aqui");
                }
            } catch (IOException | ClassNotFoundException e) {
                request.setAttribute("mensajeError", "Hubo un error al procesar la adición de la venta.");
                System.out.println("error aqui 2222");
            }

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}