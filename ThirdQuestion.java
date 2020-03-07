/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thirdquestion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 *
 * @author rant
 */
public class ThirdQuestion extends Application  {
      BufferedReader  reader ;
       String str = null;
    public void start(Stage primaryStage) {
       MenuBar menuBar = new MenuBar();
      Menu fileMenu = new Menu("File");
      Menu editMenu = new Menu("Edit");
       MenuItem openItem = new MenuItem("Open");
       MenuItem closeItem = new MenuItem("Close"); 
       MenuItem exitItem = new MenuItem("Exit");
        MenuItem fontItem = new MenuItem("Font");
         MenuItem colorItem = new MenuItem("Color");
      fileMenu.getItems().addAll(openItem,closeItem,exitItem);
      editMenu.getItems().addAll(fontItem,colorItem);
      TextArea h = new TextArea();
      h.setText("hello");
     FileChooser fileChooser = new FileChooser(); 
      exitItem.setOnAction(event ->
      {
         primaryStage.close();
      });
       openItem.setOnAction(event -> {            
                   try {
                         fileChooser.setTitle("Open Text File");
                   fileChooser.setInitialDirectory(new File("."));
                   fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt","*.*"));
                   File selectedFile = fileChooser.showOpenDialog(primaryStage);
                       reader = new BufferedReader(new FileReader(selectedFile));
                       String line = "";
                       String text = "";
                       while((line=reader.readLine()) != null){
                           text +=line +"\n";
                       }
                       h.setText(text);
                       reader.close();
                   } catch (FileNotFoundException ex) {
                       Logger.getLogger(ThirdQuestion.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (IOException ex) {
                       Logger.getLogger(ThirdQuestion.class.getName()).log(Level.SEVERE, null, ex);
                   }
                     h.setEditable(true);    
       });
       closeItem.setOnAction(event ->
      {
        h.setText(" ");
        h.setEditable(false);
      });
       colorItem.setOnAction(event->{
           Dialog<String> dialogColor = new ChoiceDialog<>("Blue",FXCollections.observableArrayList("Red","Blue","Gray","Yellow","Brown","Orange","Green","LightGreen"));
           dialogColor.setHeaderText("Select the color from List");
          dialogColor.setTitle("Color Selection");
          dialogColor.setContentText("Available Colors ");
          String col = dialogColor.showAndWait().get();
          h.setStyle("-fx-text-fill:"+col+";");
       }); 
        fontItem.setOnAction(event->{
           Dialog<String> dialogColor = new ChoiceDialog<>("10",FXCollections.observableArrayList("5","15","20","25","30","35","40"));
           dialogColor.setHeaderText("Select the font from List");
          dialogColor.setTitle("Font Selection");
          dialogColor.setContentText("Available Fonts ");
          String col = dialogColor.showAndWait().get();
          h.setStyle("-fx-font-size:"+col+"pt;");
       
      });
      menuBar.getMenus().addAll(fileMenu,editMenu);
     BorderPane borderPane = new BorderPane();
     borderPane.setTop(menuBar);
     VBox vbox = new VBox(borderPane,h);
        Scene scene = new Scene(vbox, 300, 250);
                primaryStage.setTitle("File View");
        primaryStage.setScene(scene);       
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        launch(args);
    }

   
    
}
