
package com.course.connection;
import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConnection {

    
    private static DataBaseConnection instance;
    private  Connection connection;
    
    public static DataBaseConnection getInstance(){
        if(instance==null){
            instance=new DataBaseConnection();
        }
        return instance;
    }
    
    private DataBaseConnection(){
    }
    public void connectToDataBase() throws SQLException{
        String server= "localhost";
        String port= "3305";
        String database ="chat_application";
        String userName ="root";
        String password ="root";
        connection =java.sql.DriverManager.getConnection("jdbc:mysql://"+ server+ ":" + port + "/"+database, userName, password);
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


}
