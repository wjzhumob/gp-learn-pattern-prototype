package com.gp.learn.pattern.prototype;

import java.io.*;

/**
 * @author wjzhu
 * @createDate 2019-05-02 20:57
 */
public class Novel extends Book implements Cloneable,Serializable {
    private String content;
    private String description;
    public Note note;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return deepClone();
    }

    public Object deepClone(){
        try{
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            oos.flush();
            oos.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);

            Novel clone = (Novel)ois.readObject();
            ois.close();
            return clone;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
