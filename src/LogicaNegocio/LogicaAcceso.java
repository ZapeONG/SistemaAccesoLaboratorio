package LogicaNegocio;

import AccesoDatos.AccesoDatos;
import Entidades.AccesoLaboratorio;
import Entidades.Usuario;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LogicaAcceso {

    private final String ARCHIVO_ACCESOS = "accesos.txt";
    private final AccesoDatos accesoDatos = new AccesoDatos();
    private final LogicaUsuario logicaUsuario = new LogicaUsuario();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public boolean registrarEntrada(String idUsuario) {
        if (idUsuario == null || idUsuario.trim().isEmpty()) {
            return false;
        }

        Usuario usuario = logicaUsuario.buscarUsuarioPorId(idUsuario);
        if (usuario == null) {
            return false;
        }

        if (tieneEntradaPendiente(idUsuario)) {
            return false;
        }

        String fechaHoraEntrada = LocalDateTime.now().format(formatter);
        AccesoLaboratorio acceso = new AccesoLaboratorio(idUsuario.trim(), fechaHoraEntrada, "");
        accesoDatos.agregarLinea(ARCHIVO_ACCESOS, acceso.toArchivo());

        return true;
    }

    public boolean registrarSalida(String idUsuario) {
        if (idUsuario == null || idUsuario.trim().isEmpty()) {
            return false;
        }

        ArrayList<String> lineas = accesoDatos.leerArchivo(ARCHIVO_ACCESOS);
        boolean actualizado = false;
        String fechaHoraSalida = LocalDateTime.now().format(formatter);

        for (int i = lineas.size() - 1; i >= 0; i--) {
            String[] datos = lineas.get(i).split(",", -1);

            if (datos.length >= 3
                    && datos[0].equalsIgnoreCase(idUsuario)
                    && datos[2].trim().isEmpty()) {

                lineas.set(i, datos[0] + "," + datos[1] + "," + fechaHoraSalida);
                actualizado = true;
                break;
            }
        }

        if (actualizado) {
            accesoDatos.escribirArchivo(ARCHIVO_ACCESOS, lineas);
        }

        return actualizado;
    }

    public boolean tieneEntradaPendiente(String idUsuario) {
        ArrayList<AccesoLaboratorio> accesos = consultarAccesos();

        for (int i = accesos.size() - 1; i >= 0; i--) {
            AccesoLaboratorio acceso = accesos.get(i);

            if (acceso.getIdUsuario().equalsIgnoreCase(idUsuario)
                    && (acceso.getFechaHoraSalida() == null
                    || acceso.getFechaHoraSalida().trim().isEmpty())) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<AccesoLaboratorio> consultarAccesos() {
        ArrayList<AccesoLaboratorio> accesos = new ArrayList<>();
        ArrayList<String> lineas = accesoDatos.leerArchivo(ARCHIVO_ACCESOS);

        for (String linea : lineas) {
            String[] datos = linea.split(",", -1);

            if (datos.length >= 3) {
                AccesoLaboratorio acceso = new AccesoLaboratorio(datos[0], datos[1], datos[2]);
                accesos.add(acceso);
            }
        }

        return accesos;
    }

    public ArrayList<AccesoLaboratorio> historialPorUsuario(String idUsuario) {
        ArrayList<AccesoLaboratorio> historial = new ArrayList<>();
        ArrayList<AccesoLaboratorio> accesos = consultarAccesos();

        for (AccesoLaboratorio acceso : accesos) {
            if (acceso.getIdUsuario().equalsIgnoreCase(idUsuario)) {
                historial.add(acceso);
            }
        }

        return historial;
    }

    public long calcularTiempoTotalMinutos(String idUsuario) {
        ArrayList<AccesoLaboratorio> historial = historialPorUsuario(idUsuario);
        long minutosTotales = 0;

        for (AccesoLaboratorio acceso : historial) {
            if (acceso.getFechaHoraSalida() != null && !acceso.getFechaHoraSalida().trim().isEmpty()) {
                LocalDateTime entrada = LocalDateTime.parse(acceso.getFechaHoraEntrada(), formatter);
                LocalDateTime salida = LocalDateTime.parse(acceso.getFechaHoraSalida(), formatter);

                minutosTotales += Duration.between(entrada, salida).toMinutes();
            }
        }

        return minutosTotales;
    }

    public String obtenerTiempoFormateado(String idUsuario) {
        long minutos = calcularTiempoTotalMinutos(idUsuario);
        long horas = minutos / 60;
        long minutosRestantes = minutos % 60;

        return horas + " hora(s) y " + minutosRestantes + " minuto(s)";
    }
}