package br.com.thiaago.fisica.trabalho.b1;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setContentPane(calculator.getJPanel());
        calculator.setSize(600,500);
        calculator.setTitle("Calculadora - Queda parafuso");
        calculator.setVisible(true);
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
