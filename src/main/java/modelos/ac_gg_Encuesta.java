package modelos;
import java.time.LocalDate;

public class ac_gg_Encuesta {

    private int id_encuesta;
    private int id_usuario;
    private String name;
    private String correo;
    private String sexo;
    private String deportes;
    private String nivel_ing;
    private String temas_fav;
    private LocalDate fecha;

    public ac_gg_Encuesta() {
    }

    public ac_gg_Encuesta(int id_encuesta, int id_usuario, String name, String sexo, String deportes, String nivel_ing, String temas_fav, LocalDate fecha) {
        this.id_encuesta = id_encuesta;
        this.id_usuario = id_usuario;
        this.name = name;        
        this.sexo = sexo;
        this.deportes = deportes;
        this.nivel_ing = nivel_ing;
        this.temas_fav = temas_fav;
        this.fecha = fecha;
    }

    public ac_gg_Encuesta(int id_usuario, String name, String sexo, String deportes, String nivel_ing, String temas_fav, LocalDate fecha) {
        this.id_usuario = id_usuario;
        this.name = name;
        this.sexo = sexo;
        this.deportes = deportes;
        this.nivel_ing = nivel_ing;
        this.temas_fav = temas_fav;
        this.fecha = fecha;
    }

    //Constructor que trae nombre y correo usando un join 
    public ac_gg_Encuesta(int id_encuesta,String name, String correo, String sexo, String deportes, String nivel_ing, String temas_fav, LocalDate fecha) {
         this.id_encuesta = id_encuesta;
        this.name = name;
        this.correo = correo;
        this.sexo = sexo;
        this.deportes = deportes;
        this.nivel_ing = nivel_ing;
        this.temas_fav = temas_fav;
        this.fecha = fecha;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getId_encuesta() {
        return id_encuesta;
    }

    public void setId_encuesta(int id_encuesta) {
        this.id_encuesta = id_encuesta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDeportes() {
        return deportes;
    }

    public void setDeportes(String deportes) {
        this.deportes = deportes;
    }

    public String getNivel_ing() {
        return nivel_ing;
    }

    public void setNivel_ing(String nivel_ing) {
        this.nivel_ing = nivel_ing;
    }

    public String getTemas_fav() {
        return temas_fav;
    }

    public void setTemas_fav(String temas_fav) {
        this.temas_fav = temas_fav;
    }

}
