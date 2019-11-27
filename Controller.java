package sample;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.w3c.dom.events.Event;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class Controller implements Initializable {




    @FXML TextField txtName;

    //Model Object which is Connection Configuration::::::
    ConnectionConfiguration Cgg = new ConnectionConfiguration();
    //table culomns
    @FXML private TableView<user> stTable;
    @FXML private TableColumn<user , String> rollNoCol;
    @FXML private TableColumn<user , String> nameCol;
    @FXML private TableColumn<user , String> fNameCol;
    @FXML private TableColumn<user , String> genderCol;
    @FXML private TableColumn<user , String> emailCol;
    @FXML private TableColumn<user , String> addressCol;

    private ObservableList<user>data;

    @FXML void changeLabel() {
        System.out.println("Button is pressed");

            System.out.println(txtName.getText());
            this.setSt_Table();
    }


    public void setSt_Table() {
        //clear the table items first**
        stTable.getItems().clear();
        //****************************
        ResultSet rs = null;
        try {
            rs = Cgg.PopulateTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while(true)
        {
            try {
                if (!rs.next()) break;
                System.out.println("->"+rs.getString(1));
                user temp = new user(rs.getString(1), rs.getString(2) , rs.getString(3) , rs.getString(4) ,rs.getString(5) , rs.getString(6));
                data.add(temp);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        rollNoCol.setCellValueFactory(new PropertyValueFactory<user, String>("rollNo"));
        nameCol.setCellValueFactory(new PropertyValueFactory<user, String>("name"));
        fNameCol.setCellValueFactory(new PropertyValueFactory<user, String>("fName"));
        genderCol.setCellValueFactory(new PropertyValueFactory<user, String>("gender"));
        emailCol.setCellValueFactory(new PropertyValueFactory<user, String>("email"));
        addressCol.setCellValueFactory(new PropertyValueFactory<user, String>("address"));
        data = FXCollections.observableArrayList();

        stTable.setItems(data);

    }

    //Function to change scene
    public void changeSceneOnButtonPush(javafx.event.ActionEvent event) throws IOException {

        Parent regs = FXMLLoader.load(getClass().getResource("registration.fxml"));
        System.out.println("good good");
        Scene regsView = new Scene(regs);
        Stage windows = (Stage) ((Node)event.getSource()).getScene().getWindow();

        windows.setScene(regsView);
        windows.show();
    }
}
