import java.util.Scanner;
import java.util.Stack;

public class Metodos {
    private Stack<Object> dispositivosDisponibles;
    private Stack<Prestamo> préstamosRealizados;

    public Metodos() {
        this.dispositivosDisponibles = new Stack<>();
        this.préstamosRealizados = new Stack<>();
    }

    public void agregarDispositivo(Object dispositivo) {
        dispositivosDisponibles.push(dispositivo);
    }

public void prestarDispositivo(String nombreEstudiante, String carnet, Scanner scanner) {
        if (!dispositivosDisponibles.isEmpty()) {
            System.out.println("Dispositivos disponibles:");
            Stack<Object> dispositivosAuxiliar = new Stack<>();
            int contador = 1;

            for (Object dispositivo : dispositivosDisponibles) {
                if (dispositivo instanceof PC && ((PC) dispositivo).isDisponible()) {
                    System.out.println(contador + ". " + ((PC) dispositivo).getTipo() + " - Marca: " + ((PC) dispositivo).getMarca());
                    dispositivosAuxiliar.push(dispositivo);
                    contador++;
                } else if (dispositivo instanceof Tablets && ((Tablets) dispositivo).isDisponible()) {
                    System.out.println(contador + ". " + ((Tablets) dispositivo).getTipo() + " - Marca: " + ((Tablets) dispositivo).getMarca());
                    dispositivosAuxiliar.push(dispositivo);
                    contador++;
                }
            }

            if (dispositivosAuxiliar.isEmpty()) {
                System.out.println("No hay dispositivos disponibles para préstamo.");
                return;
            }

            System.out.print("Seleccione el número del dispositivo a prestar: ");
            int selección = scanner.nextInt();

            if (selección >= 1 && selección < contador) {
                Object dispositivoSeleccionado = dispositivosAuxiliar.get(selección - 1);
                Prestamo prestamo = new Prestamo(nombreEstudiante, carnet, dispositivoSeleccionado);
                préstamosRealizados.push(prestamo);
                if (dispositivoSeleccionado instanceof PC) {
                    ((PC) dispositivoSeleccionado).setDisponible(false);
                } else if (dispositivoSeleccionado instanceof Tablets) {
                    ((Tablets) dispositivoSeleccionado).setDisponible(false);
                }
                System.out.println("Prestamo realizado con éxito.");

                Stack<Object> nuevaPila = new Stack<>();
                for (Object dispositivo : dispositivosDisponibles) {
                    if (dispositivo != dispositivoSeleccionado) {
                        nuevaPila.push(dispositivo);
                    }
                }
                dispositivosDisponibles = nuevaPila;

            } else {
                System.out.println("Selección inválida.");
            }

        } else {
            System.out.println("No hay dispositivos disponibles para préstamo.");
        }
    }
    public void devolverDispositivo(String carnet) {
        Stack<Prestamo> pilaAuxiliar = new Stack<>();
        boolean encontrado = false;

        while (!préstamosRealizados.isEmpty()) {
            Prestamo préstamo = préstamosRealizados.pop();
            if (préstamo.getCarnet().equals(carnet)) {
                Object dispositivo = préstamo.getDispositivo();
                if (dispositivo instanceof PC) {
                    ((PC) dispositivo).setDisponible(true);
                } else if (dispositivo instanceof Tablets) {
                    ((Tablets) dispositivo).setDisponible(true);
                }
                dispositivosDisponibles.push(dispositivo);
                System.out.println("Dispositivo devuelto con éxito.");
                encontrado = true;
                break;
            } else {
                pilaAuxiliar.push(préstamo);
            }
        }

        while (!pilaAuxiliar.isEmpty()) {
            préstamosRealizados.push(pilaAuxiliar.pop());
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún préstamo para el carnet especificado.");
        }
    }

    public void mostrarInventario() {
        System.out.println("Inventario de dispositivos:");
        for (Object dispositivo : dispositivosDisponibles) {
            if (dispositivo instanceof PC) {
                PC pc = (PC) dispositivo;
                System.out.println(pc.getTipo() + " - Marca: " + pc.getMarca() + " - Precio: " + pc.getPrecio() + " - Disponible: " + pc.isDisponible());
            } else if (dispositivo instanceof Tablets) {
                Tablets tablet = (Tablets) dispositivo;
                System.out.println(tablet.getTipo() + " - Marca: " + tablet.getMarca() + " - Precio: " + tablet.getPrecio() + " - Disponible: " + tablet.isDisponible());
            }
        }
    }
}