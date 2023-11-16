package modelosDAO;

import conector.ac_gg_Conexion_bd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EncuestaGraficaDAO {

    private ac_gg_Conexion_bd CN;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public EncuestaGraficaDAO() throws ClassNotFoundException {
        CN = new ac_gg_Conexion_bd();
    }

    public Map<String, Double> obtenerDatosGraficaPorSexo() {
        Map<String, Double> datosGrafica = new HashMap<>();

        try (Connection con = CN.getCon(); PreparedStatement ps = con.prepareStatement("SELECT sexo, (COUNT(*) * 100 / (SELECT COUNT(*) FROM encuesta)) AS porcentaje FROM encuesta GROUP BY sexo"); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String sexo = rs.getString("sexo");
                double porcentaje = rs.getDouble("porcentaje");
                datosGrafica.put(sexo, porcentaje);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return datosGrafica;
    }

    public Map<String, Double> obtenerDatosGraficaPorDeporte() {
        Map<String, Double> datosGrafica = new HashMap<>();

        try (Connection con = CN.getCon(); PreparedStatement ps = con.prepareStatement("SELECT deportes, (COUNT(*) * 100 / (SELECT COUNT(*) FROM encuesta)) AS porcentaje FROM encuesta GROUP BY deportes"); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String deporte = rs.getString("deportes");
                double porcentaje = rs.getDouble("porcentaje");
                datosGrafica.put(deporte, porcentaje);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de la excepción, ajusta según tus necesidades
        }

        return datosGrafica;
    }

    public Map<String, Double> obtenerDatosGraficaPorNivelIngles() {
        Map<String, Double> datosGrafica = new HashMap<>();

        try (Connection con = CN.getCon(); PreparedStatement ps = con.prepareStatement("SELECT nivel_ing, ROUND((COUNT(*) * 100.0 / (SELECT COUNT(*) FROM encuesta)), 2) AS porcentaje FROM encuesta GROUP BY nivel_ing"); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String nivelIngles = rs.getString("nivel_ing");
                double porcentaje = rs.getDouble("porcentaje");
                datosGrafica.put(nivelIngles, porcentaje);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return datosGrafica;
    }

    public Map<String, Double> obtenerDatosGraficaPorTemasFavoritos() {
        Map<String, Double> datosGrafica = new HashMap<>();

        try (Connection con = CN.getCon(); PreparedStatement ps = con.prepareStatement("SELECT temas_fav, ROUND((COUNT(*) * 100.0 / (SELECT COUNT(*) FROM encuesta)), 2) AS porcentaje FROM encuesta GROUP BY temas_fav"); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String temasFavoritos = rs.getString("temas_fav");
                double porcentaje = rs.getDouble("porcentaje");
                datosGrafica.put(temasFavoritos, porcentaje);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de la excepción, ajusta según tus necesidades
        }

        return datosGrafica;
    }

}
