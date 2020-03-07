/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thefirstques;

import javafx.application.Application;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author rant
 */
public class ThefirstQues extends Application {
       Button btn ;
       ListView<String> names;
        ListView<String> copynames;
        ObservableList s;
          Alert f ;
           
    @Override
    public void start(Stage primaryStage) {
         btn = new Button("Copy>>");
         names = new ListView<>();
         copynames = new ListView<>();       
         names.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);        
           btn.setOnAction((ActionEvent event) ->{ 
               if(event.getSource() == btn){   
                       if(names.getSelectionModel().getSelectedItems().isEmpty()){
                         f = new Alert(Alert.AlertType.ERROR);
                         f.setHeaderText("no item selections");
                           f.show();
                       }else{
                            copynames.getItems().setAll(names.getSelectionModel().getSelectedItems());
                            
               }  }
           });
        HBox rrr = new HBox(10,names,btn,copynames);
        names.setPrefSize(150, 150);
        copynames.setPrefSize(150,150);
        rrr.setAlignment(Pos.CENTER);
        rrr.setPadding(new Insets(20, 20, 180, 20));
        rrr.setStyle("-fx-background-color:lightGray;");
        rrr.setPrefSize(500,500);
    names.getItems().setAll("amal","ansam","nour","rawan");
         Group g = new Group();
        StackPane root = new StackPane();
        g.getChildren().add(rrr);
        Scene scene = new Scene(g, 500, 500);
       
        primaryStage.setTitle("Multiple Selection Lists");
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
