package hust.soict.globalict.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGrid extends JFrame {
    private final JButton[] numberButtons = new JButton[10];
    private JButton deleteButton, resetButton;
    private final JTextField textField;

    public NumberGrid(){
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250,50));
        textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        textField.setFont(new Font("JetBrains Mono",Font.PLAIN, 30));
        textField.setEditable(false);
        JPanel buttonsPanel = new JPanel(new GridLayout(4,3));
        addButtons(buttonsPanel);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(textField,BorderLayout.NORTH);
        cp.add(buttonsPanel,BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("NUMBER GRID");
        setSize(250,400);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addButtons(JPanel buttonsPanel) {
        ButtonListener buttonListener = new ButtonListener();
        for (int i = 1; i <= 9; i++){
            numberButtons[i] = new JButton("" + i);
            buttonsPanel.add(numberButtons[i]);
            numberButtons[i].addActionListener(buttonListener);
        }
        deleteButton = new JButton("DEL");
        buttonsPanel.add(deleteButton);
        deleteButton.addActionListener(buttonListener);

        numberButtons[0] = new JButton("0");
        buttonsPanel.add(numberButtons[0]);
        numberButtons[0].addActionListener(buttonListener);

        resetButton = new JButton("RESET");
        buttonsPanel.add(resetButton);
        resetButton.addActionListener(buttonListener);
    }

    public static String removeLastCharacter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, str.length() - 1);
    }

    private class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if(button.charAt(0) >= '0' && button.charAt(0) <= '9'){
                textField.setText(textField.getText() + button);
            } else if(button.equals("DEL")) {
                String temp = textField.getText();
                temp = removeLastCharacter(temp);
                textField.setText(temp);
            } else if(button.equals("RESET")){
                textField.setText("");
            }
        }
    }
    public static void main(String[] args){
        new NumberGrid();
    }
}
