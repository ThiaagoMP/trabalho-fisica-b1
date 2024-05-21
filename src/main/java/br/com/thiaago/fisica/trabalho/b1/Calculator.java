package br.com.thiaago.fisica.trabalho.b1;

import java.awt.*;
import lombok.Getter;

import javax.swing.*;

@Getter
public class Calculator extends JFrame {


    public Calculator() {
        initComponents();
        btnCalc.addActionListener(event -> {
            try {
                double height = Double.parseDouble(txtHeight.getText());
                double percent = Double.parseDouble(txtPercent.getText()) / 100;
                double gravity = Double.parseDouble(txtGravity.getText());

                double timeEndPercent = calcTimeInFinalPercent(height, percent, gravity);
                double velocityInitFinal = calcVelocityInitEnd(height, percent, gravity);
                double velocityFinal = calcVelocityFinal(height, gravity);

                JOptionPane.showMessageDialog(null,
                        "Tempo para percorrer os últimos " + percent + "% dos segundos da queda: " + String.format("%.2f", timeEndPercent) + " segundos\n" +
                                "Velocidade ao começar os últimos " + percent + "% dos segundos da queda: " + String.format("%.2f", velocityInitFinal) + "\n" +
                                "Velocidade ao atingir o solo: " + String.format("%.2f", velocityFinal));
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Preencha os campos corretamente!");
                this.clear();
            }
        });

        btnClear.addActionListener(event -> clear());
    }

    public static double calcTotalTime(double height, double gravity) {
        return Math.sqrt((2 * height) / gravity);
    }

    public static double calcTimeInFinalPercent(double heightTotal, double percentFinal, double gravity) {
        double heightFinal = heightTotal * percentFinal;
        double heightStartEnd = heightTotal - heightFinal;

        double timeTotal = calcTotalTime(heightTotal, gravity);
        double timeInitEnd = calcTotalTime(heightStartEnd, gravity);

        return timeTotal - timeInitEnd;
    }

    public static double calcVelocityInitEnd(double heightTotal, double percentFinal, double gravity) {
        double heightFinal = heightTotal * percentFinal;
        double heightStartEnd = heightTotal - heightFinal;

        double timeInitFinal = calcTotalTime(heightStartEnd, gravity);

        return gravity * timeInitFinal;
    }

    public static double calcVelocityFinal(double heightTotal, double gravity) {
        double tempoTotal = calcTotalTime(heightTotal, gravity);

        return gravity * tempoTotal;
    }

    private void clear() {
        txtHeight.setText("");
        txtPercent.setText("");
        txtGravity.setText("");
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - unknown
        jPanel = new JPanel();
        lblHeight = new JLabel();
        txtHeight = new JTextField();
        lblPercent = new JLabel();
        txtPercent = new JTextField();
        lblGravity = new JLabel();
        txtGravity = new JTextField();
        btnClear = new JButton();
        btnCalc = new JButton();


        //======== jPanel ========
        {

            jPanel.setAlignmentX(0.5F);
            jPanel.setAutoscrolls(false);
            jPanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
            . swing. border. EmptyBorder( 0, 0, 0, 0) , "", javax. swing
            . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
            Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
            ) ,jPanel. getBorder( )) ); jPanel. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
            public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName (
            ) )) throw new RuntimeException( ); }} );
            jPanel.setLayout(new GridBagLayout());

            //---- lblHeight ----
            lblHeight.setText("Altura total");
            jPanel.add(lblHeight, new GridBagConstraints(0, 0, 2, 1, 0.0, 1.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
            jPanel.add(txtHeight, new GridBagConstraints(2, 0, 10, 1, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 100), 0, 0));

            //---- lblPercent ----
            lblPercent.setText("Porcentagem final");
            jPanel.add(lblPercent, new GridBagConstraints(0, 1, 1, 1, 0.0, 1.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
            jPanel.add(txtPercent, new GridBagConstraints(2, 1, 10, 1, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 100), 0, 0));

            //---- lblGravity ----
            lblGravity.setText("Gravidade");
            jPanel.add(lblGravity, new GridBagConstraints(0, 2, 1, 1, 0.0, 1.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 100), 0, 0));

            //---- txtGravity ----
            txtGravity.setText("");
            jPanel.add(txtGravity, new GridBagConstraints(2, 2, 10, 1, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 100), 0, 0));

            //---- btnClear ----
            btnClear.setText("Limpar");
            jPanel.add(btnClear, new GridBagConstraints(2, 4, 1, 1, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- btnCalc ----
            btnCalc.setText("Calcular");
            jPanel.add(btnCalc, new GridBagConstraints(2, 3, 1, 1, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        }


        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel jPanel;
    private JLabel lblHeight;
    private JTextField txtHeight;
    private JLabel lblPercent;
    private JTextField txtPercent;
    private JLabel lblGravity;
    private JTextField txtGravity;
    private JButton btnClear;
    private JButton btnCalc;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
