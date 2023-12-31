
package com.course.service;
import com.course.event.PublicEvent;
import com.course.model.Model_Receive_Message;
import com.course.model.Model_Send_Message;
import com.course.model.Model_User_Account;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class Service {

    private static Service instance;
    private Socket client;
    private final int PORT_NUMBER = 9999;
    private final String IP = "localhost";
    private Model_User_Account user;
    private  List<Model_Send_Message> messages = new ArrayList<>();

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    private Service() {
    }

    public void startServer() {
        try {
            client = IO.socket("http://" + IP + ":" + PORT_NUMBER);
            client.on("list_user", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    //  list user
                    List<Model_User_Account> users = new ArrayList<>();
                    for (Object o : os) {
                        Model_User_Account u = new Model_User_Account(o);
                        if (u.getUserID() != user.getUserID()) {
                            users.add(u);
                        }
                    }
                    PublicEvent.getInstance().getEventMenuLeft().newUser(users);
                }
            });
            client.on("user_status", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    int userID = (Integer) os[0];
                    boolean status = (Boolean) os[1];
                    if (status) {
                        //  connect
                        PublicEvent.getInstance().getEventMenuLeft().userConnect(userID);
                    } else {
                        //  disconnect
                        PublicEvent.getInstance().getEventMenuLeft().userDisconnect(userID);
                    }
                }
            });
            client.on("receive_ms", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    Model_Receive_Message message = new Model_Receive_Message(os[0]);
                    PublicEvent.getInstance().getEventChat().receiveMessage(message);
                }
            });
            client.on("list_message",new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    for (Object o : os) {
                        Model_Send_Message msg = new Model_Send_Message(o);
                        messages.add(msg);
                    }
                        PublicEvent.getInstance().getEventChat().selectedUserLoad(messages);
                       // PublicEvent.getInstance().getEventMain().selectFind(messages);
                }
            });
            client.on("find_message",new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    for (Object o : os) {
                        Model_Send_Message msg = new Model_Send_Message(o);
                        messages.add(msg);
                        
                       
                    }
                       PublicEvent.getInstance().getEventFind().StartFind(messages);
// PublicEvent.getInstance().getEventChat().selectedUserLoad(messages);
                        //PublicEvent.getInstance().getEventMain().selectFind(messages);
//                        PublicEvent.getInstance().getEventFind().findByMessage(messages);
  //                      PublicEvent.getInstance().getEventFind().findByUserName(messages);
                }
                        
            });
            
            
            
            client.open();
        } catch (URISyntaxException e) {
            error(e);
        }
         
       
    
    }
    

    public Socket getClient() {
        return client;
    }

    public Model_User_Account getUser() {
        return user;
    }

    public void setUser(Model_User_Account user) {
        this.user = user;
    }

    private void error(Exception e) {
        System.err.println(e);
    }
}



          