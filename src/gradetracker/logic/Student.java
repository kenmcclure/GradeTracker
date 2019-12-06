package gradetracker.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Student implements Serializable {

    public ArrayList<Subject> subjects;


    public Student() {
        subjects = new ArrayList<Subject>();
    }

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
            if (subjects.get(i).name.equals(subjectName)) {
                return subjects.get(i);
            }
        }

        return null;

    }

    public void removeSubject(String subjectName) {
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).name.equals(subjectName)) {

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

    public void printsubjects() {

        for (int i = 0; i < subjects.size(); i++) {

            System.out.println(subjects.get(i).toString());

        }
    }

}
