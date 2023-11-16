package modelosDAO;

import conector.ac_gg_Conexion_bd;
import modelos.ac_gg_Encuesta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        String sql = "INSERT INTO encuesta (id_usuario, nombre, sexo, deportes, nivel_ing, temas_fav, fecha) "
                + "VALUES(?,?,?,?,?,?,?)";
        try {
            con = CN.getCon();
            ps = con.prepareStatement(sql);

            ps.setInt(1, datas.getId_usuario());
            ps.setString(2, datas.getName());
            ps.setString(3, datas.getSexo());
            ps.setString(4, datas.getDeportes());
            ps.setString(5, datas.getNivel_ing());
            ps.setString(6, datas.getTemas_fav());
            Date fechaSql = Date.valueOf(datas.getFecha());

            // Establece la fecha en la PreparedStatement
            ps.setDate(7, fechaSql);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("error de consulta? " + e);
            return false;
        }

    }

    //Verificar si ya existe la encuesta para no volver a hacerla.    
    public ac_gg_Encuesta obtenerEncuesta(int id) {
        ac_gg_Encuesta encuesta = null;
        String sql = "SELECT * FROM encuesta WHERE id_usuario=?";
        try {
            con = CN.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                encuesta = new ac_gg_Encuesta();
                encuesta.setId_encuesta(rs.getInt("id_encuesta"));
                encuesta.setId_usuario(rs.getInt("id_usuario"));
                encuesta.setName(rs.getString("nombre"));
                encuesta.setSexo(rs.getString("sexo"));
                encuesta.setDeportes(rs.getString("deportes"));
                encuesta.setNivel_ing(rs.getString("nivel_ing"));
                encuesta.setTemas_fav(rs.getString("temas_fav"));
                // Obtiene la fecha de la base de datos como java.sql.Date
                Date fechaSql = rs.getDate("fecha");
                encuesta.setFecha(fechaSql.toLocalDate());

            }
        } catch (SQLException e) {
            System.out.println("ERROR EN PEDIR LA ENCUESTA POR ID: " + e);
        }

        return encuesta;
    }

    //Ver los datos de la encuesta insertada.
    public List<ac_gg_Encuesta> VerEncuesta(int id) {
        List<ac_gg_Encuesta> lista = new ArrayList<>();
        //ac_gg_Encuesta encuesta = new ac_gg_Encuesta();
        String sql = "SELECT e.id_encuesta, u.nombre, u.correo, e.sexo, e.deportes, e.nivel_ing, e.temas_fav, e.fecha "
                + "FROM usuarios u "
                + "JOIN encuesta e ON u.id_usuario = e.id_usuario "
                + "WHERE u.id_usuario = ?";
        try {
            con = CN.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                ac_gg_Encuesta encuestasL = new ac_gg_Encuesta();
                //encuesta = new ac_gg_Encuesta();
                encuestasL.setId_encuesta(rs.getInt("id_encuesta"));
                encuestasL.setName(rs.getString("nombre"));
                encuestasL.setCorreo(rs.getString("correo"));
                encuestasL.setSexo(rs.getString("sexo"));
                encuestasL.setDeportes(rs.getString("deportes"));
                encuestasL.setNivel_ing(rs.getString("nivel_ing"));
                encuestasL.setTemas_fav(rs.getString("temas_fav"));

                Date fechaSql = rs.getDate("fecha");
                encuestasL.setFecha(fechaSql.toLocalDate());
                lista.add(encuestasL);
            }
        } catch (SQLException e) {
            System.out.println("ERROR EN PEDIR LA ENCUESTA POR ID: " + e);
        }
        return lista;
    }

    //Ver los datos de la encuesta insertada.
    public List<ac_gg_Encuesta> VerEncuestaAdmin() {
        List<ac_gg_Encuesta> lista = new ArrayList<>();
        //ac_gg_Encuesta encuesta = new ac_gg_Encuesta();
        String sql = "SELECT e.id_encuesta, u.nombre, u.correo, e.sexo, e.deportes, e.nivel_ing, e.temas_fav, e.fecha "
                + "FROM usuarios u "
                + "JOIN encuesta e ON u.id_usuario = e.id_usuario";
        try {
            con = CN.getCon();
            ps = con.prepareStatement(sql);
            //ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                ac_gg_Encuesta encuestasL = new ac_gg_Encuesta();
                //encuesta = new ac_gg_Encuesta();
                encuestasL.setId_encuesta(rs.getInt("id_encuesta"));
                encuestasL.setName(rs.getString("nombre"));
                encuestasL.setCorreo(rs.getString("correo"));
                encuestasL.setSexo(rs.getString("sexo"));
                encuestasL.setDeportes(rs.getString("deportes"));
                encuestasL.setNivel_ing(rs.getString("nivel_ing"));
                encuestasL.setTemas_fav(rs.getString("temas_fav"));

                Date fechaSql = rs.getDate("fecha");
                encuestasL.setFecha(fechaSql.toLocalDate());
                lista.add(encuestasL);
            }
        } catch (SQLException e) {
            System.out.println("ERROR EN PEDIR LA ENCUESTA POR ID: " + e);
        }
        return lista;
    }

    public List<ac_gg_Encuesta> buscarPorNombreUsuario(String nombreUsuario) {
        List<ac_gg_Encuesta> resultados = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = CN.getCon();
            String query = "SELECT e.id_encuesta, u.nombre, u.correo, e.sexo, e.deportes, e.nivel_ing, e.temas_fav, e.fecha "
                    + "FROM usuarios u "
                    + "JOIN encuesta e ON u.id_usuario = e.id_usuario "
                    + "WHERE u.nombre LIKE ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, "%" + nombreUsuario + "%");

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ac_gg_Encuesta encuestasL = new ac_gg_Encuesta();
                encuestasL.setId_encuesta(resultSet.getInt("id_encuesta"));
                encuestasL.setName(resultSet.getString("nombre"));
                encuestasL.setCorreo(resultSet.getString("correo"));
                encuestasL.setSexo(resultSet.getString("sexo"));
                encuestasL.setDeportes(resultSet.getString("deportes"));
                encuestasL.setNivel_ing(resultSet.getString("nivel_ing"));
                encuestasL.setTemas_fav(resultSet.getString("temas_fav"));

                Date fechaSql = resultSet.getDate("fecha");
                encuestasL.setFecha(fechaSql.toLocalDate());
                resultados.add(encuestasL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return resultados;
    }

    public List<ac_gg_Encuesta> buscarPorFecha(String fechaBusqueda) {
        List<ac_gg_Encuesta> resultados = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = CN.getCon();
            String query = "SELECT e.id_encuesta, u.nombre, u.correo, e.sexo, e.deportes, e.nivel_ing, e.temas_fav, e.fecha "
                    + "FROM usuarios u "
                    + "JOIN encuesta e ON u.id_usuario = e.id_usuario "
                    + "WHERE e.fecha = ?";
            statement = connection.prepareStatement(query);

            // Convierte la fecha de String a LocalDate
            LocalDate fechaLocalDate = LocalDate.parse(fechaBusqueda);
            Date fechaSql = Date.valueOf(fechaLocalDate);

            statement.setDate(1, fechaSql);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ac_gg_Encuesta encuestasL = new ac_gg_Encuesta();
                encuestasL.setId_encuesta(resultSet.getInt("id_encuesta"));
                encuestasL.setName(resultSet.getString("nombre"));
                encuestasL.setCorreo(resultSet.getString("correo"));
                encuestasL.setSexo(resultSet.getString("sexo"));
                encuestasL.setDeportes(resultSet.getString("deportes"));
                encuestasL.setNivel_ing(resultSet.getString("nivel_ing"));
                encuestasL.setTemas_fav(resultSet.getString("temas_fav"));

                Date fechaSqlResultado = resultSet.getDate("fecha");
                encuestasL.setFecha(fechaSqlResultado.toLocalDate());

                resultados.add(encuestasL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return resultados;
    }

    public void eliminarEncuestas(String[] ids) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = CN.getCon();
            String sql = "DELETE FROM encuesta WHERE id_encuesta IN (?)";
            StringBuilder placeholders = new StringBuilder();

            for (int i = 0; i < ids.length; i++) {
                placeholders.append("?");
                if (i < ids.length - 1) {
                    placeholders.append(",");
                }
            }

            sql = sql.replace("?", placeholders.toString());

            ps = con.prepareStatement(sql);

            for (int i = 0; i < ids.length; i++) {
                ps.setString(i + 1, ids[i]);
            }

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {}
    }
}
