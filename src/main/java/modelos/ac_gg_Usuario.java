
package modelos;


public class ac_gg_Usuario {
   private int id_usuario;
    private String nombre;
    private String correo;
    private String pass;
    private String rol;

    public ac_gg_Usuario() {
    }

    public ac_gg_Usuario(int id_usuario, String nombre, String correo, String pass,String rol) {
        this.id_usuario= id_usuario;
        this.nombre = nombre;
        this.correo = correo;
        this.pass = pass;
        this.rol=rol;
    }

      public ac_gg_Usuario(String nombre, String correo, String pass) {
        this.nombre = nombre;
        this.correo = correo;
        this.pass = pass;
    }
      
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
}
