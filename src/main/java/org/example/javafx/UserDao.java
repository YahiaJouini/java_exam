package org.example.javafx;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public List<User> getAllUsers(){
        List<User> liste= new ArrayList<>();
        try{
            Connection con = Connexion.getConnection();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from utilisateurs");

            while(rs.next()){
                User u = new User(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("email"),
                        rs.getString("role"));
                liste.add(u);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return liste;
    }
}
