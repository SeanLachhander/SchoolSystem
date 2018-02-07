package loginapp;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.util.ResourceBundle;

import java.net.URL;

public class LoginController implements Initializable {

    LoginModel loginModel = new LoginModel();

    @FXML
    private Label dbstatus;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox<option> combobox;
    @FXML
    private Button loginButton;


    public void initialize(URL url, ResourceBundle rb){
        if(this.loginModel.isDatabaseConnected()){
            this.dbstatus.setText("Connected to Database");
        }
        else{
            this.dbstatus.setText("Not Connected to Database");
        }

        this.combobox.setItems(FXCollections.observableArrayList(option.values()));
    }

}
