package main;

import util.Moneda;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        Moneda pesoMexico = new Moneda("Peso Mexicano",1);
        Moneda dolar = new Moneda("Dolar",1);
        Moneda euro = new Moneda("Euro",1);
        Moneda yen = new Moneda("Yen",1);

        System.out.println(pesoMexico);
        System.out.println(dolar);
        System.out.println(euro);
        System.out.println(yen);

        Moneda[] items = {pesoMexico,dolar,euro,yen};

        JComboBox<Moneda> comboBox = new JComboBox<>(items);

        int result = JOptionPane.showOptionDialog(null, comboBox, "Seleccionar Item",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        if (result == JOptionPane.OK_OPTION) {
           // String selectedItem = comboBox.getSelectedItem().toString();
            System.out.println("Item seleccionado: " + comboBox.getSelectedItem());
        }

    }
}
