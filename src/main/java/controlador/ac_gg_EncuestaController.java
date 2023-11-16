package controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.ac_gg_Encuesta;
import modelosDAO.ac_gg_EncuestaDAO;

@WebServlet(name = "ac_gg_EncuestaController", urlPatterns = {"/ac_gg_EncuestaController"})
public class ac_gg_EncuestaController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    try {
        // Obtener la sesión
        HttpSession session = request.getSession();
        
        // Obtener el ID de usuario de la sesión
        int id_user = (int) session.getAttribute("id");
        
        // Verificar si el ID de usuario es válido (no null)
        if (id_user != 0) {
            ac_gg_EncuestaDAO encuestaDAO = new ac_gg_EncuestaDAO();
            
            // Utilizar el ID de usuario obtenido de la sesión
            List<ac_gg_Encuesta> encuestaL = encuestaDAO.VerEncuesta(id_user);
            
            // Establecer los resultados en los atributos de la solicitud
            request.setAttribute("consulta", encuestaL);
            
            // Reenviar la solicitud a la página JSP
            request.getRequestDispatcher("./VistaCliente/ver_encuesta.jsp").forward(request, response);
        } else {
            // Manejar el caso donde el ID de usuario es null o 0
            System.out.println("ID de usuario no válido");
        }
    } catch (IOException | ClassNotFoundException | ServletException e) {
        System.out.println("Error en el método doGet: " + e);
    }  
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
                String nombre = request.getParameter("name");
                String genero = request.getParameter("genero");
                String deporte = request.getParameter("deporte");
                String nivel_Ingles = request.getParameter("nivel_ingles");
                String interes = request.getParameter("interes");
                String fecha = request.getParameter("fecha");

                // Crear un objeto de la clase Encuesta con los valores obtenidos
                ac_gg_Encuesta encuesta;
                encuesta = new ac_gg_Encuesta(id, nombre, genero, deporte, nivel_Ingles, interes, LocalDate.now());
                // Llamar al método de DAO para insertar la encuesta
                boolean agregado = encuestaDAO.insertEncuesta(encuesta);
                if (agregado) {
                    response.sendRedirect("./VistaCliente/perfil_cliente.jsp");
                    System.out.println("SI ENTRO AL IF");
                } else {
                    request.setAttribute("mensajeError", "No se pudo agregar la venta.");
                    System.out.println("error aqui, no se hizo xq nombre se va null");
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
