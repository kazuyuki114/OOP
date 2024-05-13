package hust.soict.globalict.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class SwingAccumulator extends JFrame {
    private final JTextField tfInput;
    private final JTextField tfOutput;
    private int sum = 0;

    public SwingAccumulator(){
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2,2));

        cp.add(new JLabel("Enter an integer: "));

        tfInput = new JTextField(10);
        cp.add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        cp.add(new JLabel("The accumulated sum is: "));
        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        cp.add(tfOutput);

        setTitle("SWING ACCUMULATOR");
        setSize(350,120);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the frame to appear in the center of the screen
        setLocationRelativeTo(null);

        setVisible(true);
    }
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int numberInput = Integer.parseInt(tfInput.getText());
                sum += numberInput;
                tfInput.setText("");
                tfOutput.setText(sum + "");
            } catch (NumberFormatException exception){
                // Show custom AWT dialog for invalid input
                JOptionPane.showMessageDialog(null,"Invalid Integer", "WARNING",JOptionPane.ERROR_MESSAGE);
                tfInput.setText("");
            }
        }
    }


    public static void main(String[] args){
        new SwingAccumulator();
    }
}
