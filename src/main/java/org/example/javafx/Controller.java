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
        String nom = username.getText();
        String email = password.getText();

        Toggle selectedToggle = role.getSelectedToggle();

        if (selectedToggle == null) {
            System.out.println("Please select a role.");
            return;
        }

        String roleText = ((RadioButton) selectedToggle).getText();
        User newUser = new User( nom, email, roleText);
        UserDao.insertUser(newUser);
    }


    @FXML
    private void annuler(){
        System.out.println("annuler");
    }

    @FXML
    private void liste(){
        List<User> users = UserDao.getAllUsers();

        String text="";
        for(User u:users){
            System.out.println(u.toString());
            text += u.getNom()+" - "+u.getEmail()+" "+u.getRole()+ "\n";
        }
        textArea.setText(text);
    }




}
