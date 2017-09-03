/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static timetable.SelectionController.selected_file;

/**
 * FXML Controller class
 *
 * @author Vika$h
 */
public class Sec1Controller implements Initializable {

    @FXML
    private TableView<Data> TimeTable;
    @FXML
    private TableColumn<Data, String> Day;
    @FXML
    private TableColumn<Data, String> slot1;
    @FXML
    private TableColumn<Data, String> slot2;
    @FXML
    private TableColumn<Data, String> slot3;
    @FXML
    private TableColumn<Data, String> slot4;
    @FXML
    private TableColumn<Data, String> lab;
   @FXML
    private Button home;

    @FXML
    private Button back;

    @FXML
    private Text year;
    @FXML
    private Button print;

    @FXML
    private Text sec;
    
    /**
     * Initializes the controller class.
     */
    
    ObservableList<Data> list = FXCollections.observableArrayList();
    
 //   public static ObservableList<Data> lst = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sec.setText(Integer.toString(SecondController.sec+1));
        year.setText(Integer.toString(FirstController.batch+1));
        

        list.clear();
        Day.setCellValueFactory(new PropertyValueFactory<Data, String>("a"));
        slot1.setCellValueFactory(new PropertyValueFactory<Data, String>("b"));

        slot2.setCellValueFactory(new PropertyValueFactory<Data, String>("c"));
        slot3.setCellValueFactory(new PropertyValueFactory<Data, String>("d"));
        slot4.setCellValueFactory(new PropertyValueFactory<Data, String>("e"));
        lab.setCellValueFactory(new PropertyValueFactory<Data, String>("f"));

        Data qq = new Data("Monday", "sub1", "sub2", "sub3", "sub4", "lab");
        this.go();
        TimeTable.setItems(list);
      
        
        
                home.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                        runbat q=new runbat();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("first.fxml"));
                        
                        System.out.println("dssff");
                        
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        System.out.println(root1);
                        stage.setScene(new Scene(root1));
                        System.out.println("dsf");
                        stage.show();
                        Stage stage5;
                        stage5 = (Stage)home.getScene().getWindow();
                        stage5.close();
                    } catch (IOException ex) {
                    }
                

                
            }

        });
                
                
                 back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                        runbat q=new runbat();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("second.fxml"));
                        
                        System.out.println("dssff");
                        
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        System.out.println(root1);
                        stage.setScene(new Scene(root1));
                        System.out.println("dsf");
                        stage.show();
                        Stage stage5;
                        stage5 = (Stage)back.getScene().getWindow();
                        stage5.close();
                    } catch (IOException ex) {
                    }
                

                
            }

        });
                 
                 
                 
                 
                print.setOnAction(new EventHandler<ActionEvent>() {
                    
                    

            @Override
            public void handle(ActionEvent event) {
                
                
               
            }

        });
                
    }
    
    public void go() {
        int no = (SecondController.sec)+FirstController.batch*3;
        String fileName = "test"+no+".txt";
        String line = "null";
        System.out.println("In Sec1");
      
        try {

            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringTokenizer st = new StringTokenizer(line);
            while ((line = bufferedReader.readLine()) != null) {
                String[] a = new String[6];
                int count = 0;
                st = new StringTokenizer(line, ";");
                while(st.hasMoreTokens()){
                      String s = st.nextToken();
                      if(s.equals("$"))
                          s=" ";
                      
                      a[count++]=s;
                    //  System.out.println(s);
                  }
                    
              list.add(new Data(a[0],a[1],a[2],"TEA BREAK",a[3],a[4]));
            }
        } catch (Exception e) {

        }
    }
}