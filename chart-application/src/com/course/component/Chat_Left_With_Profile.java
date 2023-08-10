
package com.course.component;

import java.awt.Color;
import javax.swing.Icon;


public class Chat_Left_With_Profile extends javax.swing.JLayeredPane {

  
    public Chat_Left_With_Profile() {
        initComponents();
        txt.setBackground(new Color(242,242,242));
    }
    public void setUserProfile(String user){
    txt.setUserProfile(user);
    }
    public void setImageProfile(Icon image){
        Iaimage.setImage(image);
    }
public void setText(String text){
    if(text.equals("")){
        txt.hideText();
    }else{
    txt.setText(text);
    }
}
public void setImage(Icon ...image){
    txt.setImage(false, image);
    }
public void setImage(String ...image){
    txt.setImage(false, image);
    }
    
public void setFile(String fileName, String fileSize){
    txt.setFile(fileName, fileSize);
}

public void setTime(){
txt.setTime("10:30PM");
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        Iaimage = new com.course.swing.ImageAvatar();
        txt = new com.course.component.Chat_Item();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        Iaimage.setBorderSize(0);
        Iaimage.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/course/icon/testing/Image.JPG"))); // NOI18N
        Iaimage.setMaximumSize(new java.awt.Dimension(31, 31));
        Iaimage.setMinimumSize(new java.awt.Dimension(31, 31));

        jLayeredPane1.setLayer(Iaimage, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Iaimage, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Iaimage, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        add(jLayeredPane1);
        add(txt);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.course.swing.ImageAvatar Iaimage;
    private javax.swing.JLayeredPane jLayeredPane1;
    private com.course.component.Chat_Item txt;
    // End of variables declaration//GEN-END:variables
}
