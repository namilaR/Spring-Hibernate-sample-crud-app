/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatedemo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author it13137342
 */


public class Person {
    private int personid;
    private String name;
    private int age;
    private Set hats;


    public Set getHats() {
        return hats;
    }

    public void setHats(Set hats) {
        this.hats = hats;
    }

    public Person()
    {
        hats=new HashSet();
    }
    
    public void addHat(Hat hat) {
        this.hats.add(hat);
    }

    public void removeHat(Hat hat) {
        this.hats.remove(hat);
    }
    

    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="AGE")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
  
    
    @Override
    public String toString()
    {
        String personString= "Person: "+getPersonid()+
                " Name: "+getName()+
                " Age: "+getAge();
        String hatString="";
        for (Iterator iter = hats.iterator(); iter.hasNext();) {
            Hat hat = (Hat) iter.next();
            hatString = hatString + "\t\t"+ hat.toString()+"\n";
        }
        return personString + "\n" + hatString; 
    }
}
