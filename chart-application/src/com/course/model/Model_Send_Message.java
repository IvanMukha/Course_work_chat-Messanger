
package com.course.model;




import org.json.JSONException;
import org.json.JSONObject;

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
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    public int getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(int fromUserID) {
        this.fromUserID = fromUserID;
    }

    public int getToUserID() {
        return toUserID;
    }

    public void setToUserID(int toUserID) {
        this.toUserID = toUserID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Model_Send_Message(int fromUserID, int toUserID, String text,String  date,String userName) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.text = text;
        this.date=date;
        this.userName=userName;
    }
public Model_Send_Message(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
            fromUserID = obj.getInt("fromUserID");
            toUserID=obj.getInt("toUserID");
            text = obj.getString("text");
            date=obj.getString("date");
            userName=obj.getString("userName");
            
        } catch (JSONException e) {
            System.err.println(e);
        }
    }
   

    private int fromUserID;
    private int toUserID;
    private String text;
    private String date;
    private String userName;

    public JSONObject toJsonObject() {
        try {
            JSONObject json = new JSONObject();
            json.put("fromUserID", fromUserID);
            json.put("toUserID", toUserID);
            json.put("text", text);
            json.put("date",date);
            json.put("userName", userName);
            return json;
        } catch (JSONException e) {
            return null;
        }
    }
}
