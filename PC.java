public class PC {
    private String señal;
    private String marca;
    private int memoriaRAM;
    private String discoDuro;
    private double precio;
    private boolean disponible;

    public PC(String señal, String marca, int memoriaRAM, String discoDuro, double precio) {
        this.señal = señal;
        this.marca = marca;
        this.memoriaRAM = memoriaRAM;
        this.discoDuro = discoDuro;
        this.precio = precio;
        this.disponible = true;
    }

    public String getSeñal() {
        return señal;
    }

    public String getMarca() {
        return marca;
    }

    public int getMemoriaRAM() {
        return memoriaRAM;
    }

    public String getDiscoDuro() {
        return discoDuro;
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
        return "PC";
    }
}