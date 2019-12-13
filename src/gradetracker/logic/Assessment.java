package gradetracker.logic;

import java.io.Serializable;
import java.util.Date;

public class Assessment implements Serializable {

//This is the state of the class, ie its variales
//note that all variables are private and get/set methods are provided
//this is encapsulation
    
    private Date date;
    private String reflection;
    private String name;
    private int level;
    int score;
    int outOf;
    int weight;
    String type;

    //These are the constructors (note they have no return type and are the same name as the class)       
    public Assessment() {
    }

    public Assessment(Date date, String name) {
        this.date = date;
        this.name = name;
    }
    
    //What follows is all the behavior of the class (ie. action/methods/functions)
    
    //Accessor (get) and mutator (set) methods 
    public int getLevel() {
        return level;
    }

    public void setLevel(int Level) {
        this.level = Level;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReflection() {
        return reflection;
    }

    public void setReflection(String reflection) {
        this.reflection = reflection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getOutOf() {
        return outOf;
    }

    public void setOutOf(int outOf) {
        this.outOf = outOf;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    //This method is useful for debugging as it just prints out the fields nicely
    public String toString() {
        return "Assessment name: " + name + " date:" + date + " Type: "+type+" Score:" + score + " Out of:" + outOf + " Weight:" + weight + " Level:"+level+" Reflection:" + (reflection != null ? "Yes" : "No");
    }
}
