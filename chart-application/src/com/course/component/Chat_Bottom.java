
package com.course.component;

import com.course.event.PublicEvent;
import com.course.model.Model_Send_Message;
import com.course.model.Model_User_Account;
import com.course.service.Service;
import com.course.swing.JIMSendTextPane;
import com.course.swing.ScrollBar;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;


public class Chat_Bottom extends javax.swing.JPanel {

    
    public Model_User_Account getUser() {
        return user;
    }

   
    public void setUser(Model_User_Account user) {
        this.user = user;
    }

     private Model_User_Account user;
    public Chat_Bottom() {
        initComponents();
        init();
    }

   private void init(){
       setLayout(new MigLayout("fillx,filly","0[fill]0[]0[]2","2[fill]2"));
       JScrollPane scroll =new JScrollPane();
       scroll.setBorder(null);
       JIMSendTextPane txt= new JIMSendTextPane();
       txt.addKeyListener(new KeyAdapter(){
           @Override
           public void keyTyped(KeyEvent e) {
               refresh();
           }
           
       });
       txt.setBorder(new EmptyBorder(5,5,5,5));
       txt.setHintText("Write Message Here ...");
       scroll.setViewportView(txt);
       ScrollBar sb= new ScrollBar();
       sb.setBackground(new Color(229,229,229));
       sb.setPreferredSize(new Dimension(2,10));
       scroll.setVerticalScrollBar(sb);
       add(sb);
       add(scroll,"w 100%");
       JPanel panel=new JPanel();
       panel.setLayout(new MigLayout("filly","0[]0","0[bottom]0"));
       panel.setPreferredSize(new Dimension(30,28));
       panel.setBackground(Color.WHITE);
       JButton cmd= new JButton();
       cmd.setBorder(null);
       cmd.setContentAreaFilled(false);
       cmd.setCursor(new Cursor(Cursor.HAND_CURSOR) );
       cmd.setIcon(new ImageIcon(getClass().getResource("/com/course/icon/send.png")));
       cmd.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                LocalTime time = LocalTime.now(); // получаем текущее локальное время
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm"); // создаем форматтер для часов и минут
        String timeString = time.format(formatter); // преобразуем время в строку в нужном формате
               String text =  txt.getText().trim();
               if(!text.equals("")){
                  Model_Send_Message message= new Model_Send_Message(Service.getInstance().getUser().getUserID(), user.getUserID(), text, timeString,Service.getInstance().getUser().getUserName());
                  // Model_Send_Message message= new Model_Send_Message(Service.getInstance().getUser().getUserID(),user.getUserID(),text,date);
                   send(message);
                   PublicEvent.getInstance().getEventChat().sendMessage(message);
               txt.setText("");
               txt.grabFocus();
               refresh();
               }else{
                   txt.grabFocus();
               }
           }
       });
       panel.add(cmd);
       add(panel);
       
   }
    private void send(Model_Send_Message data){
        Service.getInstance().getClient().emit("send_to_user", data.toJsonObject());
    }
   
    private void refresh(){
        revalidate();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(229, 229, 229));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
