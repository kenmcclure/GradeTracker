package gradetracker.logic;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {

//This is the state of the class, ie its variales
//note that all variables are private and get/set methods are provided
//this is encapsulation
    private ArrayList<Subject> subjects;

//These are the constructors (note they have no return type and are the same name as the class)       
    public Student() {
        subjects = new ArrayList<Subject>();
    }

    //What follows is all the behavior of the class (ie. action/methods/functions)
    //mostly accessor and mutator methods
    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public int getSubjectCount() {
        return subjects.size();
    }

    public Subject getSubject(String subjectName) {
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getName().equals(subjectName)) {
                return subjects.get(i);
            }
        }
        return null;
    }

    public void removeSubject(String subjectName) {
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getName().equalsIgnoreCase(subjectName)) {
                subjects.remove(i);
                break;
            }
        }

    }

    //add a subject
    public Subject addSubject(String newSubjectName, String teacher, boolean HL, int level) {
        if (subjects.size() < 7) {
            Subject newSubject = new Subject(newSubjectName, teacher, HL, level);
            subjects.add(newSubject);
            System.out.println("Added subject " + newSubjectName);
            return newSubject;
        } else {
            System.out.println("Tried to add " + newSubjectName + " but there is no space, must delete one first");
        }
        return null;
    }

    //allow subjects to be added without a current grade
    public Subject addSubject(String newSubjectName, String teacher, boolean HL) {
        return addSubject(newSubjectName, teacher, HL, 0);
    }

    //allow subjects to be added with just a name and HL or not
    public Subject addSubject(String newSubjectName, boolean HL) {
        return addSubject(newSubjectName, null, HL, 0);
    }

    //allow subjects to be added with just a name
    public Subject addSubject(String newSubjectName) {
        return addSubject(newSubjectName, null, false, 0);
    }

    //allow an existing Subject instance to be added
    public Subject addSubject(Subject newSubject) {
        subjects.add(newSubject);
        return newSubject;
    }

    public void printsubjects() {
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println(subjects.get(i).toString());
        }
    }

}
