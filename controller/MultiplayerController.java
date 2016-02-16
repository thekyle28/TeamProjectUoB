package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class MultiplayerController extends CustomController implements Initializable{
	@FXML private Pane backBtn, okBtn;
	@FXML private RadioButton easyRBtn, mediumRBtn, hardRBtn, treasureSelectRBtn, treasureRandomRBtn;
	@FXML private ComboBox mapHeight, mapWidth;
	
	@FXML
	private void gotoMultiplayer2(MouseEvent event) throws IOException{
		switchScene(event, "fxgraph/Multiplayer2");
	}
	
	@FXML
	private void gotoGameSelection(MouseEvent event) throws IOException {
		switchScene(event, "fxgraph/GameModeSelection.fxml");
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		EventHandler<MouseEvent> ok = new EventHandler<MouseEvent>() {
			@Override
		    public void handle(MouseEvent event) {
		    	System.out.println("ok");
			}
		};
	}

}
