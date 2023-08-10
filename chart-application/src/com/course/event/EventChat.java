
package com.course.event;

import com.course.model.Model_Receive_Message;
import com.course.model.Model_Send_Message;
import java.util.List;


public interface EventChat {
    public void sendMessage(Model_Send_Message data);
    public void receiveMessage(Model_Receive_Message data);
    public void selectedUserLoad(List<Model_Send_Message> messages);
}
