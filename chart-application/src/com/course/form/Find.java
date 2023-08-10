
package com.course.form;

import com.course.event.EventFind;
import com.course.event.PublicEvent;
import com.course.main.Main;
import com.course.model.Model_Send_Message;
import com.course.model.Model_User_Account;
import com.course.service.Service;
import com.course.swing.ScrollBar;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class Find extends javax.swing.JPanel {

//    public Model_User_Account getUser() {
//        return user;
//    }
  

     private List<Model_Send_Message> messages = null;
          public Find(){
              initComponents();
              init();
               
    //          }
          
          }
          public void init(){
               sp.setVerticalScrollBar(new ScrollBar());
        sp.getVerticalScrollBar().setBackground(Color.WHITE); 
              PublicEvent.getInstance().addEventFind(new EventFind() {
                   
                  @Override
                  public void StartFind(List<Model_Send_Message> messages) {
                      Find.this.messages = messages;
                
                  }
              });
              
              
              
          }
          public void findAll(){
          DefaultTableModel model = (DefaultTableModel) findTable.getModel();
          model.setRowCount(0);
          String regex = findField.getText();
          Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
          for (Model_Send_Message message : messages) {
              Matcher userNameMatcher = pattern.matcher(message.getUserName().toLowerCase());
              Matcher textMatcher = pattern.matcher(message.getText().toLowerCase());
              while (userNameMatcher.find() || textMatcher.find()) {
                  Object[] row = {message.getUserName(),message.getDate(), message.getText()};
                  model.addRow(row);
    }
}
          findTable.setModel(model);
          
          }
          public void findByUserName(){
              DefaultTableModel model = (DefaultTableModel) findTable.getModel();
              model.setRowCount(0);
              String regex=findField.getText();
              Pattern pattern = Pattern.compile(regex);
               for (Model_Send_Message message : messages) {
            Matcher userNameMatcher = pattern.matcher(message.getUserName());
            if (userNameMatcher.find()) {
             Object[] row = {message.getUserName(),message.getDate(), message.getText()};
               model.addRow(row);
            }
               }
          }
          
          public void findByMessage(){
           DefaultTableModel model = (DefaultTableModel) findTable.getModel();
           model.setRowCount(0);
           String regex = findField.getText();
           Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
           for (Model_Send_Message message : messages) {
               Matcher textMatcher = pattern.matcher(message.getText().toLowerCase());
               while (textMatcher.find()) {
                   Object[] row = {message.getUserName(),message.getDate(), message.getText()};
                   model.addRow(row);
    }
} 
           findTable.setModel(model);
              
          }
          
          

   
    

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        lbFind = new javax.swing.JLabel();
        exitBtn = new javax.swing.JButton();
        sp = new javax.swing.JScrollPane();
        findTable = new javax.swing.JTable();
        findBtn = new javax.swing.JButton();
        checkUserName = new javax.swing.JCheckBox();
        checkMessage = new javax.swing.JCheckBox();
        findField = new javax.swing.JTextField();

        lbFind.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lbFind.setText("Find");

        exitBtn.setText("Exit");
        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exitBtnMouseReleased(evt);
            }
        });

        findTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserName", "Time", "Text"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        sp.setViewportView(findTable);

        findBtn.setText("Find");
        findBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                findBtnMouseReleased(evt);
            }
        });
        findBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findBtnActionPerformed(evt);
            }
        });

        checkUserName.setText("by UserName");

        checkMessage.setText("by Message");

        jLayeredPane1.setLayer(lbFind, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(exitBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(sp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(findBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(checkUserName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(checkMessage, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(findField, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(findField)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(lbFind, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(308, 308, 308)
                        .addComponent(checkUserName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkMessage))
                    .addComponent(findBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 271, Short.MAX_VALUE)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFind, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkUserName)
                    .addComponent(checkMessage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(findField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(findBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void findBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findBtnActionPerformed
      
    }//GEN-LAST:event_findBtnActionPerformed
    
    private void findBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_findBtnMouseReleased
       if(checkUserName.isSelected()&&!checkMessage.isSelected()){
           findByUserName();
       }
       if(checkMessage.isSelected()&&!checkUserName.isSelected()){
       findByMessage();
       }
       if(checkUserName.isSelected()&&checkMessage.isSelected()){
       findAll();
       }
    }//GEN-LAST:event_findBtnMouseReleased

    private void exitBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseReleased
       PublicEvent.getInstance().getEventMain().hindFind();
       
    }//GEN-LAST:event_exitBtnMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkMessage;
    private javax.swing.JCheckBox checkUserName;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton findBtn;
    private javax.swing.JTextField findField;
    private javax.swing.JTable findTable;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel lbFind;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
