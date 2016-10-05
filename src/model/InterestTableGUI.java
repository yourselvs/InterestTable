package model;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class InterestTableGUI extends Application{
	@Override
    public void start(Stage primaryStage) {
		int spaceBetweenNodes = 8, verSpaceBetweenNodes = 8, horSpaceBetweenNodes = 8;
		int paneBorderTop = 20, paneBorderRight = 20;
		int paneBorderBottom = 20, paneBorderLeft = 20;
		
		HBox hboxPane = new HBox(spaceBetweenNodes);
		hboxPane.setPadding(new Insets(paneBorderTop, paneBorderRight, 
					    paneBorderBottom, paneBorderLeft));
		
        Button simpleInterestBtn = new Button();
        simpleInterestBtn.setText("Simple Interest");
        simpleInterestBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        hboxPane.getChildren().add(simpleInterestBtn);
        
        Button compoundInterestBtn = new Button();
        compoundInterestBtn.setText("Compound Interest");
        compoundInterestBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        hboxPane.getChildren().add(compoundInterestBtn);
        
        Button bothInterestBtn = new Button();
        bothInterestBtn.setText("Both Interests");
        bothInterestBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        hboxPane.getChildren().add(bothInterestBtn);
        
        GridPane gridPane = new GridPane();
		gridPane.setHgap(horSpaceBetweenNodes);
		gridPane.setVgap(verSpaceBetweenNodes);
		gridPane.setPadding(new Insets(paneBorderTop, paneBorderRight, 
					    paneBorderBottom, paneBorderLeft));
		
		Label creditsLabel = new Label("Principal: ");
		TextField credits = new TextField();
		gridPane.add(creditsLabel, 0, 0);
		gridPane.add(credits, 1, 0);
				
		Label costPerCreditLabel = new Label("Rate: ");
		TextField costPerCredit = new TextField();
		gridPane.add(costPerCreditLabel, 0, 1);
		gridPane.add(costPerCredit, 1, 1);
        
        TextArea textBox = new TextArea();
        textBox.setEditable(false);
        textBox.setText("abc");
        
        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(hboxPane);
        borderPane.setCenter(gridPane);
        borderPane.setTop(textBox);
        
        Scene scene = new Scene(borderPane, 600, 400);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	public static void main(String[] args) {
        launch(args);
    }

}
