package main;

import util.Moneda;

import javax.swing.*;

public class Inicio {
    public static void main(String[] args) {
        int streamPrograma = 0;
        do {
            Moneda[] items = crearMonedas();
            Moneda[] seleccionMonedas = elegirMonedas(items);
            double cantidadConvertir = getCantidad();
            double cantidadConvertida = convetir(seleccionMonedas[0], seleccionMonedas[1], cantidadConvertir);
            JOptionPane.showMessageDialog(null, cantidadConvertir + " " + seleccionMonedas[0].getNombre() + " Son: " + cantidadConvertida + " " + seleccionMonedas[1].getNombre());
            streamPrograma = JOptionPane.showOptionDialog(null, "Desea continuar", "Desea continuar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        } while (streamPrograma == 0);
        finPrograma();
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
        int result = JOptionPane.showOptionDialog(null, panel, "Seleccionar Item", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
        if (result == JOptionPane.OK_OPTION) {
            Moneda[] monedas = {(Moneda) monedaFuente.getSelectedItem(), (Moneda) monedaConversion.getSelectedItem()};
            return monedas;

        } else {
            finPrograma();
            return null;
        }
    }

    private static double getCantidad() {
        boolean error = false;
        String cantidadConvertir = "";
        do {
            cantidadConvertir = JOptionPane.showInputDialog("Ingrese la cantidad a convertir");
            if (validarNumero(cantidadConvertir)) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar numeros", "Error de converion", JOptionPane.ERROR_MESSAGE);
                error = true;
            }

        } while (error);
        return Double.parseDouble(cantidadConvertir);
    }

    private static double convetir(Moneda monedaFuente, Moneda monedaConversion, double cantidad) {

        return Math.round(((cantidad * monedaFuente.getDolarValor()) / (monedaConversion.getDolarValor())) * 100.0) / 100.0;
    }

    private static void finPrograma() {
        JOptionPane.showMessageDialog(null, "Programa finalizado", "Fin del programa", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

}
