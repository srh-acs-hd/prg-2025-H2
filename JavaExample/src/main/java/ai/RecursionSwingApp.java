package ai;

import javax.swing.*;
import java.awt.*;

public class RecursionSwingApp extends JFrame {
    private JTextField inputField = new JTextField(5);
    private JLabel resultLabel = new JLabel("Result: ");
    private JButton calcButton = new JButton("Calculate Factorial");

    public RecursionSwingApp() {
        setTitle("Recursive Factorial");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Enter N:"));
        add(inputField);
        add(calcButton);
        add(resultLabel);

        calcButton.addActionListener(e -> {
            try {
                int n = Integer.parseInt(inputField.getText());
                if (n < 0) throw new NumberFormatException();
                resultLabel.setText("Result: " + factorial(n));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a non-negative integer.");
            }
        });

        pack();
        setVisible(true);
    }

    // Recursive Method
    private long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RecursionSwingApp::new);
    }
}