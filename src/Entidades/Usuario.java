package Entidades;

public class Usuario {
    private String id, nombre, rol;

    public Usuario() {
    }

    public Usuario(String id, String nombre, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Rol: " + rol;
    }

    public String toArchivo() {
        return id + "," + nombre + "," + rol;
    }
}
