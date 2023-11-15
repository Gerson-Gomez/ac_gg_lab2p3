package modelos;

public class ac_gg_Encuesta {
   private int id_usuario;
   private String name;
   private String sexo;
   private String deportes;
   private String nivel_ing;
   private String temas_fav;

    public ac_gg_Encuesta(int id_usuario, String name, String sexo, String deportes, String nivel_ing, String temas_fav) {
        this.id_usuario = id_usuario;
        this.name = name;
        this.sexo = sexo;
        this.deportes = deportes;
        this.nivel_ing = nivel_ing;
        this.temas_fav = temas_fav;
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
