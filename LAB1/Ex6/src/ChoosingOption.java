import javax.swing.*;

public class ChoosingOption {
    public static void main(String[] args){
        // 6_1
        String[] reponses = {"I do", "I don't"};
        int option = JOptionPane.showConfirmDialog(null, "Do you want to change the first class ticket", "Kazuyuki",JOptionPane.YES_NO_OPTION);
        JOptionPane.showMessageDialog(null,
                "You've chosen: " + (option == JOptionPane.YES_OPTION?"YES":"NO"));
        System.exit(0);
    }
}
