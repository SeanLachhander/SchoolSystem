package loginapp;

import Admin.AdminController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import students.StudentsController;

import java.io.IOException;
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
    @FXML
    private Label loginStatus;


    public void initialize(URL url, ResourceBundle rb){
        if(this.loginModel.isDatabaseConnected()){
            this.dbstatus.setText("Connected to Database");
        }
        else{
            this.dbstatus.setText("Not Connected to Database");
        }

        this.combobox.setItems(FXCollections.observableArrayList(option.values()));
    }

    @FXML
    public void Login(ActionEvent event){
        try{
            if(this.loginModel.isLogin(this.username.getText(), this.password.getText(), ((option)this.combobox.getValue()).toString())){
                Stage stage = (Stage)this.loginButton.getScene().getWindow();
                stage.close();
                switch(((option)this.combox.getValue()).toString()){
                    case "Admin":
                        adminLogin();
                        break;
                    case "Student":
                        studentLogin();
                        break;
                }
            }
            else{
                    this.loginStatus.setText("Wrong Credentials");
            }
        }
        catch(Exception localException){

        }
    }

    public void studentLogin(){
        try{
            Stage userstage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/students/studentFXML.fxml").openStream());


            StudentsController studentsController = (StudentsController)loader.getController();

            Scene scene = new Scene(root);
            userstage.setScene(scene);
            userstage.setTitle("Student Dashboard");
            userstage.setResizable(false);
            userstage.show();

        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void adminLogin(){
        try{
            Stage adminStage = new Stage();
            FXMLLoader adminLoader = new FXMLLoader();
            Pane adminroot = (Pane)adminLoader.load(getClass().getResource("/Admin/Admin.fxml").openStream());
            AdminController adminController = (AdminController)adminLoader.getController();

            Scene scene = new Scene(adminroot);

            adminStage.setScene(scene);
            adminStage.setTitle("Admin Dashboard");

            adminStage.setResizable(false);
            adminStage.show();

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}





















