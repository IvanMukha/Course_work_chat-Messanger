
package com.course.event;

import com.course.model.Model_Send_Message;
import java.util.List;


public interface EventFind {
    public void StartFind(List<Model_Send_Message> messages);
    // public void findByUserName(List<Model_Send_Message> messages);
    //public void findByMessage(List<Model_Send_Message> messages);
}
