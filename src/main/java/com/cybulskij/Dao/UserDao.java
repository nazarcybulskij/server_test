package com.cybulskij.Dao;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysql.jdbc.Statement;


import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: NAZAR
 * Date: 03/11/13
 * Time: 12:57
 * To change this template use File | Settings | File Templates.
 */
public class UserDao {
    private   Connection connection=null;

    public UserDao() {
        try {
           Class.forName("com.mysql.jdbc.Driver");
           this.connection= DriverManager.getConnection("jdbc:mysql://ec2-50-19-213-178.compute-1.amazonaws.com:3306/user_test_db","Nazar", "nazar");
            if (connection==null)
            {
                System.out.println("Немає з'єднання з БД!");
                System.exit(0);
            }







        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }




    }
    public ArrayList<User>selectAll () throws SQLException {
        PreparedStatement statement;
       // statement = connection.prepareStatement("DELETE  FROM userandroid;");

        //statement.executeUpdate();



        ArrayList<User> userlist=new ArrayList<User>();

        statement = connection.prepareStatement("SELECT * FROM userandroid;");
        ResultSet res=statement.executeQuery();
        while (res.next())
             userlist.add(new User(res.getString("lastname"), res.getString("firstname")));
        return userlist;



    }

    public void Insert(User user) throws SQLException {
        PreparedStatement statement;
        /*statement = connection.prepareStatement("SELECT * FROM userandroid WHERE lastname=? AND firstname=? ;");
        statement.setString(1,user.getLastName());
        statement.setString(2,user.getFirstName());
        ResultSet res=statement.executeQuery();
        while (res.next()){
            return ;
        } */



        statement = connection.prepareStatement("INSERT INTO userandroid (lastname,firstname) VALUES(?,?);");
        statement.setString(1,user.getLastName());
        statement.setString(2,user.getFirstName());
        statement.executeUpdate();





    }
}
