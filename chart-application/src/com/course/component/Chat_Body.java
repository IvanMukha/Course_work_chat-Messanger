package com.course.component;

import com.course.model.Model_Receive_Message;
import com.course.model.Model_Send_Message;
import com.course.swing.ScrollBar;
import java.awt.Adjustable;
import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.sound.midi.Soundbank;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;

public class Chat_Body extends javax.swing.JPanel {

    public Chat_Body() {
        initComponents();
        init();
        
        
        
//         addItemRight("Send a text message to a group of contacts. Include photos, personalize your texts, and track who clicked your links.");
//        addItemLeft("hello\nHi","patay",new ImageIcon(getClass().getResource("/com/course/icon/testing/Image.jpg")),new ImageIcon(getClass().getResource("/com/course/icon/testing/Image.jpg")));
//        addDate("05/05/2020");
//         addItemRight("Send a text message to a group of contacts. Include photos, personalize your texts, and track who clicked your links.");
//       addItemRight("hello\nHi",new ImageIcon(getClass().getResource("/com/course/icon/testing/pic.png")));
//        String img[] ={"LREVWfIUFt$f~VM_X5o0OtRi$kNG" , "L68;Jft700M{00WB?wt79Gay?Hs:"};
//        
//  addItemLeft("your links.","dodick",img);
//
// addItemRight("Send a text message to a group of contacts. Include photos, personalize your texts, and track who clicked your links.");
// addItemRight("Send a text message to a group of contacts. Include photos, personalize your texts, and track who clicked your links.");
//    addItemLeft("hello\nHiSend a text message to a group of contacts. Include photos, pSend a text message to a group of contacts. Include photos, pSend a text message to a group of contacts. Include photos, pSend a text message to a group of contacts. Include photos, p","jskdfjs",new ImageIcon(getClass().getResource("/com/course/icon/testing/pic.png")),new ImageIcon(getClass().getResource("/com/course/icon/testing/pic.png")));
// //addItemLeft("Send a text message to a group of contacts. Include photos, personalize your texts, and track who clicked your links.","dodick",new ImageIcon(getClass().getResource("/com/course/icon/testing/Image.jpg")),new ImageIcon(getClass().getResource("/com/course/icon/testing/Image.jpg")));
// addDate("05/05/2020");       
// addItemLeft("","RO",new ImageIcon(getClass().getResource("/com/course/icon/testing/pic.png")));
//        addItemFile("my file", "data", "my doc.pdf", "100 MB");
//        addItemFileRight("","maksimka.rar", "100 MB");

    }

    private void init() {
        body.setLayout(new MigLayout("fillx", "", "5[]5"));
        sp.setVerticalScrollBar(new ScrollBar());
        sp.getVerticalScrollBar().setBackground(Color.WHITE);
    }

   public void addItemLeft(Model_Receive_Message data) {
        Chat_Left item = new Chat_Left();
        item.setText(data.getText());
        LocalTime time = LocalTime.now(); // получаем текущее локальное время
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm"); // создаем форматтер для часов и минут
        String timeString = time.format(formatter); // преобразуем время в строку в нужном формате
        item.setTime(timeString);
        body.add(item, "wrap, w 100::80%");
        repaint();
        revalidate();
    }
    
   public void LoadItemLeft(Model_Send_Message data){
        Chat_Left item =new Chat_Left();
        item.setText(data.getText());
        item.setTime(data.getDate());
        body.add(item,"wrap ,w 100::80%");
        repaint();
        revalidate();
    
   } 
   public void LoadItemRight(Model_Send_Message data){
   Chat_Right item= new Chat_Right();
   item.setText(data.getText());
       body.add(item,"wrap,w 100::80%");
       repaint();
       revalidate();
   }
   
  public void addItemLeft(String text,String user,String[] image) {
        Chat_Left_With_Profile item = new Chat_Left_With_Profile();
        item.setText(text);
        item.setImage(image);
        item.setTime();
       // item.setUserProfile(user);
        body.add(item, "wrap, w 100::80%");
        //  ::80% set max with 80%
        body.repaint();
        body.revalidate();
    }
  
    public void addItemFile(String text,String user,String fileName,String fileSize) {
        Chat_Left_With_Profile item = new Chat_Left_With_Profile();
        item.setText(text);
        item.setFile(fileName,fileSize);
        item.setTime();
        item.setUserProfile(user);
        body.add(item, "wrap, w 100::80%");
        //  ::80% set max with 80%
        body.repaint();
        body.revalidate();
    }
  
    public void addItemRight(Model_Send_Message data) {
        Chat_Right item = new Chat_Right();
        item.setText(data.getText());
        item.setTime(data.getDate());
        body.add(item, "wrap, al right, w 100::80%");
        //  ::80% set max with 80%
        repaint();
        revalidate();
        
        scrollToBottom();
    }
    
    public void addItemFileRight(String text,String fileName,String fileSize) {
        Chat_Right item = new Chat_Right();
        item.setText(text);
        item.setFile(fileName, fileSize);
        body.add(item, "wrap, al right, w 100::80%");
        //  ::80% set max with 80%
        body.repaint();
        body.revalidate();
    }
    
    public void addDate(String date){
    Chat_Date item =  new Chat_Date();
    item.setDate(date);
    body.add(item,"wrap, al center");
    body.repaint();
    body.revalidate();
    }

    public void clearChat(){
        body.removeAll();
        repaint();
        revalidate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        body = new javax.swing.JPanel();

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        body.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 826, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
        );

        sp.setViewportView(body);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void scrollToBottom() {
    JScrollBar verticalBar = sp.getVerticalScrollBar();
    AdjustmentListener downScroller = new AdjustmentListener() {
        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {
            Adjustable adjustable = e.getAdjustable();
            adjustable.setValue(adjustable.getMaximum());
            verticalBar.removeAdjustmentListener(this);
        }
    };
    verticalBar.addAdjustmentListener(downScroller);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
