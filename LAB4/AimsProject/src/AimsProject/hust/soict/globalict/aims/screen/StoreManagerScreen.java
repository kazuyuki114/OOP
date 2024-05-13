package AimsProject.hust.soict.globalict.aims.screen;

import AimsProject.hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class StoreManagerScreen extends JFrame{
    private Store store;

    JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Option");
        menu.add(new JMenuItem("View store"));
        JMenu smUpdateStore = new JMenu("Update store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("ADD DVD"));
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }
    JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font("JetBrains Mono",Font.PLAIN, 50));
        title.setForeground(Color.CYAN);
        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10,10)));
        return header;
    }

    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }
    public StoreManagerScreen(){
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(),BorderLayout.NORTH);

        setTitle("Store");
        setSize(1024,720);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args){
        new StoreManagerScreen();
    }
}
