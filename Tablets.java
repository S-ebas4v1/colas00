public class Tablets {
    private String marca;
    private double tamaño;
    private double precio;
    private boolean disponible;

    public Tablets(String marca, double tamaño, double precio) {
        this.marca = marca;
        this.tamaño = tamaño;
        this.precio = precio;
        this.disponible = true;
    }

    public String getMarca() {
        return marca;
    }

    public double getTamaño() {
        return tamaño;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getTipo() {
        return "Tablets";
    }
}
