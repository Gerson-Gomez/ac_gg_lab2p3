package modelosDAO;

import modelos.ac_gg_Usuario;
import conector.ac_gg_Conexion_bd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;

public class ac_gg_UsuarioDAO {

    private ac_gg_Conexion_bd CN;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public ac_gg_UsuarioDAO() throws ClassNotFoundException {
        CN = new ac_gg_Conexion_bd();
    }

    //recuperar correo y contrasena PARA INICIAR SESSION
    public ac_gg_Usuario ObtenerUsuarios(String mail, String pass){
    ac_gg_Usuario user = null;
    
      String sql = "SELECT id_usuario, nombre, correo, pass, rol FROM usuarios WHERE correo=? AND pass=?";
        try {
            con = CN.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, mail);
            ps.setString(2, pass);
            rs = ps.executeQuery();  
            
             if (rs.next()) {
             user = new ac_gg_Usuario();
//SE PUEDE PEDIR EL ID ACA TAMBIEN 
             user.setId_usuario(rs.getInt("id_usuario"));
             user.setNombre(rs.getString("nombre"));
             user.setCorreo(rs.getString("correo"));
             user.setPass(rs.getString("pass"));
             user.setRol(rs.getString("rol"));
             
             }           
        } catch (SQLException e) {
        }
        return user;
    }
    
//    //Obtener solo ese usuario en base al correo noma
//     public ac_gg_Usuario ObtenerUsuario(String mail){
//    ac_gg_Usuario user = null;
//    
//      String sql = "SELECT * FROM usuarios WHERE correo=?";
//        try {
//            con = CN.getCon();
//            ps = con.prepareStatement(sql);
//            ps.setString(1, mail);            
//            rs = ps.executeQuery();  
//            
//             if (rs.next()) {
//             user = new ac_gg_Usuario();
////SE PUEDE PEDIR EL ID ACA TAMBIEN 
//             user.setId_usuario(rs.getInt("id_usuario"));
//             user.setNombre(rs.getString("nombre"));
//             user.setCorreo(rs.getString("correo"));
//             user.setPass(rs.getString("pass"));
//             user.setRol(rs.getString("rol"));
//             }           
//        } catch (SQLException e) {
//        }
//        return user;
//    }
//    
    
    //Insertar Usuario.    
    public boolean insertUsuario(ac_gg_Usuario usu) {
        String sql = "INSERT INTO usuarios (nombre, correo, pass, rol) "
                + "VALUES (?, ?, ?, ?)";
        try {
            con = CN.getCon();
            ps = con.prepareStatement(sql);

            ps.setString(1, usu.getNombre());
            ps.setString(2, usu.getCorreo());
            ps.setString(3, usu.getPass());
            ps.setString(4, usu.getRol());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error: " + e);
            return false;
        }
    }
    
    //Actualizar info Usuario.
    public boolean ActualizarUser(ac_gg_Usuario user){
    String sql = "UPDATE usuarios SET nombre=?, pass=? WHERE correo=?";
        try {
               con = CN.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getPass());
            ps.setString(3, user.getCorreo());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // validar si existe correo
    public boolean existeCorreo(String correo) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE correo = ?";
        try {
            con = CN.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }

            return false;
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones (puedes personalizarlo según tus necesidades)
            return false;
        } finally {
            // Cerrar recursos
        }
    }

}
