import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JTextField zaehler1;
    private JTextField nenner1;
    private JComboBox arithmetischeOperatoren;
    private JTextField zaehler2;
    private JTextField nenner2;
    private JPanel Calculator;
    private JButton equalsBtn;
    private JButton resetBtn;

    public Calculator() {
        equalsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String zaehler1Txt = zaehler1.getText();
                String nenner1Txt = nenner1.getText();
                String zaehler2Txt = zaehler2.getText();
                String nenner2Txt = nenner2.getText();

                int operator = arithmetischeOperatoren.getSelectedIndex();
                try {
                    int zaehler1 = Integer.parseInt(zaehler1Txt);
                    int nenner1 = Integer.parseInt(nenner1Txt);
                    int zaehler2 = Integer.parseInt(zaehler2Txt);
                    int nenner2 = Integer.parseInt(nenner2Txt);

                    if(nenner1 == 0 || nenner2 == 0) {
                        JOptionPane.showMessageDialog(Calculator,
                                "Nenner duerfen nicht null sein.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                    // Bruchzahlen generieren
                    Bruchzahlen bruch1 = new Bruchzahlen(zaehler1, nenner1);
                    Bruchzahlen bruch2 = new Bruchzahlen(zaehler2, nenner2);

                    Bruchzahlen ergebnis;
                    switch(operator) {
                        case 0:
                            ergebnis = bruch1.add(bruch2);
                            ergebnis.kuerzen();
                            JOptionPane.showMessageDialog(Calculator,
                                    "Das Ergebnis ist " + ergebnis
                            );
                            break;

                        case 1:
                            ergebnis = bruch1.sub(bruch2);
                            ergebnis.kuerzen();
                            JOptionPane.showMessageDialog(Calculator,
                                    "Das Ergebnis ist " + ergebnis
                            );
                            break;

                        case 2:
                            ergebnis = bruch1.div(bruch2);
                            ergebnis.kuerzen();
                            JOptionPane.showMessageDialog(Calculator,
                                    "Das Ergebnis ist " + ergebnis
                            );
                            break;

                        case 3:
                            ergebnis = bruch1.mul(bruch2);
                            ergebnis.kuerzen();
                            JOptionPane.showMessageDialog(Calculator,
                                    "Das Ergebnis ist " + ergebnis
                            );
                    }

                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(Calculator,
                            "Bitte Zahlen benutzen.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zaehler1.setText("");
                nenner1.setText("");
                zaehler2.setText("");
                nenner2.setText("");
            }
        });
    }

    static void main() {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("Bruchrechner");
            f.setContentPane(new Calculator().Calculator);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}

