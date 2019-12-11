package gradetracker.logic;

import java.io.Serializable;
import java.util.Date;

public class Assessment implements Serializable {

//This is the state of the class, ie its variales
    Date date;
    String reflection;
    String name;
    int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int Level) {
        this.level = Level;
    }
    int score;
    int outOf;
    int weight;
    String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //These are the constructors (note they have no return type and are the same name as the class)       
    public Assessment() {
    }

    public Assessment(Date date, String name) {
        super();
        this.date = date;
        this.name = name;
    }

//This is the behaviour, ie the methods/functions of the class
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

    public String toString() {
        return "name: " + name + " date:" + date + " Type: "+type+" Score:" + score + " Out of:" + outOf + " Weight:" + weight + " Level:"+level+" Reflection" + (reflection != null ? "Yes" : "No");
    }
}
