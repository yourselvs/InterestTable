package model;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class InterestTableGUI extends Application{
	private int years = 1;
	
	@Override
    public void start(Stage primaryStage) {
		int spaceBetweenNodes = 8, verSpaceBetweenNodes = 8, horSpaceBetweenNodes = 8;
		int paneBorderTop = 20, paneBorderRight = 20;
		int paneBorderBottom = 20, paneBorderLeft = 20;
		
		TextArea textBox = new TextArea();
        textBox.setEditable(false);
        textBox.setText("Please enter a principal and rate, then choose an option.");
        
        GridPane gridPane = new GridPane();
		gridPane.setHgap(horSpaceBetweenNodes);
		gridPane.setVgap(verSpaceBetweenNodes);
		gridPane.setPadding(new Insets(paneBorderTop, paneBorderRight, 
					    paneBorderBottom, paneBorderLeft));
		
		Label principalLabel = new Label("Principal: ");
		TextField principal = new TextField("0");
		gridPane.add(principalLabel, 0, 0);
		gridPane.add(principal, 1, 0);
				
		Label rateLabel = new Label("Rate: ");
		TextField rate = new TextField("0");
		gridPane.add(rateLabel, 2, 0);
		gridPane.add(rate, 3, 0);
        
		Label yearLabel = new Label("Years: 1");
		Slider horizontalSlider = new Slider();
		horizontalSlider.setMin(1);
		horizontalSlider.setMax(25);
		horizontalSlider.setValue(1);
		horizontalSlider.setMajorTickUnit(5);
		horizontalSlider.setMinorTickCount(4);
		horizontalSlider.setMinWidth(380);
		horizontalSlider.setShowTickMarks(true);
		horizontalSlider.setShowTickLabels(true);
		/* Setting the listener */ 
		horizontalSlider.setSnapToTicks(true);
		horizontalSlider.valueProperty().addListener(e -> {
				years = (int) horizontalSlider.getValue();
				yearLabel.setText("Years: " + (int) horizontalSlider.getValue());
			});
		
		GridPane gridPane2 = new GridPane();
		gridPane2.setHgap(horSpaceBetweenNodes);
		gridPane2.setVgap(verSpaceBetweenNodes);
		gridPane2.setPadding(new Insets(paneBorderTop, paneBorderRight, 
					    paneBorderBottom, paneBorderLeft));
		
		gridPane2.add(gridPane, 0, 0);
		gridPane2.add(horizontalSlider, 0, 1);
		gridPane2.add(yearLabel, 0, 2);
		
		HBox hboxPane = new HBox(spaceBetweenNodes);
		hboxPane.setPadding(new Insets(paneBorderTop, paneBorderRight, 
					    paneBorderBottom, paneBorderLeft));
		
        Button simpleInterestBtn = new Button();
        simpleInterestBtn.setText("Simple Interest");
        simpleInterestBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	try {
            	double principalVal = Double.parseDouble(principal.getText());
            	double rateVal = Double.parseDouble(rate.getText());
                InterestTable table = new InterestTable(principalVal, 
                		rateVal, 
                		years);
                
                textBox.setText(table.simpleInterest());
            	}catch (Exception e){
            		textBox.setText("ERROR\nYou must enter a number in both fields.");
            	}
            }
        });
        hboxPane.getChildren().add(simpleInterestBtn);
        
        Button compoundInterestBtn = new Button();
        compoundInterestBtn.setText("Compound Interest");
        compoundInterestBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	try {
	            	double principalVal = Double.parseDouble(principal.getText());
	            	double rateVal = Double.parseDouble(rate.getText());
	                InterestTable table = new InterestTable(principalVal, 
	                		rateVal, 
	                		years);
	                
	                textBox.setText(table.compoundInterest());
	            }catch (Exception e){
	        		textBox.setText("ERROR\nYou must enter a number in both fields.");
	        	}
            }
        });
        hboxPane.getChildren().add(compoundInterestBtn);
        
        Button bothInterestBtn = new Button();
        bothInterestBtn.setText("Both Interests");
        bothInterestBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	try {
	            	double principalVal = Double.parseDouble(principal.getText());
	            	double rateVal = Double.parseDouble(rate.getText());
	                InterestTable table = new InterestTable(principalVal, 
	                		rateVal, 
	                		years);
	                
	                textBox.setText(table.bothInterest());
	            }catch (Exception e){
	        		textBox.setText("ERROR\nYou must enter a number in both fields.");
	        	}
            }
        });
        hboxPane.getChildren().add(bothInterestBtn);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(hboxPane);
        borderPane.setCenter(gridPane2);
        borderPane.setTop(textBox);
        
        Scene scene = new Scene(borderPane, 473, 408);

        primaryStage.setTitle("Interest Calculator");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	public static void main(String[] args) {
        launch(args);
    }

}
