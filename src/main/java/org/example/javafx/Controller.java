package org.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class Controller {

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private ToggleGroup role;

    @FXML
    private Button validerButton;

    @FXML
    private Button annulerButton;

    @FXML
    private TextArea textArea;

    @FXML
    private void enregistrer() {

        RadioButton selectedRole = (RadioButton) role.getSelectedToggle();
        String roleSelected = selectedRole == null ? "None" : selectedRole.getText();

        System.out.println(selectedRole.getText()+" "+username.getText()+" "+password.getText());
    }

    @FXML
    private void annuler(){
        System.out.println("annuler");
    }

    @FXML
    private void liste(){
        UserDao ud = new UserDao();
        List<User> users = ud.getAllUsers();

        String text="";
        for(User u:users){
            System.out.println(u.toString());
            text += u.getNom()+" - "+u.getEmail()+" "+u.getRole()+ "\n";
        }
        textArea.setText(text);
    }




}
