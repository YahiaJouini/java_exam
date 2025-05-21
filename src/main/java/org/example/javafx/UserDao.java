package org.example.javafx;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public static List<User> getAllUsers(){
        List<User> liste= new ArrayList<>();
        try{
            Connection con = Connexion.getConnection();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from utilisateurs");

            while(rs.next()){
                User u = new User(
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

    public static void insertUser(User u ){
        try{
            Connection conn = Connexion.getConnection();
            PreparedStatement s = conn.prepareStatement("insert into utilisateurs (nom,email,role) values(?,?,?)");
            s.setString(1,u.getNom());
            s.setString(2,u.getEmail());
            s.setString(3,u.getRole());
            int rs = s.executeUpdate();
            if(rs>0){
                System.out.println("User inserted");
            }else{
                System.out.println("User not inserted");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
