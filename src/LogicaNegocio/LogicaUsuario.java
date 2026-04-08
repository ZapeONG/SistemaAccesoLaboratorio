package LogicaNegocio;

import AccesoDatos.AccesoDatos;
import Entidades.Usuario;
import java.util.ArrayList;

public class LogicaUsuario {

    private final String ARCHIVO_USUARIOS = "usuarios.txt";
    private final AccesoDatos accesoDatos = new AccesoDatos();

    // Registrar usuario
    public boolean registrarUsuario(String id, String nombre, String rol) {

        // Validar datos incompletos
        if (id == null || id.trim().isEmpty()
                || nombre == null || nombre.trim().isEmpty()
                || rol == null || rol.trim().isEmpty()) {
            return false;
        }

        // Validar rol
        if (!rol.equalsIgnoreCase("Estudiante") && !rol.equalsIgnoreCase("Docente")) {
            return false;
        }

        // Validar ID duplicado
        if (buscarUsuarioPorId(id) != null) {
            return false;
        }

        Usuario usuario = new Usuario(id.trim(), nombre.trim(), capitalizarRol(rol.trim()));
        accesoDatos.agregarLinea(ARCHIVO_USUARIOS, usuario.toArchivo());

        return true;
    }

    // Consultar usuarios
    public ArrayList<Usuario> consultarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<String> lineas = accesoDatos.leerArchivo(ARCHIVO_USUARIOS);

        for (String linea : lineas) {
            String[] datos = linea.split(",");

            if (datos.length >= 3) {
                Usuario usuario = new Usuario(datos[0], datos[1], datos[2]);
                usuarios.add(usuario);
            }
        }

        return usuarios;
    }

    // Buscar usuario por ID
    public Usuario buscarUsuarioPorId(String id) {
        ArrayList<Usuario> usuarios = consultarUsuarios();

        for (Usuario usuario : usuarios) {
            if (usuario.getId().equalsIgnoreCase(id)) {
                return usuario;
            }
        }

        return null;
    }

    // Eliminar usuario
    public boolean eliminarUsuario(String id) {
        ArrayList<String> lineas = accesoDatos.leerArchivo(ARCHIVO_USUARIOS);
        ArrayList<String> nuevasLineas = new ArrayList<>();
        boolean eliminado = false;

        for (String linea : lineas) {
            String[] datos = linea.split(",");

            if (datos.length >= 1 && datos[0].equalsIgnoreCase(id)) {
                eliminado = true;
            } else {
                nuevasLineas.add(linea);
            }
        }

        if (eliminado) {
            accesoDatos.escribirArchivo(ARCHIVO_USUARIOS, nuevasLineas);
        }

        return eliminado;
    }

    // Método auxiliar
    private String capitalizarRol(String rol) {
        if (rol.equalsIgnoreCase("estudiante")) {
            return "Estudiante";
        } else {
            return "Docente";
        }
    }
}
