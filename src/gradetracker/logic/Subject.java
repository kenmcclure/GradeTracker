package gradetracker.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Subject implements Serializable {

    public String name;
    public String teacher;
    public boolean HLorNot;
    public int currentLevel;

    public ArrayList<Assessment> assessments;

    public Subject(String name, String teacher, boolean hl, int level) {
        this.name = name;
        this.teacher = teacher;
        this.HLorNot = hl;
        this.currentLevel = level;
        this.assessments = new ArrayList<Assessment>();
    }

       public void addAssessment(Assessment a) {
        assessments.add(a);
    }

    public void removeAssessment(Assessment a) {
        assessments.remove(a);
    }

    public Assessment getAssessment(Date aDate) {

        for (Assessment i : assessments) {

            if (i.date.compareTo(aDate) == 0) {
                return i;

            }

        }
        return null;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public boolean isHLorNot() {
        return HLorNot;
    }

    public void setHLorNot(boolean HLorNot) {
        this.HLorNot = HLorNot;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public ArrayList<Assessment> getAssessments() {
        return assessments;
    }


 

    public void countAssessments() {
        System.out.println(assessments.size());
    }

    public void printAssessments() {
        for (Assessment i : assessments) {
            System.out.println(i.toString());
        }
    }

    public String toString(){
           
        return "name: " + name + " Teacher:" + teacher + " HL:" + HLorNot + " Current Level:" + currentLevel;
    }
    
}
