package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelosDAO.EncuestaGraficaDAO;

@WebServlet(name = "ControllerDeporteGrafica", urlPatterns = {"/ControllerDeporteGrafica"})
public class ControllerDeporteGrafica extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerDeporteGrafica</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerDeporteGrafica at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EncuestaGraficaDAO encuestaDAO = new EncuestaGraficaDAO();

            Map<String, Double> datosGrafica = encuestaDAO.obtenerDatosGraficaPorDeporte();
            request.setAttribute("datosGrafica", datosGrafica);

            // Redirigir a la página que mostrará la gráfica
            request.getRequestDispatcher("./VistaAdmin/grafica_deporte.jsp").forward(request, response);

        }catch (ClassNotFoundException e) {
        e.printStackTrace();
        // Manejo de la excepción, ajusta según tus necesidades
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener datos para la gráfica");
    }
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
