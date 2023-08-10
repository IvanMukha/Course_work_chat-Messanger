
package com.course.event;

import com.course.model.Model_Send_Message;
import com.course.model.Model_User_Account;
import java.util.List;



public interface EventMain {
    
    public void showLoading(boolean show);
    
    public void initChat();
    public void selectUser(Model_User_Account user);
    public void updateUser(Model_User_Account user);
    public void selectFind();
    public void hindFind();
}
