
package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.ac_gg_Encuesta;
import modelosDAO.ac_gg_EncuestaDAO;

@WebServlet(name = "ac_gg_AdminController", urlPatterns = {"/ac_gg_AdminController"})
public class ac_gg_AdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        try {
            ac_gg_EncuestaDAO encuestaDAO = new ac_gg_EncuestaDAO();
            List<ac_gg_Encuesta> encuestaL = encuestaDAO.VerEncuestaAdmin();
            request.setAttribute("consulta", encuestaL);
            // Reenviar la solicitud a la página JSP
            request.getRequestDispatcher("./VistaAdmin/perfil_admin.jsp").forward(request, response);
        } catch (IOException | ClassNotFoundException | ServletException e) {
            System.out.println("Error en el método doGet: " + e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
