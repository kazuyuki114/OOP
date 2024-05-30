package hust.soict.globalict.aims.screen.customer.controller;


import java.io.IOException;

import javax.swing.JOptionPane;

import AimsProject.hust.soict.globalict.aims.cart.Cart;
import AimsProject.hust.soict.globalict.aims.media.Media;
import AimsProject.hust.soict.globalict.aims.media.Playable;
import AimsProject.hust.soict.globalict.aims.media.disc.CompactDisc;
import AimsProject.hust.soict.globalict.aims.media.disc.DigitalVideoDisc;
import AimsProject.hust.soict.globalict.aims.media.disc.Track;
import AimsProject.hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.exception.PlayerException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	private Cart cart;
	private Store store;
	
    @FXML
    private TextField tfFilter;
	
    @FXML
    private RadioButton radioBtnFilterTitle;
    
    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;


    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Label costLabel;
    
    @FXML
    private Button btnViewStore;
    
	public CartController(Cart cart, Store store) {
		this.cart = cart;
		this.store = store;
		this.cart.setCartController(this);
	}
    
	@FXML
	public void initialize() {
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		if (cart.getItemOrdered() != null) {
			tblMedia.setItems((ObservableList<Media>) cart.getItemOrdered());
		}
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
				updateButtonBar(newValue);
			}
		});
		
		tfFilter.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				showFilteredMedia(newValue);
			}
			
		});
        setTotalCost(cart.totalCost());
	}
    
    @FXML
    void btnPlaceOrderClicked(ActionEvent event) {
    	System.out.println("GAY");
    	cart.clearItems();
    	System.out.println("GAY");
    }
    
    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();

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

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	try {
			final String STORE_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
			ViewStoreController viewStoreController = new ViewStoreController(store, cart);
			fxmlLoader.setController(viewStoreController);
			Parent root = fxmlLoader.load();
			Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
			primaryStage.setTitle("STORE");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    

	

	void showFilteredMedia(String newValue) {
		
	}
	void updateButtonBar(Media media) {
		if(media == null) {
			btnPlay.setVisible(false);
			btnRemove.setVisible(false);
		} else {
			btnRemove.setVisible(true);
			if(media instanceof Playable) {
				btnPlay.setVisible(true);
			} else {
				btnPlay.setVisible(false);
			}
		}
	}
    public void setTotalCost(float totalCost) {
        costLabel.setText(totalCost + "$");
    }
}
