package main;

import util.Moneda;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        Moneda[] items = crearMonedas();
        Moneda[] seleccionMonedas = elegirMonedas(items);
        if (seleccionMonedas != null) {
            System.out.println(seleccionMonedas[0]);
            System.out.println(seleccionMonedas[1]);
            double cantidadConvertir = getCantidad();
            System.out.println(cantidadConvertir);
            double cantidadConvertida = convetir(seleccionMonedas[0],seleccionMonedas[1],cantidadConvertir);
            System.out.println(cantidadConvertida);
        }

    }

    private static Moneda[] crearMonedas() {
        Moneda pesoMexico = new Moneda("Peso Mexicano", 0.058);
        Moneda dolar = new Moneda("Dolar", 1);
        Moneda euro = new Moneda("Euro", 1.09);
        Moneda yen = new Moneda("Yen", 0.0069);
        Moneda won = new Moneda("Won", 0.00076);
        Moneda libra = new Moneda("Libras esterlinas", 1.27);

        Moneda[] items = {pesoMexico, dolar, euro, yen, won, libra};

        return items;
    }

    private static boolean validarNumero(String numero) {
        // Expresión regular para verificar si la cadena solo contiene números enteros o con punto decimal
        String patron = "^\\d+(\\.\\d+)?$";

        // Comprobar si la cadena coincide con el patrón
        return numero.matches(patron);
    }

    private static Moneda[] elegirMonedas(Moneda[] items) {
        JComboBox<Moneda> monedaFuente = new JComboBox<>(items);
        JComboBox<Moneda> monedaConversion = new JComboBox<>(items);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Convertir de"));
        panel.add(Box.createVerticalStrut(10)); // Agregar un espacio vertical de 10 píxeles
        panel.add(monedaFuente);
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JLabel("Convertir a"));
        panel.add(Box.createVerticalStrut(10));
        panel.add(monedaConversion);
        int result = JOptionPane.showOptionDialog(null, panel, "Seleccionar Item",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        if (result == JOptionPane.OK_OPTION) {
            System.out.println("Moneda fuente: " + monedaFuente.getSelectedItem());
            System.out.println("Moneda convertida: " + monedaConversion.getSelectedItem());
            /*String cantidadConvertir = JOptionPane.showInputDialog("Ingrese la cantidad a convertir");
            if (validarNumero(cantidadConvertir)){
                System.out.println("catidad correcta");
            }*/
            Moneda[] monedas = {(Moneda) monedaFuente.getSelectedItem(), (Moneda) monedaConversion.getSelectedItem()};
            return monedas;

        } else {
            return null;
        }
    }

    public static double getCantidad() {
        String cantidadConvertir = JOptionPane.showInputDialog("Ingrese la cantidad a convertir");
        if (validarNumero(cantidadConvertir)) {
            return Double.parseDouble(cantidadConvertir);
        } else {
            return 0.0;
        }
    }

    public static double convetir(Moneda monedaFuente, Moneda monedaConversion, double cantidad) {
        return (cantidad * monedaFuente.getDolarValor()) / (monedaConversion.getDolarValor());
    }

}
