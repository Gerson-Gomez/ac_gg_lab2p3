package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.ac_gg_Usuario;
import modelosDAO.ac_gg_UsuarioDAO;

@WebServlet(name = "ac_gg_UserController", urlPatterns = {"/ac_gg_UserController"})
public class ac_gg_UserController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ac_gg_UsuarioDAO usuario = new ac_gg_UsuarioDAO();
            //no puedes listar uno solo porque necesita parametro.
            
        //    List<ac_gg_Usuario> consulta = ac_gg_UsuarioDAO.ObtenerUsuario("email@mail.com");
        } catch (Exception e) {
        }
        //processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if("update".equals(action)){
            String correo = request.getParameter("correo");
            String nombre = request.getParameter("nombre");
            String pass = request.getParameter("pass");
                       
            try {
                ac_gg_UsuarioDAO usuarioDAO = new ac_gg_UsuarioDAO();
                ac_gg_Usuario user = new ac_gg_Usuario(nombre,correo,pass);
                
                boolean actulaizar = usuarioDAO.ActualizarUser(user);
                if (actulaizar) {
                    response.sendRedirect("index.jsp");
                }else{
                  request.setAttribute("mensajeError", "No se pudo actualizar la venta.");
                }
                
            } catch (Exception e) {
            }
        }
       // processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
