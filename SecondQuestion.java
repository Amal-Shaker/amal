/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondquestion;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author rant
 */
public class SecondQuestion extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       String s = "";
       RadioButton f = new RadioButton("Fahrenheit");
       RadioButton c = new RadioButton("kelvin");
        ToggleGroup radioGroup = new ToggleGroup();
      f.setToggleGroup(radioGroup);
      c.setToggleGroup(radioGroup);
       Label str = new Label("Enter Celsius temperature: ");
       Label res = new Label();
       TextArea area = new TextArea(s);
       area.setPrefHeight(20);
       HBox tt = new HBox(15,f,c);
       tt.setAlignment(Pos.CENTER);
       VBox radio = new VBox(10,str,area,tt,res);
       radio.setAlignment(Pos.CENTER);
         f.setOnAction(event ->
      {
          double m = Double.parseDouble(area.getText());
          double u = (m*9/5+32);
          String q = String.valueOf(u);
          res.setText("New Temperature in is: "+q);
       
      });
          c.setOnAction(event ->
      {
          
       double m = Double.parseDouble(area.getText());
          double u = (m+273.15);
          String q = String.valueOf(u);
          res.setText("New Temperature in is: "+q);
      });
        Scene scene = new Scene(radio, 300, 300);
        
        primaryStage.setTitle("Temperature converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
