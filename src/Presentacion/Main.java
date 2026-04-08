package Presentacion;

import Entidades.AccesoLaboratorio;
import Entidades.Usuario;
import LogicaNegocio.LogicaAcceso;
import LogicaNegocio.LogicaUsuario;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LogicaUsuario logicaUsuario = new LogicaUsuario();
        LogicaAcceso logicaAcceso = new LogicaAcceso();

        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE CONTROL DE ACCESO A LABORATORIO =====");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Consultar usuarios");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Registrar entrada");
            System.out.println("5. Registrar salida");
            System.out.println("6. Historial de accesos por usuario");
            System.out.println("7. Tiempo total dentro del laboratorio");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Ingrese un número válido: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese rol (Estudiante/Docente): ");
                    String rol = scanner.nextLine();

                    if (logicaUsuario.registrarUsuario(id, nombre, rol)) {
                        System.out.println("Usuario registrado correctamente.");
                    } else {
                        System.out.println("No se pudo registrar el usuario. Revise datos incompletos, rol inválido o ID duplicado.");
                    }
                    break;

                case 2:
                    ArrayList<Usuario> usuarios = logicaUsuario.consultarUsuarios();

                    if (usuarios.isEmpty()) {
                        System.out.println("No hay usuarios registrados.");
                    } else {
                        System.out.println("\n--- LISTA DE USUARIOS ---");
                        for (Usuario usuario : usuarios) {
                            System.out.println(usuario);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el ID del usuario a eliminar: ");
                    String idEliminar = scanner.nextLine();

                    if (logicaUsuario.eliminarUsuario(idEliminar)) {
                        System.out.println("Usuario eliminado correctamente.");
                    } else {
                        System.out.println("No se encontró el usuario.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el ID del usuario para registrar entrada: ");
                    String idEntrada = scanner.nextLine();

                    if (logicaAcceso.registrarEntrada(idEntrada)) {
                        System.out.println("Entrada registrada correctamente.");
                    } else {
                        System.out.println("No se pudo registrar la entrada. Verifique que el usuario exista y no tenga una entrada pendiente.");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese el ID del usuario para registrar salida: ");
                    String idSalida = scanner.nextLine();

                    if (logicaAcceso.registrarSalida(idSalida)) {
                        System.out.println("Salida registrada correctamente.");
                    } else {
                        System.out.println("No se pudo registrar la salida. Verifique que exista una entrada previa sin salida.");
                    }
                    break;

                case 6:
                    System.out.print("Ingrese el ID del usuario: ");
                    String idHistorial = scanner.nextLine();

                    ArrayList<AccesoLaboratorio> historial = logicaAcceso.historialPorUsuario(idHistorial);

                    if (historial.isEmpty()) {
                        System.out.println("No hay accesos registrados para ese usuario.");
                    } else {
                        System.out.println("\n--- HISTORIAL DE ACCESOS ---");
                        for (AccesoLaboratorio acceso : historial) {
                            System.out.println(acceso);
                        }
                    }
                    break;

                case 7:
                    System.out.print("Ingrese el ID del usuario: ");
                    String idTiempo = scanner.nextLine();

                    System.out.println("Tiempo total dentro del laboratorio: " 
                            + logicaAcceso.obtenerTiempoFormateado(idTiempo));
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }
}