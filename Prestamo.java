import java.time.LocalDate;

public class Prestamo {
    private String nombreEstudiante;
    private String carnet;
    private Object dispositivo;
    private LocalDate fechaPrestamo;

    public Prestamo(String nombreEstudiante, String carnet, Object dispositivo) {
        this.nombreEstudiante = nombreEstudiante;
        this.carnet = carnet;
        this.dispositivo = dispositivo;
        this.fechaPrestamo = LocalDate.now();
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public String getCarnet() {
        return carnet;
    }

    public Object getDispositivo() {
        return dispositivo;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }
}