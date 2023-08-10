
package com.course.model;




public class Model_Send_Message {

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

  

    /**
     * @return the data
     */
    public String getDate() {
        return date;
    }

    /**
     * @param data the data to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the fromUserID
     */
    public int getFromUserID() {
        return fromUserID;
    }

    /**
     * @param fromUserID the fromUserID to set
     */
    public void setFromUserID(int fromUserID) {
        this.fromUserID = fromUserID;
    }

    /**
     * @return the toUserID
     */
    public int getToUserID() {
        return toUserID;
    }

    /**
     * @param toUserID the toUserID to set
     */
    public void setToUserID(int toUserID) {
        this.toUserID = toUserID;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    public Model_Send_Message(int fromUserID, int toUserID, String text,String date,String userName) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.text = text;
        this.date=date;
        this.userName=userName;
    }
    
    public Model_Send_Message() {
    }
    
    private int fromUserID;
    private int toUserID;
    private String text;
    private String date;
    private String userName;
    
   
}
