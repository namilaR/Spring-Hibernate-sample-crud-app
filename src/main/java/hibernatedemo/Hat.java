/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatedemo;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author it13137342
 */

public class Hat {
    private int hatid;
    private String color;
    private String size;
    private int personid;
    
    public int getHatid() {
        return hatid;
    }

    public void setHatid(int hatid) {
        this.hatid = hatid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }
    
    
    @Override
    public String toString() {
        return "Hat: "+getHatid()+
        " Color: "+getColor()+
        " Size: "+getSize();
    } 

}
