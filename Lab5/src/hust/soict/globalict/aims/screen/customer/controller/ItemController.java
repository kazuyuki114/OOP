package hust.soict.globalict.aims.screen.customer.controller;

import javax.swing.JOptionPane;

import AimsProject.hust.soict.globalict.aims.cart.Cart;
import AimsProject.hust.soict.globalict.aims.media.Media;
import AimsProject.hust.soict.globalict.aims.media.Playable;
import AimsProject.hust.soict.globalict.aims.media.disc.CompactDisc;
import AimsProject.hust.soict.globalict.aims.media.disc.DigitalVideoDisc;
import AimsProject.hust.soict.globalict.aims.media.disc.Track;
import AimsProject.hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.exception.LimitExceededException;
import hust.soict.globalict.aims.exception.PlayerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
	private Media media;
	private Cart cart;
	private Store store;
    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;
    
    @FXML
    void btnAddToCartClicked(ActionEvent event) throws LimitExceededException {
    	cart.addMedia(media, store);
    }

    @FXML
    void btnPlayClicked(ActionEvent event) throws PlayerException {

        StringBuilder output = new StringBuilder();
        
        if (media instanceof DigitalVideoDisc){
        	DigitalVideoDisc DVD = (DigitalVideoDisc) media;
        	if (DVD.getLength() >= 0) {
                // Create a new information dialog
                Alert dialog = new Alert(AlertType.INFORMATION);

                // Set the dialog title and header text
                dialog.setTitle("Media Player");
                dialog.setHeaderText("You are playing media...");
                
        		output = new StringBuilder("Playing DVD: " + media.getTitle() + "\nLength: " + ((DigitalVideoDisc) media).getLength());
                
        		// Set the dialog content
                dialog.setContentText(output.toString());

                // Show the dialog and wait for the user to click "OK"
                dialog.showAndWait();
        		
        	} else {
            	JOptionPane.showMessageDialog(null, "ERROR: DVD length is non-positive!", "Illegal DVD Length", JOptionPane.WARNING_MESSAGE);
                throw new PlayerException("ERROR: DVD length is non-positive!");
            }
        } else if (media instanceof CompactDisc) {
            output = new StringBuilder("Playing CD: " + media.getTitle() + "\n");
            for (Track track : ((CompactDisc) media).getTracks()) {
            	if (track.getLength() >= 0) {
            		output.append("Track: ").append(track.getTitle()).append(". Length: ").append(track.getLength()).append("\n");
            	} else {
                	JOptionPane.showMessageDialog(null, "ERROR: Track length is non-positive!", "Illegal Track Length", JOptionPane.WARNING_MESSAGE);
                    throw new PlayerException("ERROR: Track length is non-positive!");
            	}
            }
            // Create a new information dialog
            Alert dialog = new Alert(AlertType.INFORMATION);

            // Set the dialog title and header text
            dialog.setTitle("Media Player");
            dialog.setHeaderText("You are playing media...");
    		// Set the dialog content
            dialog.setContentText(output.toString());

            // Show the dialog and wait for the user to click "OK"
            dialog.showAndWait();
        }

    }
    
    public ItemController (Cart cart, Store store) {
    	this.cart = cart;
    	this.store = store;
    }
    
	public void setData(Media media) {
		this.media = media;
		lblTitle.setText(media.getTitle());
		lblCost.setText("$"+ media.getCost());
		if(media instanceof Playable) {
			btnPlay.setVisible(true);
		} else {
			btnPlay.setVisible(false);
			HBox.setMargin(btnAddToCart, new Insets(0 , 0, 0, 60));
		}
	}

}

