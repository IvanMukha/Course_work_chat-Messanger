
package com.course.model;

import com.corundumstudio.socketio.SocketIOClient;


public class Model_Client {

    /**
     * @return the client
     */
    public SocketIOClient getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(SocketIOClient client) {
        this.client = client;
    }

    /**
     * @return the user
     */
    public Model_User_Account getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Model_User_Account user) {
        this.user = user;
    }

    public Model_Client(SocketIOClient client, Model_User_Account user) {
        this.client = client;
        this.user = user;
    }

    
    
    public Model_Client() {
    }
    
    private SocketIOClient client;
    private Model_User_Account user;
}
