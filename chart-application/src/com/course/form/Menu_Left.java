package com.course.form;

import com.course.component.Item_People;
import com.course.event.EventMenuLeft;
import com.course.event.PublicEvent;
import com.course.model.Model_Send_Message;
import com.course.model.Model_User_Account;
import com.course.swing.ScrollBar;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import net.miginfocom.swing.MigLayout;

public class Menu_Left extends javax.swing.JPanel {

    private List<Model_User_Account> userAccount;
    private List<Model_Send_Message> messages;
    public Menu_Left() {
        initComponents();
        init();
    }

    private void init() {
        sp.setVerticalScrollBar(new ScrollBar());
        menuList.setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
        userAccount=new ArrayList<>();
        PublicEvent.getInstance().addEventMenuLeft(new EventMenuLeft() {
            @Override
            public void newUser(List<Model_User_Account> users) {
                for(Model_User_Account d:users){
                    userAccount.add(d);
                    menuList.add(new Item_People(d), "wrap");
                    refreshMenuList();
                }
            }

            @Override
            public void userConnect(int userID) {
           for(Model_User_Account u:userAccount){
               if(u.getUserID()==userID){
                   u.setStatus(true);
                   PublicEvent.getInstance().getEventMain().updateUser(u);
                   break;
               }
           }
           if(menuMessage.isSelected()){
               for(Component com:menuList.getComponents()){
                   Item_People item=(Item_People)com;
                   if(item.getUser().getUserID()==userID){
                       item.updateStatus();
                       break;
                   }
               }
           }
        }

            @Override
            public void userDisconnect(int userID) {
                for(Model_User_Account u:userAccount){
               if(u.getUserID()==userID){
                   u.setStatus(false);
                   PublicEvent.getInstance().getEventMain().updateUser(u);
                   break;
               }
           }
           if(menuMessage.isSelected()){
               for(Component com:menuList.getComponents()){
                   Item_People item=(Item_People)com;
                   if(item.getUser().getUserID()==userID){
                       item.updateStatus();
                       break;
                   }
               }
           }
            }
            
        });
        showMessage();
    }

    private void showMessage() {
        //  test data
        menuList.removeAll();
        for (Model_User_Account d:userAccount) {
             menuList.add(new Item_People(null), "wrap");
        }
        refreshMenuList();
    }

//    private void showGroup() {
//        //  test data
//        menuList.removeAll();
//        for (int i = 0; i < 5; i++) {
//            menuList.add(new Item_People(null), "wrap");
//        }
//        refreshMenuList();
//    }

//    private void showFind(List<Model_Send_Message> messages) {
//        PublicEvent.getInstance().getEventMain().selectFind(messages);
//        
//   }

    private void refreshMenuList() {
        menuList.repaint();
        menuList.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JLayeredPane();
        menuMessage = new javax.swing.JButton();
        MenuGroup = new javax.swing.JButton();
        MenuBox = new javax.swing.JButton();
        sp = new javax.swing.JScrollPane();
        menuList = new javax.swing.JLayeredPane();

        menu.setBackground(new java.awt.Color(229, 229, 229));
        menu.setOpaque(true);
        menu.setLayout(new java.awt.GridLayout(1, 3));

        menuMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/course/icon/message.png"))); // NOI18N
        menuMessage.setSelected(true);
        menuMessage.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/course/icon/message_selected.png"))); // NOI18N
        menuMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMessageActionPerformed(evt);
            }
        });
        menu.add(menuMessage);

        MenuGroup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/course/icon/group.png"))); // NOI18N
        MenuGroup.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/course/icon/group_selected.png"))); // NOI18N
        MenuGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuGroupActionPerformed(evt);
            }
        });
        menu.add(MenuGroup);

        MenuBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/course/icon/box.png"))); // NOI18N
        MenuBox.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/course/icon/box_selected.png"))); // NOI18N
        MenuBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuBoxMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MenuBoxMouseReleased(evt);
            }
        });
        MenuBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBoxActionPerformed(evt);
            }
        });
        menu.add(MenuBox);

        sp.setBackground(new java.awt.Color(242, 242, 242));
        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        menuList.setBackground(new java.awt.Color(242, 242, 242));
        menuList.setOpaque(true);

        javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(menuList);
        menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuListLayout.setVerticalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
        );

        sp.setViewportView(menuList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sp)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menuMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMessageActionPerformed
      if(!menuMessage.isSelected()){
      menuMessage.setSelected(true);
        MenuGroup.setSelected(false);
        MenuBox.setSelected(false);
      showMessage();
      }
    }//GEN-LAST:event_menuMessageActionPerformed

    private void MenuGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuGroupActionPerformed
        if(!MenuGroup.isSelected()){
        menuMessage.setSelected(false);
        MenuGroup.setSelected(true);
        MenuBox.setSelected(false);
        //showGroup();
        }
    }//GEN-LAST:event_MenuGroupActionPerformed

    private void MenuBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBoxActionPerformed
       
    }//GEN-LAST:event_MenuBoxActionPerformed

    private void MenuBoxMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuBoxMouseReleased
    }//GEN-LAST:event_MenuBoxMouseReleased

    private void MenuBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuBoxMouseClicked
               PublicEvent.getInstance().getEventMain().selectFind();

    }//GEN-LAST:event_MenuBoxMouseClicked





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MenuBox;
    private javax.swing.JButton MenuGroup;
    private javax.swing.JLayeredPane menu;
    private javax.swing.JLayeredPane menuList;
    private javax.swing.JButton menuMessage;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
