package conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ac_gg_Conexion_bd {

    private Connection con;

    public ac_gg_Conexion_bd() throws ClassNotFoundException {
          try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ac_gg_encuesta","root","");
        } catch(ClassNotFoundException | SQLException e){
            System.err.println("Error"+e);

        }
    }
        public Connection getCon() { 
            return con; 
        }
}
