
package com.course.form;

import com.course.component.Chat_Body;
import com.course.component.Chat_Bottom;
import com.course.component.Chat_Title;
import com.course.event.EventChat;
import com.course.event.EventMain;
import com.course.event.PublicEvent;
import com.course.model.Model_Receive_Message;
import com.course.model.Model_Send_Message;
import com.course.model.Model_User_Account;
import net.miginfocom.swing.MigLayout;
import com.course.form.Find;

import com.course.service.Service;
import java.awt.Event;
import java.util.List;


public class Chat extends javax.swing.JPanel {

    private Chat_Title chatTitle;
    private Chat_Body chatBody;
    private Chat_Bottom chatBottom;

    public Chat() {
        initComponents();
        init();
    }

    private void init() {
        setLayout(new MigLayout("fillx", "0[fill]0", "0[]0[100%, bottom]0[shrink 0]0"));
        chatTitle = new Chat_Title();
        chatBody = new Chat_Body();
        chatBottom = new Chat_Bottom();
        
        PublicEvent.getInstance().addEventChat(new EventChat() {
            @Override
            public void sendMessage(Model_Send_Message data) {
             chatBody.addItemRight(data);
            }

            @Override
            public void receiveMessage(Model_Receive_Message data) {
           if (chatTitle.getUser().getUserID() == data.getFromUserID()) {
                    chatBody.addItemLeft(data);
               }
            
            }

            @Override
            public void selectedUserLoad(List<Model_Send_Message> messages) {
                chatBody.clearChat();
                int i=0;
                
                for(Model_Send_Message d:messages){
                   i++;
                 
                  if(chatTitle.getUser().getUserID()==d.getToUserID()&&Service.getInstance().getUser().getUserID()==d.getFromUserID()){
                     chatBody.addItemRight(d);
                  }
                  if(chatTitle.getUser().getUserID()==d.getFromUserID()&&Service.getInstance().getUser().getUserID()==d.getToUserID()){
                  chatBody.LoadItemLeft(d);
                  }
                 
                  
          
                }
                messages.clear();
            }
        });
        

       
        add(chatTitle, "wrap");
        add(chatBody, "wrap");
        add(chatBottom, "h ::50%");
    };

    public void setUser(Model_User_Account user) {
        chatTitle.setUserName(user);
        chatBottom.setUser(user);
        chatBody.clearChat();
    }

    public void updateUser(Model_User_Account user) {
        chatTitle.updateUser(user);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
