package hust.soict.globalict.aims.screen.customer.controller;

import java.io.IOException;

import AimsProject.hust.soict.globalict.aims.cart.Cart;
import AimsProject.hust.soict.globalict.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ViewStoreController {
	private Store store;
	private Cart cart;
    @FXML
    private GridPane gridPane;
    
    public ViewStoreController(Store store, Cart cart) {
    	this.store = store;
    	this.cart = cart;
    }
    
    @FXML
    private Button btnViewCart;

    @FXML
    void btnViewCartPressed(ActionEvent event) {
    	try {
    		System.out.println("GAY");
			final String STORE_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Cart.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
			CartController cartController = new CartController(cart, store);
			fxmlLoader.setController(cartController);
			Parent root = fxmlLoader.load();
			Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
			primaryStage.setTitle("Cart");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    @FXML
    public void initialize() {
    	final String ITEM_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Item.fxml";
    	int column = 0;
    	int row = 1;
    	for (int i = 0; i < store.itemsInStore.size(); i ++) {
    		try {
    			FXMLLoader fxmlLoader = new FXMLLoader();
    			fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));
    			ItemController itemController = new ItemController(cart, store);
    			fxmlLoader.setController(itemController);
    			AnchorPane anchorPane = new AnchorPane();
    			anchorPane = fxmlLoader.load();
    			itemController.setData(store.itemsInStore.get(i));
    			if(column == 3) {
    				column = 0;
    				row++;
    			}
    			gridPane.add(anchorPane, column++, row);
    			GridPane.setMargin(anchorPane, new Insets(20,10,10,10));
    			
    		} catch(IOException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
}
