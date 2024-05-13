package hust.soict.globalict.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWTAccumulator extends Frame {
    private final TextField tfInput;
    private final TextField tfOutput;
    private int sum = 0;    // Accumulated sum

    // Constructor
    public AWTAccumulator() {
        setLayout(new GridLayout(2,2));

        add(new Label("Enter a number"));
        tfInput = new TextField(10);
        add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        add(new Label("The accumulated sum is: "));
        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);

        setTitle("AWT Accumulator");
        setSize(350,120);
        setVisible(true);
    }
    private void showErrorDialog() {
        // Create a dialog
        Dialog dialog = new Dialog(this, "Error", true);
        dialog.setLayout(new BorderLayout());

        // Add label with error message
        Label label = new Label("Invalid Integer!!");
        dialog.add(label, BorderLayout.CENTER);

        // Add button to close the dialog
        Button closeButton = new Button("OK");
        closeButton.addActionListener(e -> {
            dialog.dispose(); // Close the dialog
        });

        Panel buttonPanel = new Panel();
        buttonPanel.add(closeButton);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setSize(200, 100);

        // Add window listener to handle window closing event
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose(); // Close the frame
                System.exit(0); // Exit the program
            }
        });
        dialog.setVisible(true);
    }

    private class TFInputListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int numberInput = Integer.parseInt(tfInput.getText());
                sum += numberInput;
                tfInput.setText("");
                tfOutput.setText(sum + "");
            } catch (NumberFormatException exception){
                // Show custom AWT dialog for invalid input
                showErrorDialog();
            }
        }
    }
    public static void main(String[] args){
        new AWTAccumulator();
    }
}
