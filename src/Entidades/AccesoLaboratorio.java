package Entidades;

public class AccesoLaboratorio {
    private String idUsuario, fechaHoraEntrada, fechaHoraSalida;

    public AccesoLaboratorio() {
    }

    public AccesoLaboratorio(String idUsuario, String fechaHoraEntrada, String fechaHoraSalida) {
        this.idUsuario = idUsuario;
        this.fechaHoraEntrada = fechaHoraEntrada;
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }

    public void setFechaHoraEntrada(String fechaHoraEntrada) {
        this.fechaHoraEntrada = fechaHoraEntrada;
    }

    public String getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(String fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    @Override
    public String toString() {
        return "ID Usuario: " + idUsuario
                + " | Entrada: " + fechaHoraEntrada
                + " | Salida: " + (fechaHoraSalida == null || fechaHoraSalida.isEmpty() ? "PENDIENTE" : fechaHoraSalida);
    }

    public String toArchivo() {
        return idUsuario + "," + fechaHoraEntrada + "," + (fechaHoraSalida == null ? "" : fechaHoraSalida);
    }
}