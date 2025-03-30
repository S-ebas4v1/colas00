import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Metodos metodos = new Metodos();
        Scanner scanner = new Scanner(System.in);

        int opción;
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar dispositivo");
            System.out.println("2. Prestar dispositivo");
            System.out.println("3. Devolver dispositivo");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            opción = scanner.nextInt();

            switch (opción) {
                case 1:
                    agregarDispositivo(scanner, metodos);
                    break;
                case 2:
                    prestarDispositivo(scanner, metodos);
                    break;
                case 3:
                    devolverDispositivo(scanner, metodos);
                    break;
                case 4:
                    metodos.mostrarInventario();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opción != 5);

        scanner.close();
    }

    public static void agregarDispositivo(Scanner scanner, Metodos metodos) {
        System.out.print("Ingrese el tipo de dispositivo (PC/Tablet): ");
        String tipo = scanner.next();
        if (tipo.equalsIgnoreCase("PC")) {
            System.out.print("Ingrese la señal: ");
            String señal = scanner.next();
            System.out.print("Ingrese la marca: ");
            String marca = scanner.next();
            System.out.print("Ingrese la memoria RAM (GB): ");
            int memoriaRAM = scanner.nextInt();
            System.out.print("Ingrese el disco duro: ");
            String discoDuro = scanner.next();
            System.out.print("Ingrese el precio: ");
            double precio = scanner.nextDouble();
            metodos.agregarDispositivo(new PC(señal, marca, memoriaRAM, discoDuro, precio));
        } else if (tipo.equalsIgnoreCase("Tablet")) {
            System.out.print("Ingrese la marca: ");
            String marca = scanner.next();
            System.out.print("Ingrese el tamaño1: ");
            double tamaño = scanner.nextDouble();
            System.out.print("Ingrese el precio: ");
            double precio = scanner.nextDouble();
            metodos.agregarDispositivo(new Tablets(marca, tamaño, precio));
        } else {
            System.out.println("Tipo de dispositivo inválido.");
        }
    }

    public static void prestarDispositivo(Scanner scanner, Metodos metodos) {
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombreEstudiante = scanner.next();
        System.out.print("Ingrese el carnet del estudiante: ");
        String carnet = scanner.next();
        metodos.prestarDispositivo(nombreEstudiante, carnet, scanner);
    }

    public static void devolverDispositivo(Scanner scanner, Metodos metodos) {
        System.out.print("Ingrese el carnet del estudiante: ");
        String carnet = scanner.next();
        metodos.devolverDispositivo(carnet);
    }
}