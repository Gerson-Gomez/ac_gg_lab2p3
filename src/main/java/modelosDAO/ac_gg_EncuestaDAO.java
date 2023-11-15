package modelosDAO;

import conector.ac_gg_Conexion_bd;
import modelos.ac_gg_Encuesta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ac_gg_EncuestaDAO {

    private ac_gg_Conexion_bd CN;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public ac_gg_EncuestaDAO() throws ClassNotFoundException {
        CN = new ac_gg_Conexion_bd();
    }

    //insertar encuesta desde vista usuario.
    public boolean insertEncuesta(ac_gg_Encuesta datas) {
        String sql = "INSERT INTO encuesta (id_usuario, nombre, sexo, deportes, nivel_ing, temas_fav) "
                + "VALUES(?,?,?,?,?,?)";
        try {
            con = CN.getCon();
            ps = con.prepareStatement(sql);

            ps.setInt(1, datas.getId_usuario());
            ps.setString(2, datas.getNombre());
            ps.setString(3, datas.getSexo());
            ps.setString(4, datas.getDeportes());
            ps.setString(5, datas.getNivel_ing());
            ps.setString(6, datas.getTemas_fav());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("error de consulta?"+ e);
            return false;
        }
        
    }

}
