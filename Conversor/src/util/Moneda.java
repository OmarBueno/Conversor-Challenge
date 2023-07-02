package util;

public class Moneda {

    String nombre;
    double dolarValor;

    public Moneda(String nombre, double dolarValor) {
        this.nombre = nombre;
        this.dolarValor = dolarValor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDolarValor() {
        return dolarValor;
    }

    public void setDolarValor(double dolarValor) {
        this.dolarValor = dolarValor;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
