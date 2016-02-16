package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gui.MainMenu;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameModeSelectionController extends CustomController implements Initializable {

	@FXML
	private Pane singlePlayerBtn, multiPlayerBtn;
	
	@FXML
	private void gotoSinglePlayer(MouseEvent event) throws IOException {
		switchScene(event, "fxgraph/SinglePlayer.fxml");
	}
	
	@FXML
	private void gotoMultiPlayer(MouseEvent event) throws IOException {
	    switchScene(event, "fxgraph/Multiplayer.fxml");
		
//		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        AnchorPane gameSelection = (AnchorPane) FXMLLoader.load(MainMenu.class.getResource("fxgraph/GameModeSelection.fxml"));
//		Scene scene = new Scene(gameSelection,700,739);
//		stage.setScene(scene);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
