/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forthquestion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author rant
 */
public class ForthQuestion extends Application {  
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, NoSuchAlgorithmException {
 String password = "123456";
       MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest);    
        File file = new File("src/forthquestion/press.data");
        PrintWriter printt = new PrintWriter(file);
        printt.print("ahamed"+myHash);
        printt.close();
 Button add = new Button("Add Student");
add.setStyle("-fx-background-color:#006666;-fx-text-fill:white;");
  Button view = new Button("View Student");
view.setStyle("-fx-background-color:#006666;-fx-text-fill:white;");
VBox vbox = new VBox(10,add,view);
vbox.setAlignment(Pos.CENTER);
Scene later = new Scene(vbox,250,250);

vbox.setStyle("-fx-background-color:gray");
GridPane grid = new GridPane();
grid.setVgap(10);
grid.setAlignment(Pos.CENTER);
Label wel = new Label("Welcome");
wel.setFont(Font.font("Tahoma", FontWeight.BOLD, 22));
grid.add(wel, 0, 0);
Label username = new Label("username:");
grid.add(username, 0, 1);
TextField user = new TextField();
grid.add(user,1, 1);
Label pass = new Label("password:");
grid.add(pass, 0, 2);
PasswordField passf = new  PasswordField();
grid.add(passf, 1, 2);
Button logic = new Button("sign in");
grid.add(logic, 1, 3);
logic.setStyle("-fx-background-color:#006666;-fx-text-fill:white;");
Button exit = new Button("Exit");
grid.add(exit, 1, 3);
exit.setStyle("-fx-background-color:#006666;-fx-text-fill:white;");

GridPane.setHalignment(exit, HPos.RIGHT);
GridPane.setHalignment(logic, HPos.CENTER);
logic.setOnAction(event->{
     MessageDigest gd = null;
     try {
         gd = MessageDigest.getInstance("MD5");
     } catch (NoSuchAlgorithmException ex) {
         Logger.getLogger(ForthQuestion.class.getName()).log(Level.SEVERE, null, ex);
     }
        gd.update((passf.getText()).getBytes());
        byte[] digestt = gd.digest();
        String myHashh = DatatypeConverter.printHexBinary(digestt);
        
     try {
         Scanner s = new Scanner(file);
         while(s.hasNextLine()){
             String line = s.nextLine();
             String w = (user.getText())+ myHashh;
             if(line.equalsIgnoreCase(w))
                  primaryStage.setScene(later);
             
         }
     } catch (FileNotFoundException ex) {
         Logger.getLogger(ForthQuestion.class.getName()).log(Level.SEVERE, null, ex);
     }
   
});
exit.setOnAction(event->{
    primaryStage.close();
});        
        Scene scene = new Scene(grid, 300, 250);
      

         grid.setStyle("-fx-background-color:rgba(120, 120, 120);");
        primaryStage.setTitle("Hello World!");
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
