package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class registrationController {

    public void changeSceneOnButtonPush(javafx.event.ActionEvent event) throws IOException {
        Parent regs= FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene regsView = new Scene(regs);
        Stage windows = (Stage) ((Node)event.getSource()).getScene().getWindow();
        windows.setScene(regsView);
        windows.show();
    }
}
