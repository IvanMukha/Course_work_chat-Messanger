
package com.course.service;

import com.course.connection.DataBaseConnection;
import com.course.model.Model_Client;
import com.course.model.Model_Login;
import java.sql.PreparedStatement;
import com.course.model.Model_Message;
import com.course.model.Model_Register;
import com.course.model.Model_Send_Message;
import com.course.model.Model_User_Account;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class ServiceUser {
    
    public ServiceUser(){
    this.con= DataBaseConnection.getInstance().getConnection();
    }
    
    public Model_Message register(Model_Register data){
        //check user exit
        Model_Message message =new Model_Message();
        
        try {
            PreparedStatement p=con.prepareStatement(CHECK_USER);
        p.setString(1, data.getUserName());
        ResultSet r=p.executeQuery();
        if(r.first()){
            message.setAction(false);
            message.setMessage("User Alredy Exit");
        }else{
            message.setAction(true);
        }
        r.close();
        p.close();
        if(message.isAction()){
        //Insert User Register
        con.setAutoCommit(false);
        p=con.prepareStatement(INSERT_USER,PreparedStatement.RETURN_GENERATED_KEYS);
        p.setString(1, data.getUserName());
        p.setString(2,data.getPassword());
        p.execute();
        r=p.getGeneratedKeys();
        r.first();
        int userID=r.getInt(1);
        r.close();
        p.close();
        // create user account
        p=con.prepareStatement(INSERT_USER_ACCOUNT);
        p.setInt(1, userID);
        p.setString(2, data.getUserName());
        p.execute();
        p.close();
        con.commit();
        con.setAutoCommit(true);
        message.setAction(true);
        message.setMessage("OK");
        message.setData(new Model_User_Account(userID, data.getUserName(), "", "", true));
        }
        } catch (SQLException e) {
            message.setAction(false);
            message.setMessage("Server Error");
         
            try {
                if(con.getAutoCommit()==false){
                    con.rollback();
                    con.setAutoCommit(true);
                }
            } catch (SQLException e1) {
                
            }
        }
        return message;
        
    }
    public Model_User_Account login(Model_Login login )throws SQLException{
       Model_User_Account  data=null;
       PreparedStatement p=con.prepareStatement(LOGIN);
       p.setString(1, login.getUserName());
       p.setString(2,login.getPassword());
       ResultSet r=p.executeQuery();
       if(r.first()){
           int userID=r.getInt(1);
           String userName=r.getString(2);
           String gender=r.getString(3);
           String image= r.getString(4);
           data=new Model_User_Account(userID, userName, gender, image, true);
       }
       r.close();
       p.close();
       return data;
    }
   public List<Model_Send_Message>getMessage()throws SQLException{
       
       List<Model_Send_Message> list=new ArrayList<>();
   PreparedStatement p=con.prepareStatement(SELECT_CHAT);
   ResultSet r=p.executeQuery();
   while(r.next()){
   int fromUserID=r.getInt(1);
   int toUserID=r.getInt(2);
   String text=r.getString(3);
   String date=r.getString(4);
   String userName=r.getString(5);
      list.add(new Model_Send_Message(fromUserID, toUserID, text, date,userName));
    
   }
   r.close();
   p.close();
   return list;
   }
    public List<Model_User_Account> getUser (int exitUser)throws SQLException{
        List<Model_User_Account> list=new ArrayList<>();
        PreparedStatement p=con.prepareStatement(SELECT_USER_ACCOUNT);
        p.setInt(1, exitUser);
        ResultSet r=p.executeQuery();
        while(r.next()){
            int userID=r.getInt(1);
            String userName=r.getString(2);
            String gender=r.getString(3);
            String image= r.getString(4);
            
            list.add(new Model_User_Account(userID, userName, gender, image, checkUserStatus(userID)));
        }
        r.close();
        p.close();
        return list;
    }
    
    public Model_Send_Message sendMsgToDb(Model_Send_Message data)throws SQLException{
        try {
           
        PreparedStatement  p=con.prepareStatement(INSERT_CHAT);
        p.setInt(1,data.getFromUserID());
        p.setInt(2,data.getToUserID());
        p.setString(3,data.getText());
        p.setString(4,data.getDate() );
        p.setString(5, data.getUserName());
        p.execute();
        p.close();
        
        
      
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return null;
    }
    
    private boolean checkUserStatus(int userID){
    List<Model_Client> clients=Service.getInstance(null).getListClient();
    for(Model_Client c: clients){
    if( c.getUser().getUserID() == userID) {
        return true;
            }
        }
         return false;
    }
    
    // SQL
    private final String SELECT_CHAT="select fromUserID, toUserID, text, date, userName from `chat` ";
    private final String INSERT_CHAT="INSERT INTO chat(fromUserID, toUserID, text, date, userName) VALUES(?,?,?,?,?)";
    private final String LOGIN = "select UserID, user_account.UserName, Gender, ImageString from `user` join user_account using (UserID) where `user`.UserName=BINARY(?) and `user`.`Password`=BINARY(?) and user_account.`Status`='1'";
    private final String SELECT_USER_ACCOUNT = "select UserID, UserName, Gender, ImageString from user_account where user_account. Status='1' and UserID<>?";
    private final String INSERT_USER = "insert into user (UserName, Password) values (?,?)";
    private final String INSERT_USER_ACCOUNT="insert into user_account(UserID, UserName) values (?,?)";
    private final String CHECK_USER = "select UserID from user where UserName =? limit 1";
    //instance
    private final Connection con;
    
}
