import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	private Button button1, button2, button3, button4, button5;
	private Label label1;
	private TextField text;
	private HBox hbox1, hbox2;
	
	//student Task #4:
	private DataManager dataManager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		
		dataManager = new DataManager(); 
		//student Task #2:
		button1 = new Button("Hello");
		button2 = new Button("Howdy");
		button3 = new Button("Chinese");
		button4 = new Button("Clear");
		button5 = new Button("Exit");
		
		label1 = new Label("Feedback: ");
		text = new TextField();
		hbox1 = new HBox();
		hbox2 = new HBox();
		
		button1.setOnAction(new ButtonHandler());
        button2.setOnAction(new ButtonHandler());
        button3.setOnAction(new ButtonHandler());
        button4.setOnAction(new ButtonHandler());
        button5.setOnAction(new ButtonHandler());
		
		
		
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
		HBox.setMargin(button1, new Insets(10));
	    HBox.setMargin(button2, new Insets(10));
	    HBox.setMargin(button3, new Insets(10));
	    HBox.setMargin(button4, new Insets(10));
	    HBox.setMargin(button5, new Insets(10));

	    hbox1.setAlignment(Pos.CENTER);
	    hbox2.setAlignment(Pos.CENTER);
		
	    //student Task #3:
		hbox2.getChildren().addAll(button1,button2,button3,button4,button5);
		hbox1.getChildren().addAll(label1,text);
		this.getChildren().addAll(hbox1,hbox2);
		
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {
	    @Override
	    public void handle(ActionEvent event) {
	        // Check which button was clicked and perform the corresponding action
	        if (event.getTarget() == button1) {
	            text.setText(dataManager.getHello());
	        } else if (event.getTarget() == button2) {
	            text.setText(dataManager.getHowdy());
	        } else if (event.getTarget() == button3) {
	            text.setText(dataManager.getChinese());
	        } else if (event.getTarget() == button4) {
	            text.setText(""); // Clear the text field
	        } else if (event.getTarget() == button5) {
	            Platform.exit();  // Exit the application
	            System.exit(0);  // Ensure the application terminates
	        }
	    }
	}
}